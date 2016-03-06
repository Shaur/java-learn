package oop.example;

import oop.example.interfaces.impl.base.Bird;
import oop.example.interfaces.impl.ordinal.Duck;
import oop.example.interfaces.impl.ordinal.Penguin;


public class Main {

    public static void main(String[] args) {
        Bird anyBird = new Duck();
        anyBird.go();

        anyBird = new Penguin();
        anyBird.go();
    }
    
}
