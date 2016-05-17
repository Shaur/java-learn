package simple;

import simple.threads.CalculationThread;

/**
 * Created by OOGIS RG.
 * Yury Glamazdo <glamazdo@oogis.ru>
 * 29.03.16
 */
public class SimpleInCodeThread {

    public static void main(String[] args) {


        CalculationThread thread = new CalculationThread(2, 2);
        System.out.println(thread.getResult());
    }
}
