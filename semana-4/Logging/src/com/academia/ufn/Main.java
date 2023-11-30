package com.academia.ufn;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner leitura = new Scanner(System.in)) {
            Calculadora c = new Calculadora();
            Log log = new Log("./log-calc.txt");
            log.logger.info("Log Calculadora Iniciado");

            float a = 0, b = 0, resultado = 0;
            String operador;
            System.out.println("Calculadora");
            do {
                System.out.println("Insira o operador +, -, *, /");
                operador = leitura.nextLine();
            } while (!(operador.contains("+") || operador.contains("-") || operador.contains("*")
                    || operador.contains("/")));

            System.out.println("Insira o 1o valor");
            a = leitura.nextFloat();
            System.out.println("Insira o 2o valor");
            b = leitura.nextFloat();

            resultado = c.calcular(a, b, operador.charAt(0));
            System.out.println("O resultado de " + a + " " + operador + " " + b + " é: " + resultado);

            log.logger.info("Foi utilizado o operador '"  + operador + "' com os números: '" + a + "' e '" + b + "' resultado: '" + resultado + "'\n");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
