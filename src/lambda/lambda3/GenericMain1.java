package lambda.lambda3;

public class GenericMain1 {
    public static void main(String[] args) {
        StringFunction upperCase = String::toUpperCase;
        String result1 = upperCase.apply("Hello");
        System.out.println("result1 = " + result1);

        NumberFunction square = i -> i * i;
        Integer result2 = square.apply(5);
        System.out.println("result2 = " + result2);
    }

    @FunctionalInterface
    interface StringFunction {
        String apply(String s);
    }

    @FunctionalInterface
    interface NumberFunction {
        Integer apply(Integer i);
    }
}
