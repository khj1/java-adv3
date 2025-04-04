package stream.operation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperationMain {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);

        System.out.println("1. collect - 복잡한 수집이 필요할 때 사용");
        List<Integer> evenNumbers1 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("evenNumbers1 = " + evenNumbers1);
        System.out.println();

        System.out.println("2. toList() - Java(16+)");
        List<Integer> evenNumbers2 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("evenNumbers2 = " + evenNumbers2);
        System.out.println();

        System.out.println("3. toArray() - 배열로 변환");
        Integer[] arr = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toArray(Integer[]::new);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println();

        System.out.println("4. forEach - 각 요소 처리");
        numbers.stream()
                .limit(5)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        System.out.println("5. count -> 요소 개수");
        long count = numbers.stream()
                .filter(n -> n > 5)
                .count();
        System.out.println("count = " + count);
        System.out.println();

        System.out.println("6. reduce -> 요소들을 계산");
        Optional<Integer> sum1 = numbers.stream()
                .reduce((a, b) -> a + b);
        System.out.println("sum1 = " + sum1);
        System.out.println();

        System.out.println("7. 초기 값이 있는 reduce");
        Integer sum2 = numbers.stream()
                .reduce(10, (a, b) -> a + b);
        System.out.println("sum2 = " + sum2);
        System.out.println();

        System.out.println("8. min - 최솟값");
        Optional<Integer> min = numbers.stream()
                .min(Integer::compare);
        System.out.println("min = " + min.get());
        System.out.println();

        System.out.println("9. max - 최댓값");
        Optional<Integer> max = numbers.stream()
                .max(Integer::compare);
        System.out.println("max = " + max.get());
        System.out.println();

        System.out.println("10. findFirst() - 첫 번째 요소");
        Optional<Integer> first = numbers.stream()
                .filter(n -> n > 5)
                .findFirst();
        System.out.println("first.get() = " + first.get());
        System.out.println();

        System.out.println("11. findAny() - 아무 요소나 하나 찾기 - 멀티 쓰레드 상황에서 유의미한 차이");
        Optional<Integer> any = numbers.stream()
                .filter(n -> n > 5)
                .findAny();
        System.out.println("any.get() = " + any.get());
        System.out.println();

        System.out.println("12. anyMatch() -  조건을 만족하는 요소 존재 여부");
        boolean hasEven = numbers.stream()
                .anyMatch(n -> n % 2 == 0);
        System.out.println("hasEven = " + hasEven);
        System.out.println();

        System.out.println("13. allMatch() - 모든 요소가 조건을 만족하는지");
        boolean allPositive = numbers.stream()
                .allMatch(n -> n > 0);
        System.out.println("allPositive = " + allPositive);
        System.out.println();

        System.out.println("14. noneMatch - 조건을 만족하는 요소가 없는지");
        boolean noNegative = numbers.stream()
                .noneMatch(n -> n < 0);
        System.out.println("noNegative = " + noNegative);
        System.out.println();
    }
}
