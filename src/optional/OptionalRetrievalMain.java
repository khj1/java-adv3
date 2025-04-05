package optional;

import java.util.Optional;

public class OptionalRetrievalMain {
    public static void main(String[] args) {
        // 예제: 문자열 "Java"가 있는 Optional과 비어있는 Optional 준비
        Optional<String> optValue = Optional.of("Java");
        Optional<String> optEmpty = Optional.empty();

        // isPresent(): 값이 있으면 true
        System.out.println("=== 1. isPresent() / isEmpty() ===");
        System.out.println("optValue.isPresent() = " + optValue.isPresent());
        System.out.println("optEmpty.isPresent() = " + optEmpty.isPresent());
        System.out.println("optEmpty.isEmpty() = " + optEmpty.isEmpty());

        // get(): 직접 내부 값을 꺼낸다. 값이 없으면 예외 발생
        System.out.println("=== 2. get() ===");
        System.out.println("optValue.get() = " + optValue.get());
//        System.out.println("optEmpty.get() = " + optEmpty.get());

        // 값이 있으면 그 값, 없으면 지정된 기본값 사용
        System.out.println("=== 3. orElse() ===");
        System.out.println("optValue.orElse() = " + optValue.orElse("기본값"));
        System.out.println("optEmpty.orElse() = " + optEmpty.orElse("가본값"));

        // 값이 없을 때만 람다(Supplier)가 실행되어 기본값 생성
        System.out.println("=== 4. orElseGet() ===");
        String value = optValue.orElseGet(() -> {
            System.out.println("람다 호출 - optValue");
            return "newValue";
        });

        String empty = optEmpty.orElseGet(() -> {
            System.out.println("람다 호출 - optEmpty");
            return "newValue";
        });

        System.out.println("value = " + value);
        System.out.println("empty = " + empty);

        // 값이 있으면 반환, 없으면 예외 발생
        System.out.println("=== 5. orElseThrow() ===");
        String value2 = optValue.orElseThrow(() -> new RuntimeException("값이 없습니다"));
        System.out.println("value2 = " + value2);

        try {
            String empty2 = optEmpty.orElseThrow(() -> new RuntimeException("값이 없습니다"));
            System.out.println("empty2 = " + empty2); // 실행되지 않는다.
        } catch (RuntimeException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // Optional 을 반환할 때
        System.out.println("=== 6. or() ===");
        Optional<String> result1 = optValue.or(() -> Optional.of("FallBack"));
        System.out.println("result1 = " + result1);

        Optional<String> result2 = optEmpty.or(() -> Optional.of("FallBack"));
        System.out.println("result2 = " + result2);
    }
}
