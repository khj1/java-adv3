package lambda.lambda4;

import java.util.function.Function;

public class FunctionMain {
    public static void main(String[] args) {
        Function<String, Integer> function = s -> s.length();
        System.out.println(function.apply("hello"));
    }
}
