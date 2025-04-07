package parallel;

import java.util.concurrent.*;

import static util.MyLogger.log;

// Thread 를 사용해서 문제를 해결해보자
public class ParallelMain3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();

        // 1. Fork - 작업을 분할한다.
        ExecutorService es = Executors.newFixedThreadPool(2);

        SumTask task1 = new SumTask(1, 4);
        SumTask task2 = new SumTask(5, 8);

        // 2. 분할한 작업을 처리한다.
        Future<Integer> future1 = es.submit(task1);
        Future<Integer> future2 = es.submit(task2);

        // 3. join - 처리한 결과를 합친다. get() 은 결과가 나올 때 까지 대기한다.
        Integer result1 = future1.get();
        Integer result2 = future2.get();
        log("main 스레드 대기 완료");

        int sum = result1 + result2;

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum);

        es.close();
    }

    static class SumTask implements Callable<Integer> {
        int startValue;
        int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() {
            log("작업 시작");
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += HeavyJob.heavyTask(i);
            }
            log("작업 완료 result = " + sum);

            return sum;
        }
    }
}
