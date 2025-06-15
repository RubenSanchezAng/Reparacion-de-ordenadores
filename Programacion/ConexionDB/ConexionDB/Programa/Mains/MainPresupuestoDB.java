package Mains;

import java.sql.Connection;
import java.sql.SQLException;

import BaseDatos.PresupuestoDB;
import BaseDatos.ConexionDB;

public class MainPresupuestoDB {
    public static void main(String[] args) {
        try (Connection con = ConexionDB.obtenerConexion()) {
            System.out.println("Conexión establecida.");
   
            int id = 199;
            double cantidad = 1500.75;
            int idEquipo = 2;
            int idCliente = 3;
            int idFactura = 4;

            PresupuestoDB.insertarPresupuesto(con, cantidad, idEquipo, idCliente, idFactura);

            PresupuestoDB.verPresupuestos(con);

            PresupuestoDB.verPresupuestoPorId(con, id);

            double nuevaCantidad = 2000.50;
            PresupuestoDB.modificarCantidad(con, id, nuevaCantidad);

            PresupuestoDB.verPresupuestoPorId(con, id);

            PresupuestoDB.borrarPresupuestoPorId(con, id);

            PresupuestoDB.verPresupuestos(con);

            
        } catch (SQLException e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
        }
    }
}
