import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private LocalDateTime data;
    private String status;
    private List<ItemPedido> itens = new ArrayList<>();

    public static class ItemPedido {
        private Produto produto;
        private int quantidade;

        public ItemPedido(Produto produto, int quantidade) {
            this.produto = produto;
            this.quantidade = quantidade;
        }

        public Produto getProduto() {
            return produto;
        }

        public int getQuantidade() {
            return quantidade;
        }
    }

    public interface PedidoDAO {
        void salvar(Pedido pedido);
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.status = "EM_ABERTO";
        this.data = LocalDateTime.now();
    }

    public void adicionarNoCarrinho(Produto produto, int quantidade) {
        if (produto.getEstoque() < quantidade) {
            System.out.println("Estoque insuficiente.");
            return;
        }
        itens.add(new ItemPedido(produto, quantidade));
    }

    public void removerDoCarrinho(int produtoId) {
        itens.removeIf(item -> item.getProduto().getId() == produtoId);
    }

    public boolean finalizarPedido(PedidoDAO pedidoDAO, ProdutoDAO produtoDAO) {
        if (itens.isEmpty()) {
            return false;
        }

        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();
            produto.setEstoque(produto.getEstoque() - item.getQuantidade());
            produtoDAO.salvar(produto);
        }

        this.status = "FINALIZADO";
        this.data = LocalDateTime.now();
        pedidoDAO.salvar(this);
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}