
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdministrativoDB {
   public static void insertarAdministrativo(Connection con, String cargo, String nombre, String tlf) throws SQLException {

        String insertEmpleado = "INSERT INTO Empleado (cargo, nombre, tlf) VALUES (?, ?, ?)";
        try (PreparedStatement pstmtEmpleado = con.prepareStatement(insertEmpleado)) {
            pstmtEmpleado.setString(1, cargo);
            pstmtEmpleado.setString(2, nombre);
            pstmtEmpleado.setString(3, tlf);
            pstmtEmpleado.executeUpdate();
        }

        int idGenerado = -1;
        String obtenerId = "SELECT LAST_INSERT_ID()";
        try (Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(obtenerId)) {
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
        }

        if (idGenerado != -1) {
            String insertaAdministrativo = "INSERT INTO Administrativo (id) VALUES (?)";
            try (PreparedStatement pstmtAdmin = con.prepareStatement(insertaAdministrativo)) {
                pstmtAdmin.setInt(1, idGenerado);
                pstmtAdmin.executeUpdate();
            }
        }
    }
    public static boolean buscarAdministrativoPorId(Connection con, int idBuscado) throws SQLException {
        boolean existe = false;
        String query = "SELECT id FROM Administrativo WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, idBuscado);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        }
        return existe;
    }
    
    
    public static void verAdministrativos(Connection con) throws SQLException {
        String queryIds = "SELECT id FROM Administrativo";
        try (PreparedStatement pstmtIds = con.prepareStatement(queryIds)) {
            ResultSet rsIds = pstmtIds.executeQuery();
            while (rsIds.next()) {
                int id = rsIds.getInt("id");
    
                String subQuery = "SELECT id_Empleado, cargo, nombre, tlf FROM Empleado WHERE id_Empleado = ?";
                try (PreparedStatement pstmtEmp = con.prepareStatement(subQuery)) {
                    pstmtEmp.setInt(1, id);
                    ResultSet rsEmp = pstmtEmp.executeQuery();
                    if (rsEmp.next()) {
                        System.out.println("ID: " + rsEmp.getInt("id_Empleado"));
                        System.out.println("Cargo: " + rsEmp.getString("cargo"));
                        System.out.println("Nombre: " + rsEmp.getString("nombre"));
                        System.out.println("Teléfono: " + rsEmp.getString("tlf"));
                        System.out.println("-------------");
                    }
                }
            }
        }
    }
    public static void verAdministrativoPorId(Connection con, int idBuscado) throws SQLException {
        boolean existe = buscarAdministrativoPorId(con, idBuscado);
        if (existe) {
            String query = "SELECT id_Empleado, cargo, nombre, tlf FROM Empleado WHERE id_Empleado = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, idBuscado);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id_Empleado"));
                    System.out.println("Cargo: " + rs.getString("cargo"));
                    System.out.println("Nombre: " + rs.getString("nombre"));
                    System.out.println("Teléfono: " + rs.getString("tlf"));
                    System.out.println("---------");
                }
            }
        } else {
            System.out.println("No se puede mostrar porque no existe el administrativo que buscas");
        }
    }
   
    public static void borrarAdministrativoPorId(Connection con, int idBorrar) throws SQLException {
    boolean existe = buscarAdministrativoPorId(con, idBorrar);
    if (existe) {

        String deleteAdministrativo = "DELETE FROM Administrativo WHERE id = ?";
        try (PreparedStatement pstmt1 = con.prepareStatement(deleteAdministrativo)) {
            pstmt1.setInt(1, idBorrar);
            pstmt1.executeUpdate();
        }
        String deleteEmpleado = "DELETE FROM Empleado WHERE id_Empleado = ?";
        try (PreparedStatement pstmt2 = con.prepareStatement(deleteEmpleado)) {
            pstmt2.setInt(1, idBorrar);
            pstmt2.executeUpdate();
        }

        System.out.println("Administrativo borrado");
    } else 
        System.out.println("No se puede borrar porque no existe el administrativo");
    
    }


    public static void modificarTelefono(Connection con, int id, String nuevoTelefono) throws SQLException {
        boolean existe = buscarAdministrativoPorId(con, id);
        if (existe) {
            String sql = "UPDATE Empleado SET tlf = ? WHERE id_Empleado = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, nuevoTelefono);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Teléfono modificado");
            }
        } else {
            System.out.println("No se puede modificar porque no existe el administrativo");
        }
    }
    public static void modificarNombre(Connection con, int id, String nuevoNombre) throws SQLException {
        boolean existe = buscarAdministrativoPorId(con, id);
        if (existe) {
            String sql = "UPDATE Empleado SET nombre = ? WHERE id_Empleado = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, nuevoNombre);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Nombre modificado");
            }
        } else {
            System.out.println("No se puede modificar porque no existe el administrativo");
        }
    }    
}
