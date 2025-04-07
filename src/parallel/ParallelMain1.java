package parallel;

import java.util.stream.IntStream;

import static util.MyLogger.log;

// 무거운 작업을 순차적으로 처리하면 속도가 급격히 저하된다.
public class ParallelMain1 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 8)
                .map(HeavyJob::heavyTask)
                .reduce(0, (a, b) -> a + b);

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum);
    }
}
