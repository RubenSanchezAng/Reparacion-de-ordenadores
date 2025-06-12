package BaseDatos;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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
        public static void leerAlmacenesDesdeArch(Connection con, String fichero) throws SQLException {
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
                        Date fecha = Date.valueOf(partes[1].trim()); 
                        String ubicacion = partes[2].trim();
                        AlmacenDB.insertarAlmacen(con, id, fecha, ubicacion);
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
    public static void escribirAlmacenesEnArch(Connection con, String fichero) {
        String sql = "SELECT id, fecha, ubicacion FROM Almacen";

        File f = new File(fichero);
        FileWriter fw = null;
        BufferedWriter bw = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                Date fecha = rs.getDate("fecha");
                String ubicacion = rs.getString("ubicacion");

                String linea = id + "," + fecha + "," + ubicacion;
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Almacenes exportados");

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
