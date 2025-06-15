package Mains;

import java.sql.Connection;
import java.sql.SQLException;

import BaseDatos.ConexionDB;
import BaseDatos.EmpleadoDB;

public class MainEmpleado {
    public static void main(String[] args) {
        try (Connection con = ConexionDB.obtenerConexion()) {
                System.out.println("Conexión establecida.");

            EmpleadoDB.insertarEmpleado(con,  "Gerente", "Juan Perez", "123456789");

            EmpleadoDB.verTodosEmpleados(con);

            EmpleadoDB.verEmpleadoPorId(con, 100);

         

            EmpleadoDB.modificarTelefono(con, 100, "555-1234");

            EmpleadoDB.modificarNombre(con, 100, "Juan Carlos Perez");

            EmpleadoDB.borrarEmpleadoPorId(con, 100);

            EmpleadoDB.borrarEmpleadoPorId(con, 5);
            

            } catch (SQLException e) {
                System.out.println("Error en la base de datos");
                e.printStackTrace();
            }
    }
}
