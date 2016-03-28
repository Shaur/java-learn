package me.dmax.example3;


public class Demo5 {
    public static void main(String[] args) {
        // тут все компилируется, Demo.test хотел Parent и мы дали ему подтип - Child
        Demo.test(new ChildD5());
    }
}

class Demo {
    public static void test(Parent ref) {
        // тут все компилируется, Parent.f() пугает Exception и мы его ловим catch
        try {
            ref.f();
        } catch(Exception e) {}
    }
}

class Parent {
    // предок пугает Exception
    public void f() throws Exception {}
}

// тут ошибка компиляции в Java, но, ДОПУСТИМ, ее нет
class ChildD5 extends Parent {
    // потомок расширил Exception до Throwable
    @Override
    public void f()/*throws Throwable*/ {

    }
}

