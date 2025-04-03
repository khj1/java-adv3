package stream.basic;

import lambda.lambda5.mystream.MyStreamV3;

import java.util.List;

/*
스트림 API가 지연 연산을 사용하는 이유
    - 스트림의 중간 연산의 결과 중 첫번째 값만 필요하다면?
    - 리스트의 모든 요소에 중간 연산을 적용할 필요 없이
    - 요소 별로 연산을 실행해서 성능을 최적화 시킬 수 있다.
        - 불필요한 연산 생략
        - 메모리를 효율적으로 사용
            - 중간 연산의 결과를 매 단계마다 별도의 자료구조에 저장하지 않고
            - 최종 연산 때까지 필요할 때만 가져와서 처리한다.
        - 파이프라인 최적화
 */
public class LazyEvalMain3 {
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

        Integer result = MyStreamV3.of(data)
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
                .getFirst();

        System.out.println("result = " + result);
        System.out.println("== MyStreamV3 종료 ==");
    }

    //스트림 API (파이프라인 방식)
    private static void ex2(List<Integer> data) {
        System.out.println("== 스트림 API 시작==");

        Integer result = data.stream()
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
                .findFirst().get();

        System.out.println("result = " + result);
        System.out.println("== 스트림 API 종료 ==");
    }
}
