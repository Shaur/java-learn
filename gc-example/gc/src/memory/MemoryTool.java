package memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * -XX:+UseSerialGC
 * -XX:+UseParallelGC
 * -XX:+UseConcMarkSweepGC
 * -XX:+UseG1GC
 *
 * -Xms512m -Xmx512m
 *
 * @see https://habrahabr.ru/post/112676/
 */
public class MemoryTool {

    private static List objects = new ArrayList();
    private static boolean cont = true;
    private static Scanner in = new Scanner(System.in);

    public static final int MB = 5;

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Memory Tool!");

        MemoryUtil.startGCMonitor();

        while (cont) {
            System.out.println(String.format(help, objects.size(), objects.size() * MB));
            switch (in.nextInt()) {
                case 1: createObjects(); break;
                case 2: removeObjects(); break;
                case 3: System.gc(); break;
                case 4: MemoryUtil.printUsage(true); break;
                default: cont = false; break;
            }
        }

        MemoryUtil.stopGCMonitor();

        System.out.println("Bye!");
    }

    private static void createObjects() {
        System.out.println("Creating objects...");
        for (int i = 0; i < 2; i++) {
            objects.add(new byte[MB * 1024 * 1024]);
        }
    }

    private static void removeObjects() {
        System.out.println("Removing objects...");
        int start = objects.size() - 1;
        int end = start - 2;
        for (int i = start; ((i >= 0) && (i > end)); i--) {
            objects.remove(i);
        }
    }

    private static final String help = "\n\nI have %d objects in use, about %d MB." +
            "\nWhat would you like me to do?\n" +
            "1. Create some objects\n" +
            "2. Remove some objects\n" +
            "3. System.gc()\n" +
            "4. Print usage\n" +
            "0. Quit";
}
