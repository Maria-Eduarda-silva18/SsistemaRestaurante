package pedido;

import java.util.HashMap;
import java.util.ArrayList;

public class GerenciadorPedidos {

    private HashMap<Integer, Pedido> pedidos = new HashMap<>();
    private int proximoNumero = 1;

    // Criar um novo Pedido
    public Pedido criarPedido(String nomeCliente) {

        Pedido pedido = new Pedido(proximoNumero, nomeCliente);

        pedidos.put(proximoNumero, pedido);

        proximoNumero++;

        return pedido;
    }

    // Buscar um Pedido pelo número
    public Pedido buscarPedido(int numero) {
        return pedidos.get(numero);
    }

    // Consultar todos os pedidos
    public ArrayList<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos.values());
    }

    // Calcular o total das vendas
    public double calcularTotalVendas() {

        double total = 0;

        for (Pedido pedido : pedidos.values()) {
            total += pedido.calcularTotal();
        }

        return total;
    }


    public boolean cancelarPedido(int numero) {

        if (!pedidos.containsKey(numero)) {
            return false;
        }

        pedidos.remove(numero);
        return true;
    }

}
