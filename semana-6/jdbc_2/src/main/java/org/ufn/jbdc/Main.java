package org.ufn.jbdc;

import org.ufn.jbdc.model.Departamento;
import org.ufn.jbdc.model.Funcionario;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            // Criar um departamento
            Departamento departamento = new Departamento("TI");

            // Exibir informações sobre o departamento
            System.out.println("Detalhes do Departamento:");
            System.out.println("ID: " + departamento.getId());
            System.out.println("Nome: " + departamento.getNome());
            System.out.println("Quantidade de Funcionários: " + departamento.getQuantidadeFuncionarios());

            // Criar um funcionário no departamento
            Funcionario funcionario = new Funcionario("João", "Desenvolvedor", departamento.getId(), 5000);

            // Exibir informações sobre o funcionário
            System.out.println("\nDetalhes do Funcionário:");
            System.out.println("ID: " + funcionario.getId());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("Departamento: " + funcionario.getDepartamentoNome());


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}