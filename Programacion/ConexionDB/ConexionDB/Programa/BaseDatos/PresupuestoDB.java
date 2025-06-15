package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PresupuestoDB {

    public static void insertarPresupuesto(Connection con, double cantidad, int idE, int idC, int idF) throws SQLException {
        String insert = "INSERT INTO Presupuesto (cantidad, idE, idC, idF) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(insert)) {
            pstmt.setDouble(1, cantidad);
            pstmt.setInt(2, idE);
            pstmt.setInt(3, idC);
            pstmt.setInt(4, idF);
            pstmt.executeUpdate();
            System.out.println("Presupuesto insertado");
        }
    }


    public static boolean buscarPresupuestoPorId(Connection con, int idBuscado) throws SQLException {
        String query = "SELECT id FROM Presupuesto WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, idBuscado);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
    }

    public static void verPresupuestos(Connection con) throws SQLException {
        String query = "SELECT id, cantidad, idE, idC, idF FROM Presupuesto";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Cantidad: " + rs.getDouble("cantidad"));
                System.out.println("ID Equipo: " + rs.getInt("idE"));
                System.out.println("ID Cliente: " + rs.getInt("idC"));
                System.out.println("ID Factura: " + rs.getInt("idF"));
                System.out.println("------------");
            }
        }
    }

    public static void verPresupuestoPorId(Connection con, int idBuscado) throws SQLException {
        if (buscarPresupuestoPorId(con, idBuscado)) {
            String query = "SELECT id, cantidad, idE, idC, idF FROM Presupuesto WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, idBuscado);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Cantidad: " + rs.getDouble("cantidad"));
                    System.out.println("ID Equipo: " + rs.getInt("idE"));
                    System.out.println("ID Cliente: " + rs.getInt("idC"));
                    System.out.println("ID Factura: " + rs.getInt("idF"));
                    System.out.println("------------");
                }
            }
        } else {
            System.out.println("No se puede mostrar porque no existe el presupuesto");
        }
    }

    public static void borrarPresupuestoPorId(Connection con, int idBorrar) throws SQLException {
        if (buscarPresupuestoPorId(con, idBorrar)) {
            String delete = "DELETE FROM Presupuesto WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(delete)) {
                pstmt.setInt(1, idBorrar);
                pstmt.executeUpdate();
                System.out.println("Presupuesto borrado");
            }
        } else {
            System.out.println("No se puede borrar porque no existe el presupuesto");
        }
    }

    public static void modificarCantidad(Connection con, int id, double nuevaCantidad) throws SQLException {
        if (buscarPresupuestoPorId(con, id)) {
            String sql = "UPDATE Presupuesto SET cantidad = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setDouble(1, nuevaCantidad);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Cantidad modificada");
            }
        } else {
            System.out.println("No se puede modificar porque no existe el presupuesto");
        }
    }
    public static void modificarIdC(Connection con, int id, int nuevoIdC) throws SQLException {
        boolean existe = buscarPresupuestoPorId(con, id);
        if (existe) {
            String sql = "UPDATE Presupuesto SET idC = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, nuevoIdC);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("ID Cliente modificado");
            }
        } else {
            System.out.println("No se puede modificar porque no existe el presupuesto o ese cliente");
        }
    }
    public static void modificarIdE(Connection con, int id, int nuevoIdE) throws SQLException {
        boolean existe = buscarPresupuestoPorId(con, id);
        if (existe) {
            String sql = "UPDATE Presupuesto SET idE = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, nuevoIdE);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("ID Equipo modificado");
            }
        } else {
            System.out.println("No se puede modificar porque no existe el presupuesto o ese equipo");
        }
    }
    public static void modificarIdF(Connection con, int id, int nuevoIdF) throws SQLException {
        boolean existe = buscarPresupuestoPorId(con, id);
        if (existe) {
            String sql = "UPDATE Presupuesto SET idF = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, nuevoIdF);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("ID Factura modificado");
            }
        } else {
            System.out.println("No se puede modificar porque no existe el presupuesto o esa factura");
        }
    }

}
