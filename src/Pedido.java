import java.util.ArrayList;
import java.util.List;

public class Pedido {

    // Estados possíveis do pedido
    public enum Situacao {
        ABERTO,
        CONFIRMADO,
        PREPARANDO,
        CONCLUIDO
    }

    private List<ItemPedido> listaItens;
    private Situacao situacaoAtual;

    // Construtor: inicia com lista vazia e status ABERTO
    public Pedido() {
        listaItens = new ArrayList<>();
        situacaoAtual = Situacao.ABERTO;
    }

    // Adiciona item ao pedido
    public void incluirItem(ItemPedido item) {
        listaItens.add(item);
    }

    // Soma o valor total dos itens
    public double obterTotal() {
        double soma = 0;

        for (ItemPedido i : listaItens) {
            soma += i.calcularSubtotal();
        }

        return soma;
    }

    public Situacao getSituacao() {
        return situacaoAtual;
    }

    // Controle de mudança de estado
    public void atualizarSituacao(Situacao novaSituacao) {

        if (situacaoAtual == Situacao.ABERTO && novaSituacao == Situacao.CONFIRMADO) {
            situacaoAtual = novaSituacao;

        } else if (situacaoAtual == Situacao.CONFIRMADO && novaSituacao == Situacao.PREPARANDO) {
            situacaoAtual = novaSituacao;

        } else if (situacaoAtual == Situacao.PREPARANDO && novaSituacao == Situacao.CONCLUIDO) {
            situacaoAtual = novaSituacao;

        } else {
            throw new IllegalStateException("Mudança de situação não permitida!");
        }
    }

    public List<ItemPedido> listarItens() {
        return listaItens;
    }

    // Mostra o resumo do pedido
    public void mostrarResumo() {
        System.out.println("----- RESUMO DO PEDIDO -----");

        for (ItemPedido i : listaItens) {
            System.out.println(i.exibirItem());
        }

        System.out.println("----------------------------");
        System.out.println("Valor total: R$ " + obterTotal());
    }
}
