package tests.example.example5;

import java.util.Random;

public class Game {
  private static final int MIN = 1;
  private static final int MAX = 100;
  private int current;
  private int tries;

  public enum AssumptionResult { MORE, LESS, WIN }

  public void restartGame() {
    tries = 0;
    current = randInt();
  }

  public AssumptionResult checkAssumption(int assumption) {
    tries++;

    if (assumption > current) {
      return AssumptionResult.LESS;
    } else if (assumption < current) {
      return AssumptionResult.MORE;
    } else {
      return AssumptionResult.WIN;
    }
  }

  protected int randInt() {
    return new Random().nextInt((MAX - MIN) + 1) + MIN;
  }

  public int getTriesCount() {
    return tries;
  }
}
