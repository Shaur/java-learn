package me.dmax.example4;


public class Demo1 {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void d() throws HoHumException {
        throw new HoHumException();
    }
    public static void main(String[] args) {
        try {
            Demo1 lm = new Demo1();
            try {
                lm.f();
            } finally {
                lm.d();
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception";
    }
}
