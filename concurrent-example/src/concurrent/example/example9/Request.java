package concurrent.example.example9;


import java.util.Random;

public class Request {
  private int id;

  public Request() {
    id = Math.abs(new Random().nextInt());
    System.out.println(String.valueOf(id) + ": request added");
  }

  public void response(String responseText) {
    try {
      Thread.sleep(new Random().nextInt(1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(String.valueOf(id) + ": " + responseText);
  }
}
