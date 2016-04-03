package ru.javalearn.example.synch;

import java.util.LinkedList;


public class Printer {

    public static LinkedList<String> messages = new LinkedList<>();

    public void print(String message) {
        messages.add(message);
        PrintWorker.create().start();
    }


}
