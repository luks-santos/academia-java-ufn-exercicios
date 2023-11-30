package br.com.academiajava.ufn.agenda;

import br.com.academiajava.ufn.animal.Animal;
import br.com.academiajava.ufn.servico.Servico;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Agenda {

    private Animal animal;
    private Servico servico;
    private LocalDate data;
    private LocalTime horario;

    public Agenda(Animal animal, Servico servico, LocalDate data, LocalTime horario) {
        this.animal = animal;
        this.servico = servico;
        this.data = data;
        this.horario = horario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agenda agenda = (Agenda) o;
        return Objects.equals(data, agenda.data) && Objects.equals(horario, agenda.horario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, horario);
    }

    @Override
    public String toString() {
        return "Agenda " +
                "\nAnimal: " + animal +
                ", Serviço: " + servico +
                ", Data: " + data +
                ", Horário: " + horario +
                '}';
    }
}
