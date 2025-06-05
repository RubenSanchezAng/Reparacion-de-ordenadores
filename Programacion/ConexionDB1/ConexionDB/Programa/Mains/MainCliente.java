package Mains;

import java.sql.Connection;
import java.sql.SQLException;

import BaseDatos.ClienteDB;
import BaseDatos.ConexionDB;

public class MainCliente {
    public static void main(String[] args) {
        try (Connection con = ConexionDB.obtenerConexion()) {
            System.out.println("Conexión establecida.");
   
            // Insertar clientes
            ClienteDB.insertarCliente(con, 101, "juan@mail.com", "Juan Perez", "Calle Falsa 123");

            // Ver clientes
            ClienteDB.verClientes(con);

            // Mostrar cliente
            ClienteDB.mostrarClientePorId(con, 1);

            // Modificar correo 
            ClienteDB.modificarCorreo(con, 1, "juan.nuevo@mail.com");
            ClienteDB.mostrarClientePorId(con, 1);
           // Borrar cliente 
            ClienteDB.borrarClientePorId(con, 100);

            // Intentar mostrar cliente borrado
            System.out.println("\n-- Intentar mostrar cliente 2 borrado --");
            ClienteDB.mostrarClientePorId(con, 2);

        } catch (SQLException e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
        }
    }
}