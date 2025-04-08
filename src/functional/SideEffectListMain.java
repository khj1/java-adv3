package functional;

import java.util.ArrayList;
import java.util.List;

public class SideEffectListMain {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("apple");
        list1.add("banana");

        System.out.println("before list1 = " + list1);
        changeList1(list1);
        System.out.println("after list1 = " + list1);

        List<String> list2 = new ArrayList<>();
        list2.add("apple");
        list2.add("banana");

        System.out.println("before list2 = " + list2);
        List<String> resultList = changeList2(list2);
        System.out.println("after list2 = " + list2);
        System.out.println("after resultList = " + resultList);

        /*
        함수형 프로그래밍에서는 원본을 유지하는 2번째 방식을 권장한다.
         */
    }

    private static void changeList1(List<String> list) {
        list.replaceAll(s -> s + " complete");
    }

    private static List<String> changeList2(List<String> list) {
        return list.stream()
                .map(s -> s + " complete")
                .toList();
    }
}
