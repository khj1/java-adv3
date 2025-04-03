package lambda.lambda5.filter;

import java.util.List;

public class FilterMainV3 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = IntegerFilter.filter(numbers, i -> i % 2 == 0);
        List<Integer> oddNumbers = IntegerFilter.filter(numbers, i -> i % 2 == 1);

        System.out.println("evenNumbers = " + evenNumbers);
        System.out.println("oddNumbers = " + oddNumbers);
    }
}
