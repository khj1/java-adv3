package lambda.ex2review;

import java.util.ArrayList;
import java.util.List;

public class MapExample {
    public static void main(String[] args) {
        List<String> list = List.of("java", "spring", "jpa");
        List<String> mapped = map(list, String::toUpperCase);

        System.out.println(mapped);
    }

    private static List<String> map(List<String> list, MyTransformer transformer) {
        List<String> mapped = new ArrayList<>();
        for (String s : list) {
            mapped.add(transformer.transform(s));
        }
        return mapped;
    }
}
