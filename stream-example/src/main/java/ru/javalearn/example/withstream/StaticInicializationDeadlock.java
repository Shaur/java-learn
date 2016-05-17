package ru.javalearn.example.withstream;

import java.util.stream.IntStream;

/**
 * Created by shaur on 22.04.16.
 */
public class StaticInicializationDeadlock {
    private static final int SUM = IntStream.range(0, 100).parallel().reduce((left, right) -> left + right).getAsInt();

    public static void main(String[] args) {
        System.out.println(SUM);
    }
}


