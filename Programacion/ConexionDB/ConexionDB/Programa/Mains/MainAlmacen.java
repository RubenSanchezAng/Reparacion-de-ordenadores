package Mains;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.SQLException;

import BaseDatos.ConexionDB;
import BaseDatos.AlmacenDB;

public class MainAlmacen {
    public static void main(String[] args) {
        try (Connection con = ConexionDB.obtenerConexion()) {
            System.out.println("Conexión establecida.");
   
             
            AlmacenDB.insertarAlmacen(con,  Date.valueOf(LocalDate.of(2025, 6, 4)), "Madrid");

            AlmacenDB.verAlmacenes(con);

            AlmacenDB.verAlmacenPorId(con, 100);

            AlmacenDB.modificarFecha(con, 100, Date.valueOf(LocalDate.of(2025, 12, 25)));

            AlmacenDB.modificarUbicacion(con, 100, "Barcelona");

            AlmacenDB.verAlmacenPorId(con, 100);

            AlmacenDB.borrarAlmacenPorId(con, 100);

            AlmacenDB.verAlmacenPorId(con, 100);

        } catch (SQLException e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
        }
    }
}