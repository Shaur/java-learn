package tests.example.example4;


public class WordMirrorer {
  public static String mirror(String word) {
    return new StringBuilder(word).reverse().toString();
  }
}
