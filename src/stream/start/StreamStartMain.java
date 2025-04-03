package stream.start;

import java.util.List;

public class StreamStartMain {
    public static void main(String[] args) {
        List<String> names = List.of("Apple", "Banana", "Orange", "Berry");

        // "B"로 시작하는 이름만 필터 후 대문자로 바꿔서 리스트 수집
        List<String> result = names.stream()
                .filter(name -> name.startsWith("B"))
                .map(String::toUpperCase)
                .toList();

        // 외부 반복 출력
        System.out.println("result = " + result);

        // 내부 반복 출력
        names.stream()
                .filter(name -> name.startsWith("B"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
