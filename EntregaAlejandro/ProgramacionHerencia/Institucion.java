public class Institucion extends Usuario{
    private String sector;

    //3 constructores
    public Institucion() {
        super();
        this.sector = "Desconocido";
    }

    public Institucion(String nombre, String direccion, String contacto, String tipoCliente, String sector) {
        super(nombre, direccion, contacto, tipoCliente);
        this.sector = sector;
    }

    public Institucion(Institucion s1){
        super(s1);
        this.sector = s1.sector;
    }

    //Establezco y devuelvo el sector
    public void setSector(String sector) {
        this.sector = sector;
    }
    public String getSector() {
        return sector;
    }

    public String toString() {
        return super.toString() + " y el sector es " + sector;
    }
}
