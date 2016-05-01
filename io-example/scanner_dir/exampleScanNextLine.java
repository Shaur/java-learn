package scanner_dir;

import java.util.Scanner;

public class exampleScanNextLine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первую строку");
        String s1 = sc.nextLine();
        System.out.println("Введите Второю строку для склейки");
        String s2 = sc.nextLine();
        System.out.print("Результат: ");
        System.out.println(s1 + s2);
    }
}
