/* Clase InformeFinanciero heredada de la clase Informe  *
 * que calcula la rentabilidad de un informe financiero  *
 * Subsistema Informes                                   *
 * Irma Wendolin Domínguez Morales                       */
 


public class InformeFinanciero extends Informe {
    private double costos;
    private double ingresos;

    public InformeFinanciero(int id, String fechaGeneracion, double costos, double ingresos) {
        super(id, fechaGeneracion, "Financiero");
        this.costos = costos;
        this.ingresos = ingresos;
    }

    public double calcularRentabilidad() {
        return ingresos - costos;
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Costos: " + costos + ", Ingresos: " + ingresos + ", Rentabilidad: " + calcularRentabilidad());
    }
}
