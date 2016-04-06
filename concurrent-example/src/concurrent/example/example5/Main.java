package concurrent.example.example5;

public class Main {

  // Пример 5. Синхронизация в банковских операциях (с локами).
  //
  public static void main(String[] args) {
    final Account acc1 = new Account(1530);
    final Account acc2 = new Account(2740);

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          // Переводим 100 рублей с acc1 на acc2
          Account.transfer(acc1, acc2, 100);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }).start();


    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          // Переводим 300 рублей с acc2 на acc1
          Account.transfer(acc2, acc1, 300);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }).start();
  }
}
