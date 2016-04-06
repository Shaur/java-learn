package concurrent.example.example1;

public class ThreadsPlusPlus {
  private static class Worker extends Thread {
    @Override
    public void run() {
      synchronized (LOCK) {
        try {
          // Работник остановится в этом месте до тех пор пока не будет
          // вызван LOCK.notify() или LOCK.notifyAll()
          LOCK.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      increment();
    }
  }

  private static final Object LOCK = new Object();
  private static Integer counter = 0;

  private static void increment() {
    counter++;
  }

  public static void startWorkers(int cnt) {
    Worker w;

    for (int i = 0; i < cnt; i++) {
      w = new Worker();
      w.start();
    }

    // Ждем завершения инициализации всех потоков
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    synchronized (LOCK) {
      LOCK.notifyAll();
    }

    // Ждем завершения работы всех потоков
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(counter);
  }
}
