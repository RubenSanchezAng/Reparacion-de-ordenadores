
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MaterialesDB {
    public static void insertarMaterial(Connection con, int id, String nombre, int stock, double coste) throws SQLException {
        String insert = "INSERT INTO Materiales (id, nombre, stock, coste) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(insert)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, stock);
            pstmt.setDouble(4, coste);
            pstmt.executeUpdate();
            System.out.println("Material insertado");
        }
    }

    public static boolean buscarMaterialPorId(Connection con, int idBuscado) throws SQLException {
        boolean existe = false;
        String query = "SELECT id FROM Materiales WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, idBuscado);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        }
        return existe;
    }

     public static void verMateriales(Connection con) throws SQLException {
        String query = "SELECT id, nombre, stock, coste FROM Materiales";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Stock: " + rs.getInt("stock"));
                System.out.println("Coste: " + rs.getDouble("coste"));
                System.out.println("------------");
            }
        }
    }

     public static void verMaterialPorId(Connection con, int idBuscado) throws SQLException {
        boolean existe = buscarMaterialPorId(con, idBuscado);
        if (existe) {
            String query = "SELECT id, nombre, stock, coste FROM Materiales WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, idBuscado);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                     System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Nombre: " + rs.getString("nombre"));
                    System.out.println("Stock: " + rs.getInt("stock"));
                    System.out.println("Coste: " + rs.getDouble("coste"));
                    System.out.println("------------");
                }
            }
        } else {
            System.out.println("No se puede mostrar porque no existe el material");
        }
    }

      public static void borrarMateriaPorId(Connection con, int idBorrar) throws SQLException {
        boolean existe = buscarMaterialPorId(con, idBorrar);
        if (existe) {
            String delete = "DELETE FROM Materiales WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(delete)) {
                pstmt.setInt(1, idBorrar);
                pstmt.executeUpdate();
                System.out.println("Material borrado");
            }
        } else {
            System.out.println("No se puede borrar porque no existe el material");
        }
    }
    
    public static void modificarNombre(Connection con, int id, String nuevoNombre) throws SQLException {
       boolean existe = buscarMaterialPorId(con, id);
        if (existe) {
            String sql = "UPDATE Materiales SET nombre = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, nuevoNombre);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Nombre modificada");
            }
        } else {
            System.out.println("No se puede modificar  porque no existe el material");
        }
    }
    public static void modificarStock(Connection con, int id, int nuevoStock) throws SQLException {
        boolean existe = buscarMaterialPorId(con, id);
        if (existe) {
            String sql = "UPDATE Materiales SET stock = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, nuevoStock);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Stock modificado");
            }
        } else {
            System.out.println("No se puede modificar porque no existe el material");
        }
    }
    public static void modificarCoste(Connection con, int id, double nuevoCoste) throws SQLException {
    boolean existe = buscarMaterialPorId(con, id);
    if (existe) {
        String sql = "UPDATE Materiales SET coste = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setDouble(1, nuevoCoste);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Coste modificado");
        }
    } else {
        System.out.println("No se puede modificar porque no existe el material");
    }
}

}
