package defaultmethod.ex3;

import java.time.LocalDateTime;

public interface Notifier {
    void notify(String message);

    default void scheduleNotification(String message, LocalDateTime scheduleTime) {
        System.out.println("[기본 스케쥴링] message: " + message + ", time: " + scheduleTime);
    }
}
