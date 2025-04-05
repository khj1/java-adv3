package defaultmethod.ex3;

import java.time.LocalDateTime;
import java.util.List;

/*
디폴트 메서드의 올바른 사용법
    1. 하위 호환성을 위해 최소한으로 사용해야 한다.
    2. 인터페이스는 여전히 추상화의 역할에 충실하는 것이 좋다.
    3. 디폴트 메서드는 어디까지나 하위 호환을 위한 기능이나 공통으로 쓰기 쉬운 간단한 로직을 제공하는 정도가 이상적이다.
    4. 디폴트 메서드에 상태를 두어선 안된다.
 */
public class NotifierMainV3 {
    public static void main(String[] args) {
        List<Notifier> notifiers = List.of(
                new EmailNotifier(),
                new SMSNotifier(),
                new AppPushNotifier()
        );
        notifiers.forEach(notifier -> notifier.notify("서비스 가입을 환영합니다!"));

        // 스케쥴 기능 추가
        LocalDateTime plusDays = LocalDateTime.now().plusDays(1);
        notifiers.forEach(notifier -> notifier.scheduleNotification("hello!", plusDays));
    }
}
