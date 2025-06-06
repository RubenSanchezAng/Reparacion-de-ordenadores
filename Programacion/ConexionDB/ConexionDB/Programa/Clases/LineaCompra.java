package Clases;
/**
 * Representa una línea de compra con sus atributos como ID, número de líneas, y los IDs asociados a un artículo y un modelo.
 */
public class LineaCompra {
    //---ATRIBUTOS---

    /** El identificador único de la línea de compra.
     */
    private int id;

    /** El número de líneas en esta línea de compra.
     */
    private int nlineas;

    /** El ID del artículo asociado a esta línea de compra.
     */
    private int ida;

    /** El ID del modelo asociado a esta línea de compra.
     */
    private int idM;

    /**
     * Constructor por defecto de la clase LineaCompra.
     */
    public LineaCompra() {
    }

    /**
     * Constructor parametrizado para inicializar todos los atributos de una línea de compra.
     *
     * @param id El identificador único de la línea de compra.
     * @param nlineas El número de líneas.
     * @param ida El ID del artículo asociado.
     * @param idM El ID del modelo asociado.
     */
    public LineaCompra(int id, int nlineas, int ida, int idM) {
        this.id = id;
        this.nlineas = nlineas;
        this.ida = ida;
        this.idM = idM;
    }

    // --SETTERS--
    /**
     * Establece el identificador único de la línea de compra.
     * @param id El nuevo ID de la línea de compra.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece el número de líneas en esta línea de compra.
     * @param nlineas El nuevo número de líneas.
     */
    public void setNlineas(int nlineas) {
        this.nlineas = nlineas;
    }

    /**
     * Establece el ID del artículo asociado a la línea de compra.
     * @param ida El nuevo ID del artículo.
     */
    public void setIda(int ida) {
        this.ida = ida;
    }

    /**
     * Establece el ID del modelo asociado a la línea de compra.
     * @param idM El nuevo ID del modelo.
     */
    public void setIdM(int idM) {
        this.idM = idM;
    }

    //---GETTERS---
    /**
     * Obtiene el identificador único de la línea de compra.
     * @return El ID de la línea de compra.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el número de líneas en esta línea de compra.
     * @return El número de líneas.
     */
    public int getNlineas() {
        return nlineas;
    }

    /**
     * Obtiene el ID del artículo asociado a la línea de compra.
     * @return El ID del artículo.
     */
    public int getIda() {
        return ida;
    }

    /**
     * Obtiene el ID del modelo asociado a la línea de compra.
     * @return El ID del modelo.
     */
    public int getIdM() {
        return idM;
    }

    //---METODOS--
    /**
     * Muestra los datos de una línea de compra.
     * @return Una cadena que representa todos los atributos de la línea de compra.
     */
    @Override
    public String toString() {
        return "LineaCompra + id=" + id + ", nlineas=" + nlineas +", ida=" + ida +", idM=" + idM ;
    }
}