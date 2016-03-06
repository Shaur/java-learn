package oop.example.interfaces.impl.ordinal;

import oop.example.interfaces.impl.base.Bird;


public class Penguin extends Bird {

    @Override
    public Boolean canFly() {
        return false;
    }

    @Override
    public void go() {
        System.out.println("Penguin cant't fly, but very quick in water");
    }
}
