package stream.collectors;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Collectors1Basic {
    public static void main(String[] args) {
        // 기본 기능
        List<String> list = Stream.of("Java", "Spring", "JAP")
                .collect(toList()); // 수정 가능 리스트 반환
        System.out.println("list = " + list);

        // 수정 불가능 리스트 (java 16+ toList() -> 불변 리스트 제공)
        List<String> unmodifiableList = Stream.of("Java", "Spring", "JAP")
                .collect(toUnmodifiableList());
        System.out.println("unmodifiableList = " + unmodifiableList);

        Set<Integer> set = Stream.of(1, 2, 3, 3, 4, 4, 5, 5)
                .collect(toSet());
        System.out.println("set = " + set);

        // 타입 지정
        TreeSet<Integer> treeSet = Stream.of(3, 4, 5, 1)
                .collect(toCollection(TreeSet::new));
        System.out.println("treeSet = " + treeSet); // TreeSet -> 정렬 유지
    }
}
