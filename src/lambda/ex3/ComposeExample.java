package lambda.ex3;

import java.util.function.Function;

public class ComposeExample {
    public static void main(String[] args) {
        Function<String, String> toUpper = String::toUpperCase;
        Function<String, String> addDeco = s -> "**" + s + "**";
        Function<String, String> composeFunc = compose(toUpper, addDeco);

        System.out.println(composeFunc.apply("hello"));
    }

    private static Function<String, String> compose(Function<String, String> f1, Function<String, String> f2) {
        return s -> {
            String result = f1.apply(s);
            return f2.apply(result);
        };
    }
}
