package lambda.lambda1;

public class LambdaSimple4 {
    public static void main(String[] args) {
        MyCall call1 = (int value) -> value * 2; //기본
        MyCall call2 = (value) -> value * 2; //타입 추론
        MyCall call3 = value -> value * 2; //괄호 생략 (매개 변수가 한 개일 때 생략 가능)
    }

    interface MyCall {
        int call(int value);
    }
}
