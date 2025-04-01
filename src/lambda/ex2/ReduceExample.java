package lambda.ex2;

import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);
        int sum = reduce(list, 0, (a, b) -> a + b);
        int mul = reduce(list, 1, (a, b) -> a * b);

        System.out.println("합(누적 +): " + sum);
        System.out.println("곱(누적 *): " + mul);
    }

    static int reduce(List<Integer> list, int initial, MyReducer reducer) {
        int result = initial;
        for (Integer i : list) {
            result = reducer.reduce(result, i);
        }
        return result;
    }
}
