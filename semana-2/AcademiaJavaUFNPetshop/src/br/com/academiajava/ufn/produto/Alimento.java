package br.com.academiajava.ufn.produto;

import java.time.LocalDate;

public class Alimento extends Produto {

    private LocalDate dataValidade;

    public Alimento(String nome, Double preco, int quantidadeEmEstoque, LocalDate dataValidade) {
        super(nome, preco, quantidadeEmEstoque);
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nData de Validade: " + dataValidade;
    }
}
