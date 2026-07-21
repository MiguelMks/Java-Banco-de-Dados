import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaBD {
    private static final String URL = "jdbc:mysql://localhost:3306/aula";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (Exception e ) {
            System.out.println("Erro na Conexão ");
            System.out.println("motivo: " + e.getMessage());
            return null;
        }
    }
}