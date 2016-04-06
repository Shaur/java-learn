package concurrent.example.example1;

public class Main {

  // Пример 1. Много потоков увеличивают счетчик.
  //
  public static void main(String[] args) {
    ThreadsPlusPlus.startWorkers(1000);
  }
}
