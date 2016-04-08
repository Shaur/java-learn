package concurrent.example.example2;

public class Main {

  // Пример 2. Синхронизация в банковских операциях.
  //
  public static void main(String[] args) {
    final Account acc1 = new Account(1530, "Mickey Mouse");
    final Account acc2 = new Account(2740, "Donald Duck");

    new Thread(new Runnable() {
      @Override
      public void run() {
        // Переводим 100 рублей с acc1 на acc2.
        transfer(acc1, acc2, 100);
      }
    }).start();


    new Thread(new Runnable() {
      @Override
      public void run() {
        // Переводим 300 рублей с acc2 на acc1.
        transfer(acc2, acc1, 300);
      }
    }).start();
  }


  public static void transfer(Account a, Account b, int amount) {
    synchronized (a) {
      System.out.println("Sync (" + a.getName() + ") for " + String.valueOf(amount));

      // Эмулируем небольшое зависание (например при чтении из базы данных второго аккаунта).
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      synchronized (b) {
        System.out.println("Sync (" + b.getName() + ") for " + String.valueOf(amount));

        // Проводим транзакцию.
        a.withdraw(amount);
        b.debit(amount);
      }
    }
  }
}
