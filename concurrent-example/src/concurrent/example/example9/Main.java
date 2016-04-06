package concurrent.example.example9;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class Main {

  // Пример 9. Очередь обработки запросов.
  //
  public static void main(String[] args) {
    BlockingQueue<Request> requests = new LinkedTransferQueue<Request>();

    for (int i = 0; i < 3; i++) {
      new RequestHandler(requests, i).start();
    }

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    for (int i = 0; i < 5; i++) {
      requests.add(new Request());
    }

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    for (int i = 0; i < 7; i++) {
      requests.add(new Request());
    }
  }
}
