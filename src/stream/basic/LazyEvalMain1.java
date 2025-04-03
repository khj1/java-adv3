package stream.basic;

import lambda.lambda5.mystream.MyStreamV3;

import java.util.List;

public class LazyEvalMain1 {
    public static void main(String[] args) {
        //짝수를 추출하고 10을 곱해서 출력한다.
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        ex1(data);
        System.out.println("--------------------");
        ex2(data);
    }

    //직접 만든 스트림 (일괄 처리 방식)
    private static void ex1(List<Integer> data) {
        System.out.println("== MyStreamV3 시작==");

        MyStreamV3.of(data)
                .filter(x -> {
                    boolean isEven = x % 2 == 0;
                    System.out.println("filter() 실행: " + x + "(" + isEven + ")");
                    return isEven;
                })
                .map(x -> {
                    int mapped = x * 10;
                    System.out.println("map() 실행: " + x + "- > " + mapped);
                    return mapped;
                })
                .forEach(System.out::println);

        System.out.println("== MyStreamV3 종료 ==");
    }

    //스트림 API (파이프라인 방식)
    private static void ex2(List<Integer> data) {
        System.out.println("== 스트림 API 시작==");

        data.stream()
                .filter(x -> {
                    boolean isEven = x % 2 == 0;
                    System.out.println("filter() 실행: " + x + "(" + isEven + ")");
                    return isEven;
                })
                .map(x -> {
                    int mapped = x * 10;
                    System.out.println("map() 실행: " + x + "- > " + mapped);
                    return mapped;
                })
                .forEach(System.out::println);

        System.out.println("== 스트림 API 종료 ==");
    }
}
