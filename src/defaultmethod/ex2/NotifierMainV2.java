package defaultmethod.ex2;

import java.time.LocalDateTime;
import java.util.List;

public class NotifierMainV2 {
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
