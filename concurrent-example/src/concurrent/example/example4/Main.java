package concurrent.example.example4;

public class Main {

  // Пример 4. Много потоков увеличивают счетчик (с атомиками).
  //
  public static void main(String[] args) {
    ThreadsPlusPlus.startWorkers(1000);
  }
}
