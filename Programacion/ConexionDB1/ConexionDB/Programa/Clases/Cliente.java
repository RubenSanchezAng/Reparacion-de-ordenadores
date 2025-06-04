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
public class Cliente extends Usuario {

    /** Información sobre la última reparación realizada por el cliente */
    private String ultimaReparacion;

    /**
     * <p>Constructor por defecto. Inicializa los campos heredados con valores por defecto
     * y <code>ultimaReparacion</code> con un mensaje indicando que no hay reparaciones registradas.</p>
     */
    public Cliente() {
        super();
        this.ultimaReparacion = "No hay reparaciones registradas";
    }

    /**
     * <p>Constructor parametrizado. Inicializa todos los atributos incluyendo los heredados
     * y la <code>ultimaReparacion</code> proporcionada.</p>
     *
     * @param nombre Nombre del cliente
     * @param direccion Dirección del cliente
     * @param contacto Información de contacto
     * @param tipoCliente Tipo de cliente (debería ser "particular")
     * @param ultimaReparacion Información sobre la última reparación realizada
     */
    public Cliente(String nombre, String direccion, String contacto, String tipoCliente, String ultimaReparacion) {
        super(nombre, direccion, contacto, tipoCliente);
        this.ultimaReparacion = ultimaReparacion;
    }

    /**
     * <p>Constructor copia. Crea un nuevo objeto Cliente copiando
     * los datos de otra instancia.</p>
     *
     * @param c1 Objeto Cliente que se copia
     */
    public Cliente(Cliente c1) {
        super(c1);
        this.ultimaReparacion = c1.ultimaReparacion;
    }

    /**
     * <p>Establece la información de la última reparación realizada por el cliente.</p>
     *
     * @param ultimaReparacion Texto con la descripción de la reparación
     */
    public void setUltimaReparacion(String ultimaReparacion) {
        this.ultimaReparacion = ultimaReparacion;
    }

    /**
     * <p>Devuelve la información de la última reparación.</p>
     *
     * @return Texto con la última reparación realizada
     */
    public String getUltimaReparacion() {
        return ultimaReparacion;
    }

    /**
     * <p>Devuelve una representación en texto del objeto Cliente.</p>
     *
     * @return Cadena con la información del usuario y la última reparación
     */
    public String toString() {
        return super.toString() + " y su última reparación ha sido " + ultimaReparacion;
    }
}