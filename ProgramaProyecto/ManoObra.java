public class ManoObra extends Estimacion {
    public ManoObra(String descripcion, double costo) {
        super(descripcion, costo);
    }

    @Override
    public String getTipo() {
        return "Mano de Obra";
    }
}