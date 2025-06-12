package Mains;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import BaseDatos.ConexionDB;
import BaseDatos.EquipoDB;

public class MainEquipo {
    public static void main(String[] args) {
        try (Connection con = ConexionDB.obtenerConexion()) {
            System.out.println("Conexión establecida.");
   
            int id = 100;
            String estado = "activo";
            Date fecha = Date.valueOf(LocalDate.of(2025, 6, 6));
            String modelo = "X123";
            String marca = "HP";
            int idTecnico = 3;
            
            EquipoDB.insertarEquipo(con, id, estado, fecha, modelo, marca, idTecnico);

            // Ver todos los equipos.
            //EquipoDB.verEquipos(con);

            // Ver equipo por ID
            //EquipoDB.verEquipoPorId(con, id);

            // Modificar estado
           // EquipoDB.modificarEstado(con, id, "en reparación");

            // Modificar modelo
           // EquipoDB.modificarModelo(con, id, "Z987");

            // Modificar marca
           // EquipoDB.modificarMarca(con, id, "Lenovo");

            // Modificar fecha
           // EquipoDB.modificarFecha(con, id, Date.valueOf(LocalDate.of(2025, 6, 10)));

            // Ver equipo después de modificaciones
           // EquipoDB.verEquipoPorId(con, id);

            // Borrar equipo
           // EquipoDB.borrarEquipoPorId(con, id);

            // Verificar que se borró
            //EquipoDB.verEquipoPorId(con, id);

        } catch (SQLException e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
        }
    }
}
