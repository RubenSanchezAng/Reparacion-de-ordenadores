package Clases;

/**
 * <h2>Clase Cliente</h2>
 * <p>
 * Representa a un cliente que hereda de la clase Usuario.
 * Añade información adicional como la última reparación realizada.
 * </p>
 *
 * <p>Se puede utilizar para registrar clientes particulares con sus datos personales
 * y la información de su última reparación.</p>
 *
 * @author Alejandro Farinós Ramos
 * @version 1.0
 * @date 15-04-2025
 */
public class Cliente{

     private int id;
    private String correo;
    private String nombre;
    private String direccion;

    /**
     * Crea una nueva instancia de Cliente con los datos proporcionados.
     * 
     * @param id        el identificador del cliente
     * @param correo    el correo electrónico del cliente
     * @param nombre    el nombre del cliente
     * @param direccion la dirección del cliente
     */
    public Cliente(int id, String correo, String nombre, String direccion) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * Obtiene el identificador del cliente.
     * 
     * @return el id del cliente
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del cliente.
     * 
     * @param id el nuevo identificador del cliente
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     * 
     * @return el correo del cliente
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del cliente.
     * 
     * @param correo el nuevo correo del cliente
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return el nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre el nuevo nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la dirección del cliente.
     * 
     * @return la dirección del cliente
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del cliente.
     * 
     * @param direccion la nueva dirección del cliente
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
    
