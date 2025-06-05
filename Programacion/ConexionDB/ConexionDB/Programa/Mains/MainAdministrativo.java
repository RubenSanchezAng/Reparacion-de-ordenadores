package Mains;

import java.sql.Connection;
import java.sql.SQLException;

import BaseDatos.AdministrativoDB;
import BaseDatos.ConexionDB;


public class MainAdministrativo {
    public static void main(String[] args) {
        int idAdmin = 100;

        try (Connection con = ConexionDB.obtenerConexion()) {

            // Insertar técnico
            AdministrativoDB.insertarAdministrativo(con, idAdmin, "Soporte", "Carlos Gómez", "612345678");

            // Ver todos los técnicos
            AdministrativoDB.verTAdministrativos(con);

            // Ver técnico por ID
            AdministrativoDB.verAdministrativoPorId(con, idAdmin);

            // Modificar nombre
            AdministrativoDB.modificarNombre(con, idAdmin, "Carlos G.");

            // Modificar cargo
            AdministrativoDB.modificarCargo(con, idAdmin, "Especialista");

            // Modificar teléfono
            AdministrativoDB.modificarTelefono(con, idAdmin, "600000000");

            // Ver técnico modificado
            AdministrativoDB.verAdministrativoPorId(con, idAdmin);

            // Borrar técnico
            AdministrativoDB.borrarAdministrativoPorId(con, idAdmin);

            // Intentar ver técnico borrado
            AdministrativoDB.verAdministrativoPorId(con, idAdmin);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
