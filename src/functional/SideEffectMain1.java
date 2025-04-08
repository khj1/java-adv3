package functional;

import java.util.function.Function;

// 함수가 전역 변수를 변경하고 있다.
// 이러한 외부 상태의 변화가 부수 효과의 대표적인 예다.
// 함수 사용시 이러한 부수효과가 최소화되도록 하는 것을 권장한다.
public class SideEffectMain1 {

    public static int count = 0;

    public static void main(String[] args) {
        System.out.println("before count: " + count);

        Function<Integer, Integer> func = x -> {
            count++;
            return x * 2;
        };

        func.apply(10);
        System.out.println("after count: " + count);
    }
}
