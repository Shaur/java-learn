package ru.javalearn.example.simple;

import ru.javalearn.example.extend.ImplementThread;
import ru.javalearn.example.extend.ThreadExtend;


/**
 * (a + b) * (c + b)
 */
public class FlashCalculation {

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        calculate1Thread();
        //calculate2Threads();
        //onceThread();
        double time = (System.nanoTime() - start) / 1000000;
        System.out.println(String.format("Время: %.2f мс", time));
    }

    public static void calculate2Threads() throws InterruptedException {
        ImplementThread runnable = new ImplementThread(2, 3);
        Thread thread1 = new Thread(runnable);
        thread1.start();

        ThreadExtend thread2 = new ThreadExtend(4, 3);
        thread2.start();

        thread1.join();
        thread2.join();

        double result = runnable.getResult() * thread2.getResult();
        System.out.println(String.format("Конечное значение: %.2f", result));
    }

    public static void calculate1Thread() throws InterruptedException {
        ThreadExtend thread1 = new ThreadExtend(2, 3);
        thread1.start();
        double result = 4 + 3;
        thread1.join();
        result *= thread1.getResult();
        System.out.println(String.format("Конечное значение: %.2f", result));
    }

    public static void onceThread() {
        double result = (2 + 3) * (4 + 3);
        System.out.println(String.format("Конечное значение: %.2f", result));
    }
}
