package ru.javalearn.strategy.example2;



public class OperacaoSoma implements OperacaoStrategy {

    @Override
    public int fazOperacao(int num1, int num2) {
        return num1 + num2;
    }
}
