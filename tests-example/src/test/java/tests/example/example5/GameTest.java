package tests.example.example5;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GameTest extends Assert {

  @Test
  public void testLessAssumption() {
    // Создаем spy для класса игры - spy сейчас полностью
    // повторяет оригинальный класс
    //
    Game gameSpy = spy(new Game());


    // Заменяем protected метод randInt на метод, который
    // всегда будет возвращать 10
    //
    when(gameSpy.randInt()).thenReturn(10);


    // Запускаем игру. randInt будет вызван и вернет 10
    //
    gameSpy.restartGame();


    // Проверяем что результат проверки совпадает с ожидаемым
    //
    assertEquals(gameSpy.checkAssumption(11), Game.AssumptionResult.LESS);


    // Проверяем что randInt был вызван ровно 1 раз
    //
    verify(gameSpy, times(1)).randInt();
  }
}
