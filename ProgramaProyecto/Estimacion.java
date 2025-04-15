public abstract class Estimacion {
    protected String descripcion;
    protected double costo;

    public Estimacion(String descripcion, double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public abstract String getTipo();

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }
}
