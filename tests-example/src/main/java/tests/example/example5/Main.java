package tests.example.example5;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Game game = new Game();

    game.restartGame();

    Scanner sc = new Scanner(System.in);
    System.out.println("Game started");

    while (true) {
      String str = sc.nextLine();

      Game.AssumptionResult res = game.checkAssumption(Integer.parseInt(str));

      switch (res) {
        case LESS:
          System.out.println("less");
          break;
        case MORE:
          System.out.println("more");
          break;
        case WIN:
          System.out.println("You win! Tries count is: " + String.valueOf(game.getTriesCount()));
          game.restartGame();
          System.out.println("Game restarted");
          break;
      }
    }
  }
}
