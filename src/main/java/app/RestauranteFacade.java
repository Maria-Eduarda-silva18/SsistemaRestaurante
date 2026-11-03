package app;

import cardapio.ItemCardapio;
import cardapio.Lanche;
import cardapio.LancheFactory;
import cardapio.ComCheddar;
import cardapio.ComBaconExtra;

import pedido.Pedido;
import pedido.GerenciadorPedidos;

import java.util.HashSet;

public class RestauranteFacade {

    private MenuConsole menu;
    private GerenciadorPedidos gerenciador;

    public RestauranteFacade() {
        menu = new MenuConsole();
        gerenciador = new GerenciadorPedidos();
    }

    // REGISTRAR PEDIDO
    public void registrarPedido() {

        String nomeCliente = menu.lerNomeCliente();

        Pedido pedido = gerenciador.criarPedido(nomeCliente);

        boolean continuar = true;

        while (continuar) {

            int opcao = menu.escolherLanche();

            ItemCardapio item;

            switch (opcao) {

                case 1:
                    item = LancheFactory.criarLanche("x-burger");
                    break;

                case 2:
                    item = LancheFactory.criarLanche("x-salada");
                    break;

                case 3:
                    item = LancheFactory.criarLanche("x-bacon");
                    break;

                default:
                    menu.mostrarMensagem("Opção inválida!");
                    continue;
            }

            // PERSONALIZAÇÃO DOS INGREDIENTES
            Lanche lanchePersonalizado = (Lanche) item;

            if (menu.desejaRetirarIngrediente("queijo")) {
                lanchePersonalizado.setQueijo(false);
            }

            if (menu.desejaRetirarIngrediente("alface")) {
                lanchePersonalizado.setAlface(false);
            }

            if (menu.desejaRetirarIngrediente("tomate")) {
                lanchePersonalizado.setTomate(false);
            }

            if (menu.desejaRetirarIngrediente("cebola")) {
                lanchePersonalizado.setCebola(false);
            }

            // ESCOLHA DOS ADICIONAIS
            int adicional = menu.escolherAdicional();

            switch (adicional) {

                case 0:
                    break;

                case 1:
                    item = new ComCheddar(item);
                    break;

                case 2:
                    item = new ComBaconExtra(item);
                    break;

                case 3:
                    item = new ComCheddar(item);
                    item = new ComBaconExtra(item);
                    break;

                default:
                    menu.mostrarMensagem(
                            "Adicional inválido! Sem adicionais."
                    );
                    break;
            }

            // ADICIONAR LANCHE AO PEDIDO
            pedido.adicionarItem(item);

            menu.mostrarMensagem(
                    item.getDescricao() + " adicionado!"
            );

            continuar = menu.desejaAdicionarOutro();
        }

        menu.mostrarMensagem(
                "Pedido número " + pedido.getNumero()
                        + " registrado com sucesso!"
        );

        menu.mostrarMensagem(
                "Total do Pedido: R$ " + pedido.calcularTotal()
        );
    }

    // LISTAR PEDIDOS
    public void listarPedidos() {

        if (gerenciador.listarPedidos().isEmpty()) {

            menu.mostrarMensagem("Nenhum Pedido cadastrado!");
            return;
        }

        for (Pedido pedido : gerenciador.listarPedidos()) {

            menu.mostrarMensagem("\nPedido: " + pedido.getNumero());

            menu.mostrarMensagem(
                    "Cliente: " + pedido.getNomeCliente()
            );

            for (ItemCardapio item : pedido.getItens()) {

                menu.mostrarMensagem(
                        "Lanche: " + item.getDescricao()
                                + " - R$ " + item.getPreco()
                );
            }

            menu.mostrarMensagem(
                    "Total: R$ " + pedido.calcularTotal()
            );
        }
    }

    // BUSCAR PEDIDO
    public void buscarPedido() {

        int numero = menu.lerNumeroPedido();

        Pedido pedido = gerenciador.buscarPedido(numero);

        if (pedido == null) {

            menu.mostrarMensagem("Pedido não encontrado!");
            return;
        }

        menu.mostrarMensagem("\n===== PEDIDO ENCONTRADO =====");

        menu.mostrarMensagem("Número: " + pedido.getNumero());

        menu.mostrarMensagem(
                "Cliente: " + pedido.getNomeCliente()
        );

        for (ItemCardapio item : pedido.getItens()) {

            menu.mostrarMensagem(
                    item.getDescricao() + " - R$ " + item.getPreco()
            );
        }

        menu.mostrarMensagem(
                "Total: R$ " + pedido.calcularTotal()
        );
    }

    // REMOVER LANCHE DE UM PEDIDO
    public void removerItemPedido() {

        int numero = menu.lerNumeroPedido();

        Pedido pedido = gerenciador.buscarPedido(numero);

        if (pedido == null) {

            menu.mostrarMensagem("Pedido não encontrado!");
            return;
        }

        if (pedido.getItens().isEmpty()) {

            menu.mostrarMensagem(
                    "Esse Pedido não possui lanches!"
            );
            return;
        }

        menu.mostrarMensagem("\n===== LANCHES DO PEDIDO =====");

        for (int i = 0; i < pedido.getItens().size(); i++) {

            ItemCardapio item = pedido.getItens().get(i);

            menu.mostrarMensagem(
                    (i + 1) + " - " + item.getDescricao()
                            + " - R$ " + item.getPreco()
            );
        }

        int numeroItem = menu.lerNumeroItem();

        boolean removido = pedido.removerItem(numeroItem - 1);

        if (removido) {

            menu.mostrarMensagem(
                    "Lanche removido com sucesso!"
            );

            menu.mostrarMensagem(
                    "Novo total do Pedido: R$ "
                            + pedido.calcularTotal()
            );

        } else {

            menu.mostrarMensagem("Número de lanche inválido!");
        }
    }

    // CANCELAR PEDIDO
    public void cancelarPedido() {

        int numero = menu.lerNumeroPedido();

        boolean cancelado = gerenciador.cancelarPedido(numero);

        if (cancelado) {

            menu.mostrarMensagem(
                    "Pedido cancelado com sucesso!"
            );

        } else {

            menu.mostrarMensagem("Pedido não encontrado!");
        }
    }

    // FECHAMENTO DO RESTAURANTE
    public void fecharRestaurante() {

        double total = gerenciador.calcularTotalVendas();

        HashSet<String> lanchesVendidos = new HashSet<>();

        for (Pedido pedido : gerenciador.listarPedidos()) {

            for (ItemCardapio item : pedido.getItens()) {

                lanchesVendidos.add(item.getDescricao());
            }
        }

        menu.mostrarMensagem(
                "\n===== FECHAMENTO DO RESTAURANTE ====="
        );

        menu.mostrarMensagem(
                "Total de vendas: R$ " + total
        );

        menu.mostrarMensagem(
                "\n===== LANCHES DIFERENTES VENDIDOS ====="
        );

        if (lanchesVendidos.isEmpty()) {

            menu.mostrarMensagem(
                    "Nenhum lanche foi vendido."
            );

        } else {

            for (String lanche : lanchesVendidos) {

                menu.mostrarMensagem("- " + lanche);
            }
        }
    }

    // ACESSAR MENU
    public MenuConsole getMenu() {
        return menu;
    }

}
