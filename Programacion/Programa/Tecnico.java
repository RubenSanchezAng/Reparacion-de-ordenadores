/**
 * @author Irma
 */
public class Tecnico extends Empleado {
    public Tecnico(String nombre, int horasTrabajadas) {
        super(nombre, horasTrabajadas);
    }

    @Override
    public String generarInforme() {
        return "Técnico: " + nombre + " - Horas: " + horasTrabajadas;
    }
}
