package BaseDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacturaDB {
    public static void insertarFactura(Connection con, int id, Double cantidad, int idA) throws SQLException {
        String insert = "INSERT INTO Factura (id, cantidad, idA) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(insert)) {
            pstmt.setInt(1, id);
            pstmt.setDouble(2, cantidad);
            pstmt.setInt(3, idA);
            pstmt.executeUpdate();

            System.out.println("Factura insertada");

        }
    }

    public static boolean buscarFacturaPorId(Connection con, int idBuscado) throws SQLException {
        boolean existe = false;
        String query = "SELECT id FROM Factura WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, idBuscado);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        }
        return existe;
    }
    
    public static void verFacturas(Connection con) throws SQLException {
        String query = "SELECT id, cantidad, idA FROM Factura";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Cantidad : " + rs.getDouble("cantidad"));
                System.out.println("ID del Administrativo que ha hecho la factura: " + rs.getInt("idA"));
                System.out.println("-------------");
            }
        }
    }
    public static void verFacturaPorId(Connection con, int idBuscado) throws SQLException {
        boolean existe = buscarFacturaPorId(con, idBuscado);
        if (existe) {
            String query = "SELECT id, cantidad, idA FROM Factura WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, idBuscado);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Cantidad : " + rs.getDouble("cantidad"));
                    System.out.println("ID del Administrativo que ha hecho la factura: " + rs.getInt("idA"));
                    System.out.println("-------------");
                }
            }
        } else {
            System.out.println("No se puede mostrar porque no existe la factura");
        }
    }
    
    public static void borrarFacturaPorId(Connection con, int idBorrar) throws SQLException {
        boolean existe = buscarFacturaPorId(con, idBorrar);
        if (existe) {

            String delete = "DELETE FROM Factura WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(delete)) {
                pstmt.setInt(1, idBorrar);
                pstmt.executeUpdate();
                System.out.println("Factura borrada");
            }
        } else {
            System.out.println("No se puede borrar porque no existe la factura");
        }
    }
    public static void modificarCantidad(Connection con, int id, Double nuevaCantidad) throws SQLException {
        boolean existe = buscarFacturaPorId(con, id);
         if (existe) {
             String sql = "UPDATE Factura SET cantidad = ? WHERE id = ?";
             try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                 pstmt.setDouble(1, nuevaCantidad);
                 pstmt.setInt(2, id);
                 pstmt.executeUpdate();
                 System.out.println("Cantidad modificada");
             }
         } else {
             System.out.println("No se puede modificar  porque no existe la factura");
         }
     }

   public static void modificarIdA(Connection con, int id, int nuevoIdA) throws SQLException {
        boolean existe = buscarFacturaPorId(con, id);
        if (existe) {
            String sql = "UPDATE Factura SET idA = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, nuevoIdA);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("ID Administrador modificado");
            }
        } else {
            System.out.println("No se puede modificar porque no existe el equipo o ese administrador");
        }
    }


    public static void leerFacturasDesdeArch(Connection con, String fichero) throws SQLException {
        File f = new File(fichero);
        if (f.exists()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader lector = new BufferedReader(fr);
                String linea;

                while ((linea = lector.readLine()) != null) {
                    String[] partes = linea.split(",");
                    if (partes.length == 3) {
                        int id = Integer.parseInt(partes[0].trim());
                        double cantidad = Double.parseDouble(partes[1].trim());
                        int idA = Integer.parseInt(partes[2].trim());
                        FacturaDB.insertarFactura(con, id, cantidad, idA);
                    }
                }
                lector.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("El fichero no existe");
        }

    }
}
