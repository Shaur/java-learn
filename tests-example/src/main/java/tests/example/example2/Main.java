package tests.example.example2;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    ICalculator calc = new Calculator(new ExpressionParser());
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter expression:");

    while (true) {
      String str = sc.nextLine();

      if (str.equals("exit")) {
        System.out.println("Bye bye");
        System.exit(0);
      }

      System.out.println(calc.execute(str));
    }
  }
}
