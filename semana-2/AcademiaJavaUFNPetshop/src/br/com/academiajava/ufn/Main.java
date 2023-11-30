package br.com.academiajava.ufn;

import br.com.academiajava.ufn.animal.Cachorro;
import br.com.academiajava.ufn.animal.Gato;
import br.com.academiajava.ufn.animal.enums.PorteCachorro;
import br.com.academiajava.ufn.animal.enums.TipoPelagemGato;
import br.com.academiajava.ufn.petshop.Menu;
import br.com.academiajava.ufn.petshop.PetShop;
import br.com.academiajava.ufn.produto.Alimento;
import br.com.academiajava.ufn.produto.Brinquedo;
import br.com.academiajava.ufn.produto.Medicamento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale enUSLocale = new Locale("en", "US");
        Scanner sc = new Scanner(System.in);
        sc.useLocale(enUSLocale);

        PetShop petShop = new PetShop();
        popularSistema(petShop);
        Menu.executarMenu(sc, petShop);
    }
    private static void popularSistema(PetShop petShop) {
        petShop.addAnimal(new Cachorro("Maya", "Shih-tzu",
                LocalDate.parse("22/04/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                "Joaquina da Silva",
                16.3, PorteCachorro.PEQUENO));
        petShop.addAnimal(new Cachorro("Rex", "Labrador",
                LocalDate.parse("15/01/2017", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                "Carlos Alberto",
                25.5, PorteCachorro.MEDIO));
        petShop.addAnimal(new Gato("Whiskers", "Siamese",
                LocalDate.parse("05/07/2020", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                "Maria da Silva",
                5.0, TipoPelagemGato.PELO_CURTO));
        petShop.addAnimal(new Cachorro("Luna", "Golden Retriever",
                LocalDate.parse("10/11/2018", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                "Fernando Silva",
                30.0, PorteCachorro.GRANDE));
        petShop.addAnimal(new Gato("Mittens", "Persian",
                LocalDate.parse("12/03/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                "Luana Rodrigues",
                6.5, TipoPelagemGato.PELO_LONGO));

        petShop.addProduto(new Alimento("Ração Special Dog", 15.5, 10,
                LocalDate.parse("01/10/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        petShop.addProduto(new Brinquedo("Bolinha", 2.5, 50));
        petShop.addProduto(new Medicamento("Dipirona", 10.5, 30, "1 mg/kg"));
        petShop.addProduto(new Alimento("Ração Premium Cat", 12.0, 15,
                LocalDate.parse("15/09/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        petShop.addProduto(new Brinquedo("Arranhador para Gatos", 8.0, 20));
    }
}
