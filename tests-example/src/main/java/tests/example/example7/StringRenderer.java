package tests.example.example7;

import java.util.Observable;
import java.util.Observer;

public class StringRenderer implements Observer {
  private String representation = "";

  public String asString() {
    return representation;
  }

  @Override
  public void update(Observable o, Object arg) {
    if (o instanceof Game) {
      StringBuilder representation = new StringBuilder();
      Game game = (Game) o;
      Boolean[][] grid = game.getGrid();

      for (int i = 0; i < game.getHeight(); i++) {
        for (int j = 0; j < game.getWidth(); j++) {
          representation.append(grid[j][i] ? "X" : ".");
        }

        if (i != grid.length - 1) {
          representation.append("\n");
        }
      }

      this.representation = representation.toString();
    }
  }
}
