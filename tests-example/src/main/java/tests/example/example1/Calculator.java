package tests.example.example1;

public class Calculator implements ICalculator {
  private IExpressionParser expressionParser;

  public Calculator(IExpressionParser expressionParser) {
    this.expressionParser = expressionParser;
  }

  @Override
  public float execute(String expression) {
    ExpressionToken[] tokens = this.expressionParser.parse(expression);

    float acc = 0;
    String sign = "+";

    for (ExpressionToken token : tokens) {
      if (token.getType().equals(ExpressionToken.ExpressionTokenType.SIGN)) {
        sign = token.getValue();
      } else {
        switch (sign) {
          case "+":
            acc += Float.parseFloat(token.getValue());
            break;
          case "-":
            acc -= Float.parseFloat(token.getValue());
            break;
          case "*":
            acc *= Float.parseFloat(token.getValue());
            break;
          case "/":
            float val = Float.parseFloat(token.getValue());

            if (val == 0) {
              throw new ArithmeticException("can't divide to zero");
            }

            acc /= val;
            break;
        }
      }
    }

    return acc;
  }
}
