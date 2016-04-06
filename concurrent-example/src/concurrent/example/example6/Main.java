package concurrent.example.example6;

public class Main {

  // Пример 6. Перебор коллекции с параллельным изменением и RW локом.
  //
  public static void main(String[] args) {
    final RWDictionary dict = new RWDictionary();

    dict.put("a", "a1");
    dict.put("b", "b1");
    dict.put("c", "c1");
    dict.put("d", "d1");

    final Object o = new Object();

    // Первый поток на чтение.
    new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (o) {
          try {
            o.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        for (int i = 0; i < 3; i++) {
          dict.get("a");
        }
      }
    }).start();

    // Второй поток на чтение.
    new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (o) {
          try {
            o.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        for (int i = 0; i < 2; i++) {
          dict.get("b");
        }
      }
    }).start();

    // Поток на запись.
    new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (o) {
          try {
            o.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        for (int i = 0; i < 3; i++) {
          dict.put("e", "e1");
        }
      }
    }).start();

    // Подождем пока все три потока запустятся и будут ждать на o.wait().
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Запускаем все три разом.
    synchronized (o) {
      o.notifyAll();
    }
  }
}
