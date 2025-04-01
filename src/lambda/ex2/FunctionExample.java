package lambda.ex2;

public class FunctionExample {
    public static void main(String[] args) {
        StringFunction greeter = buildGreeter("Hello");
        System.out.println(greeter.apply("java!"));
    }

    static StringFunction buildGreeter(String message) {
        return s -> message + ", " + s;
    }
}
