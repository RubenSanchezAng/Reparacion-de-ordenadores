package Clases;
import java.time.LocalDate;

/**
 * Representa un equipo con sus atributos como ID, estado, fecha, modelo, marca y el ID del técnico asociado.
 */
public class Equipo {
    //---ATRIBUTOS---

    /** El identificador único del equipo.
     * 
     */
    private int id;
   
    /** El estado actual del equipo
     * 
     */
    private String estado;
    
    /** 
     * La fecha asociada al equip
     * 
    */
    private LocalDate fecha;

    /** 
     * El modelo del equipo.
     * 
     */
    private String modelo;
    /** 
     * La marca del equipo. 
     * */
    private String marca;
    /**
     *  El ID del técnico asociado a este equipo
     * */
    private int idT;

    /**
     * Constructor por defecto de la clase Equipo.
     */
    public Equipo() {
    }

    /**
     * Constructor parametrizado para inicializar todos los atributos de un equipo.
     *
     * @param id El identificador único del equipo.
     * @param estado El estado actual del equipo.
     * @param fecha La fecha asociada al equipo.
     * @param modelo El modelo del equipo.
     * @param marca La marca del equipo.
     * @param idT El ID del técnico asociado.
     */
    public Equipo(int id, String estado, LocalDate fecha, String modelo, String marca, int idT) {
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;
        this.modelo = modelo;
        this.marca = marca;
        this.idT = idT;
    }

    // --SETTERS--
    /**
     * Establece el identificador único del equipo.
     * @param id El nuevo ID del equipo.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece el estado actual del equipo.
     * @param estado El nuevo estado del equipo.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Establece la fecha asociada al equipo.
     * @param fecha La nueva fecha del equipo.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece el modelo del equipo.
     * @param modelo El nuevo modelo del equipo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Establece la marca del equipo.
     * @param marca La nueva marca del equipo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Establece el ID del técnico asociado al equipo.
     * @param idT El nuevo ID del técnico.
     */
    public void setIdT(int idT) {
        this.idT = idT;
    }

    //---GETTERS---
    /**
     * Obtiene el identificador único del equipo.
     * @return El ID del equipo.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el estado actual del equipo.
     * @return El estado del equipo.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Obtiene la fecha asociada al equipo.
     * @return La fecha del equipo.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Obtiene el modelo del equipo.
     * @return El modelo del equipo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Obtiene la marca del equipo.
     * @return La marca del equipo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Obtiene el ID del técnico asociado al equipo.
     * @return El ID del técnico.
     */
    public int getIdT() {
        return idT;
    }

    //---METODOS--
    /**
    *Muestra los datos de un equipo
    * @return Un método que muestra todos los atributos del equipo.
     */
    @Override
    public String toString() {
        return "Equipo: id=" + id +", estado='" + estado + ", fecha=" + fecha +", modelo='" + modelo +", marca='" + marca + ", idT=" + idT;
    }
}