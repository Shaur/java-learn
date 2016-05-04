package tests.example.example4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterizedTest extends Assert {

  @Parameterized.Parameters
  public static Collection<String[]> data() {
    return Arrays.asList(new String[][]{
      {"dog", "god"},
      {"cow", "woc"},
      {"human", "namuh"}
    });
  }

  private String src, dst;

  public ParameterizedTest(String src, String dst) {
    this.src = src;
    this.dst = dst;
  }

  @Test
  public void test() {
    assertEquals(dst, WordMirrorer.mirror(src));
  }
}
