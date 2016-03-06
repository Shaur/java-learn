package oop.example.interfaces.impl.base;

import oop.example.interfaces.Animal;


public abstract class Bird implements Animal {

    @Override
    public Boolean canFly() {
        return true;
    }

    public abstract void go();
}
