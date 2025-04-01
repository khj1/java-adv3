package lambda.ex2;

import java.util.ArrayList;
import java.util.List;

public class MapExample {
    public static void main(String[] args) {
        List<String> list = List.of("hello", "java", "lambda");
        List<String> mapped1 = map(list, String::toUpperCase);
        List<String> mapped2 = map(list, s -> "***" + s + "***");

        System.out.println(mapped1);
        System.out.println(mapped2);
    }

    static List<String> map(List<String> list, StringFunction function) {
        List<String> mapped = new ArrayList<>();
        for (String s : list) {
            mapped.add(function.apply(s));
        }
        return mapped;
    }
}
