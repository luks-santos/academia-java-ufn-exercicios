package br.com.academiajava.ufn.servico;

import br.com.academiajava.ufn.animal.Animal;
import br.com.academiajava.ufn.animal.Cachorro;
import br.com.academiajava.ufn.animal.Gato;

public class ConsultaVeterinaria implements Servico {

    @Override
    public String descricao() {
        return "Consulta Veterinária";
    }

    @Override
    public double preco() {
        return 200.0;
    }

    @Override
    public String toString() {
        return "Banho - " +
                "Valor: R$ " + preco();
    }
}
