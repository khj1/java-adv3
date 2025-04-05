package optional;

import optional.model.Address;
import optional.model.User;

import java.util.Optional;

public class AddressMain1 {
    public static void main(String[] args) {
        User user1 = new User("user1", null);
        User user2 = new User("user2", new Address("hello street"));

        printStreet(user1);
        printStreet(user2);
    }

    private static void printStreet(User user) {
        System.out.println(getUserStreet(user).orElse("Unknown"));
    }

    // 메서드 체이닝 중간에 null 이 등장하면 Optional.empty() 반환
    static Optional<String> getUserStreet(User user) {
        return Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getStreet);
    }
}
