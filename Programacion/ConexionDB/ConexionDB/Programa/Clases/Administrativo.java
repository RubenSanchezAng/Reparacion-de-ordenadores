package Clases;

/**
 * Clase que representa un administrativo, que es un tipo de empleado.
 */
public class Administrativo extends Empleado {

    /**
     * Constructor de Administrativo.
     * 
     * @param idEmpleado Identificador del empleado administrativo.
     * @param cargo Cargo del empleado.
     * @param nombre Nombre del empleado.
     * @param tlf Teléfono del empleado.
     */
    public Administrativo(int idEmpleado, String cargo, String nombre, String tlf) {
        super(idEmpleado, cargo, nombre, tlf);
    }

    @Override
    public String toString() {
        return "Administrativo{" + super.toString() + "}";
    }
}

