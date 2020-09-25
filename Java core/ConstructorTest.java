class Child {
    public static String a = "first";

    static{
        a += " block init";
        System.out.println(a);
        System.out.println("block constructor");
    }

    public Child() {
        a += " constructor";
        System.out.println(a);
        System.out.println("no argument constructor");
    }
}

public class ConstructorTest {
    public static void main(String[] args) {
//        Child child = new Child();
//        System.out.println(child.a);
//        child.a = "changed";
//        System.out.println(child.a);
        System.out.println(Child.a);
    }
}

