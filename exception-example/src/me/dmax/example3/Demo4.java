package me.dmax.example3;



import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo4 {
    // предок пугает IOException и InterruptedException
    public void f() throws IOException, InterruptedException {
        throw new InterruptedException();
    }
}

class Child extends Demo4 {
    // а потомок пугает только потомком IOException
    @Override
    public void f() throws IOException {}
}