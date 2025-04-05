package optional;

import optional.model.Delivery;
import optional.model.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
Optional 은 메서드의 반환 타입으로 쓰는 것을 권잗한다.
    1. 필드에 사용하는 것은 지양하자.
    2. 메서드 매개변수로 사용하는 것도 지양하자.
    3. 컬렉션이나 배열 타입을 Optional 로 감싸지 말
        컬렉션은 그 자체로 비어있음(empty)을 표현할 수 있다.
        컬렉션은 null 을 반환하지 말고 빈 컬렉션을 반환하자.
    4. isPresent() 와 get() 조합을 사용하지 말자.
        get() 사용을 자제해야함.
    5. orElse() 와 orElseGet() 의 차이를 분명하게 인지하자.
        즉시 연산 vs 지연 연산
        비용이 크지 않은 간단한 상수, 대체값이라면 orElse()
        복잡하고 비용이 큰 객체 생성이 필요한 경우, Optional 값이 이미 존재할 가능성이 높다면 orElseGet()
    6. Optional 이 무조건 좋은 것은 아니다.
        비즈니스 로직 상 null 이 될 수 없는 경우라면 일반 타입을 사용하고 방어적으로 예외를 던지는 것이 더 낫다.
 */
public class OrderMain {
    private static Map<Long, Order> orderRepository = new HashMap<>();

    static {
        orderRepository.put(1L, new Order(1L, new Delivery("배송완료", false)));
        orderRepository.put(2L, new Order(2L, new Delivery("배송중", false)));
        orderRepository.put(3L, new Order(3L, new Delivery("배송중", true)));
        orderRepository.put(4L, new Order(4L, null));
    }

    public static void main(String[] args) {
        System.out.println("1 = " + getDeliveryStatus(1l));
        System.out.println("2 = " + getDeliveryStatus(2l));
        System.out.println("3 = " + getDeliveryStatus(3l));
        System.out.println("4 = " + getDeliveryStatus(4l));
    }

    private static String getDeliveryStatus(long id) {
        return findById(id).map(Order::getDelivery)
                .filter(delivery -> !delivery.isCancelled())
                .map(Delivery::getStatus)
                .orElse("배송 X");
    }

    private static Optional<Order> findById(long id) {
        return Optional.ofNullable(orderRepository.get(id));
    }
}
