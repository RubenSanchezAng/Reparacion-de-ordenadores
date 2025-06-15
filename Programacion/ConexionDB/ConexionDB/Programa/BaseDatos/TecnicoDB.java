package BaseDatos;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TecnicoDB {
    

   public static void insertarTecnico(Connection con, String cargo, String nombre, String tlf) throws SQLException {

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
            String insertaAdministrativo = "INSERT INTO Tecnico (id) VALUES (?)";
            try (PreparedStatement pstmtAdmin = con.prepareStatement(insertaAdministrativo)) {
                pstmtAdmin.setInt(1, idGenerado);
                pstmtAdmin.executeUpdate();
            }
        }
    }
    public static boolean buscarTecnicoPorId(Connection con, int idBuscado) throws SQLException {
        boolean existe = false;
        String query = "SELECT id FROM Tecnico WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, idBuscado);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        }
        return existe;
    }
    
    
    public static void verTecnicos(Connection con) throws SQLException {
        String queryIds = "SELECT id FROM Tecnico";
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
    public static void verTecnicoPorId(Connection con, int idBuscado) throws SQLException {
        boolean existe = buscarTecnicoPorId(con, idBuscado);
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
            System.out.println("No se puede mostrar porque no existe el técnico");
        }
    }
   
    public static void borrarTecnicoPorId(Connection con, int idBorrar) throws SQLException {
        boolean existe = buscarTecnicoPorId(con, idBorrar);
        if (existe) {
            String deleteTecnico = "DELETE FROM Tecnico WHERE id = ?";
            try (PreparedStatement pstmt1 = con.prepareStatement(deleteTecnico)) {
                pstmt1.setInt(1, idBorrar);
                pstmt1.executeUpdate();
            }
    
            String deleteEmpleado = "DELETE FROM Empleado WHERE id_Empleado = ?";
            try (PreparedStatement pstmt2 = con.prepareStatement(deleteEmpleado)) {
                pstmt2.setInt(1, idBorrar);
                pstmt2.executeUpdate();
            }
    
            System.out.println("Técnico borrado");
        } else {
            System.out.println("No se puede borrar porque no existe el técnico");
        }
    }

    public static void modificarCargo(Connection con, int id, String nuevoCargo) throws SQLException {
        boolean existe = buscarTecnicoPorId(con, id);
        if (existe) {
            String sql = "UPDATE Empleado SET cargo = ? WHERE id_Empleado = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, nuevoCargo);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Cargo modificado");
            }
        } else {
            System.out.println("No se puede modificar porque no existe el técnico");
        }
    }

    public static void modificarTelefono(Connection con, int id, String nuevoTelefono) throws SQLException {
        boolean existe = buscarTecnicoPorId(con, id);
        if (existe) {
            String sql = "UPDATE Empleado SET tlf = ? WHERE id_Empleado = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, nuevoTelefono);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Teléfono modificado");
            }
        } else {
            System.out.println("No se puede modificar porque no existe el técnico");
        }
    }
    public static void modificarNombre(Connection con, int id, String nuevoNombre) throws SQLException {
            boolean existe = buscarTecnicoPorId(con, id);
            if (existe) {
                String sql = "UPDATE Empleado SET nombre = ? WHERE id_Empleado = ?";
                try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                    pstmt.setString(1, nuevoNombre);
                    pstmt.setInt(2, id);
                    pstmt.executeUpdate();
                    System.out.println("Nombre modificado");
                }
            } else {
                System.out.println("No se puede modificar porque no existe el técnico");
            }
        }    
        public static void leerTecnicosDesdeArch(Connection con, String fichero) throws SQLException {
            File f = new File(fichero);
            if (f.exists()) {
                try (
                FileReader fr = new FileReader(f);
                BufferedReader lector = new BufferedReader(fr)
                ) {
                    String linea;
                    while ((linea = lector.readLine()) != null) {
                        String[] partes = linea.split(",");
                        if (partes.length == 4) {
                            int id = Integer.parseInt(partes[0].trim());
                            String cargo = partes[1].trim();
                            String nombre = partes[2].trim();
                            String tlf = partes[3].trim();
                            
                            insertarTecnico(con, cargo, nombre, tlf);
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error al leer el fichero");
                    e.printStackTrace();
                }
            } else {
            System.err.println("El fichero no existe");
            }
    }     
    public static void escribirTecnicosEnArch(Connection con, String fichero) {
        String queryIds = "SELECT id FROM Tecnico";

        File f = new File(fichero);

        try (
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PreparedStatement pstmtIds = con.prepareStatement(queryIds);
            ResultSet rsIds = pstmtIds.executeQuery()
        ) {
            while (rsIds.next()) {
                int id = rsIds.getInt("id");

                String subQuery = "SELECT id_Empleado, cargo, nombre, tlf FROM Empleado WHERE id_Empleado = ?";
                try (
                    PreparedStatement pstmtEmp = con.prepareStatement(subQuery)
                ) {
                    pstmtEmp.setInt(1, id);
                    ResultSet rsEmp = pstmtEmp.executeQuery();

                    if (rsEmp.next()) {
                        int idEmpleado = rsEmp.getInt("id_Empleado");
                        String cargo = rsEmp.getString("cargo");
                        String nombre = rsEmp.getString("nombre");
                        String tlf = rsEmp.getString("tlf");

                        String linea = idEmpleado + "," + cargo + "," + nombre + "," + tlf;
                        bw.write(linea);
                        bw.newLine();
                    }
                }
            }
            System.out.println("Técnicos exportados al fichero.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al acceder a la base de datos.");
            e.printStackTrace();
        }
    }
}
