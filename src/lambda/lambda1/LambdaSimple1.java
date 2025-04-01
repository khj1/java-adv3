package lambda.lambda1;

import lambda.MyFunction;

public class LambdaSimple1 {
    public static void main(String[] args) {
        //기본
        MyFunction function1 = (a, b) -> {
            return a + b;
        };
        System.out.println("function1 = " + function1.apply(1, 2));

        //단일 표현식인 경우 중괄호와 리턴 생략 가능
        MyFunction function2 = (a, b) -> a + b;
        System.out.println("function2 = " + function2.apply(1, 2));

        //단일 표현식이 아닐 경우 중괄호와 return 모두 필수
        MyFunction function3 = (a, b) -> {
            System.out.println("람다 실행");
            return a + b;
        };
        System.out.println("function3 = " + function3.apply(1, 2));
    }
}
