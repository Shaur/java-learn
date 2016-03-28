package me.dmax.p2;


public class Demo6 {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (RuntimeException e) {  ///нельзя ставить потомка после предка!
            System.err.println("catch RuntimeException");
        } catch (Exception e) {
            System.err.println("catch Exception");
        } catch (Throwable e) {
            System.err.println("catch Throwable");
        }
        System.err.println("next statement");
    }
}
