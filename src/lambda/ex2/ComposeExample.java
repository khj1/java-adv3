package lambda.ex2;

public class ComposeExample {
    public static void main(String[] args) {
        MyTransformer toUpper = String::toUpperCase;
        MyTransformer addDeco = s -> "**" + s + "**";
        MyTransformer composeFunc = compose(toUpper, addDeco);

        System.out.println(composeFunc.transform("hello"));
    }

    static MyTransformer compose(MyTransformer f1, MyTransformer f2) {
        return s -> {
            String transformed = f1.transform(s);
            return f2.transform(transformed);
        };
    }
}
