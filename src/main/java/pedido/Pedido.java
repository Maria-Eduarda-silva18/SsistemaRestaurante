package pedido;

import cardapio.ItemCardapio;
import java.util.ArrayList;

public class Pedido {

    private int numero;
    private String nomeCliente;
    private ArrayList<ItemCardapio> itens = new ArrayList<>();

    // Construtor
    public Pedido(int numero, String nomeCliente) {
        this.numero = numero;
        setNomeCliente(nomeCliente);
    }

    // Validar nome do cliente
    public void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente inválido!");
        }

        this.nomeCliente = nomeCliente;
    }

    // Consultar nome do cliente
    public String getNomeCliente() {
        return nomeCliente;
    }

    // Consultar número
    public int getNumero() {
        return numero;
    }

    // Adicionar item ao Pedido
    public void adicionarItem(ItemCardapio item) {
        itens.add(item);
    }

    // Consultar itens
    public ArrayList<ItemCardapio> getItens() {
        return itens;
    }

    // Calcular total
    public double calcularTotal() {
        double total = 0;

        for (ItemCardapio item : itens) {
            total += item.getPreco();
        }

        return total;
    }


    public boolean removerItem(int indice) {

        if (indice < 0 || indice >= itens.size()) {
            return false;
        }

        itens.remove(indice);
        return true;
    }

}
