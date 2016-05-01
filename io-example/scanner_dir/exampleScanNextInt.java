package scanner_dir;
import java.util.Scanner;

public class exampleScanNextInt {
    public exampleScanNextInt() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean i = true;
        System.out.print("Введите целое число: ");
        if(sc.hasNextInt()) {
            int i1 = sc.nextInt();
            System.out.println(i1 * 2);
        } else {
            System.out.println("Вы ввели не целое число");
        }

    }
}
