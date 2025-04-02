package lambda.lambda4;

import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;

public class PrimitiveFunction {
    public static void main(String[] args) {
        // 기본형 매개변수, IntFunction, LongFunction, DoubleFunction
        IntFunction<String> intFunction = value -> "숫자: " + value;
        System.out.println("function.apply(100) = " + intFunction.apply(100));

        // 기본형 반환
        ToIntFunction<String> toIntFunction = String::length;
        System.out.println("toIntFunction.applyAsInt(\"hello\") = " + toIntFunction.applyAsInt("hello"));

        // 기본형 매개변수
        IntToLongFunction intToLongFunction = value -> value * 10;
        System.out.println("intToLongFunction.applyAsLong(100) = " + intToLongFunction.applyAsLong(10));

        // IntUnaryOperator
        IntUnaryOperator intUnaryOperator = value -> value * 10;
        System.out.println("intUnaryOperator.applyAsInt(10) = " + intUnaryOperator.applyAsInt(10));

        // 기타, IntConsumer, IntSupplier, IntPredicate
    }
}
