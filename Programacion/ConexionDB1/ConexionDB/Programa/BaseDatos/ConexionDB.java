import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/proyectoIntermodular";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "tu_contraseña";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}