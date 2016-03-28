package me.dmax.w;


public class Demo2 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                //if(true) throw new Exception();
                if(true) throw new Error();
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3");
            } finally {
                System.err.print(" 4");
            }
            System.err.print(" 5");
        } catch (Exception e) {
            System.err.print(" 6");
        } finally {
            System.err.print(" 7");
        }
        System.err.print(" 8");
    }
}