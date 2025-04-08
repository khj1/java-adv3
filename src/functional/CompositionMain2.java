package functional;

import java.util.function.Function;

public class CompositionMain2 {

    public static void main(String[] args) {
        // 1. String -> Integer
        Function<String, Integer> parseInt = Integer::parseInt;

        // 2. Integer -> Integer
        Function<Integer, Integer> square = x -> x * x;

        // 3. Integer -> String
        Function<Integer, String> toString = x -> "결과: " + x;

        // compose 혹은 andThen 으로 합성하기
        Function<String, String> finalFunc = parseInt
                .andThen(square)
                .andThen(toString);

        String result1 = finalFunc.apply("5");
        System.out.println("result1 = " + result1);

        // 또 다른 조합으로 사용 가능
        Function<String, Integer> stringToSquareFunc = parseInt.andThen(square);
        Integer result2 = stringToSquareFunc.apply("5");
        System.out.println("result2 = " + result2);
    }
}
