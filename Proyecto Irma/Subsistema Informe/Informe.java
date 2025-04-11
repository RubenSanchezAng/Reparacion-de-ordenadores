/* Clase Informe que tiene los métodos              *
 * generar() y visualizar() que son heredados       *
 * por la clase InformeFinanciero                   *
 * Subsistema Informes                              *
 * Irma Wendolin Domínguez Morales                  */
 
class Informe {
    protected int id;
    protected String fechaGeneracion;
    protected String tipo;

    public Informe(int id, String fechaGeneracion, String tipo) {
        this.id = id;
        this.fechaGeneracion = fechaGeneracion;
        this.tipo = tipo;
    }

    public void generar() {
        System.out.println("Generando informe: " + tipo);
    }

    public void visualizar() {
        System.out.println("Visualizando informe " + id + " generado el " + fechaGeneracion);
    }
}



