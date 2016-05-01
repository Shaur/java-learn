package byteArray;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

class ByteArrayOutputStreamS {
    ByteArrayOutputStreamS() {
    }

    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream f0 = new ByteArrayOutputStream(12);
        System.out.println("введите 10 символов");

        while(f0.size() != 10) {
            f0.write(System.in.read());
        }

        System.out.println("Буфер в виде строки");
        System.out.println(f0.toString());
        System.out.println("В массиве");
        byte[] b = f0.toByteArray();

        for(int i = 0; i < b.length; ++i) {
            System.out.print((char)b[i]);
        }

        System.out.println();
        System.out.println("Работаем с  OutputStream()");
        FileOutputStream f2 = new FileOutputStream("ioExample/test.txt");
        f0.writeTo(f2);
        f0.reset();
        System.out.println("Возвпащаем в файл");

        while(f0.size() != 10) {
            f0.write(System.in.read());
        }

        System.out.println("Done.");
    }
}
