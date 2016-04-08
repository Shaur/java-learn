package concurrent.example.example1;

import java.util.LinkedList;
import java.util.List;

public class Main {
  private static Integer counter = 0;


  // Пример 1. Много потоков увеличивают счетчик.
  //
  public static void main(String[] args) {
    List<Thread> threads = new LinkedList<Thread>();

    // Запускаем 1000 потоков.
    for (int i = 0; i < 1000; i++) {
      Thread t = new Thread(new Worker());
      t.start();
      threads.add(t);
    }

    // Ждем пока все потоки закончат работу.
    try {
      for (Thread t : threads) {
        t.join();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Выводим результат.
    System.out.println(counter);
  }


  // Поток увеличивает counter 1000 раз.
  private static class Worker implements Runnable {
    @Override
    public void run() {
      for (int i = 0; i < 1000; i++) {
        counter++;
      }
    }
  }
}
