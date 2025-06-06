package Clases;

/**
 * Clase que representa un técnico, que es un tipo de empleado.
 */
public class Tecnico extends Empleado {

    /**
     * Constructor de Técnico.
     * 
     * @param idEmpleado Identificador del empleado técnico.
     * @param cargo Cargo del empleado.
     * @param nombre Nombre del empleado.
     * @param tlf Teléfono del empleado.
     */
    public Tecnico(int idEmpleado, String cargo, String nombre, String tlf) {
        super(idEmpleado, cargo, nombre, tlf);
    }

    @Override
    public String toString() {
        return "Tecnico{" + super.toString() + "}";
    }
}