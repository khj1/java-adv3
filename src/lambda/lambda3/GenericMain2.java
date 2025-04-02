package lambda.lambda3;

public class GenericMain2 {
    public static void main(String[] args) {
        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, Integer> stringLength = String::length;
        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Boolean> isEven = x -> x % 2 == 0;

        System.out.println(toUpperCase.apply("Hello"));
        System.out.println(stringLength.apply("Hello"));
        System.out.println(square.apply(3));
        System.out.println(isEven.apply(3));
    }

    @FunctionalInterface
    interface Function<T, R> {
        R apply(T o);
    }
}
