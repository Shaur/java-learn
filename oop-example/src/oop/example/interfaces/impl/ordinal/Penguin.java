package oop.example.interfaces.impl.ordinal;

import oop.example.interfaces.impl.base.Bird;

/**
 * Created by shaur on 28.02.16.
 * for Imp manga server project
 */
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
