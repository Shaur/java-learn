package me.dmax.example4;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.io.IOException;

public class Demo7Multi {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            if (args == null) {
                throw new IOException();
            } else {
                throw new InterruptedException();
            }
        } catch (InterruptedException | IOException e) {

            e.printStackTrace();
            System.out.println("сообщение");
            //throw e;
        }
    }
}

