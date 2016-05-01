package FileIO;

import java.io.FileOutputStream;

public class exampleFileOutputStream {
    public static byte[] getlnput() throws Exception {
        System.out.println("Введите данные....");
        byte[] buffer = new byte[12];

        for(int i = 0; i < 12; ++i) {
            buffer[i] = (byte)System.in.read();
        }

        return buffer;
    }

    public static void main(String[] args) throws Exception {
        byte[] buf = getlnput();
        FileOutputStream f0 = new FileOutputStream("ioExample/file1.txt");
        FileOutputStream f1 = new FileOutputStream("ioExample/file2.txt");
        FileOutputStream f2 = new FileOutputStream("ioExample/file3.txt");

        for(int i = 0; i < 12; i += 2) {
            f0.write(buf[i]);
        }

        f0.close();
        f1.write(buf);
        f1.close();
        f2.write(buf, 3, 6);
        f2.close();
    }
}
