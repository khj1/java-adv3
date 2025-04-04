package stream.collectors;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.maxBy;

public class Collectors4MinMax {
    public static void main(String[] args) {
        // 다운스트림 컬렉터에서 유용하게 사용한다.
        Integer max1 = Stream.of(1, 2, 3)
                .collect(maxBy(
                        (o1, o2) -> o1.compareTo(o2)
                )).get();
        System.out.println("max1 = " + max1);

        // 기본형 특화 스트림
        int max2 = IntStream.of(1, 2, 3)
                .max()
                .getAsInt();
        System.out.println("max2 = " + max2);
    }
}
