public interface  ICRUDPedido {
    void salvar(Pedido pedido);
    void deletar(int id);
    void alterar(Pedido pedido);
    void listar();   
}
