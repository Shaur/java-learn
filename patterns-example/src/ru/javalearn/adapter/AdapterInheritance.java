package ru.javalearn.adapter;



// Target
interface ChiefA
{
    public Object makeBreakfast();
    public Object makeLunch();
    public Object makeDinner();
}

// Adaptee
class PlumberA {
    public Object getScrewNut(){ return new Object(); }
    public Object getPipe(){ return new Object(); }
    public Object getGasket(){ return new Object(); }
}

// Adapter
class ChiefAdapterA extends PlumberA implements ChiefA
{
    public Object makeBreakfast()
    {
        return getGasket();
    }
    public Object makeLunch()
    {
        return getPipe();
    }
    public Object makeDinner()
    {
        return getScrewNut();
    }
}

// Client
public class AdapterInheritance
{
    public static void eat(Object dish){}

    public static void main(String[] args)
    {
        ChiefA ch = new ChiefAdapterA();
        Object dish = ch.makeBreakfast();
        eat(dish);
        dish = ch.makeLunch();
        eat(dish);
        dish = ch.makeDinner();
        eat(dish);
        //callAmbulance();
    }
}
