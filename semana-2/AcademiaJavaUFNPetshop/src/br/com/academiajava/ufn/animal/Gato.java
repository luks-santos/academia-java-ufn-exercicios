package br.com.academiajava.ufn.animal;

import br.com.academiajava.ufn.animal.enums.TipoPelagemGato;

import java.time.LocalDate;

public class Gato extends Animal {

    private Enum<TipoPelagemGato> pelagem;
    public Gato(String nome, String raca, LocalDate dataNascimento, String proprietario, double peso,
                Enum<TipoPelagemGato> pelagem) {
        super(nome, raca, dataNascimento, proprietario, peso);
        this.pelagem = pelagem;
    }

    public Enum<TipoPelagemGato> getPelagem() {
        return pelagem;
    }

    public void setPelagem(Enum<TipoPelagemGato> pelagem) {
        this.pelagem = pelagem;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTipo pelagem: " + pelagem;
    }
}
