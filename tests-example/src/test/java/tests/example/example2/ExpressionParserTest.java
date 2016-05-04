package tests.example.example2;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionParserTest extends Assert {
  private final IExpressionParser expressionParser = new ExpressionParser();

  @Test
  public void testExpressionWithPlusSign() {
    ExpressionToken[] tokens = expressionParser.parse("2+3");

    assertEquals(tokens.length, 3);

    assertEquals(tokens[1].getValue(), "+");
    assertEquals(tokens[1].getType(), ExpressionToken.ExpressionTokenType.SIGN);
  }

  @Test
  public void testExpressionWithFloatVal() {
    ExpressionToken[] tokens = expressionParser.parse("2.2");

    assertEquals(tokens.length, 1);

    assertEquals(tokens[0].getValue(), "2.2");
    assertEquals(tokens[0].getType(), ExpressionToken.ExpressionTokenType.NUMBER_FLOAT);
  }

  @Test
  public void testExpressionWithExtraWhitespaces() {
    ExpressionToken[] tokens = expressionParser.parse("3.14           / 42");

    assertEquals(tokens.length, 3);

    assertEquals(tokens[0].getValue(), "3.14");
    assertEquals(tokens[0].getType(), ExpressionToken.ExpressionTokenType.NUMBER_FLOAT);

    assertEquals(tokens[1].getValue(), "/");
    assertEquals(tokens[1].getType(), ExpressionToken.ExpressionTokenType.SIGN);

    assertEquals(tokens[2].getValue(), "42");
    assertEquals(tokens[2].getType(), ExpressionToken.ExpressionTokenType.NUMBER_INT);
  }
}
