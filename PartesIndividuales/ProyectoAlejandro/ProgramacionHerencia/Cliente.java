public class Cliente extends Usuario{
    private String ultimaReparacion;


    //3 constructores
    public Cliente(){
        super();
        this.ultimaReparacion = "No hay reparaciones registradas";
    }

    public Cliente(String nombre, String direccion, String contacto, String tipoCliente, String ultimaReparacion){
        super(nombre, direccion, contacto, tipoCliente);
        this.ultimaReparacion = ultimaReparacion;
    }

    public Cliente(Cliente c1){
        super(c1);
        this.ultimaReparacion = c1.ultimaReparacion;
    }

    //Establezco y devuelvo la última reparación
    public void setUltimaReparacion(String ultimaReparacion) {
        this.ultimaReparacion = ultimaReparacion;
    }
    public String getUltimaReparacion() {
        return ultimaReparacion;
    }

    //Uso el toString de la clase Usuario y le añado la información de última reparación
    public String toString() {
        return super.toString() + " y su última reparación ha sido " + ultimaReparacion;
    }
}
