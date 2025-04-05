package defaultmethod.ex2;

import java.time.LocalDateTime;

public interface Notifier {
    void notify(String message);

    // 신규 기능 추가
    void scheduleNotification(String message, LocalDateTime scheduleTime);
}
