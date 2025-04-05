package optional.logger;

/*
자바 언어의 연산자 우선순위상 메서드를 호출하기 전에 괄호 안의 내용이 먼저 계산된다.
 */
public class LogMain1 {
    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.setDebug(true);
        logger.debug(10 * 20);

        System.out.println("== 디버그 모드 끄기 ===");
        logger.setDebug(false);
        logger.debug(100 * 200);
        /*
        Debug 모드가 꺼져있기 때문에 연산이 출력되지 않는다.
        따라서 100 * 200 연산도 실행될 필요가 없다.
        하지만 위 코드는 100 * 200 연산을 실행한 후 결과 값을 버리는 비효율적인 방식이다.
         */
    }
}
