/**
 * <h2>Clase Institucion</h2>
 * <p>
 * Representa a un cliente institucional que hereda de la clase Usuario.
 * Añade información adicional como el sector al que pertenece la institución.
 * </p>
 *
 * <p>Se puede utilizar para registrar instituciones con sus datos de contacto
 * y el sector en el que operan.</p>
 *
 * @author Alejandro Farinós Ramos
 * @version 1.0
 * @date : 15-04-2025
 */
public class Institucion extends Usuario {
    
    /** Sector al que pertenece la institución*/
    private String sector;

    /**
     * <p>Constructor por defecto. Inicializa los campos heredados con valores por defecto
     * y el sector como "Desconocido".</p>
     */
    public Institucion() {
        super();
        this.sector = "Desconocido";
    }

    /**
     * <p>Constructor parametrizado. Inicializa todos los atributos incluyendo los heredados
     * y el <code>sector</code> proporcionado.</p>
     *
     * @param nombre        Nombre de la institución
     * @param direccion     Dirección de la institución
     * @param contacto      Información de contacto
     * @param tipoCliente   Tipo de cliente (debería ser "institucional")
     * @param sector        Sector al que pertenece la institución
     */
    public Institucion(String nombre, String direccion, String contacto, String tipoCliente, String sector) {
        super(nombre, direccion, contacto, tipoCliente);
        this.sector = sector;
    }

    /**
     * <p>Constructor copia. Crea un nuevo objeto Institucion copiando
     * los datos de otra instancia.</p>
     *
     * @param s1 Objeto Institucion que se copia
     */
    public Institucion(Institucion s1) {
        super(s1);
        this.sector = s1.sector;
    }

    /**
     * <p>Establece el sector al que pertenece la institución.</p>
     *
     * @param sector 
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    /**
     * <p>Devuelve el sector de la institución.</p>
     *
     * @return El sector al que pertenece
     */
    public String getSector() {
        return sector;
    }

    /**
     * <p>Devuelve una representación en texto del objeto Institucion.</p>
     *
     * @return Cadena con la información del usuario y el sector
     */
    public String toString() {
        return super.toString() + " y el sector es " + sector;
    }
}
