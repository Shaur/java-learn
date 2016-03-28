package me.dmax.example2;


public class Demo1 {
    public static void main(String[] args) {
        try {
            System.err.println(" 0");
            if (true) {throw new RuntimeException("Info");}
            System.err.println(" 1");
        } catch (Exception e) {
            System.err.println(" 2 " + e.getMessage());
        }
        System.err.println(" 3");
    }
}
