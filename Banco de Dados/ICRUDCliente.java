public interface ICRUDCliente {
    void salvar(Cliente cliente);
    void deletar(int id);
    void alterar(Cliente cliente);
    void listar();
}
