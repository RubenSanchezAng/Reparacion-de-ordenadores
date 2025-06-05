package Clases;
/**
 * Clase abstracta que representa un empleado.
 */
public abstract class Empleado {
    private int idEmpleado;
    private String cargo;
    private String nombre;
    private String tlf;

    /**
     * Constructor de Empleado.
     * 
     * @param idEmpleado Identificador del empleado.
     * @param cargo Cargo del empleado.
     * @param nombre Nombre del empleado.
     * @param tlf Teléfono del empleado.
     */
    public Empleado(int idEmpleado, String cargo, String nombre, String tlf) {
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.nombre = nombre;
        this.tlf = tlf;
    }

    /** Obtiene el id del empleado.
     * 
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /** Establece el id del empleado. 
     *
    */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /** Obtiene el cargo del empleado. 
     * 
    */
    public String getCargo() {
        return cargo;
    }

    /** Establece el cargo del empleado
     * 
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /** Obtiene el nombre del empleado
     * 
    */
    public String getNombre() {
        return nombre;
    }

    /** Establece el nombre del empleado
     * 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Obtiene el teléfono del empleado
     * 
     */
    public String getTlf() {
        return tlf;
    }

    /** Establece el teléfono del empleado
     * 
     */
    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    @Override
    public String toString() {
        return "Empleado: idEmpleado= " + idEmpleado +", cargo= " + cargo +", nombre= " + nombre +", tlf= " + tlf ;
    }
}
