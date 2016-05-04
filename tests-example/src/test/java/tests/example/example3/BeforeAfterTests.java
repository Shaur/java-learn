package tests.example.example3;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class BeforeAfterTests extends Assert {
  private List<Integer> arr;


  // Метод будет вызван один раз перед всеми тестами. В нем можно открыть общий
  // для всех тестов ресурс - например файл.
  //
  @BeforeClass
  public static void setUpClass() {
    System.out.println("BeforeClass");
    System.out.println("");
  }


  // Метод будет вызван один раз после всех тестов. В нем можно закрыть общие
  // ресурсы, открытые в setUpClass.
  //
  @AfterClass
  public static void tearDownClass() {
    System.out.println("AfterClass");
  }


  // Будет вызван перед каждым тестом. Тут можно подготовить тестовые данные,
  // если они одинаковые для всех тесто.
  //
  @Before
  public void setUp() {
    System.out.println("Before");

    arr = new ArrayList<>();

    arr.add(10);
    arr.add(20);
    arr.add(30);
  }


  // После каждого теста
  //
  @After
  public void tearDown() {
    System.out.println("After");

    arr.clear();
  }


  @Test
  public void testSum() {
    System.out.println("Test 1");

    int sum = 0;

    for (Integer item : arr) {
      sum += item;
    }

    assertEquals(sum, 60);
  }


  @Test
  public void testMulti() {
    System.out.println("Test 2");

    int acc = 1;

    for (Integer item : arr) {
      acc *= item;
    }

    assertEquals(acc, 6000);
  }
}
