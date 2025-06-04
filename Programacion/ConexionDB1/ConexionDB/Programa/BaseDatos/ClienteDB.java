import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDB {

    public static void insertarCliente(int id, String correo, String nombre, String direccion) {
        String sql = "INSERT INTO Cliente (id, correo, nombre, direccion) VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, correo);
            pstmt.setString(3, nombre);
            pstmt.setString(4, direccion);

            int filas = pstmt.executeUpdate();
            System.out.println("Filas insertadas: " + filas);

        } catch (SQLException e) {
            System.out.println("Error al insertar cliente");
            e.printStackTrace();
        }
    }

    public static void mostrarClientes() {
        String sql = "SELECT * FROM Cliente";

        try (Connection conexion = ConexionDB.obtenerConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String correo = rs.getString("correo");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");

                System.out.println("ID: " + id + ", Correo: " + correo + ", Nombre: " + nombre + ", Dirección: " + direccion);
            }

        } catch (SQLException e) {
            System.out.println("Error al mostrar clientes");
            e.printStackTrace();
        }
    }
    public static void buscarClientePorId(int idBuscado) {
    String sql = "SELECT * FROM Cliente WHERE id = ?";

    try (Connection conexion = ConexionDB.obtenerConexion();
         PreparedStatement pstmt = conexion.prepareStatement(sql)) {

        pstmt.setInt(1, idBuscado);

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                int id = rs.getInt("id");
                String correo = rs.getString("correo");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");

                System.out.println("Cliente encontrado:");
                System.out.println("ID: " + id + ", Correo: " + correo + ", Nombre: " + nombre + ", Dirección: " + direccion);
            } else {
                System.out.println("No se encontró un cliente con ID: " + idBuscado);
            }
        }

    } catch (SQLException e) {
        System.out.println("Error al buscar cliente por ID");
        e.printStackTrace();
    }
}
public static void borrarClientePorId(int idABorrar) {
    String sql = "DELETE FROM Cliente WHERE id = ?";

    try (Connection conexion = ConexionDB.obtenerConexion();
         PreparedStatement pstmt = conexion.prepareStatement(sql)) {

        pstmt.setInt(1, idABorrar);
        int filas = pstmt.executeUpdate();

        if (filas > 0) {
            System.out.println("Cliente con ID " + idABorrar + " eliminado");
        } else {
            System.out.println("No se encontró un cliente con ID: " + idABorrar);
        }

    } catch (SQLException e) {
        System.out.println("Error al eliminar cliente por ID");
        e.printStackTrace();
    }
}
}