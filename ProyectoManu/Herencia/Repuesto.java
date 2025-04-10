public class Repuesto extends Materiales {

    protected double precio;

    public Repuesto(String nombre, String codigo, int cantidad, double precio) {
        
        super(nombre, codigo, cantidad);
        this.precio = precio;
    }
    public double getPrecio() {
        return precio;
    }

    
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Precio: " + precio);


}
}