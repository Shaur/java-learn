package ru.javalearn.example.nonstream;

import ru.javalearn.example.Resources;

import java.util.Collections;

/**
 * Created by shaur on 21.04.16.
 */
public class SortStrings {
    public static void main(String[] args) {
        Collections.sort(Resources.words);
        for(String word : Resources.words) {
            System.out.println(word);
        }
    }
}
