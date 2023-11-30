package br.com.academiajava.ufn.servico;

import br.com.academiajava.ufn.animal.Animal;
import br.com.academiajava.ufn.animal.Cachorro;
import br.com.academiajava.ufn.animal.Gato;

public class Tosa implements Servico {

    @Override
    public String descricao() {
        return "Tosa";
    }

    @Override
    public double preco() {
        return 60.0;
    }

    @Override
    public String toString() {
        return "Tosa - " +
                "Valor: R$ " + preco();
    }
}
