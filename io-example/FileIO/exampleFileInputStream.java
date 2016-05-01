package FileIO;
import java.io.FileInputStream;

public class exampleFileInputStream {
    public static void main(String[] args) throws Exception {
        FileInputStream f1 = new FileInputStream("ioExample/test.txt");
        int size = f1.available();
        System.out.println("Всего свободно байтов: " + size);
        System.out.println(" 1/4 ая файла: read() = \n");

        for(int b = 0; b < size / 4; ++b) {
            System.out.println("");
            System.out.print((char)f1.read());
            System.out.println("!!!!!!!!!");
        }

        System.out.println("Всего: " + f1.available());
        System.out.println("Читаем следающую 1/8: read(b[])");
        byte[] var5 = new byte[size / 8];
        if(f1.read(var5) != var5.length) {
            System.err.println("херня");
        }

        String tmpstr = new String(var5, 0, var5.length);
        System.out.println(tmpstr);
        System.out.println("Сейчес имеем байтов: " + f1.available());
        System.out.println("Пропускаем 1/4: skip()");
        f1.skip((long)(size / 4));
        System.out.println("Сейчас имеем: " + f1.available());
        f1.close();
    }
}
