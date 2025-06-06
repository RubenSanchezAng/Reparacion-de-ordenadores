package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDB {
    public static void insertarEmpleado(Connection con, int id, String cargo, String nombre, String tlf) throws SQLException {
        String insertEmpleadoSQL = "INSERT INTO Empleado (id_Empleado, cargo, nombre, tlf) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(insertEmpleadoSQL)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, cargo);
            pstmt.setString(3, nombre);
            pstmt.setString(4, tlf);
            pstmt.executeUpdate();
        }
        System.out.println("Empleado insertado.");
    }

    public static boolean buscarEmpleadoPorId(Connection con, int idBuscado) throws SQLException {
        boolean existe = false;
        String query = "SELECT id_Empleado FROM Empleado WHERE id_Empleado = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, idBuscado);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        }
        return existe;
    }

    public static void verTodosEmpleados(Connection con) throws SQLException {
        String query = "SELECT id_Empleado, cargo, nombre, tlf FROM Empleado";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_Empleado"));
                System.out.println("Cargo: " + rs.getString("cargo"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Teléfono: " + rs.getString("tlf"));
                System.out.println("-------------");
            }
        }
    }

    public static void verEmpleadoPorId(Connection con, int idBuscado) throws SQLException {
        if (buscarEmpleadoPorId(con, idBuscado)) {
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
            System.out.println("No se puede mostrar porque no existe el empleado con ID: " + idBuscado);
        }
    }

    public static void borrarEmpleadoPorId(Connection con, int idBorrar) throws SQLException {
        if (buscarEmpleadoPorId(con, idBorrar)) {
            String deleteEmpleadoSQL = "DELETE FROM Empleado WHERE id_Empleado = ?";
            try (PreparedStatement pstmt = con.prepareStatement(deleteEmpleadoSQL)) {
                pstmt.setInt(1, idBorrar);
                pstmt.executeUpdate();
            }
            System.out.println("Empleado con ID " + idBorrar + " borrado correctamente.");
        } else {
            System.out.println("No se puede borrar porque no existe el empleado con ID: " + idBorrar);
        }
    }

    public static void modificarCargo(Connection con, int id, String nuevoCargo) throws SQLException {
        if (buscarEmpleadoPorId(con, id)) {
            String updateSQL = "UPDATE Empleado SET cargo = ? WHERE id_Empleado = ?";
            try (PreparedStatement pstmt = con.prepareStatement(updateSQL)) {
                pstmt.setString(1, nuevoCargo);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Cargo del empleado con ID " + id + " modificado a: " + nuevoCargo);
            }
        } else {
            System.out.println("No se puede modificar el cargo porque no existe el empleado con ID: " + id);
        }
    }

    public static void modificarTelefono(Connection con, int id, String nuevoTelefono) throws SQLException {
        if (buscarEmpleadoPorId(con, id)) {
            String updateSQL = "UPDATE Empleado SET tlf = ? WHERE id_Empleado = ?";
            try (PreparedStatement pstmt = con.prepareStatement(updateSQL)) {
                pstmt.setString(1, nuevoTelefono);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Teléfono del empleado con ID " + id + " modificado a: " + nuevoTelefono);
            }
        } else {
            System.out.println("No se puede modificar el teléfono porque no existe el empleado con ID: " + id);
        }
    }

    public static void modificarNombre(Connection con, int id, String nuevoNombre) throws SQLException {
        if (buscarEmpleadoPorId(con, id)) {
            String updateSQL = "UPDATE Empleado SET nombre = ? WHERE id_Empleado = ?";
            try (PreparedStatement pstmt = con.prepareStatement(updateSQL)) {
                pstmt.setString(1, nuevoNombre);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Nombre del empleado con ID " + id + " modificado a: " + nuevoNombre);
            }
        } else {
            System.out.println("No se puede modificar el nombre porque no existe el empleado con ID: " + id);
        }
    }
}