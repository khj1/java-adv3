package lambda.lambda3;

import java.util.function.Function;

public class TargetType2 {
    public static void main(String[] args) {
        Function<String, String> upperCase = String::toUpperCase;
        String result1 = upperCase.apply("hello");
        System.out.println("result1 = " + result1);

        Function<Integer, Integer> square = x -> x * x;
        int result2 = square.apply(5);
        System.out.println("result2 = " + result2);
    }
}
