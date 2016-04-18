package ru.javalearn.delegation;




class A {
    void foo() {
        System.out.println("A: вызван метод foo()");
    }
    void bar() {
        System.out.println("A: вызван метод bar()");
    }
}

class B {
    // Создаём объект, методам которого будет делегироваться поведение.
    private A a = new A();

    void foo() {
        a.foo();
    }
    void bar() {
        a.bar();
    }
}


public class Delegation {
    public static void main(String[] args) {
        B b = new B();
        b.foo();
        b.bar();
    }
}
