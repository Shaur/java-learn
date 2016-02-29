package oop.example.interfaces.impl.magic;

import oop.example.interfaces.Animal;
import oop.example.interfaces.MagicAnimal;
import oop.example.interfaces.impl.ordinal.Duck;

/**
 * Created by shaur on 29.02.16.
 * for Imp manga server project
 */
public class MagicDuck extends Duck implements MagicAnimal {
    private MagicAnimal inside;

    public MagicDuck(MagicAnimal inside) {
        this.inside = inside;
    }

    @Override
    public MagicAnimal getAnimalInside() {
        return inside;
    }

    @Override
    public String tale() {
        return "Вылетела утка";
    }
}
