package me.dmax;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.err.println("1");
        System.out.println(area(-12, 32));
        System.out.println("2");
    }


    public static int area(int width, int height){
        if(width < 0 || height <0) throw new IllegalArgumentException();
        return width * height;
    }
}
