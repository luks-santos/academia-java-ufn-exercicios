package br.com.academiajava.ufn.produto;

public class Medicamento extends Produto {

    private String dosagem;

    public Medicamento(String nome, Double preco, int quantidadeEmEstoque, String dosagem) {
        super(nome, preco, quantidadeEmEstoque);
        this.dosagem = dosagem;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDosagem: " + dosagem;
    }
}
