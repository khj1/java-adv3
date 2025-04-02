package lambda.ex2review;

public class ComposeExample {
    public static void main(String[] args) {
        MyTransformer toUpperCase = String::toUpperCase;
        MyTransformer addDeco = s -> "**" + s + "**";
        MyTransformer composed = compose(toUpperCase, addDeco);
        System.out.println(composed.transform("hello"));
    }

    private static MyTransformer compose(MyTransformer f1, MyTransformer f2) {
        return s -> {
            String transformed = f1.transform(s);
            return f2.transform(transformed);
        };
    }
}
