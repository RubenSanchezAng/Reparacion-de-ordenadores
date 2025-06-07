package Mains;

import java.sql.Connection;
import java.sql.SQLException;

import BaseDatos.ProveedorDB;
import BaseDatos.ConexionDB;

public class MainProvedorDB{
    public static void main(String[] args) {
        try (Connection con = ConexionDB.obtenerConexion()) {
            System.out.println("Conexión establecida.");
   
            ProveedorDB.insertarProveedor(con, 100, "Proveedor Dos", "987654321");

            ProveedorDB.verProveedores(con);

            ProveedorDB.verProveedorPorId(con, 1);

            ProveedorDB.modificarNombre(con, 100, "Proveedor Actualizado");
            
            ProveedorDB.modificarTelefono(con, 100, "111222333");

            ProveedorDB.verProveedorPorId(con, 100);

            ProveedorDB.borrarProveedorPorId(con, 100);

            ProveedorDB.verProveedores(con);


            
        } catch (SQLException e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
        }
    }
}
