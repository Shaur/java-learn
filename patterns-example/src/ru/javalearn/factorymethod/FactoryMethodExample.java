package ru.javalearn.factorymethod;


class Furniture { }

class Table extends Furniture { }

class Chair extends Furniture { }

abstract class FurnitureFactory {
    public abstract Furniture factoryMethod();
}

class TableFactory extends FurnitureFactory {
    @Override
    public Furniture factoryMethod() { return new Table(); }
}

class ChairFactory extends FurnitureFactory {
    @Override
    public Furniture factoryMethod() { return new Chair(); }
}

public class FactoryMethodExample {
    public static void main(String[] args) {
        // an array of creators
        FurnitureFactory[] creators = {new TableFactory(), new ChairFactory()};
        // iterate over creators and create products
        for (FurnitureFactory creator: creators) {
            Furniture product = creator.factoryMethod();
            System.out.printf("Created {%s}\n", product.getClass());
        }
    }
}