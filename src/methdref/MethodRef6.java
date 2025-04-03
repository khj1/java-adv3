package methdref;

import java.util.function.BiFunction;

public class MethodRef6 {
    public static void main(String[] args) {
        Person person = new Person("Kim");

        BiFunction<Person, Integer, String> fun1 = (p, integer) -> p.introduceWithNumber(integer);
        System.out.println("person.introduceWithNumber = " + fun1.apply(person, 1));

        //타입이 첫번째 매개변수가 된다.
        //그리고 첫번째 매개변수의 메서드를 호출한다.
        BiFunction<Person, Integer, String> fun2 = Person::introduceWithNumber;
        System.out.println("person.introduceWithNumber = " + fun2.apply(person, 1));
    }
}
