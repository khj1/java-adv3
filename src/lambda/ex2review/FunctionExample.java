package lambda.ex2review;

public class FunctionExample {
    public static void main(String[] args) {
        StringFunction greeter = buildGreeter("java!");
        System.out.println(greeter.apply("Hello"));
    }

    private static StringFunction buildGreeter(String message) {
        return s -> s + ", " + message;
    }
}
