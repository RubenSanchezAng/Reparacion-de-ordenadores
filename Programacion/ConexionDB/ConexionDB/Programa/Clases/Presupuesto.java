package Clases;

/**
 * Representa un presupuesto con sus atributos como ID, cantidad, y los IDs asociados a un equipo, un cliente y una factura.
 */
public class Presupuesto {
    //---ATRIBUTOS---

    /** El identificador único del presupuesto.
     */
    private int id;

    /** La cantidad total del presupuesto.
     */
    private double cantidad;

    /** El ID del equipo asociado a este presupuesto.
     */
    private int idE;

    /** El ID del cliente asociado a este presupuesto.
     */
    private int idC;

    /** El ID de la factura asociada a este presupuesto.
     */
    private int idF;

    /**
     * Constructor por defecto de la clase Presupuesto.
     */
    public Presupuesto() {
    }

    /**
     * Constructor parametrizado para inicializar todos los atributos de un presupuesto.
     *
     * @param id El identificador único del presupuesto.
     * @param cantidad La cantidad total del presupuesto.
     * @param idE El ID del equipo asociado.
     * @param idC El ID del cliente asociado.
     * @param idF El ID de la factura asociada.
     */
    public Presupuesto(int id, double cantidad, int idE, int idC, int idF) {
        this.id = id;
        this.cantidad = cantidad;
        this.idE = idE;
        this.idC = idC;
        this.idF = idF;
    }

    // --SETTERS--
    /**
     * Establece el identificador único del presupuesto.
     * @param id El nuevo ID del presupuesto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece la cantidad total del presupuesto.
     * @param cantidad La nueva cantidad del presupuesto.
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Establece el ID del equipo asociado al presupuesto.
     * @param idE El nuevo ID del equipo.
     */
    public void setIdE(int idE) {
        this.idE = idE;
    }

    /**
     * Establece el ID del cliente asociado al presupuesto.
     * @param idC El nuevo ID del cliente.
     */
    public void setIdC(int idC) {
        this.idC = idC;
    }

    /**
     * Establece el ID de la factura asociada al presupuesto.
     * @param idF El nuevo ID de la factura.
     */
    public void setIdF(int idF) {
        this.idF = idF;
    }

    //---GETTERS---
    /**
     * Obtiene el identificador único del presupuesto.
     * @return El ID del presupuesto.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene la cantidad total del presupuesto.
     * @return La cantidad del presupuesto.
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Obtiene el ID del equipo asociado al presupuesto.
     * @return El ID del equipo.
     */
    public int getIdE() {
        return idE;
    }

    /**
     * Obtiene el ID del cliente asociado al presupuesto.
     * @return El ID del cliente.
     */
    public int getIdC() {
        return idC;
    }

    /**
     * Obtiene el ID de la factura asociada al presupuesto.
     * @return El ID de la factura.
     */
    public int getIdF() {
        return idF;
    }

    //---METODOS--
    /**
     * Muestra los datos de un presupuesto.
     * @return Una cadena que representa todos los atributos del presupuesto.
     */
    @Override
    public String toString() {
        return "Presupuesto: id=" + id +", cantidad=" + cantidad +", idE=" + idE +", idC=" + idC + ", idF=" + idF ;
    }
}