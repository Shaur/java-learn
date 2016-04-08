package concurrent.example.example5;

import java.util.Random;

public class Main {

  // Пример 5. Синхронизация в банковских операциях (с локами).
  //
  public static void main(String[] args) {
    final Account acc1 = new Account(1530, "Mickey Mouse");
    final Account acc2 = new Account(2740, "Donald Duck");

    new Thread(new Runnable() {
      @Override
      public void run() {
        // Переводим 100 рублей с acc1 на acc2.
        try {
          transfer(acc1, acc2, 100);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }).start();


    new Thread(new Runnable() {
      @Override
      public void run() {
        // Переводим 300 рублей с acc2 на acc1.
        try {
          transfer(acc2, acc1, 300);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }).start();
  }


  public static void transfer(Account a, Account b, int amount) throws InterruptedException {
    // Пытаемся захватить блокировку для первого аккаунта в течении секунды.
    if (a.getLock().tryLock()) {
      try {
        System.out.println("Sync (" + a.getName() + ") for " + String.valueOf(amount));

        // Эмулируем небольшое зависание - как в примере 2.
        Thread.sleep(100);

        // Пытаемся захватить блокировку для первого аккаунта в течении секунды.
        if (b.getLock().tryLock()) {
          try {
            System.out.println("Sync (" + b.getName() + ") for " + String.valueOf(amount));

            // Проводим транзакцию.
            a.withdraw(amount);
            b.debit(amount);

            return;
          } finally {
            // Освобождаем блокировку для второго аккаунта.
            b.getLock().unlock();
          }
        }

      } finally {
        // Освобождаем блокировку для первого аккаунта.
        a.getLock().unlock();
      }
    }

    // Если не удалось захватить одну из блокировок - пробуем снова через случайный промежуток времени.
    Thread.sleep(new Random().nextInt(1000));
    System.out.println("Retry for " + String.valueOf(amount));
    transfer(a, b, amount);
  }
}
