public interface ICRUDProduto {
    void salvar(Produto prod);
    void deletar(int id);
    void alterar(Produto produto);
    void listar();
    Produto buscarPorId(int id);
}