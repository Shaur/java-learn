package ru.javalearn.example.nonstream;

import ru.javalearn.example.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class ImagesDownload {

    public static void main(String[] args) {
        Long time = System.currentTimeMillis();

        for (String url : Resources.kitties) {
            String fileName = Resources.kitties.indexOf(url) + ".png";
            try {
                Files.copy((new URL(url)).openStream(), Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(System.currentTimeMillis() - time);
    }
}
