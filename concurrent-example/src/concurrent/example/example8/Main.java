package concurrent.example.example8;


import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {

  // Пример 8. Synchronizers.
  //
  public static void main(String[] args) {
    example1();
  }


  // Semaphore.
  //
  private static class SemaphoreWorker extends Thread {
    private Semaphore s;
    private int id;

    public SemaphoreWorker(Semaphore s, int id) {
      this.s = s;
      this.id = id;
    }

    @Override
    public void run() {
      System.out.println(String.valueOf(id) + ": before acquire");

      try {
        s.acquire();
      } catch (InterruptedException e) {
        e.printStackTrace();
        return;
      }

      try {
        System.out.println(String.valueOf(id) + ": acquire success");
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println(String.valueOf(id) + ": release success");
        s.release();
      }

      System.out.println(String.valueOf(id) + ": after acquire");
    }
  }

  private static void example1() {
    Semaphore s = new Semaphore(2);

    for (int i = 0; i < 10; i++) {
      new SemaphoreWorker(s, i).start();
    }
  }


  // CountDownLatch.
  //
  private static class CountDownLatchWorker extends Thread {
    private CountDownLatch l;
    private int id;

    public CountDownLatchWorker(CountDownLatch l, int id) {
      this.l = l;
      this.id = id;
    }

    @Override
    public void run() {
      try {
        Thread.sleep(new Random().nextInt(2000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println(String.valueOf(id) + ": done");
      l.countDown();
    }
  }

  private static void example2() {
    CountDownLatch l = new CountDownLatch(4);

    for (int i = 0; i < 8; i++) {
      new CountDownLatchWorker(l, i).start();
    }

    try {
      l.await();
      System.out.println("4 workers done here");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  // CyclicBarrier.
  //
  private static class CyclicBarrierWorker extends Thread {
    private CyclicBarrier cb;
    private int id;

    public CyclicBarrierWorker(CyclicBarrier cb, int id) {
      this.cb = cb;
      this.id = id;
    }

    @Override
    public void run() {
      System.out.println(String.valueOf(id) + ": start");

      try {

        Thread.sleep(new Random().nextInt(10000));
        cb.await();

      } catch (Exception e) {
        e.printStackTrace();
      }

      System.out.println(String.valueOf(id) + ": done");
    }
  }

  private static void example3() {
    CyclicBarrier cb = new CyclicBarrier(3);


    for (int i = 0; i < 12; i++) {
      new CyclicBarrierWorker(cb, i).start();
    }
  }
}
