package br.com.academiajava.ufn.petshop;

import br.com.academiajava.ufn.agenda.Agenda;
import br.com.academiajava.ufn.animal.Animal;
import br.com.academiajava.ufn.animal.Cachorro;
import br.com.academiajava.ufn.animal.Gato;
import br.com.academiajava.ufn.animal.enums.PorteCachorro;
import br.com.academiajava.ufn.animal.enums.TipoPelagemGato;
import br.com.academiajava.ufn.produto.Alimento;
import br.com.academiajava.ufn.produto.Brinquedo;
import br.com.academiajava.ufn.produto.Medicamento;
import br.com.academiajava.ufn.produto.Produto;
import br.com.academiajava.ufn.servico.Banho;
import br.com.academiajava.ufn.servico.ConsultaVeterinaria;
import br.com.academiajava.ufn.servico.Tosa;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void executarMenu(Scanner sc, PetShop petShop) {
        int escolha;
        do {
            try {
                System.out.println("\n\n=================================");
                System.out.println("      \uD83D\uDC31PETSHOP AMIGO FIEL\uD83D\uDC36");
                System.out.println("=================================");
                System.out.println("1. Cadastrar Pet");
                System.out.println("2. Listar Pets Cadastrados ");
                System.out.println("---------------------------------");
                System.out.println("3. Cadastrar Produto");
                System.out.println("4. Listar Produtos  ");
                System.out.println("5. Vender Produto");
                System.out.println("---------------------------------");
                System.out.println("6. Realizar Agendamento de Serviço");
                System.out.println("7. Listar Agendamentos");
                System.out.println("0. <-\uD83C\uDFC3\u200D♂\uFE0F Sair ");
                System.out.print("> ");
                escolha = sc.nextInt();

                switch(escolha) {
                    case 1:
                        petShop.addAnimal(cadastrarPet(sc));
                        break;
                    case 2:
                        System.out.print(petShop.listarItens(petShop.getAnimalList(), "ANIMAIS CADASTRADOS"));
                        System.out.print("\nPressione Enter para Sair <-\uD83C\uDFC3\u200D♂\uFE0F");
                        sc.nextLine();
                        break;
                    case 3:
                        petShop.addProduto(cadastrarProduto(sc));
                        break;
                    case 4:
                        System.out.print(petShop.listarItens(petShop.getProdutoList(), "PRODUTOS CADASTRADOS"));
                        System.out.print("\nPressione Enter para Sair <-\uD83C\uDFC3\u200D♂\uFE0F");
                        sc.nextLine();
                        break;
                    case 5:
                        venderProduto(sc, petShop);
                        System.out.print("\nPressione Enter para Sair <-\uD83C\uDFC3\u200D♂\uFE0F");
                        sc.nextLine();
                        break;
                    case 6:
                        if(!petShop.agendar(realizarAgendamento(sc, petShop))) {
                            System.out.println("❌Já possui agendamento feito nesse horário❌");
                            System.out.print("\nPressione Enter para Sair <-\uD83C\uDFC3\u200D♂\uFE0F");
                            sc.nextLine();
                        }
                        break;
                    case 7:
                        System.out.print(petShop.listarItens(petShop.getAgendaList(), "SERVIÇOS AGENDADOS"));
                        System.out.print("\nPressione Enter para Sair <-\uD83C\uDFC3\u200D♂\uFE0F");
                        sc.nextLine();
                        break;
                }

            } catch (InputMismatchException e) {
                if(e.getMessage() == null) {
                    System.out.println("Entrada inválida. Por favor, insira um número válido.");
                } else {
                    System.out.println(e.getMessage());
                }
                System.out.print("Pressione Enter para continuar <-\uD83C\uDFC3\u200D♂\uFE0F");
                escolha = 0;
                sc.nextLine();
            } finally {
                sc.nextLine();
            }
        } while(escolha != 0);
    }

    private static void input(String texto) {
        System.out.println(texto);
        System.out.print("> ");
    }

    private static Animal cadastrarPet(Scanner sc) {
        System.out.println("\n=================================");
        System.out.println("       Cadastro de Pet\uD83D\uDCBE");
        System.out.println("==================================");

        System.out.println("Escolha o tipo do pet");
        System.out.println("1. Cachorro");
        System.out.println("2. Gato");
        System.out.print("> ");

        int tipo = sc.nextInt();
        sc.nextLine();

        if(tipo < 1 || tipo > 2) {
            throw new InputMismatchException("Escolha de tipo de pet inválido");
        }

        input("Digite o nome do pet");
        String nome = sc.nextLine();

        input("Digite a raça do pet");
        String raca = sc.nextLine();

        input("Digite a data de nascimento (dd/MM/yyyy/)");
        String data = sc.nextLine();

        input("Digite o nome do proprietario");
        String proprietario = sc.nextLine();

        input("Digite o peso");
        double peso = sc.nextDouble();

        if(tipo == 1) {
            System.out.println("Escolha o porte do cachorro");
            System.out.println("1. Pequeno");
            System.out.println("2. Médio  ");
            System.out.println("3. Grande ");
            System.out.println("4. Gigante");
            System.out.print("> ");

            int escolhaPorte = sc.nextInt();
            PorteCachorro porte = switch (escolhaPorte) {
                case 1 -> PorteCachorro.PEQUENO;
                case 2 -> PorteCachorro.MEDIO;
                case 3 -> PorteCachorro.GRANDE;
                case 4 -> PorteCachorro.GIGANTE;
                default -> throw new InputMismatchException("Escolha de porte inválida");
            };
            return new Cachorro(nome, raca, LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    proprietario, peso, porte);
        } else {
            System.out.println("Escolha o tipo de pelagem do gato");
            System.out.println("1. Pelo Curto");
            System.out.println("2. Pelo Médio  ");
            System.out.println("3. Pelo Longo ");
            System.out.print("> ");

            int escolhaPelagem = sc.nextInt();
            TipoPelagemGato pelagemGato = switch (escolhaPelagem) {
                case 1 -> TipoPelagemGato.PELO_CURTO;
                case 2 -> TipoPelagemGato.PELO_MEDIO;
                case 3 -> TipoPelagemGato.PELO_LONGO;
                default -> throw new InputMismatchException("Escolha de tipo de pelagem inválida");
            };
            return new Gato(nome, raca, LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    proprietario, peso, pelagemGato);
        }
    }

    private static Produto cadastrarProduto(Scanner sc) {
        System.out.println("\n=================================");
        System.out.println("     Cadastro de Produto\uD83D\uDCBE");
        System.out.println("==================================");

        System.out.println("Escolha o tipo do produto");
        System.out.println("1. Alimento");
        System.out.println("2. Brinquedo");
        System.out.println("3. Medicamento");
        System.out.print("> ");

        int tipo = sc.nextInt();

        if (tipo < 1 || tipo > 3) {
            sc.nextLine();
            throw new InputMismatchException("Escolha de tipo de produto inválida");
        }
        sc.nextLine();

        input("Digite o nome do produto");
        String nome = sc.nextLine();

        input("Digite o preço do produto");
        double preco = sc.nextDouble();

        input("Digite a quantidade em estoque do produto");
        int quantidadeEmEstoque = sc.nextInt();

        sc.nextLine();

        if (tipo == 1) {
            input("Digite a data de validade (dd/MM/yyyy)");
            String dataValidade = sc.nextLine();
            return new Alimento(nome, preco, quantidadeEmEstoque,
                    LocalDate.parse(dataValidade, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        else if (tipo == 2) {
            return new Brinquedo(nome, preco, quantidadeEmEstoque);
        }
        else {
            input("Digite a dosagem do medicamento");
            String dosagem = sc.nextLine();
            return new Medicamento(nome, preco, quantidadeEmEstoque, dosagem);
        }
    }

    private static void venderProduto(Scanner sc, PetShop petShop) {
        System.out.println(petShop.listarItens(petShop.getProdutoList(), "PRODUTOS DISPONÍVEIS"));

        input("Informe o Índice do produto: ");
        int indiceProduto = sc.nextInt();

        if(indiceProduto < 0 || indiceProduto > petShop.getProdutoList().size()) {
            throw new InputMismatchException("Não existe esse índice do produto selecionado.");
        }

        input("\nInforme a quantidade que deseja comprar");
        int quantidade = sc.nextInt();

        Produto produto = petShop.getProdutoList().get(indiceProduto - 1);
        if(produto.vender(quantidade)) {
            System.out.println("Produto vendido com sucesso!");
            System.out.println("Valor total R$: " + quantidade * produto.getPreco() );
        } else {
            System.out.println("O produto não possui quantidade em estoque suficiente.");
        }
    }

    private static Agenda realizarAgendamento(Scanner sc, PetShop petShop) {
        System.out.println("\n=================================");
        System.out.println("  Cadastro de Agendamentos\uD83D\uDCC4");
        System.out.println("==================================");

        System.out.println(petShop.listarItens(petShop.getAnimalList(), "PETS CADASTRADOS"));
        input("Escolha o índice do pet");
        int escolhaAnimal = sc.nextInt();

        Animal animalSelecionado = petShop.getAnimalList().get(escolhaAnimal - 1);

        System.out.println("Serviços Disponíveis:");
        System.out.println("1. Banho");
        System.out.println("2. Tosa");
        System.out.println("3. Consulta Veterinária");
        input("Escolha o serviço: ");
        int escolhaServico = sc.nextInt();

        sc.nextLine();

        input("Informe a data de agendamento (dd/MM/yyyy)");
        String dataInp = sc.nextLine();

        input("Informe o horário (HH:mm)");
        String horarioInp = sc.nextLine();

        DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter horaFormato = DateTimeFormatter.ofPattern("HH:mm");

        try {
            LocalDate data = LocalDate.parse(dataInp, dataFormato);
            LocalTime hora = LocalTime.parse(horarioInp, horaFormato);

            if(escolhaServico == 1) {
                return new Agenda(animalSelecionado, new Banho(), data, hora);
            }
            else if(escolhaServico == 2) {
                return new Agenda(animalSelecionado, new Tosa(), data, hora);
            }
            else {
                return new Agenda(animalSelecionado, new ConsultaVeterinaria(), data, hora);
            }
        } catch (DateTimeParseException e) {
            throw new InputMismatchException("Data e hora de agendamento inválida");
        }
    }
}
