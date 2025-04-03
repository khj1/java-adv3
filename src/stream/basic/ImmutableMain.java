package stream.basic;

import java.util.List;

// 스트림은 원본을 절대 바꾸지 않는다.
public class ImmutableMain {
    public static void main(String[] args) {
        List<Integer> origin = List.of(1, 2, 3, 4, 5);
        System.out.println("origin = " + origin);

        List<Integer> filtered = origin.stream()
                .filter(e -> e % 2 == 0)
                .toList();

        System.out.println("origin = " + origin);
        System.out.println("filtered = " + filtered);
    }
}
