package tests.example.example1;

import org.junit.Assert;
import org.junit.Test;
import tests.example.example1.ExpressionToken.ExpressionTokenType;

public class ExpressionParserTest extends Assert {
  private final IExpressionParser expressionParser = new ExpressionParser();

  @Test
  public void testExpressionWithPlusSign() {
    ExpressionToken[] tokens = expressionParser.parse("2+3");

    assertEquals(3, tokens.length);

    assertEquals("+", tokens[1].getValue());
    assertEquals(ExpressionTokenType.SIGN, tokens[1].getType());
  }

  @Test
  public void testExpressionWithFloatVal() {
    ExpressionToken[] tokens = expressionParser.parse("1.21");

    assertEquals(1, tokens.length);

    assertEquals("1.21", tokens[0].getValue());
    assertEquals(ExpressionTokenType.NUMBER_FLOAT, tokens[0].getType());
  }

  @Test
  public void testExpressionWithExtraWhitespaces() {
    ExpressionToken[] tokens = expressionParser.parse("3.14           / 42");

    assertEquals(3, tokens.length);

    assertEquals("3.14", tokens[0].getValue());
    assertEquals(ExpressionTokenType.NUMBER_FLOAT, tokens[0].getType());

    assertEquals("/", tokens[1].getValue());
    assertEquals(ExpressionTokenType.SIGN, tokens[1].getType());

    assertEquals("42", tokens[2].getValue());
    assertEquals(ExpressionTokenType.NUMBER_INT, tokens[2].getType());
  }
}
