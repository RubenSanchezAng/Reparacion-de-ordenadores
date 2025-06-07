package Mains;

import java.sql.Connection;
import java.sql.SQLException;

import BaseDatos.FacturaDB;
import BaseDatos.ConexionDB;


public class MainFactura{
    public static void main(String[] args) {

        try (Connection con = ConexionDB.obtenerConexion()) {


             // 1. Insertar
              FacturaDB.insertarFactura(con, 100, 1200.50, 1);

             // 2. Ver todas
             System.out.println("Facturas registradas:");
             FacturaDB.verFacturas(con);
 
             // 3. Ver factura 
             System.out.println("Factura con ID 100:");
              FacturaDB.verFacturaPorId(con, 100);
 
             // 4. Modificar la cantidad
             FacturaDB.modificarCantidad(con, 100, 1500.00);
 

             FacturaDB.verFacturaPorId(con, 100);
 
             // 6. Borrar la factura
              FacturaDB.borrarFacturaPorId(con, 100);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
