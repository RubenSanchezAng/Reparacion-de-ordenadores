package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDB {
    
    public static void insertarCliente(Connection con, int id, String correo, String nombre, String direccion) throws SQLException {
        String insert = "INSERT INTO Cliente (id, correo, nombre, direccion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(insert)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, correo);
            pstmt.setString(3, nombre);
            pstmt.setString(4, direccion);
            pstmt.executeUpdate();
            System.out.println("Filas insertadas");
        }
    }

    public static void verClientes(Connection con) throws SQLException {
        String query = "SELECT id, correo, nombre, direccion FROM Cliente";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Correo: " + rs.getString("correo"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Dirección: " + rs.getString("direccion"));
                System.out.println("-----------");
            }
        }
    }

 public static boolean buscarClientePorId(Connection con, int idBuscado) throws SQLException {
        boolean clienteExiste = false;
        String query = "SELECT id FROM Cliente WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, idBuscado);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                clienteExiste = true;
            }
        }
        return clienteExiste;
    }
  public static void mostrarClientePorId(Connection con, int idBuscado) throws SQLException {
        if (buscarClientePorId(con, idBuscado)) {
            String query = "SELECT id, correo, nombre, direccion FROM Cliente WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, idBuscado);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Correo: " + rs.getString("correo"));
                    System.out.println("Nombre: " + rs.getString("nombre"));
                    System.out.println("Dirección: " + rs.getString("direccion"));
                    System.out.println("--------------");
                }
            }
        } else 
            System.out.println("No se puede mostrar porque no existe el cliente");
    }

    public static void borrarClientePorId(Connection con, int idBorrar) throws SQLException {
        boolean clienteExiste = buscarClientePorId(con, idBorrar);
        if (clienteExiste) {
            String delete = "DELETE FROM Cliente WHERE id = ?";
            try (PreparedStatement pstmtDelete = con.prepareStatement(delete)) {
                pstmtDelete.setInt(1, idBorrar);
                pstmtDelete.executeUpdate();
                System.out.println("Cliente borrado");
            }
        } else {
            System.out.println("No se puede borrar porque no existe el cliente");
        }
    }

    public static void modificarCorreo(Connection con, int id, String nuevoCorreo) throws SQLException {
        boolean clienteExiste = buscarClientePorId(con, id);
        if (clienteExiste) {
            String update = "UPDATE Cliente SET correo = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(update)) {
                pstmt.setString(1, nuevoCorreo);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Correo modificado");
            }
        } else {
            System.out.println("No se puede modificar porque no existe el cliente");
        }
    }

    public static void modificarNombre(Connection con, int id, String nuevoNombre) throws SQLException {
        boolean clienteExiste = buscarClientePorId(con, id);
        if (clienteExiste) {
            String update = "UPDATE Cliente SET nombre = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(update)) {
                pstmt.setString(1, nuevoNombre);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Nombre modificado");
            }
        } else {
            System.out.println("No se puede modificar porque no existe el cliente");
        }
    }

    public static void modificarDireccion(Connection con, int id, String nuevaDireccion) throws SQLException {
        boolean clienteExiste = buscarClientePorId(con, id);
        if (clienteExiste) {
            String update = "UPDATE Cliente SET direccion = ? WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(update)) {
                pstmt.setString(1, nuevaDireccion);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Dirección modificada");
            }
        } else {
            System.out.println("No se puede modificar porque no existe el cliente");
        }
    }


    
}