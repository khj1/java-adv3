package optional;

import java.util.Optional;

public class OptionalProcessingMain {
    public static void main(String[] args) {
        Optional<String> optValue = Optional.of("Hello");
        Optional<String> optEmpty = Optional.empty();

        // 값이 존재하면 Consumer 실행, 없으면 아무 일도 하지 않음
        System.out.println("=== 1. ifPresent() ===");
        optValue.ifPresent(v -> System.out.println("optValue 값: " + v));
        optEmpty.ifPresent(v -> System.out.println("optEmpty 값: " + v)); // 실행 안됨

        // 값이 있으면 Consumer 실행, 없으면 Runnable 실행
        System.out.println("=== 2. ifPresentOrElse() ===");
        optValue.ifPresentOrElse(
                v -> System.out.println("optValue 값: " + v),
                () -> System.out.println("optValue 비어있음")
        );
        optEmpty.ifPresentOrElse(
                v -> System.out.println("optEmpty 값: " + v),
                () -> System.out.println("optEmpty 비어있음")
        );

        // 값이 있으면 Function 적용 후 Optional 로 변환, 없으면 Optional.empty()
        System.out.println("=== 3. map() ===");
        Optional<String> toUpper1 = optValue.map(String::toUpperCase);
        System.out.println("toUpper1 = " + toUpper1);

        Optional<String> toUpper2 = optEmpty.map(String::toUpperCase);
        System.out.println("toUpper2 = " + toUpper2);

        // map() 과 유사하나, 이미 Optional을 반환하는 경우 중첩을 제거
        System.out.println("=== 4. flatMap() ===");
        Optional<Optional<String>> nestedOpt = optValue.map(s -> Optional.of(s.toUpperCase()));
        System.out.println("nestedOpt = " + nestedOpt);

        Optional<String> flatOpt = optValue.flatMap(s -> Optional.of(s.toUpperCase()));
        System.out.println("flatOpt = " + flatOpt);

        // 값이 있고, 조건을 만족하면 그 값을 그대로, 불만족시 Optional.empty()
        System.out.println("=== 5. filter() ===");
        Optional<String> filtered1 = optValue.filter(s -> s.startsWith("H"));
        System.out.println("filtered1 = " + filtered1);
        Optional<String> filtered2 = optValue.filter(s -> s.startsWith("X"));
        System.out.println("filtered2 = " + filtered2);

        Optional<String> filtered3 = optEmpty.filter(s -> s.startsWith("H"));
        System.out.println("filtered3 = " + filtered3);

        // 값이 있으면 단일 요소 스트림, 없으면 빈 스트림
        System.out.println("=== 6. stream() ===");
        optValue.stream()
                .forEach(s -> System.out.println("optValue.stream() -> " + s));
        optEmpty.stream()
                .forEach(s -> System.out.println("optEmpty.stream() -> " + s));
    }
}
