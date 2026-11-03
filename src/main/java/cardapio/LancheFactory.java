package cardapio;

public class LancheFactory {

    public static Lanche criarLanche(String tipo) {

        switch (tipo.toLowerCase()) {

            case "x-burger":
                return new Lanche("X-Burger", 16.00);

            case "x-salada":
                return new Lanche("X-Salada", 18.00);

            case "x-bacon":
                return new Lanche("X-Bacon", 22.00);

            default:
                throw new IllegalArgumentException("Lanche não encontrado!");
        }
    }
}

