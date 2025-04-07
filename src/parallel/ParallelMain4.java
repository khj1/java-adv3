package parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.log;

/*
Fork/Join 프레임 워크는 CPU 바운드 작업에만 사용해야 한다.

CPU 바운드 작업?
    계산 집약적고 I/O 대기 시간이 적은 작업을 의미한다.

I/O 작업처럼 블로킹 대기 시간이 긴 작업을 Fork/Join 에서 처리하면 다음과 같은 문제가 발생한다.
    1. 스레드 블로킹에 따른 CPU 낭비
        - ForkJoinPool은 CPU 코어 수에 맞춰 제한된 개수의 스레드를 사용한다.
        - I/O 작업으로 스레드가 블로킹되면 CPU가 놀게 되므로, 전체 병렬 처리 효율이 크게 떨어진다.
    2. 컨텍스트 스위칭 오버헤드 증가
        - I/O 작업 때문에 스레드를 늘리면, 실제 연산보다 대기 시간이 길어지는 상황이 발생할 수 있다.
        - 스레드가 많아질수록 컨텍스트 스위칭 비용도 증가하여 오히려 성능이 떨어질 수 있다.
    3. 작업 훔치기 기법 무력화
        - ForkJoinPool 이 제공하는 작업 훔치기 알고리즘은 CPU 바운드 작업에서 빠르게 작업 단위를 계속
            처리하도록 설계되었다. (쉬는 스레드 없이 계속 작업하도록)
        - I/O 대기 시간이 많은 작업은 스레드가 I/O로 인해 대기하고 있는 경우가 많아 작업 훔치기의 장점을 살리지 못한다.
    4. 분할, 정복 이점 감소
        - Fork/Join 방식을 통해 작업을 잘게 나누어도, I/O 병목이 발생하면 CPU 병렬화 이점이 크게 줄어든다.
        - 오히려 분할된 작업들이 각기 I/O 대기를 반복하면서, fork(), join() 에 따른 오버헤드만 증가할 수 있다.
 */
public class ParallelMain4 {

    public static void main(String[] args) {
        int processorsCount = Runtime.getRuntime().availableProcessors();
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        log("processorsCount = " + processorsCount + ", commonPool = " + commonPool.getParallelism());

        long startTime = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 8)
                .parallel()
                .map(HeavyJob::heavyTask)
                .reduce(0, (a, b) -> a + b);

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum);
    }
}
