package concurrent.example.example5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
  private int balance;
  private String name;

  private Lock lock = new ReentrantLock();

  public Account(int balance, String name) {
    this.balance = balance;
    this.name = name;
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

  public String getName() {
    return name;
  }

  public Lock getLock() {
    return lock;
  }
}
