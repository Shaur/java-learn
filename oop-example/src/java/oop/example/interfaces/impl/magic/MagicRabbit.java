package oop.example.interfaces.impl.magic;

import oop.example.interfaces.MagicAnimal;
import oop.example.interfaces.impl.ordinal.Rabbit;


public class MagicRabbit extends Rabbit implements MagicAnimal {
    MagicAnimal inside;

    public MagicRabbit(MagicAnimal inside) {
        this.inside = inside;
    }

    @Override
    public MagicAnimal getAnimalInside() {
        return inside;
    }

    @Override
    public String tale() {
        return "Выбежал кролик";
    }
}
