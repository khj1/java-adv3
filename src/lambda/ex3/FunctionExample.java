package lambda.ex3;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, String> greeter = buildGreeter("Hello");
        System.out.println(greeter.apply("java!"));
    }

    static Function<String, String> buildGreeter(String message) {
        return s -> message + ", " + s;
    }
}
