package oop.example.interfaces.impl.base;

import oop.example.interfaces.Animal;

/**
 * Created by shaur on 28.02.16.
 * for Imp manga server project
 */
public abstract class Bird implements Animal {

    @Override
    public Boolean canFly() {
        return true;
    }

    public abstract void go();
}
