package lambda.lambda4;

import java.util.function.Predicate;

//의도를 명확히하고 코드의 가독성을 높이기 위해 사용한다.
public class PredicateMain {
    public static void main(String[] args) {
        Predicate<Integer> p = i -> i < 10;
        System.out.println(p.test(1));
        System.out.println(p.test(11));
    }
}
