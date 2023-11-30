package br.com.academiajava.ufn.petshop;

import br.com.academiajava.ufn.agenda.Agenda;
import br.com.academiajava.ufn.animal.Animal;
import br.com.academiajava.ufn.produto.Produto;

import java.util.ArrayList;
import java.util.List;

public class PetShop {

    private final List<Animal> animalList;
    private final List<Produto> produtoList;
    private final List<Agenda> agendaList;
    public PetShop() {
        animalList = new ArrayList<>();
        produtoList = new ArrayList<>();
        agendaList = new ArrayList<>();
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public List<Agenda> getAgendaList() {
        return agendaList;
    }

    public boolean addAnimal(Animal animal) {
        return animalList.add(animal);
    }

    public boolean addProduto(Produto produto) {
        return produtoList.add(produto);
    }

    public boolean agendar(Agenda agenda) {
        if(agendaList.contains(agenda)) {
            return false;
        }
        return agendaList.add(agenda);
    }

    public String listarItens(List<?> itens, String titulo) {
        StringBuilder result = new StringBuilder();
        result.append("==================================\n");
        result.append("      ").append(titulo).append("     \n");
        result.append("==================================");

        for(int i =0; i < itens.size(); i++) {
            result.append("\nÍndice: ").append(i + 1).append("\n");
            result.append(itens.get(i).toString());
            result.append("\n==================================");
        }
        return result.toString();
    }
}
