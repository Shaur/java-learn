package me.dmax.p4;



public class Demo7Mpr {


    public static void main(String[] args) {
        finalThrow();
    }

    private static void finalThrow() {
        try {
            throw new RuntimeException("test");
        } catch (Exception e) {
            // final можно не указывать.
            throw e;
        }
    }



}
