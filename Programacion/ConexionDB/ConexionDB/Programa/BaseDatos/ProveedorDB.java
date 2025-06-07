package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProveedorDB {

    public static void insertarProveedor(Connection con, int id, String nombre, String telefono) throws SQLException {
        String insert = "INSERT INTO Proveedor (id, nombre, telefono) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(insert)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setString(3, telefono);
            pstmt.executeUpdate();
            System.out.println("Proveedor insertado");
        }
    }

    public static boolean buscarProveedorPorId(Connection con, int idBuscado) throws SQLException {
        String query = "SELECT id FROM Proveedor WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, idBuscado);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
    }

    public static void verProveedores(Connection con) throws SQLException {
        String query = "SELECT id, nombre, telefono FROM Proveedor";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Teléfono: " + rs.getString("telefono"));
                System.out.println("------------");
            }
        }
    }

    public static void verProveedorPorId(Connection con, int idBuscado) throws SQLException {
        if (buscarProveedorPorId(con, idBuscado)) {
            String query = "SELECT id, nombre, telefono FROM Proveedor WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, idBuscado);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Nombre: " + rs.getString("nombre"));
                    System.out.println("Teléfono: " + rs.getString("telefono"));
                    System.out.println("------------");
                }
            }
        } else {
            System.out.println("No se puede mostrar porque no existe el proveedor");
        }
    }

    public static void borrarProveedorPorId(Connection con, int idBorrar) throws SQLException {
        if (buscarProveedorPorId(con, idBorrar)) {
            String delete = "DELETE FROM Proveedor WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(delete)) {
                pstmt.setInt(1, idBorrar);
                pstmt.executeUpdate();
                System.out.println("Proveedor borrado");
            }
        } else {
            System.out.println("No se puede borrar porque no existe el proveedor");
        }
    }

    public static void modificarNombre(Connection con, int id, String nuevoNombre) throws SQLException {
        if (buscarProveedorPorId(con, id)) {
            String sql = "UPDATE Proveedor SET nombre = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, nuevoNombre);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Nombre modificado");
            }
        } else {
            System.out.println("No se puede modificar porque no existe el proveedor");
        }
    }

    public static void modificarTelefono(Connection con, int id, String nuevoTelefono) throws SQLException {
        if (buscarProveedorPorId(con, id)) {
            String sql = "UPDATE Proveedor SET telefono = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, nuevoTelefono);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Teléfono modificado");
            }
        } else {
            System.out.println("No se puede modificar porque no existe el proveedor");
        }
    }
}
