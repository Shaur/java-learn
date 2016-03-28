package me.dmax.p4;


import java.sql.SQLException;

public class Demo4 {
    // Нету throws: исключения не объявлены
    public static void main(String[] args) {
        doThrow(new Exception());
    }

    static void doThrow(Exception e) {
        Demo4.<RuntimeException> doThrow0(e);
    }

    //@SuppressWarnings("unchecked")
    static <E extends Exception>
    void doThrow0(Exception e) throws E {
        throw (E) e;
    }
}
