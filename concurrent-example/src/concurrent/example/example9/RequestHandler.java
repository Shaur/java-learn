package concurrent.example.example9;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class RequestHandler extends Thread {
  private BlockingQueue<Request> requests = new LinkedBlockingDeque<Request>();
  private int handlerId;

  public RequestHandler(BlockingQueue<Request> requests, int handlerId) {
    this.requests = requests;
    this.handlerId = handlerId;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Request request = requests.take();
        request.response("Hello!");
        System.out.println(String.valueOf(handlerId) + ": response handled");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
