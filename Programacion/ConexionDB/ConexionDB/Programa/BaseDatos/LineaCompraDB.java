package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LineaCompraDB {

    public static void insertarLineaCompra(Connection con, int id, int nlineas, int ida, int idM) throws SQLException {
        String insert = "INSERT INTO Linea_Compra (id, nlineas, ida, idM) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(insert)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, nlineas);
            pstmt.setInt(3, ida);
            pstmt.setInt(4, idM);
            pstmt.executeUpdate();
            System.out.println("Línea de compra insertada");
        }
    }

    public static boolean buscarLineaCompraId(Connection con, int idBuscado) throws SQLException {
        String query = "SELECT id FROM Linea_Compra WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, idBuscado);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
    }

    public static void verLineasCompra(Connection con) throws SQLException {
        String query = "SELECT id, nlineas, ida, idM FROM Linea_Compra";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Número de líneas : " + rs.getInt("nlineas"));
                System.out.println("ID del Administrativo que ha realizado la factura: " + rs.getInt("ida"));
                System.out.println("ID de los materiales de la línea: " + rs.getInt("idM"));
                System.out.println("-------------");
            }
        }
    }

    public static void verLineaCompraPorId(Connection con, int idBuscado) throws SQLException {
        if (buscarLineaCompraId(con, idBuscado)) {
            String query = "SELECT id, nlineas, ida, idM FROM Linea_Compra WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, idBuscado);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Número de líneas : " + rs.getInt("nlineas"));
                    System.out.println("ID del Administrativo que ha realizado la factura: " + rs.getInt("ida"));
                    System.out.println("ID de los materiales de la línea: " + rs.getInt("idM"));
                    System.out.println("-------------");
                }
            }
        } else {
            System.out.println("No se puede mostrar porque no existe la línea de compra");
        }
    }

    public static void borrarLineaCompraPorId(Connection con, int idBorrar) throws SQLException {
        if (buscarLineaCompraId(con, idBorrar)) {
            String delete = "DELETE FROM Linea_Compra WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(delete)) {
                pstmt.setInt(1, idBorrar);
                pstmt.executeUpdate();
                System.out.println("Línea de compra borrada");
            }
        } else {
            System.out.println("No se puede borrar porque no existe la línea de compra");
        }
    }

    public static void modificarNlineas(Connection con, int id, int nuevaNlineas) throws SQLException {
        if (buscarLineaCompraId(con, id)) {
            String sql = "UPDATE Linea_Compra SET nlineas = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, nuevaNlineas);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Número de líneas modificado");
            }
        } else {
            System.out.println("No se puede modificar porque no existe la línea de compra");
        }
    }
    public static void modificarIdA(Connection con, int id, int nuevoIdA) throws SQLException {
        boolean existe = buscarLineaCompraId(con, id);
        if (existe) {
            String sql = "UPDATE Linea_Compra SET idA = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, nuevoIdA);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("ID Administrador modificado");
            }
        } else {
            System.out.println("No se puede modificar porque no existe la linea de compra o ese administrador");
        }
    }

    public static void modificarIdM(Connection con, int id, int nuevoIdM) throws SQLException {
    boolean existe = buscarLineaCompraId(con, id);
    if (existe) {
        String sql = "UPDATE Linea_Compra SET idM = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, nuevoIdM);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("ID Material modificado");
        }
    } else {
        System.out.println("No se puede modificar porque no existe la línea de compra o ese material");
    }
}

}
