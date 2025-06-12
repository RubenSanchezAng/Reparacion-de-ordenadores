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

    public static void leerClientesDesdeArch(Connection con, String fichero) {
        File f = new File(fichero);
        FileReader fr = null;
        BufferedReader lector = null;

        if (f.exists()) {
            try {
                fr = new FileReader(f);
                lector = new BufferedReader(fr);
                String linea;
                int numLinea = 0;

                System.out.println("Iniciando lectura de clientes desde el fichero: " + fichero);

                while ((linea = lector.readLine()) != null) {
                    numLinea++;
                    String[] partes = linea.split(",");
                    if (partes.length == 4) {
                        try {
                            int id = Integer.parseInt(partes[0]);
                            String correo = partes[1];
                            String nombre = partes[2];
                            String direccion = partes[3];

                            insertarCliente(con, id, correo, nombre, direccion);

                        } catch (NumberFormatException e) {
                            System.err.println("Error de formato numérico" + e.getMessage());
                        } catch (SQLException e) {
                            System.err.println("Error de base de datos al insertar cliente" + e.getMessage());
                        }
                    } 
                }
                System.out.println("Lectura de clientes realizada");

            } catch (IOException e) {
                System.err.println("Error al leer el fichero: ");
                e.printStackTrace();
            } finally {
                try {
                    if (lector != null){
                    lector.close();
                    } 
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (fr != null) fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("El fichero no existe");
        }
    }
    public static void escribirClientesEnArch(Connection con, String fichero) {
        String sql = "SELECT id, correo, nombre, direccion FROM Cliente";

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
                String correo = rs.getString("correo");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");

                String linea = id + "," + correo + "," + nombre + "," + direccion;
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Clientes exportados");

        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + fichero);
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