package concurrent.example.example2;

public class Account {
  private int balance;
  private String name;

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
}
