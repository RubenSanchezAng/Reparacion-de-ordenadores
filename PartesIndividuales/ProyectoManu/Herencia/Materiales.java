public class Materiales {
    
    protected String nombre;   
    protected String cod;   
    protected int cantidad;
    

    public Materiales (String nombre, String cod, int cantidad){
        this.nombre = nombre;
        this.cod = cod;
        this.cantidad = cantidad;
       

    }
    public void setNombre(String nombre){
        this.nombre = nombre;

    }
    public void setCod(String cod){
        this.cod = cod;

    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    

    public String getNombre(){
        return nombre;
    }
    public String getCod(){
        return cod;
    }
    public int getCantidad(){
        return cantidad;    
    }
    
    

    public void mostrarInformacion() {
        
        System.out.println("El codigo del material es: "+ getCod()+ "El nombre del material es: "+ getNombre()+ " y la cantidad es: "+getCantidad());
    }
}