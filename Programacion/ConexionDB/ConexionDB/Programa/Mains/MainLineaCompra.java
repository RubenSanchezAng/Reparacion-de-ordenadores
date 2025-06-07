package Mains;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.SQLException;

import BaseDatos.ConexionDB;
import BaseDatos.LineaCompraDB;

public class MainLineaCompra{
    public static void main(String[] args) {

        try (Connection con = ConexionDB.obtenerConexion()) {
            System.out.println("Conexión establecida.");
   
            //LineaCompraDB.insertarLineaCompra(con, 100, 5, 1, 2);

            LineaCompraDB.verLineasCompra(con);

            LineaCompraDB.verLineaCompraPorId(con, 100);

            LineaCompraDB.modificarNlineas(con, 100, 10);

            LineaCompraDB.verLineaCompraPorId(con, 100);

            LineaCompraDB.borrarLineaCompraPorId(con, 100);

            LineaCompraDB.verLineasCompra(con);

            
        } catch (SQLException e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
        }
    }
}