package oop.example.interfaces.impl.magic;

import oop.example.interfaces.Animal;
import oop.example.interfaces.MagicAnimal;

/**
 * Created by shaur on 29.02.16.
 */
public class Egg implements MagicAnimal {
    @Override
    public MagicAnimal getAnimalInside() {
        return null;
    }

    @Override
    public String tale() {
        return "Выкатилось яйцо со смертью Кощея";
    }

    @Override
    public Boolean canFly() {
        return false;
    }
}
