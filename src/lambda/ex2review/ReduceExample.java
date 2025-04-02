package lambda.ex2review;

import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Integer sum = reduce(list, 0, Integer::sum);
        Integer mul = reduce(list, 1, (a, b) -> a * b);

        System.out.println(sum);
        System.out.println(mul);
    }

    private static Integer reduce(List<Integer> list, int initial, MyReducer reducer) {
        int result = initial;
        for (Integer i : list) {
            result = reducer.reduce(result, i);
        }
        return result;
    }
}
