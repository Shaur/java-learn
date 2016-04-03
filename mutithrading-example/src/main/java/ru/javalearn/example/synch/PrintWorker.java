package ru.javalearn.example.synch;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;


public class PrintWorker extends Thread {
    private volatile static PrintWorker instance;
    private FileOutputStream stream;

    public static PrintWorker getInstance() throws FileNotFoundException {
        if(instance == null) {
            synchronized (PrintWorker.class) {
                if(instance == null)
                    instance = new PrintWorker("printer.txt");
            }
        }

        return instance;
    }

    private PrintWorker(String path) {
        try {
            stream = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private PrintWorker() { }

    public static PrintWorker create() {
        return new PrintWorker();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(randomTime());
            synchronized (PrintWorker.getInstance().stream) {
                PrintWorker.getInstance().stream.write((Printer.messages.getFirst() + "\r\n").getBytes());
                PrintWorker.getInstance().stream.write("---------------\r\n".getBytes());
                Printer.messages.removeFirst();
            }

            System.out.println(String.format("Print result from thread: %s", this.getName()));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int randomTime() {
        return (new Random()).nextInt(10) + 1;
    }
}
