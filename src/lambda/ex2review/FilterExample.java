package lambda.ex2review;

import java.util.ArrayList;
import java.util.List;

public class FilterExample {
    public static void main(String[] args) {
        List<Integer> list = List.of(-2, -1, 0, 1, 2);
        List<Integer> filteredA = filter(list, i -> i < 0);
        List<Integer> filteredB = filter(list, i -> i % 2 == 0);

        System.out.println(filteredA);
        System.out.println(filteredB);
    }

    private static List<Integer> filter(List<Integer> list, MyPredicate predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (int i : list) {
            if (predicate.test(i)) {
                filtered.add(i);
            }
        }
        return filtered;
    }
}
