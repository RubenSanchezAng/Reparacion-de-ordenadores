/**
 * La clase abstracta sirve como base para representar diferentes tipos 
 * de estimaciones.
 *
 * <p>Contiene atributos comunes como una descripción y un costo, y define el método
 * abstracto </p> 
 * @author Rubén Sánchez
 * @version 1.0
 */
public abstract class Estimacion {
    /**
     * Descripción del ítem de estimación (por ejemplo, nombre del material o tipo de trabajo).
     */
    protected String descripcion;

    /**
     * Costo asociado a la estimación.
     */
    protected double costo;

    /**
     * Crea una  instancia con una descripción y un costo.
     *
     * @param descripcion una breve descripción del elemento estimado.
     * @param costo el costo correspondiente al elemento.
     */
    public Estimacion(String descripcion, double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    /**
     * Devuelve el tipo de estimación (por ejemplo, "Material", "Mano de Obra").
     * Este método debe ser implementado por las subclases.
     *
     * @return una cadena que indica el tipo de estimación.
     */
    public abstract String getTipo();

    /**
     * Devuelve la descripción del elemento de estimación.
     *
     * @return la descripción como una cadena.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Devuelve el costo del elemento de estimación.
     *
     * @return el costo como un valor {@code double}.
     */
    public double getCosto() {
        return costo;
    }
}