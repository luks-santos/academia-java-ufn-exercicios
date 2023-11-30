package br.com.academiajava.ufn.servico;

import br.com.academiajava.ufn.animal.Animal;
import br.com.academiajava.ufn.animal.Cachorro;
import br.com.academiajava.ufn.animal.Gato;
import br.com.academiajava.ufn.animal.enums.PorteCachorro;
import br.com.academiajava.ufn.animal.enums.TipoPelagemGato;

public class Banho implements Servico {

    @Override
    public String descricao() {
        return "Banho";
    }

    @Override
    public double preco() {
       return 120.0;
    }

    @Override
    public String toString() {
        return "Banho - " +
                "Valor: R$ " + preco();
    }
}

