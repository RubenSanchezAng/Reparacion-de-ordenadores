package EntregaProyecto;

public class Repuesto extends Material {
    private String tipo;

    public Repuesto(String nombre, int cantidad, double precio, String tipo) {
        super(nombre, cantidad, precio);
        this.tipo = tipo;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Repuesto: " + nombre + " | Tipo: " + tipo + " | Cantidad: " + cantidad + " | Precio: " + precio);
    }
}
