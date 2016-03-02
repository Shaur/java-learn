package oop.example.person;

import oop.example.interfaces.Animal;
import oop.example.interfaces.MagicAnimal;

/**
 * Created by shaur on 29.02.16.
 */
public class Ivan {

    public static MagicAnimal bowShot(Animal animal) {
        System.out.println("Выстрелил Иван из лука");

        if(!animal.canFly()) {
            System.out.println("Не могу стрелять по тем, кто не летает");
            return null;
        }

        if(!(animal instanceof MagicAnimal)) {
            System.out.println("Мне жалко настоящих животных");
            return null;
        }

        return ((MagicAnimal)animal).getAnimalInside();
    }

    public static MagicAnimal killByGreyWolf(Animal animal) {
        System.out.println("Выпустил Иван Серого Волка");

        if(animal.canFly()) {
            System.out.println("Волк не прыгает так высоко");
            return null;
        }

        if(!(animal instanceof MagicAnimal)) {
            System.out.println("Мне жалко настоящих животных");
            return null;
        }

        return ((MagicAnimal)animal).getAnimalInside();
    }
}
