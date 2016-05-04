package tests.example.example1;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest extends Assert {
  // DELTA нужна потому что 0.1 (к примеру) не может быть точно представлена в
  // двоичном формате (подробнее можно почитать тут https://habrahabr.ru/post/112953/)
  private static final double DELTA = 1e-15;

  @Test
  public void testSum() {
    Calculator c = new Calculator(expression -> new ExpressionToken[]{
      new ExpressionToken("2", ExpressionToken.ExpressionTokenType.NUMBER_INT),
      new ExpressionToken("+", ExpressionToken.ExpressionTokenType.SIGN),
      new ExpressionToken("2", ExpressionToken.ExpressionTokenType.NUMBER_INT)
    });

    assertEquals(c.execute("2+2"), 4.0, DELTA);
  }

  @Test(expected = ArithmeticException.class)
  public void testDivideZero() {
    Calculator c = new Calculator(expression -> new ExpressionToken[]{
      new ExpressionToken("0", ExpressionToken.ExpressionTokenType.NUMBER_INT),
      new ExpressionToken("/", ExpressionToken.ExpressionTokenType.SIGN),
      new ExpressionToken("0", ExpressionToken.ExpressionTokenType.NUMBER_INT)
    });

    c.execute("0/0");
  }
}
