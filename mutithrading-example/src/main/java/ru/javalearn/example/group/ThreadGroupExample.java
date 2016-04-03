package ru.javalearn.example.group;


import ru.javalearn.example.extend.ThreadExtend;

public class ThreadGroupExample {


    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("Test thread group");
        group.enumerate(new ThreadExtend[]{new ThreadExtend(1, 2), new ThreadExtend(3, 2), new ThreadExtend(1, 5)});
        group.setDaemon(true);
    }
}
