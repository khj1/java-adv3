package optional;

import java.util.Optional;

public class OptionalCreationMain {
    public static void main(String[] args) {
        // 1. of(): 값이 null 이 아님이 확실할 때 사용한다.
        // 해당 값이 절대 null 이 아님을 명시적으로 강조하기 위해 사용한다.
        String nonNullValue = "Hello Optional";
        Optional<String> opt1 = Optional.of(nonNullValue);
        System.out.println("opt1 = " + opt1);

        // 2. ofNullable(): 값이 null일 수도 아닐 수도 있을 때
        Optional<String> opt2 = Optional.ofNullable("Hello");
        Optional<String> opt3 = Optional.ofNullable(null);
        System.out.println("opt2 = " + opt2);
        System.out.println("opt3 = " + opt3);

        // 3. empty(): 비어있는 Optional 을 명시적으로 생성한다.
        Optional<Object> opt4 = Optional.empty();
        System.out.println("opt4 = " + opt4);
    }
}
