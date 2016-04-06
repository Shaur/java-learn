package concurrent.example.example7;


import java.util.concurrent.Callable;

public class AsyncFactorial implements Callable<Integer> {
  private int n;

  public AsyncFactorial(int n) {
    this.n = n;
  }

  private int calc(int n) {
    if (n == 0) return 1;
    return n * calc(n - 1);
  }

  @Override
  public Integer call() throws ArithmeticException {
    // Задержка для наглядности.
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    if (n < 0) {
      throw new ArithmeticException("n should be positive");
    }

    return calc(n);
  }
}
