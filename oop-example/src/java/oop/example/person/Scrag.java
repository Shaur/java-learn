package oop.example.person;

import oop.example.interfaces.impl.magic.Egg;
import oop.example.interfaces.impl.magic.MagicDuck;
import oop.example.interfaces.impl.magic.MagicRabbit;


public class Scrag {
    public static Chest hideDeath() {
        Egg egg = new Egg();
        MagicDuck duck = new MagicDuck(egg);
        MagicRabbit rabbit = new MagicRabbit(duck);
        Chest chest = new Chest();
        chest.animal = rabbit;

        return chest;
    }
}