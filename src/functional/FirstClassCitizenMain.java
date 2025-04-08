package functional;

import java.util.function.Function;

public class FirstClassCitizenMain {

    public static void main(String[] args) {
        // 함수를 변수에 담는다.
        Function<Integer, Integer> func = x -> x * 2;

        // 함수를 인자로 전달한다.
        Integer result1 = applyFunction(10, func);
        System.out.println("result1 = " + result1);

        // 함수를 반환한다.
        Integer result2 = getFunc().apply(10);
        System.out.println("result2 = " + result2);
    }

    // 고차 함수: 함수를 인자로 받음
    private static Integer applyFunction(int input, Function<Integer, Integer> func) {
        return func.apply(input);
    }

    // 고차 함수: 함수를 반환
    private static Function<Integer, Integer> getFunc() {
        return x -> x * 2;
    }
}
