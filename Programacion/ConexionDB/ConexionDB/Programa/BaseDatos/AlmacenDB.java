package BaseDatos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlmacenDB {

    public static void insertarAlmacen(Connection con, int id, java.sql.Date fecha, String ubicacion) throws SQLException {
        String insert = "INSERT INTO Almacen (id, fecha, ubicacion) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(insert)) {
            pstmt.setInt(1, id);
            pstmt.setDate(2, fecha);
            pstmt.setString(3, ubicacion);
            pstmt.executeUpdate();
            System.out.println("almacen insertado");
        }
    }

    public static boolean buscarAlmacenPorId(Connection con, int idBuscado) throws SQLException {
        boolean existe = false;
        String query = "SELECT id FROM Almacen WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, idBuscado);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        }
        return existe;
    }

    public static void verAlmacenes(Connection con) throws SQLException {
        String query = "SELECT id, fecha, ubicacion FROM Almacen";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Fecha: " + rs.getDate("fecha"));
                System.out.println("Ubicación: " + rs.getString("ubicacion"));
                System.out.println("-------------");
            }
        }
    }

    public static void verAlmacenPorId(Connection con, int idBuscado) throws SQLException {
        boolean existe = buscarAlmacenPorId(con, idBuscado);
        if (existe) {
            String query = "SELECT id, fecha, ubicacion FROM Almacen WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, idBuscado);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Fecha: " + rs.getDate("fecha"));
                    System.out.println("Ubicación: " + rs.getString("ubicacion"));
                    System.out.println("---------");
                }
            }
        } else {
            System.out.println("No se puede mostrar porque no existe el almacen");
        }
    }

    public static void borrarAlmacenPorId(Connection con, int idBorrar) throws SQLException {
        boolean existe = buscarAlmacenPorId(con, idBorrar);
        if (existe) {
            String delete = "DELETE FROM Almacen WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(delete)) {
                pstmt.setInt(1, idBorrar);
                pstmt.executeUpdate();
                System.out.println("Almacén borrado");
            }
        } else {
            System.out.println("No se puede borrar porque no existe el almacen");
        }
    }

    public static void modificarFecha(Connection con, int id, java.sql.Date nuevaFecha) throws SQLException {
       boolean existe = buscarAlmacenPorId(con, id);
        if (existe) {
            String sql = "UPDATE Almacen SET fecha = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setDate(1, nuevaFecha);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Fecha modificada");
            }
        } else {
            System.out.println("No se puede modificar  porque no existe el almacen");
        }
    }

    public static void modificarUbicacion(Connection con, int id, String nuevaUbicacion) throws SQLException {
       boolean existe = buscarAlmacenPorId(con, id);
        if (existe) {
            String sql = "UPDATE Almacen SET ubicacion = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, nuevaUbicacion);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Ubicación modificada");
            }
        } else {
            System.out.println("No se puede modificar  porque no existe el almacen");
        }
    }
}
