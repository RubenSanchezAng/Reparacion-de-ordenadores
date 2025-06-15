package Mains;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.SQLException;

import BaseDatos.ConexionDB;
import BaseDatos.OrdenCompraDB;

public class MainOrdenCompra{
    public static void main(String[] args) {

        try (Connection con = ConexionDB.obtenerConexion()) {
            System.out.println("Conexión establecida.");
   
            int id = 100;
            Date fecha = Date.valueOf("2025-06-06");
            int idProveedor = 1;
            int idAdministrativo = 2;
            OrdenCompraDB.insertarOrdenCompra(con,  fecha, idProveedor, idAdministrativo);

            OrdenCompraDB.verOrdenesCompra(con);

            OrdenCompraDB.verOrdenCompraPorId(con, id);

            Date nuevaFecha = Date.valueOf("2025-06-10");
            OrdenCompraDB.modificarFechaOrden(con, id, nuevaFecha);

            OrdenCompraDB.verOrdenCompraPorId(con, id);


        } catch (SQLException e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
        }
    }
}