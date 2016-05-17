package ru.javalearn.example.withstream;

import ru.javalearn.example.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by shaur on 19.04.16.
 */
public class ImagesDownloadStream {

    public static void main(String[] args) {
        Long time = System.currentTimeMillis();

        Resources.kitties.parallelStream().forEach((String url)->{
            String fileName = Resources.kitties.indexOf(url) + ".png";
            try {
                Files.copy((new URL(url)).openStream(), Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        System.out.println(System.currentTimeMillis() - time);
    }
}
