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

            TecnicoDB.insertarTecnico(con, "Soporte", "Carlos Gómez", "612345678");

            TecnicoDB.verTecnicos(con);

            TecnicoDB.verTecnicoPorId(con, idTecnico);

            TecnicoDB.modificarNombre(con, idTecnico, "Carlos G.");

            TecnicoDB.modificarCargo(con, idTecnico, "Especialista");

            TecnicoDB.modificarTelefono(con, idTecnico, "600000000");

            TecnicoDB.verTecnicoPorId(con, idTecnico);

            TecnicoDB.borrarTecnicoPorId(con, idTecnico);

            TecnicoDB.verTecnicoPorId(con, idTecnico);

        } catch (SQLException e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
        }
    }
}