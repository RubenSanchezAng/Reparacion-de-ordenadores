public class Administrativo extends Empleado {
    public Administrativo(String nombre, int horasTrabajadas) {
        super(nombre, horasTrabajadas);
    }

    @Override
    public String generarInforme() {
        return "Administrativo: " + nombre + " - Horas: " + horasTrabajadas;
    }
}
