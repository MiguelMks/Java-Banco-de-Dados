import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO implements ICRUDCliente {
    @Override
    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO tb_clientes (cpf, nome, email, rua, numero, bairro, cep, cidade, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection con = ConectaBD.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getRua());
            stmt.setInt(5, cliente.getNumero());
            stmt.setString(6, cliente.getBairro());
            stmt.setInt(7, cliente.getCep());
            stmt.setString(8, cliente.getCidade());
            stmt.setString(9, cliente.getEstado());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                cliente.setId(rs.getInt(1));
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deletar(int id) {

        String sql = "DELETE FROM tb_clientes WHERE id=?";

        Connection con = ConectaBD.getConnection();

        try {
        PreparedStatement stmt = con.prepareStatement(sql);
                
        stmt.setInt(1,id);
        
        stmt.execute();
        stmt.close();
        con.close();

        System.out.println("Cliente removido!");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void alterar(Cliente cliente) {

        String sql = "UPDATE tb_clientes SET cpf=?, nome=?, email=?, rua=?, numero=?, bairro=?, cep=?, cidade=?, estado=? WHERE id=?";

        Connection con = ConectaBD.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getRua());
            stmt.setInt(5, cliente.getNumero());
            stmt.setString(6, cliente.getBairro());
            stmt.setInt(7, cliente.getCep());
            stmt.setString(8, cliente.getCidade());
            stmt.setString(9, cliente.getEstado());
            stmt.setInt(10, cliente.getId());

            stmt.executeUpdate();

            stmt.close();
            con.close();

            System.out.println("Atualizado!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

@Override
public void listar() {
    String sql = "SELECT id, cpf, nome, email FROM tb_clientes";

    // O Java abre e fecha a conexão, o statement e o result set automaticamente aqui
    try (Connection con = ConectaBD.getConnection();
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        boolean encontrouRegistros = false;

        while (rs.next()) {
            encontrouRegistros = true;
            System.out.println(
                rs.getInt("id") + " - " +
                rs.getString("cpf") + " - " +
                rs.getString("nome") + " - " +
                rs.getString("email")
            );
        }

        if (!encontrouRegistros) {
            System.out.println("Nenhum cliente cadastrado no banco de dados.");
        }

    } catch (SQLException e) {
        System.out.println("Erro ao listar: " + e.getMessage());
    }
}
    @Override
    public Cliente buscarPorId(int id) {
        Cliente clienteEncontrado = null;
        String sql = "SELECT id, cpf, nome, email, rua, numero, bairro, cep, cidade, estado FROM tb_clientes WHERE id = ?";

        try (Connection con = ConectaBD.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    clienteEncontrado = new Cliente();
                    clienteEncontrado.setId(rs.getInt("id"));
                    clienteEncontrado.setCpf(rs.getString("cpf"));
                    clienteEncontrado.setNome(rs.getString("nome"));
                    clienteEncontrado.setEmail(rs.getString("email"));
                } else {
                    System.out.println("Cliente não encontrado.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
        }
        return clienteEncontrado;
    }
}
