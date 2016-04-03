package ru.javalearn.example.synch;

import java.util.ArrayList;
import java.util.List;


public class NoSynchCollection {
    private static List<String> names = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (names) {
                    for (int i = 0; i < 50; i++) {
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        names.add("Thread one was here!");
                    }
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (names) {
                    for (int i = 0; i < 50; i++) {

                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        names.add("Thread two was not here!");
                    }
                }

            }
        });

        thread2.start();
        thread1.start();


        thread1.join();
        thread2.join();

        for (String name : names) {
            System.out.println(name);
        }
    }
}
