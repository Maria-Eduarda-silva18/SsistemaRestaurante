package app;

public class Main {

    public static void main(String[] args) {

        RestauranteFacade restaurante = new RestauranteFacade();

        boolean executando = true;

        while (executando) {

            int opcao = restaurante.getMenu().mostrarMenu();

            switch (opcao) {

                case 1:
                    restaurante.registrarPedido();
                    break;

                case 2:
                    restaurante.listarPedidos();
                    break;

                case 3:
                    restaurante.fecharRestaurante();
                    executando = false;
                    break;

                case 4:
                    restaurante.buscarPedido();
                    break;

                case 5:
                    restaurante.removerItemPedido();
                    break;

                case 6:
                    restaurante.cancelarPedido();
                    break;

                case 0:
                    restaurante.getMenu().mostrarMensagem(
                            "Sistema encerrado. Até a próxima!"
                    );
                    executando = false;
                    break;

                default:
                    restaurante.getMenu().mostrarMensagem(
                            "Opção inválida! Tente novamente."
                    );
            }
        }

        restaurante.getMenu().fecharScanner();
    }
}
