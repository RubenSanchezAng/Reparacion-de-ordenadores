package Mains;

import java.sql.Connection;
import java.sql.SQLException;

import BaseDatos.ConexionDB;
import BaseDatos.TecnicoDB;

public class MainTecnico{
    public static void main(String[] args) {
        try (Connection con = ConexionDB.obtenerConexion()) {
            System.out.println("Conexión establecida.");
           
            int idTecnico = 100;

            // Insertar técnico
            //TecnicoDB.insertarTecnico(con, idTecnico, "Soporte", "Carlos Gómez", "612345678");

            // Ver todos los técnicos
            TecnicoDB.verTecnicos(con);

            // Ver técnico por ID
            TecnicoDB.verTecnicoPorId(con, idTecnico);

            // Modificar nombre
            TecnicoDB.modificarNombre(con, idTecnico, "Carlos G.");

            // Modificar cargo
            TecnicoDB.modificarCargo(con, idTecnico, "Especialista");

            // Modificar teléfono
            TecnicoDB.modificarTelefono(con, idTecnico, "600000000");

            // Ver técnico modificado
            TecnicoDB.verTecnicoPorId(con, idTecnico);

            // Borrar técnico
            TecnicoDB.borrarTecnicoPorId(con, idTecnico);

            // Intentar ver técnico borrado
            TecnicoDB.verTecnicoPorId(con, idTecnico);

        } catch (SQLException e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
        }
    }
}