package me.dmax.p4;


import java.io.FileInputStream;
import java.io.IOException;

public class Demo2 {

    public static void main(String[] args) {
            printFileJava7();
    }

    private static void printFileJava7() {

        try(FileInputStream input = new FileInputStream("file.txt")) {

            int data = input.read();
            while(data != -1){
                System.out.print((char) data);
                data = input.read();
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
