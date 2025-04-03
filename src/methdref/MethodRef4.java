package methdref;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodRef4 {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Kim"),
                new Person("Park"),
                new Person("Lee")
        );

        List<String> result1 = mapPersonToString(personList, Person::introduce);
        System.out.println("result1 = " + result1);

        List<String> result2 = mapStringToString(result1, String::toUpperCase);
        System.out.println("result2 = " + result2);
    }

    static List<String> mapPersonToString(List<Person> personList, Function<Person, String> function) {
        List<String> result = new ArrayList<>();
        for (Person person : personList) {
            String applied = function.apply(person);
            result.add(applied);
        }
        return result;
    }

    static List<String> mapStringToString(List<String> strings, Function<String, String> function) {
        List<String> result = new ArrayList<>();
        for (String s : strings) {
            String applied = function.apply(s);
            result.add(applied);
        }
        return result;
    }
}
