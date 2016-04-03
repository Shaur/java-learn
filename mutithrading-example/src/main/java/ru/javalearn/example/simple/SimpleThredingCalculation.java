package ru.javalearn.example.simple;


public class SimpleThredingCalculation {
    private static double result;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                result = 2 * 3;
            }
        });

        thread1.start();
        System.out.println(String.format("Попробуем получить результат сразу: %.2f", result));
        thread1.join();
        System.out.println(String.format("А теперь получим значение после гарантрованного завершения потока: %.2f", result));
    }
}
