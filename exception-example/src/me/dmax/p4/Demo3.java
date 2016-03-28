package me.dmax.p4;



public class Demo3 {
    static void demoproc(){
        NullPointerException е = new NullPointerException("верхний уровень");
        ArithmeticException e2 = new ArithmeticException("причина");
        е.initCause(e2);
        e2.initCause(е);
        throw е;
    }
    public static void main(String args[]) {
        try {
            demoproc();
        }
        catch(NullPointerException e) {
            while (e.getCause()!=null){
                //Exception e2 = e.getCause();
                System.out.println("Перехвачено: " + e) ;
            }
            System.out.println("Перехвачено: " + e) ;
            System.out.println("Исходная причина: " + e.getCause()) ;
        }
    }

}