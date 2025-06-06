package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipoDB {

    public static void insertarEquipo(Connection con, int id, String estado, java.sql.Date fecha, String modelo, String marca, int idT) throws SQLException {
        String insert = "INSERT INTO Equipo (id, estado, fecha, modelo, marca, idT) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(insert)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, estado);
            pstmt.setDate(3, fecha);
            pstmt.setString(4, modelo);
            pstmt.setString(5, marca);
            pstmt.setInt(6, idT);
            pstmt.executeUpdate();
            System.out.println("equipo insertado");
        }
    }
    public static boolean buscarEquipoPorId(Connection con, int idBuscado) throws SQLException {
        boolean existe = false;
        String query = "SELECT id FROM Equipo WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, idBuscado);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        }
        return existe;
    } 
    public static void verEquipos(Connection con) throws SQLException {
        String query = "SELECT id, estado, fecha, modelo, marca, idT FROM Equipo";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Estado: " + rs.getString("estado"));
                System.out.println("Fecha: " + rs.getDate("fecha"));
                System.out.println("Modelo: " + rs.getString("modelo"));
                System.out.println("Marca: " + rs.getString("marca"));
                System.out.println("ID del técnico: " + rs.getInt("idT"));

                System.out.println("-------------");
            }
        }
    }   

    public static void verEquipoPorId(Connection con, int idBuscado) throws SQLException {
        boolean existe = buscarEquipoPorId(con, idBuscado);
        if (existe) {
            String query = "SELECT id, estado, fecha, modelo, marca, idT FROM Equipo WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, idBuscado);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Estado: " + rs.getString("estado"));
                    System.out.println("Fecha: " + rs.getDate("fecha"));
                    System.out.println("Modelo: " + rs.getString("modelo"));
                    System.out.println("Marca: " + rs.getString("marca"));
                    System.out.println("ID del técnico: " + rs.getInt("idT"));
                    System.out.println("---------");
                }
            }
        } else {
            System.out.println("No se puede mostrar porque no existe el equipo");
        }
    }

    public static void borrarEquipoPorId(Connection con, int idBorrar) throws SQLException {
        boolean existe = buscarEquipoPorId(con, idBorrar);
        if (existe) {
            String delete = "DELETE FROM Equipo WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(delete)) {
                pstmt.setInt(1, idBorrar);
                pstmt.executeUpdate();
                System.out.println("Equipo borrado");
            }
        } else {
            System.out.println("No se puede borrar porque no existe el Eequipo");
        }
    }
    public static void modificarFecha(Connection con, int id, java.sql.Date nuevaFecha) throws SQLException {
        boolean existe = buscarEquipoPorId(con, id);
         if (existe) {
             String sql = "UPDATE Equipo SET fecha = ? WHERE id = ?";
             try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                 pstmt.setDate(1, nuevaFecha);
                 pstmt.setInt(2, id);
                 pstmt.executeUpdate();
                 System.out.println("Fecha modificada");
             }
         } else {
             System.out.println("No se puede modificar  porque no existe el equipo");
         }
    }
    public static void modificarEstado(Connection con, int id, String nuevoEstado) throws SQLException {
        boolean existe = buscarEquipoPorId(con, id);
         if (existe) {
             String sql = "UPDATE Equipo SET estado = ? WHERE id = ?";
             try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                 pstmt.setString(1, nuevoEstado);
                 pstmt.setInt(2, id);
                 pstmt.executeUpdate();
                 System.out.println("Estado modificado");
             }
         } else {
             System.out.println("No se puede modificar  porque no existe el equipo");
         }
     }
     public static void modificarModelo(Connection con, int id, String nuevoModelo) throws SQLException {
        boolean existe = buscarEquipoPorId(con, id);
         if (existe) {
             String sql = "UPDATE Equipo SET modelo = ? WHERE id = ?";
             try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                 pstmt.setString(1, nuevoModelo);
                 pstmt.setInt(2, id);
                 pstmt.executeUpdate();
                 System.out.println("Modelo modificado");
             }
         } else {
             System.out.println("No se puede modificar  porque no existe el equipo");
         }
     } public static void modificarMarca(Connection con, int id, String nuevaMarca) throws SQLException {
        boolean existe = buscarEquipoPorId(con, id);
         if (existe) {
             String sql = "UPDATE Equipo SET marca = ? WHERE id = ?";
             try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                 pstmt.setString(1, nuevaMarca);
                 pstmt.setInt(2, id);
                 pstmt.executeUpdate();
                 System.out.println("Marca modificada");
             }
         } else {
             System.out.println("No se puede modificar  porque no existe el equipo");
         }
     }
}
