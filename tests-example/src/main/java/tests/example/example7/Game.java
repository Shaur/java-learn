package tests.example.example7;

import java.util.Observable;

public class Game extends Observable {
  private Boolean[][] grid;
  private int width, height;

  public Game(int width, int height) {
    this.width = width;
    this.height = height;

    grid = new Boolean[width][];

    for (int i = 0; i < width; i++) {
      grid[i] = new Boolean[height];

      for (int j = 0; j < height; j++) {
        grid[i][j] = false;
      }
    }
  }

  public void toggleCellAt(int x, int y) {
    grid[x][y] = !grid[x][y];
    setChanged();
    notifyObservers();
  }

  public Boolean[][] getGrid() {
    return grid;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }
}
