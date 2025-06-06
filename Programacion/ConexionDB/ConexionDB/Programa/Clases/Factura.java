package Clases;

/**
 * Representa una factura con sus atributos como ID, cantidad y el ID asociado a un cliente.
 */
public class Factura {
    //---ATRIBUTOS---

    /** El identificador único de la factura.
     */
    private int id;

    /** La cantidad total de la factura.
     */
    private double cantidad;

    /** El ID del cliente asociado a esta factura.
     */
    private int idA;

    /**
     * Constructor por defecto de la clase Factura.
     */
    public Factura() {
    }

    /**
     * Constructor parametrizado para inicializar todos los atributos de una factura.
     *
     * @param id El identificador único de la factura.
     * @param cantidad La cantidad total de la factura.
     * @param idA El ID del cliente asociado.
     */
    public Factura(int id, double cantidad, int idA) {
        this.id = id;
        this.cantidad = cantidad;
        this.idA = idA;
    }

    // --SETTERS--
    /**
     * Establece el identificador único de la factura.
     * @param id El nuevo ID de la factura.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece la cantidad total de la factura.
     * @param cantidad La nueva cantidad de la factura.
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Establece el ID del cliente asociado a la factura.
     * @param idA El nuevo ID del cliente.
     */
    public void setIdA(int idA) {
        this.idA = idA;
    }

    //---GETTERS---
    /**
     * Obtiene el identificador único de la factura.
     * @return El ID de la factura.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene la cantidad total de la factura.
     * @return La cantidad de la factura.
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Obtiene el ID del cliente asociado a la factura.
     * @return El ID del cliente.
     */
    public int getIdA() {
        return idA;
    }

    //---METODOS--
    /**
     * Muestra los datos de una factura.
     * @return Una cadena que representa todos los atributos de la factura.
     */
    @Override
    public String toString() {
        return "Factura: id=" + id + ", cantidad=" + cantidad + ", idA=" + idA;
    }
}