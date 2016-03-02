package oop.example;

import oop.example.interfaces.MagicAnimal;
import oop.example.interfaces.impl.magic.Egg;
import oop.example.person.Chest;
import oop.example.person.Ivan;
import oop.example.person.Scrag;

/**
 * Created by shaur on 29.02.16.
 */
public class Tale {

    public static void main(String[] argv) {
        Chest chest = Scrag.hideDeath();
        killScrag(chest.animal);
    }

    private static void killScrag(MagicAnimal animal) {
        if(animal instanceof Egg) {
            System.out.println(animal.tale() + ". Кощей убит");
            return;
        }

        System.out.println(animal.tale());

        if (animal.canFly()) {
            animal = Ivan.bowShot(animal);
        } else {
            animal = Ivan.killByGreyWolf(animal);
        }

        killScrag(animal);
    }
}
