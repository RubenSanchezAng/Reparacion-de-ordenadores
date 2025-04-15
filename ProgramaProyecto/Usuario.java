/**
 * <h2>Clase Usuario</h2>
 * <p>
 * Representa un usuario base con información común como nombre, dirección, contacto
 * y tipo de cliente. Esta clase sirve como clase padre para clases más específicas como
 * Cliente o Institucion.
 * </p>
 *
 * <p>Incluye constructores para crear objetos desde cero, con parámetros o copiando
 * otro objeto de tipo Usuario.</p>
 *
 * @author Alejandro Farinós Ramos
 * @version 1.0
 * @date 15-04-2025
 */
public class Usuario {
    
    /** Nombre del usuario */
    private String nombre;
    
    /** Dirección del usuario */
    private String direccion;
    
    /** Tipo de cliente (particular o institucional) */
    private String tipoCliente;
    
    /** Información de contacto del usuario */
    private String contacto;

    /**
     * <p>Constructor por defecto. Inicializa los campos con valores vacíos.</p>
     */
    public Usuario() {
        nombre = " ";
        direccion = " ";
        contacto = "";
        tipoCliente = " ";
    }

    /**
     * <p>Constructor parametrizado. Permite inicializar todos los atributos del usuario.</p>
     *
     * @param nombre Nombre del usuario
     * @param direccion Dirección del usuario
     * @param contacto Información de contacto
     * @param tipoCliente Tipo de cliente (particular o institucional)
     */
    public Usuario(String nombre, String direccion, String contacto, String tipoCliente) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
        this.tipoCliente = tipoCliente;
    }

    /**
     * <p>Constructor copia. Crea un nuevo objeto Usuario copiando los valores
     * de otro objeto Usuario existente.</p>
     *
     * @param u1 Objeto Usuario del cual se copian los datos
     */
    public Usuario(Usuario u1) {
        this.nombre = u1.nombre;
        this.direccion = u1.direccion;
        this.contacto = u1.contacto;
        this.tipoCliente = u1.tipoCliente;
    }

    /**
     * <p>Establece el nombre del usuario.</p>
     *
     * @param nombre Nombre a asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * <p>Establece la dirección del usuario.</p>
     *
     * @param direccion Dirección a asignar
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * <p>Establece el contacto del usuario.</p>
     *
     * @param contacto Información de contacto a asignar
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
     * <p>Establece el tipo de cliente.</p>
     *
     * @param tipoCliente Tipo de cliente a asignar (particular o institucional)
     */
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    /**
     * <p>Devuelve el nombre del usuario.</p>
     *
     * @return Nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <p>Devuelve la dirección del usuario.</p>
     *
     * @return Dirección del usuario
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * <p>Devuelve el contacto del usuario.</p>
     *
     * @return Información de contacto
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * <p>Devuelve el tipo de cliente.</p>
     *
     * @return Tipo de cliente (particular o institucional)
     */
    public String getTipoCliente() {
        return tipoCliente;
    }

    /**
     * <p>Devuelve una representación en texto del objeto Usuario.</p>
     *
     * @return Cadena con los datos del usuario
     */
    public String toString() {
        return "Los datos del usuario son nombre: " + nombre + " direccion: " + direccion + " contacto: " + contacto + " tipo de cliente: " + tipoCliente;
    }
}
