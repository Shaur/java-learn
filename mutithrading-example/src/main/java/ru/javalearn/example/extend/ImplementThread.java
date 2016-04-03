package ru.javalearn.example.extend;


public class ImplementThread implements Runnable {
    private double a;
    private double b;
    private double result;

    public ImplementThread(double a, double b) {
        super();
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        result = a + b;
    }

    public double getResult() {
        return result;
    }
}
