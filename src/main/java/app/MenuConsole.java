package app;

import java.util.Scanner;
import java.util.InputMismatchException;

public class MenuConsole {

    private Scanner scanner = new Scanner(System.in);

    // LER NÚMEROS COM TRATAMENTO DE ERROS
    private int lerInteiro() {

        try {
            int numero = scanner.nextInt();
            scanner.nextLine();
            return numero;

        } catch (InputMismatchException e) {

            scanner.nextLine();

            System.out.println(
                    "Entrada inválida! Digite apenas números."
            );

            return -1;
        }
    }

    // MOSTRAR MENU PRINCIPAL
    public int mostrarMenu() {

        System.out.println("\n===== SISTEMA DE RESTAURANTE =====");
        System.out.println("1 - Registrar Pedido");
        System.out.println("2 - Listar pedidos");
        System.out.println("3 - Fechar restaurante");
        System.out.println("4 - Buscar Pedido");
        System.out.println("5 - Remover lanche de um Pedido");
        System.out.println("6 - Cancelar Pedido");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

        return lerInteiro();
    }

    // LER NOME DO CLIENTE
    public String lerNomeCliente() {

        System.out.print("Digite o nome do cliente: ");

        return scanner.nextLine();
    }

    // MOSTRAR MENSAGENS
    public void mostrarMensagem(String mensagem) {

        System.out.println(mensagem);
    }

    // ESCOLHER LANCHE
    public int escolherLanche() {

        System.out.println("\n===== CARDÁPIO =====");
        System.out.println("1 - X-Burger - R$ 16,00");
        System.out.println("2 - X-Salada - R$ 18,00");
        System.out.println("3 - X-Bacon - R$ 22,00");
        System.out.print("Escolha seu lanche: ");

        return lerInteiro();
    }

    // ESCOLHER ADICIONAIS
    public int escolherAdicional() {

        System.out.println("\n===== ADICIONAIS =====");
        System.out.println("0 - Sem adicionais");
        System.out.println("1 - Cheddar (+ R$ 4,00)");
        System.out.println("2 - Bacon extra (+ R$ 6,00)");
        System.out.println("3 - Cheddar e bacon extra (+ R$ 10,00)");
        System.out.print("Escolha uma opção: ");

        return lerInteiro();
    }

    // DESEJA ADICIONAR OUTRO LANCHE?
    public boolean desejaAdicionarOutro() {

        System.out.print(
                "Deseja adicionar outro lanche? (1 - Sim / 0 - Não): "
        );

        int resposta = lerInteiro();

        return resposta == 1;
    }

    // RETIRAR INGREDIENTE
    public boolean desejaRetirarIngrediente(String ingrediente) {

        System.out.println(
                "Deseja retirar " + ingrediente + "?"
        );

        System.out.println("1 - Sim");
        System.out.println("0 - Não");
        System.out.print("Escolha: ");

        int resposta = lerInteiro();

        return resposta == 1;
    }

    // LER NÚMERO DO PEDIDO
    public int lerNumeroPedido() {

        System.out.print("Digite o número do Pedido: ");

        return lerInteiro();
    }

    // LER NÚMERO DO LANCHE
    public int lerNumeroItem() {

        System.out.print(
                "Digite o número do lanche que deseja remover: "
        );

        return lerInteiro();
    }

    // FECHAR SCANNER
    public void fecharScanner() {

        scanner.close();
    }
}
