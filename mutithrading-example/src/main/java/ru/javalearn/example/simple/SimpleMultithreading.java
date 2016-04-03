package ru.javalearn.example.simple;

public class SimpleMultithreading {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Это выводится в отдельном потоке");
            }
        });

        System.out.println("Это выводится до начала выполнения потока");
        thread1.start();
        thread1.join();
        System.out.println("Это выводится во время выполнения потока");
    }
}