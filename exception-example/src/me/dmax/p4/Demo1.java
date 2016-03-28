package me.dmax.p4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class Demo1 {


    public static void main(String[] args) {

    }

    private static void printFile() throws IOException {
        InputStream input = null;
        try {
            input = new FileInputStream("file.txt"); //!

            int data = input.read(); //!
            while(data != -1){
                System.out.print((char) data);
                data = input.read(); //!
            }
        } catch (IOException e){
            System.out.println(e);
        }finally {
            if(input != null){
                input.close(); //!
            }
        }
    }
}
