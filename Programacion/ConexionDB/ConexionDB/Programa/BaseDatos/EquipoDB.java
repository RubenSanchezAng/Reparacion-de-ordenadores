package BaseDatos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class EquipoDB {

    public static void insertarEquipo(Connection con, String estado, java.sql.Date fecha, String modelo, String marca, int idT) throws SQLException {
        String insert = "INSERT INTO Equipo (estado, fecha, modelo, marca, idT) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(insert)) {
            pstmt.setString(1, estado);
            pstmt.setDate(2, fecha);
            pstmt.setString(3, modelo);
            pstmt.setString(4, marca);
            pstmt.setInt(5, idT);
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
     } 
     public static void modificarMarca(Connection con, int id, String nuevaMarca) throws SQLException {
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
    
     public static void modificarIdT(Connection con, int id, int nuevoIdT) throws SQLException {
        boolean existe = buscarEquipoPorId(con, id);
        if (existe) {
            String sql = "UPDATE Equipo SET idT = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, nuevoIdT);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("ID Técnico modificado");
            }
        } else {
            System.out.println("No se puede modificar porque no existe el equipo o ese técnico");
        }
    }
    public static void escribirEquiposEnArch(Connection con, String fichero) {
        String sql = "SELECT id, estado, fecha, modelo, marca, idT FROM Equipo";

        File f = new File(fichero);
        FileWriter fw = null;
        BufferedWriter bw = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            fw = new FileWriter(f , true);
            bw = new BufferedWriter(fw);
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String estado = rs.getString("estado");
                Date fecha = rs.getDate("fecha");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                int idT = rs.getInt("idT");

                String linea = id + "," + estado + "," + fecha + "," + modelo + "," + marca + "," + idT;
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Equipos exportados");

        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al acceder a la base de datos.");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null) bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null) fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
