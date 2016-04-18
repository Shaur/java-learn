package ru.javalearn.singleton;


public enum EnumSingleton {
    INSTANCE;

    public int someMethod() {
        return 123;
    }

    public void anotherMethod() {
        //***
    }
}

class App{
    public static void main(String[] args) {
        System.out.println(EnumSingleton.INSTANCE.someMethod());
    }
}