package lambda.lambda3;

import java.util.function.Function;

public class TargetType3 {
    public static void main(String[] args) {
        Function<Integer, String> a = i -> "value: " + i;
        System.out.println(a.apply(10));

        Function<Integer, String> b = a;
        System.out.println(b.apply(20));
    }
}
