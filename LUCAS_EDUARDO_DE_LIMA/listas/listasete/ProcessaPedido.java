package listas.listasete;

import java.time.LocalDate;
import java.util.List;

public class ProcessaPedido {

    static int id = 1;
    Loja loja;
    ProcessaPedido(Loja loja) {
        this.loja = loja;
    }

    public Pedido processar(Vendedor vendedor, Cliente cliente, List<Item> items, String lojaParceira) {
        LocalDate dataAtual = LocalDate.now();
        Pedido pedido = new Pedido(id++, dataAtual, null, dataAtual.plusDays(3),
                cliente, vendedor, loja, items, lojaParceira);

        System.out.println("***** Pedido Realizado com Sucesso! *****");
        System.out.println("Data criação: " + pedido.getDataCriacao());
        System.out.println("Quantidade de Itens: " + pedido.getItens().size());
        System.out.println("Valor: R$ " + pedido.calcularValorTotal());
        System.out.println("Loja parceira: " + pedido.getLojaParceira());
        return pedido;
    }

    public void confirmarPagamento(Pedido pedido) {
        if (LocalDate.now().isBefore(pedido.getDataVencimentoReserva())) {
            pedido.setDataPagamento(LocalDate.now());
            System.out.println("Pedido pago com sucesso");
        } else {
            System.out.println("Pedido ja venceu o pagamento.");
        }
    }
}
