/**
 * La clase {@code ManoObra} representa un tipo de estimación correspondiente a mano de obra.
 * Hereda de la clase {@code Estimacion} y especifica el tipo como "Mano de Obra".
 *
 * <p>Se puede utilizar para modelar los costos relacionados con el trabajo humano
 * dentro de un sistema de estimaciones o presupuestos de proyectos.</p>
 * 
 * @author Ruben Sanchez
 * @version 1.0
 */
public class ManoObra extends Estimacion {

    /**
     * Crea una instancia con una descripción y un costo.
     *
     * @param descripcion una breve descripción del trabajo o servicio prestado.
     * @param costo el costo asociado a la mano de obra.
     */
    public ManoObra(String descripcion, double costo) {
        super(descripcion, costo);
    }

    /**
     * Devuelve el tipo de estimación, en este caso "Mano de Obra".
     *
     * @return una cadena que indica que el tipo es "Mano de Obra".
     */
    @Override
    public String getTipo() {
        return "Mano de Obra";
    }
}