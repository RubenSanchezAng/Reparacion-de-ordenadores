package Clases;

import java.time.LocalDate;

/**
 * Representa una orden de compra con sus atributos como ID, fecha, y los IDs asociados a un producto y un cliente.
 */
public class OrdenCompra {
    //---ATRIBUTOS---

    /** El identificador único de la orden de compra.
     */
    private int id;

    /** La fecha en que se realizó la orden de compra.
     */
    private LocalDate fecha;

    /** El ID del producto asociado a esta orden de compra.
     */
    private int idP;

    /** El ID del cliente asociado a esta orden de compra.
     */
    private int idA;

    /**
     * Constructor por defecto de la clase OrdenCompra.
     */
    public OrdenCompra() {
    }

    /**
     * Constructor parametrizado para inicializar todos los atributos de una orden de compra.
     *
     * @param id El identificador único de la orden de compra.
     * @param fecha La fecha en que se realizó la orden de compra.
     * @param idP El ID del producto asociado.
     * @param idA El ID del cliente asociado.
     */
    public OrdenCompra(int id, LocalDate fecha, int idP, int idA) {
        this.id = id;
        this.fecha = fecha;
        this.idP = idP;
        this.idA = idA;
    }

    // --SETTERS--
    /**
     * Establece el identificador único de la orden de compra.
     * @param id El nuevo ID de la orden de compra.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece la fecha de la orden de compra.
     * @param fecha La nueva fecha de la orden de compra.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece el ID del producto asociado a la orden de compra.
     * @param idP El nuevo ID del producto.
     */
    public void setIdP(int idP) {
        this.idP = idP;
    }

    /**
     * Establece el ID del cliente asociado a la orden de compra.
     * @param idA El nuevo ID del cliente.
     */
    public void setIdA(int idA) {
        this.idA = idA;
    }

    //---GETTERS---
    /**
     * Obtiene el identificador único de la orden de compra.
     * @return El ID de la orden de compra.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene la fecha de la orden de compra.
     * @return La fecha de la orden de compra.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Obtiene el ID del producto asociado a la orden de compra.
     * @return El ID del producto.
     */
    public int getIdP() {
        return idP;
    }

    /**
     * Obtiene el ID del cliente asociado a la orden de compra.
     * @return El ID del cliente.
     */
    public int getIdA() {
        return idA;
    }

    //---METODOS--
    /**
     * Muestra los datos de una orden de compra.
     * @return Una cadena que representa todos los atributos de la orden de compra.
     */
    @Override
    public String toString() {
        return "OrdenCompra: id=" + id +", fecha=" + fecha + ", idP=" + idP +", idA=" + idA;
    }
}