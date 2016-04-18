package ru.javalearn.strategy.example2;



public class Contexto {

    private OperacaoStrategy estrategia;

    public Contexto(OperacaoStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public int executarEstrategia(int num1, int num2) {
        return estrategia.fazOperacao(num1, num2);
    }
}