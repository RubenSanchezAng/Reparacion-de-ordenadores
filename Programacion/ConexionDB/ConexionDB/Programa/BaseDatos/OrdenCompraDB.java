package BaseDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdenCompraDB {

    public static void insertarOrdenCompra(Connection con, int id, Date fecha, int idP, int idA) throws SQLException {
        String insert = "INSERT INTO Orden_Compra (id, fecha, idP, idA) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(insert)) {
            pstmt.setInt(1, id);
            pstmt.setDate(2, fecha);
            pstmt.setInt(3, idP);
            pstmt.setInt(4, idA);
            pstmt.executeUpdate();
            System.out.println("Orden de compra insertada");
        }
    }

    public static boolean buscarOrdenCompraId(Connection con, int idBuscado) throws SQLException {
        String query = "SELECT id FROM Orden_Compra WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, idBuscado);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
    }

    public static void verOrdenesCompra(Connection con) throws SQLException {
        String query = "SELECT id, fecha, idP, idA FROM Orden_Compra";
        try (PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Fecha: " + rs.getDate("fecha"));
                System.out.println("ID del Proveedor: " + rs.getInt("idP"));
                System.out.println("ID del Administrativo: " + rs.getInt("idA"));
                System.out.println("-------------");
            }
        }
    }

    public static void verOrdenCompraPorId(Connection con, int idBuscado) throws SQLException {
        if (buscarOrdenCompraId(con, idBuscado)) {
            String query = "SELECT id, fecha, idP, idA FROM Orden_Compra WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, idBuscado);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Fecha: " + rs.getDate("fecha"));
                    System.out.println("ID del Proveedor: " + rs.getInt("idP"));
                    System.out.println("ID del Administrativo: " + rs.getInt("idA"));
                    System.out.println("-------------");
                }
            }
        } else {
            System.out.println("No se puede mostrar porque no existe la orden de compra");
        }
    }

    public static void borrarOrdenCompraPorId(Connection con, int idBorrar) throws SQLException {
        if (buscarOrdenCompraId(con, idBorrar)) {
            String delete = "DELETE FROM Orden_Compra WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(delete)) {
                pstmt.setInt(1, idBorrar);
                pstmt.executeUpdate();
                System.out.println("Orden de compra borrada");
            }
        } else {
            System.out.println("No se puede borrar porque no existe la orden de compra");
        }
    }

    public static void modificarFechaOrden(Connection con, int id, Date nuevaFecha) throws SQLException {
        if (buscarOrdenCompraId(con, id)) {
            String update = "UPDATE Orden_Compra SET fecha = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(update)) {
                pstmt.setDate(1, nuevaFecha);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Fecha de la orden modificada");
            }
        } else {
            System.out.println("No se puede modificar porque no existe la orden de compra");
        }
    }
}
