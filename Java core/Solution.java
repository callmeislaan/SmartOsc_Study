import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

class A {

}

class B extends A{

}

class Main{
    public static void main(String[] args) {
        A a = new A();
        B b = (B) a;
    }
}0