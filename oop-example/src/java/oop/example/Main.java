package oop.example;

import oop.example.interfaces.impl.base.Bird;
import oop.example.interfaces.impl.ordinal.Duck;
import oop.example.interfaces.impl.ordinal.Penguin;

/**
 *
 * @author shaur
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bird anyBird = new Duck();
        anyBird.go();

        anyBird = new Penguin();
        anyBird.go();
    }
    
}
