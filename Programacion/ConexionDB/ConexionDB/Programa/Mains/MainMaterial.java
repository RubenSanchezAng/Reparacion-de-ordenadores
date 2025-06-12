package Mains;

import java.sql.Connection;
import java.sql.SQLException;

import BaseDatos.ConexionDB;
import BaseDatos.MaterialesDB;

public class MainMaterial{
    public static void main(String[] args) {
        try (Connection con = ConexionDB.obtenerConexion()) {
            System.out.println("Conexión establecida.");

            MaterialesDB.insertarMaterial(con, 1, "Tornillos", 100, 15.75,2);

            MaterialesDB.verMateriales(con);

            MaterialesDB.verMaterialPorId(con, 1);

            MaterialesDB.modificarNombre(con, 100, "Tornillos Acero");

            MaterialesDB.modificarStock(con, 100, 150);

            MaterialesDB.modificarCoste(con, 100, 18.50);

            MaterialesDB.verMaterialPorId(con, 100);

            MaterialesDB.borrarMateriaPorId(con, 100);

            MaterialesDB.verMateriales(con);

        } catch (SQLException e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
        }
    }
}