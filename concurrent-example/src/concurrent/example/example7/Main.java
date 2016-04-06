package concurrent.example.example7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

  // Пример 7. Факториал в бассейне (Future, Callable, ExecutorService).
  //
  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(16);
    List<Future<Integer>> results = new ArrayList<Future<Integer>>();

    for (int i = -3; i < 15; i++) {
      Future<Integer> future = executor.submit(new AsyncFactorial(i));
      results.add(future);
    }

    int i = -3;
    for (Future<Integer> future : results) {
      System.out.print(String.valueOf(i) + ": ");

      try {
        System.out.println(future.get());
      } catch (Exception e) {
        System.out.println("Exception");
      }

      i++;
    }

    executor.shutdown();
  }
}
