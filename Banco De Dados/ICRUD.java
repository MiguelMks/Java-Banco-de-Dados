public interface ICRUD {
    void salvar(Produto prod);
    void deletar(int id);
    void alterar(Produto produto);
    void listar();
}