package lambda.ex2;

import java.util.ArrayList;
import java.util.List;

public class FilterExample {
    public static void main(String[] args) {
        List<Integer> list = List.of(-3, -2, -1, 1, 2, 3, 5);
        List<Integer> filter1 = filter(list, i -> i < 0);
        List<Integer> filter2 = filter(list, i -> i % 2 == 0);

        System.out.println(filter1);
        System.out.println(filter2);
    }

    static List<Integer> filter(List<Integer> list, MyPredicate predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer i : list) {
            if (predicate.test(i)) {
                filtered.add(i);
            }
        }
        return filtered;
    }
}
