package br.com.academiajava.ufn.animal;

import br.com.academiajava.ufn.animal.enums.PorteCachorro;

import java.time.LocalDate;

public class Cachorro extends Animal {

    private Enum<PorteCachorro> porte;
    public Cachorro(String nome, String raca, LocalDate dataNascimento, String proprietario, Double peso,
                    Enum<PorteCachorro> porte) {
        super(nome, raca, dataNascimento, proprietario, peso);
        this.porte = porte;
    }

    public Enum<PorteCachorro> getPorte() {
        return porte;
    }

    public void setPorte(Enum<PorteCachorro> porte) {
        this.porte = porte;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPorte: " + porte;
    }
}
