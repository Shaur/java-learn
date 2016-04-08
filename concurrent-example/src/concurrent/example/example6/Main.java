package concurrent.example.example6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

  // Пример 6. Перебор коллекции с параллельным изменением и RW локом.
  //
  public static void main(String[] args) {
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    final List<Integer> list = new ArrayList<Integer>();

    // Заполняем коллекцию 100 значений.
    for (int i = 0; i < 100; i++) {
      list.add(i);
    }

    new Thread(new Runnable() {
      @Override
      public void run() {
        // Через 100 мс удаляем одно значение.
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        rwl.writeLock().lock();
        list.remove(12);
        rwl.writeLock().unlock();
        System.out.println("removed!");
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        // Через 50 мс читаем ещё пару значений.
        try {
          Thread.sleep(50);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        rwl.readLock().lock();
        System.out.println(">>>>> " + list.get(17));
        System.out.println(">>>>> " + list.get(42));
        System.out.println(">>>>> " + list.get(65));
        rwl.readLock().unlock();
      }
    }).start();

    // По очереди с задержкой в 10 мс выводим значения из списка.
    rwl.readLock().lock();
    try {
      for (int i : list) {
        System.out.println(i);
        Thread.sleep(10);

      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    rwl.readLock().unlock();
  }
}
