package simple.threads;

/**
 * Created by OOGIS RG.
 * Yury Glamazdo <glamazdo@oogis.ru>
 * 29.03.16
 */
public class CalculationThread implements Runnable {
    private int i;
    private int b;
    private int result;

    public CalculationThread(int i, int b) {
        super();
        this.i = i;
        this.b = b;
    }

    @Override
    public void run() {
        result = i * b;
    }

    public synchronized int getResult() {
        return result;
    }
}
