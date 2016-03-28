package me.dmax.p2;


public class Demo5 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (RuntimeException e) { // перехватили RuntimeException
            System.err.print(" 2.1");
            try {
                System.err.print(" 2.2");
                if (true) {throw new Error();} // и бросили новый Error
                System.err.print(" 2.3");
            } catch (Throwable t) {            // перехватили Error
                System.err.print(" 2.4");
            }
            System.err.print(" 2.5");
        } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
            System.err.print(" 3");
        }
        System.err.println(" 4");
    }
}