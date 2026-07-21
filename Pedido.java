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

        public void adicionarQuantidade(int adicional) {
            this.quantidade += adicional;
        }
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.status = "EM_ABERTO";
        this.data = LocalDateTime.now();
    }

    public void adicionarNoCarrinho(Produto produto, int quantidade) {
// Validação 1: Não alterar pedido finalizado
        if (!"EM_ABERTO".equals(this.status)) {
            System.out.println("Não é possível alterar um pedido já finalizado.");
            return;
        }

        // Validação 2: Verificar estoque
        if (produto.getEstoque() < quantidade) {
            System.out.println("Estoque insuficiente para o produto: " + produto.getDescricao());
            return;
        }

        // Se o produto já existir no carrinho, apenas incrementa a quantidade
        for (ItemPedido item : itens) {
            if (item.getProduto().getId() == produto.getId()) {
                item.adicionarQuantidade(quantidade);
                return;
            }
        }

        // Se for um produto novo no carrinho
        itens.add(new ItemPedido(produto, quantidade));
    }
    public void removerDoCarrinho(int produtoId) {
        itens.removeIf(item -> item.getProduto().getId() == produtoId);
    }

    public boolean finalizarPedido(PedidoDAO pedidoDAO, ProdutoDAO produtoDAO) {
        if (itens.isEmpty() || !"EM_ABERTO".equals(this.status)) {
            return false;
        }

        // Atualiza estoque dos produtos no banco
        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();
            produto.setEstoque(produto.getEstoque() - item.getQuantidade());
            produtoDAO.alterar(produto);
        }

        this.status = "FINALIZADO";
        this.data = LocalDateTime.now();
        
          // Salva o pedido finalizado no banco de dados
        pedidoDAO.salvar(this);
        return true;
    }
    public double getValorTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            Produto p = item.getProduto();
            double preco = 0.0;
            try {
                preco = p.getPreco();
            } catch (Exception e) {
                // se Produto não tiver getPreco ou ocorrer erro, considera 0
                preco = 0.0;
            }
            total += preco * item.getQuantidade();
        }
        return total;
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