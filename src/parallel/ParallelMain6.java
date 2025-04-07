package parallel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static util.MyLogger.log;

/*
그렇다면 여러 I/O 작업을 동시에 처리해야할 땐 어떻게 해야할까?
    별도의 스레드 풀을 사용하면 된다.
 */
public class ParallelMain6 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService requestPool = Executors.newFixedThreadPool(100);

        // 로직 처리 전 스레드 풀 추가
        ExecutorService logicPool = Executors.newFixedThreadPool(400);

        int nThreads = 3;
        for (int i = 1; i <= nThreads; i++) {
            String requestName = "request" + i;
            requestPool.submit(() -> logic(requestName, logicPool));
            Thread.sleep(100); // 스레드 순서를 확인하기 위해 약간 대기
        }
        requestPool.close();
        logicPool.close();
    }

    private static void logic(String requestName, ExecutorService es) {
        log("[" + requestName + "] START");
        long startTime = System.currentTimeMillis();

        List<Future<Integer>> futures = IntStream.rangeClosed(1, 4)
                .mapToObj(i -> es.submit(() -> HeavyJob.heavyTask(i, requestName)))
                .toList();

        int sum = futures.stream()
                .mapToInt(f -> {
                    try {
                        return f.get();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .sum();

        long endTime = System.currentTimeMillis();
        log("[" + requestName + "] END, time: " + (endTime - startTime) + "ms, sum: " + sum);
    }
}
