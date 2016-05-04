package tests.example.example2;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser implements IExpressionParser {

  @Override
  public ExpressionToken[] parse(String expression) {
    List<ExpressionToken> result = new ArrayList<>();

    // Режем по пустому символу до и после одного из знаков "+", "-", "*", "/"
    String[] parts = expression.split("(?<=[\\+\\-\\*/])|(?=[\\+\\-\\*/])");

    for (String part : parts) {
      part = part.trim();

      // Строки в switch будут работать только в JDK 7+
      switch (part) {
        case "":
          break;

        case "+":
        case "-":
        case "*":
        case "/":
          result.add(new ExpressionToken(part, ExpressionToken.ExpressionTokenType.SIGN));
          break;

        default:
          if (part.contains(".")) {
            result.add(new ExpressionToken(part, ExpressionToken.ExpressionTokenType.NUMBER_FLOAT));
          } else {
            result.add(new ExpressionToken(part, ExpressionToken.ExpressionTokenType.NUMBER_INT));
          }
      }
    }

    return result.toArray(new ExpressionToken[result.size()]);
  }
}
