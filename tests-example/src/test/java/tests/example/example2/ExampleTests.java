package tests.example.example2;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;


public class ExampleTests extends Assert {

  // Примеры простых проверок
  //
  @Test
  public void testAssetsSimple() {
    // Что значение равно другому (работает для всех типов - для Object через .equals)
    assertEquals(2, 2);
    // Что значение не null
    assertNotNull(new Object());
    // Что значение null
    assertNull(null);
    // Что это не один и тот же объект
    assertNotSame(new Object(), new Object());
    // Что true
    assertTrue(true);
    // Что false
    assertFalse(false);
    // Что массивы одинаковые
    assertArrayEquals(new String[]{"abc", "bcd"}, new String[]{"abc", "bcd"});
  }


  // Примеры с использованием Hamcrest (часть встроена в JUnit, часть нужно импортировать отдельно)
  //
  @Test
  public void testAssertThat() {
    List<String> arr = Arrays.asList(new String[]{"NBC", "CNN"});

    // Что каждая строка в массиве содержит букву "N"
    assertThat(arr, everyItem(containsString("N")));
    // Что в массиве есть строка "CNN"
    assertThat(arr, hasItem("CNN"));
    // Что в массиве нет строки "Fox"
    assertThat(arr, not(hasItem("Fox")));

    // Что это два разных экземпляра объекта (проверка ссылок)
    assertThat(new Object(), not(sameInstance(new Object())));

    // Что число больше 9
    assertThat(12, is(greaterThan(9)));
    // Что число больше 6 и меньше 8
    assertThat(7, allOf(greaterThan(6), lessThan(8)));
  }


  // Пример теста, который проигнорирован
  //
  @Ignore("Test ignored as an example")
  @Test
  public void testSkip() {
    assertEquals(1, 2);
  }


  // Пример таймаута
  //
  @Test(timeout=300)
  public void testWithTimeout() {
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {}
  }


  // Также таймаут можно установить правилом (для всех тестов сразу)
  //
  @Rule
  public Timeout globalTimeout = Timeout.seconds(10);


  // Тест, который проверяет брошено ли исключение
  //
  @Test(expected = IndexOutOfBoundsException.class)
  public void testException() {
    List<String> arr = new ArrayList<>();
    arr.get(10);
  }
}
