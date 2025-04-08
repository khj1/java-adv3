package functional;

import java.util.function.Function;

public class SideEffectMain2 {


    public static void main(String[] args) {
        Function<Integer, Integer> func = x -> {
            int result = x * 2;

            // 부수 효과(Side Effect)
            // 함수가 외부 상태 (콘솔에 출력되는 결과물)에 영향을 주었다.
            System.out.println("x = " + x + ", result = " + (x * 2));
            return result;
        };

        // 함수를 여러번 호출할 수록 콘솔창에 출력되는 메세지의 길이도 늘어난다. (부수 효과)
        func.apply(10);
        func.apply(10);
    }
}
