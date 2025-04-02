package lambda.lambda4;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

//입력된 타입과 동일한 타입을 반환한다.
//unary -> 단항, binary -> 이항
public class OperatorMain {
    public static void main(String[] args) {
        UnaryOperator<Integer> unaryOperator = x -> x * x;
        System.out.println(unaryOperator.apply(3));

        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
        System.out.println(binaryOperator.apply(3, 4));

        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x * y;
        System.out.println(biFunction.apply(3, 4));
    }
}
