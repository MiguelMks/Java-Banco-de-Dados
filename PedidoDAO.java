import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class PedidoDAO implements ICRUDPedido {

	@Override
	public void salvar(Pedido pedido) {
        String sqlPedido = "INSERT INTO tb_pedidos (tb_cliente_id, data_pedido, status, valor_total) VALUES (?, ?, ?, ?)";
        String sqlItem = "INSERT INTO tb_item_pedido (tb_pedidos_id, tb_produtos_id, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";

        Connection con = null;

        try {
            con = ConectaBD.getConnection();
            // Desativa o autocommit para garantir que se um item falhar, nada seja salvo (Transação)
            con.setAutoCommit(false);

            // 1. Salva o cabeçalho do pedido
            PreparedStatement stmtPedido = con.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);
            stmtPedido.setInt(1, pedido.getCliente().getId());
            stmtPedido.setTimestamp(2, java.sql.Timestamp.valueOf(pedido.getData()));
            stmtPedido.setString(3, pedido.getStatus());
            stmtPedido.setDouble(4, pedido.getValorTotal());

            stmtPedido.executeUpdate();

            // Pega o ID gerado para o pedido
            ResultSet rs = stmtPedido.getGeneratedKeys();
            int idPedidoGerado = 0;
            if (rs.next()) {
                idPedidoGerado = rs.getInt(1);
                pedido.setId(idPedidoGerado);
            }
            rs.close();
            stmtPedido.close();

            // 2. Salva cada item associado a esse pedido
            PreparedStatement stmtItem = con.prepareStatement(sqlItem);
            for (Pedido.ItemPedido item : pedido.getItens()) {
                stmtItem.setInt(1, idPedidoGerado);
                stmtItem.setInt(2, item.getProduto().getId());
                stmtItem.setInt(3, item.getQuantidade());
                stmtItem.setDouble(4, item.getProduto().getPreco());
                stmtItem.executeUpdate();
            }
            stmtItem.close();

            // Confirma todas as inserções no banco
            con.commit();
            System.out.println("Pedido #" + idPedidoGerado + " gravado com sucesso no banco de dados!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar pedido no banco: " + e.getMessage());
            if (con != null) {
                try {
                    con.rollback(); // Cancela tudo em caso de erro
                } catch (SQLException ex) {
                    System.out.println("Erro ao fazer rollback: " + ex.getMessage());
                }
            }
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
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
