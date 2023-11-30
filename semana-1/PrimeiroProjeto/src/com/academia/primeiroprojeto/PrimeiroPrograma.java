package com.academia.primeiroprojeto;

public class PrimeiroPrograma {

    public static void main(String[] args) {
        //System.out.println("Olá Mundo!");
        //ctrl + / (comentario)
        //ctrl + F11 (roda o projeto)

        //Identificadores (letra, _, $)
        //Reservadas (int, double, char, ...)
        int numeroInteiro = 1; //inteiro
        double numeroDecimal = 99.99; //numeros decimais
        float valorPi = 3.14f; //menor numero de bits
        char unicaLetra = 'G';
        boolean valorVerdadeiro = true;

        //Declaração
        String nome;
        //Inicialização
        String nome1 = "Gabriel";
        //Atribuição
        nome = "Gabriel";
        System.out.println("Nome: " + nome);
        //Reatribuição
        nome = "Jose";
        System.out.println("Nome: " + nome);

        //Operadores
        int n1 = 1;
        int n2 = 2;
        System.out.println(n1 + n2);
        System.out.println(n1 - n2);
        System.out.println(n1 * n2);
        System.out.println(n1 / n2);
        System.out.println(n1 % n2);

        int na = 1;
        int nb = 2;
        System.out.println(na == nb);
        System.out.println(na != nb);
        System.out.println(na < nb);
        System.out.println(na > nb);

        //Operadores Lógicos
        boolean x = true;
        boolean y = false;

        System.out.println(x && y);
        System.out.println(x || y);
        System.out.println(!x);

        int numeroX = 10;
        //Incremento
        numeroX++; //11
        //Decremento
        numeroX--; //10
        //Operadores de atribuição
        numeroX += 5;
        numeroX -= 10;
        numeroX *= 2;
        numeroX /= 2;

        //vetores
        int[] number = new int[5];
        int[] inicializaVetor = {1, 2, 3, 4, 5};
        int primeiroNumero = inicializaVetor[0];
    }
}
