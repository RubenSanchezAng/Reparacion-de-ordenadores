/**
 * La clase  representa un tipo de estimación que corresponde a materiales.
 * Hereda de la clase Estimacion y agrega la especificación del tipo como "Material".
 * 
 * <p>Esta clase se puede utilizar para modelar elementos de costo que corresponden
 * a materiales dentro de un sistema de presupuestación o estimación de proyectos.</p>
 * 
 * @author Ruben Sanchez
 * @version 1.0
 */
public class Material extends Estimacion {

    /**
     * Crea una  instancia  con una descripción y un costo.
     *
     * @param descripcion una breve descripción del material.
     * @param costo el costo asociado al material.
     */
    public Material(String descripcion, double costo) {
        super(descripcion, costo);
    }

    /**
     * Devuelve el tipo de estimación, en este caso siempre "Material".
     *
     * @return una cadena que indica que el tipo es "Material".
     */
    @Override
    public String getTipo() {
        return "Material";
    }
}