package functional;

import java.util.function.Function;

// 같은 값을 넣으면 항상 같은 결과 값이 반환된다.
public class PureFunctionMain1 {

    public static void main(String[] args) {
        Function<Integer, Integer> func = x -> x * 2;
        System.out.println("result1 = " + func.apply(10));
        System.out.println("result2 = " + func.apply(10));
    }
}
