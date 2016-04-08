package concurrent.example.example3;

import java.util.ArrayList;
import java.util.List;

public class Main {

  // Пример 3. Перебор коллекции с параллельным изменением.
  //
  public static void main(String[] args) {
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
        list.remove(12);
      }
    }).start();

    // По очереди с задержкой в 10 мс выводим значения из списка.
    for (int i : list) {
      System.out.println(i);
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
