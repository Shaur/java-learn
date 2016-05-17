package ru.javalearn.example.withstream;

import ru.javalearn.example.Resources;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class SortStringsStream {
    public static void main(String[] args) {
        String[] strings = new String[5];
        final StringBuilder builder = new StringBuilder("");

        Resources.words.stream()
                .sorted((String str1, String str2)
                        -> Integer.compare(str1.length(), str2.length()))
                .forEach(builder::append);

        Stream<Object> objectStream = Resources.words.stream().map((String str)->str.split(".")[0]);
    }
}
