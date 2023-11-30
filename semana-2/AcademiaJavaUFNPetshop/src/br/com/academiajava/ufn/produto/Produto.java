package br.com.academiajava.ufn.produto;

public abstract class Produto {

    private String nome;
    private Double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, Double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public boolean vender(int quantidade) {
        if(quantidade <= this.quantidadeEmEstoque) {
            this.quantidadeEmEstoque -= quantidade;
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "\nNome: " + nome +
                "\nPreço: " + preco +
                "\nQuantidade em Estoque: " + quantidadeEmEstoque;
    }
}
