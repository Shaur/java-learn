package ru.javalearn.nullobject;



public class NullObject {}

interface Animal {
    public void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("woof!");
    }
}

class NullAnimal implements Animal {
    public void makeSound() {

    }
}