public class Material extends Estimacion {
    public Material(String descripcion, double costo) {
        super(descripcion, costo);
    }

    @Override
    public String getTipo() {
        return "Material";
    }
}