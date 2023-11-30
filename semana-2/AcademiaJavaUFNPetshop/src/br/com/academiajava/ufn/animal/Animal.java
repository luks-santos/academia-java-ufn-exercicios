package br.com.academiajava.ufn.animal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Animal {

    private String nome;
    private String raca;
    private LocalDate dataNascimento;
    private String proprietario;
    private double peso;

    public Animal(String nome, String raca, LocalDate dataNascimento, String proprietario, double peso) {
        this.nome = nome;
        this.raca = raca;
        this.dataNascimento = dataNascimento;
        this.proprietario = proprietario;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "\nRaça: " + raca +
                "\nNome: " + nome +
                "\nData de Nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                "\nProprietário: " + proprietario +
                "\nPeso: " + peso + " kg";
    }
}
