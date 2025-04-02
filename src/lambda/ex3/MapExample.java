package lambda.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class MapExample {
    public static void main(String[] args) {
        List<String> list = List.of("hello", "java", "lambda");
        List<String> mapped1 = map(list, String::toUpperCase);
        List<String> mapped2 = map(list, s -> "***" + s + "***");

        System.out.println(mapped1);
        System.out.println(mapped2);
    }

    static List<String> map(List<String> list, UnaryOperator<String> function) {
        List<String> mapped = new ArrayList<>();
        for (String s : list) {
            mapped.add(function.apply(s));
        }
        return mapped;
    }
}
