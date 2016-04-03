package ru.javalearn.example.synch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OOGIS RG.
 * Yury Glamazdo <glamazdo@oogis.ru>
 * 01.04.16
 */
public class PrintWorkerExample {


    public static void main(String[] args) throws IOException, InterruptedException {
        int result = 0;
        Printer printer = new Printer();
        for (int i = 0; i < 100; i++) {
            result += i;
            System.out.println(String.format("Calculate iteration %s with value %s", i, result));
            printer.print(String.valueOf(result));
        }
    }
}
