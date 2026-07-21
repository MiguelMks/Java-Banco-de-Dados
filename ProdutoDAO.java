import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ProdutoDAO implements ICRUDProduto {

    public void salvar(Produto prod) {

        String sql = "INSERT into tb_produtos(descricao, preco, estoque)values(?, ?, ?)";

        Connection con = ConectaBD.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, prod.getDescricao());
            stmt.setDouble(2, prod.getPreco());
            stmt.setInt(3, prod.getEstoque());

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()) {

                prod.setId(rs.getInt(1));

            }

            stmt.execute();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        public void listar() {

        String sql = "SELECT * FROM tb_produtos";

        Connection con = ConectaBD.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                System.out.println(
                    rs.getInt("id")+" - "+
                    rs.getString("descricao")+" - "+
                    rs.getDouble("preco")+" - "+
                    rs.getInt("estoque"));
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public Produto buscarPorId(int id) {
        String sql = "SELECT * FROM tb_produtos WHERE id=?";

        Connection con = ConectaBD.getConnection();
        Produto prod = null;

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                prod = new Produto();
                prod.setId(rs.getInt("id"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setEstoque(rs.getInt("estoque"));
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return prod;
    }
    @Override
    public void alterar(Produto prod) {

        String sql = "UPDATE tb_produtos SET descricao=?, preco=?, estoque=? WHERE id=?";

        Connection con = ConectaBD.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, prod.getDescricao());
            stmt.setDouble(2, prod.getPreco());
            stmt.setInt(3, prod.getEstoque());
            stmt.setInt(4, prod.getId());

            stmt.execute();

            stmt.close();
            con.close();

            System.out.println("Atualizado!");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void deletar(int id) {

        String sql = "DELETE FROM tb_produtos WHERE id=?";

        Connection con = ConectaBD.getConnection();

        try {
        PreparedStatement stmt = con.prepareStatement(sql);
                
        stmt.setInt(1,id);
        
        stmt.execute();
        stmt.close();
        con.close();

        System.out.println("Produto removido!");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
