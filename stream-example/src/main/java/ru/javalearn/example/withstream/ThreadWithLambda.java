package ru.javalearn.example.withstream;

public class ThreadWithLambda {
    public static void main(String[] args) {
        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });


        Thread thread1 = new Thread(()->{

        });
    }
}
