package parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static util.MyLogger.log;

/*
실무에선 절대 공용 풀을 I/O 바운드 작업에 사용해선 안된다.
 */
public class ParallelMain5 {

    public static void main(String[] args) throws InterruptedException {
        // 병렬 수준 3으로 제한
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");

        // 요청 풀 추가
        ExecutorService requestPool = Executors.newFixedThreadPool(100);
        int nThreads = 20;
        for (int i = 1; i <= nThreads; i++) {
            String requestName = "request" + i;
            requestPool.submit(() -> logic(requestName));
            Thread.sleep(100); // 스레드 순서를 확인하기 위해 약간 대기
        }
        requestPool.close();
    }

    private static void logic(String requestName) {
        log("[" + requestName + "] START");
        long startTime = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 4)
                .parallel()
                .map(i -> HeavyJob.heavyTask(i, requestName))
                .reduce(0, (a, b) -> a + b);

        long endTime = System.currentTimeMillis();
        log("[" + requestName + "] END, time: " + (endTime - startTime) + "ms, sum: " + sum);
    }
}
