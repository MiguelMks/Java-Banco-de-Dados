import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class PedidoDAO implements ICRUDPedido {

	@Override
	public void salvar(Pedido pedido) {

	}
	@Override
	public void remover(Pedido pedido) {
	}
	@Override
	public void listar() {
		String sql = "SELECT * FROM tb_pedidos";

		        Connection con = ConectaBD.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                System.out.println(
                    rs.getInt("id")+" - "+
                    rs.getString("tb_client_id")+" - "+
                    rs.getString("data_pedido")+" - "+
                    rs.getString("status_pedido"));
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
}
