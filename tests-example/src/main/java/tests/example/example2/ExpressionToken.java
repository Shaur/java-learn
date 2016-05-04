package tests.example.example2;

public class ExpressionToken {
  public enum ExpressionTokenType {
    SIGN,
    NUMBER_INT,
    NUMBER_FLOAT
  }

  private String value;
  private ExpressionTokenType type;

  public ExpressionToken(String value, ExpressionTokenType type) {
    this.value = value;
    this.type = type;
  }

  public ExpressionTokenType getType() {
    return type;
  }

  public String getValue() {
    return value;
  }
}
