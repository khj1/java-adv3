package optional;

import java.util.Optional;
import java.util.Random;

/*
orElse() - 즉시 평가
orElseGet() - 람다를 활용한 지연 평가
 */
public class OrElseGetMain {
    public static void main(String[] args) {
        Optional<Integer> optValue = Optional.of(100);
        Optional<Integer> optEmpty = Optional.empty();

        System.out.println("단순 계산");
        Integer result1 = optValue.orElse(10 * 20); // 10 * 20 계산 후 버림
        Integer result2 = optEmpty.orElse(10 * 20); // 10 * 20 계산 후 사용
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);

        // 값이 있으면 그 값, 없으면 지정된 기본값 사용
        System.out.println("=== orElse ===");
        System.out.println("값이 있는 경우");
        Integer result3 = optValue.orElse(createData());
        System.out.println("result3 = " + result3);

        System.out.println("값이 없는 경우");
        Integer result4 = optEmpty.orElse(createData());
        System.out.println("result4 = " + result4);

        // 값이 있으면 그 값, 없으면 지정된 람다를 사용
        System.out.println("=== orElseGet() ===");
        System.out.println("값이 있는 경우");
        Integer result5 = optValue.orElseGet(OrElseGetMain::createData);
        System.out.println("result5 = " + result5);

        System.out.println("값이 없는 경우");
        Integer result6 = optEmpty.orElseGet(OrElseGetMain::createData);
        System.out.println("result6 = " + result6);
    }

    static int createData() {
        System.out.println("데이터 생성 중...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int createValue = new Random().nextInt(100);
        System.out.println("데이터 생성이 완료되었습니다. 생성 값: " + createValue);
        return createValue;
    }
}
