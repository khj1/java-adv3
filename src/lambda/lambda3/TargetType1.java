package lambda.lambda3;

public class TargetType1 {
    public static void main(String[] args) {
        //람다 직접 대입: 문제 없음
        FunctionA a = i -> "value: " + i;
        FunctionB b = i -> "value: " + i;

        //이미 만들어진 FunctionA 인스턴스를 FunctionB에 대입
//        FunctionB targetB = a;
    }

    @FunctionalInterface
    interface FunctionA {
        String apply(Integer i);
    }

    @FunctionalInterface
    interface FunctionB {
        String apply(Integer i);
    }
}
