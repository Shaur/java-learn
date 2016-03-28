package me.dmax.p3;


import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo2 {
    // они пугают целым Throwable
    public static void main(String[] args) throws Throwable {
        f();
    }
    // хотя мы пугали всего-лишь Exception
    public static void f() throws Exception {
    }




    //public static void d2() throws IOException {
    public static void d2() throws IOException {
        f0();
        f1();

    }
    public static void f0() throws EOFException {}
    public static void f1() throws FileNotFoundException {}
}
