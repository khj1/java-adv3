package lambda.lambda1;

import lambda.Procedure;

public class LambdaSimple2 {
    public static void main(String[] args) {
        Procedure procedure1 = () -> System.out.println("hello lambda");
        procedure1.run();
    }
}
