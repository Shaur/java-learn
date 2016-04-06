package concurrent.example.example2;

public class Account {
  private int balance;

  public Account(int balance) {
    this.balance = balance;
  }

  public void withdraw(int amount) {
    balance -= amount;
  }

  public void debit(int amount) {
    balance += amount;
  }

  public int getBalance() {
    return balance;
  }

  public static void transfer(Account a, Account b, int amount) throws LowBalanceException {
    synchronized (a) {
      System.out.println("Sync a (" + String.valueOf(a.getBalance()) + ") for " + String.valueOf(amount));

      // Эмулируем зависание.
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      synchronized (b) {
        System.out.println("Sync b (" + String.valueOf(b.getBalance()) + ") for " + String.valueOf(amount));

        if (a.getBalance() < amount) {
          throw new LowBalanceException();
        }

        a.withdraw(amount);
        b.debit(amount);
      }
    }
  }
}
