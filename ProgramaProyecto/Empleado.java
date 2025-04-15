
public abstract class Empleado {
    protected String nombre;
    protected int horasTrabajadas;

    public Empleado(String nombre, int horasTrabajadas) {
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract String generarInforme();
}
