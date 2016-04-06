package concurrent.example.example5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
  private int balance;

  private Lock lock = new ReentrantLock();

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

  public Lock getLock() {
    return lock;
  }

  public static void transfer(Account a, Account b, int amount) throws LowBalanceException, TransferInProgressException {
    // Пытаемся захватить блокировку для первого аккаунта.
    if (a.getLock().tryLock()) {
      // При использовании локов желательно оборачивать свой
      // код в try {...} finally { ... }, иначе можно получить зависший поток.
      try {
        System.out.println("Sync a (" + String.valueOf(a.getBalance()) + ") for " + String.valueOf(amount));

        // Эмулируем зависание (как и в примере без локов).
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        // Пытаемся захватить блокировку для второго аккаунта.
        if (b.getLock().tryLock()) {
          try {
            // В этой части кода гарантированно находится только один
            // поток, который работает с обоими аккаунтами.

            System.out.println("Sync b (" + String.valueOf(b.getBalance()) + ") for " + String.valueOf(amount));

            if (a.getBalance() < amount) {
              throw new LowBalanceException();
            }

            a.withdraw(amount);
            b.debit(amount);
          } finally {
            b.getLock().unlock();
          }
        } else {
          // Если не удалось захватить блокировку для второго аккаунта - кидаем ошибку.
          throw new TransferInProgressException();
        }
      } finally {
        a.getLock().unlock();
      }
    } else {
      // Если не удалось захватить блокировку для первого аккаунта - кидаем ошибку.
      throw new TransferInProgressException();
    }
  }
}
