package lambda.lambda4;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierMain {
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> new Random().nextInt(10);
        System.out.println(supplier.get());
    }
}
