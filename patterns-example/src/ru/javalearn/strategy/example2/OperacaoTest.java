package ru.javalearn.strategy.example2;



public class OperacaoTest {

    public static void main(String[] args) {
        // Adicionando a estratégia de multiplicação no contexto
        Contexto contexto = new Contexto(new OperacaoMultiplicacao());
        System.out.println("10 * 10 = " +
                contexto.executarEstrategia(10, 10));

        // Adicionando a estratégia de soma no contexto
        contexto = new Contexto(new OperacaoSoma());
        System.out.println("10 + 5 = " +
                contexto.executarEstrategia(10, 5));

        // Adicionando a estratégia de subtracao no contexto
        contexto = new Contexto(new OperacaoSubtracao());
        System.out.println("18 - 3 = " +
                contexto.executarEstrategia(18, 3));
    }
}