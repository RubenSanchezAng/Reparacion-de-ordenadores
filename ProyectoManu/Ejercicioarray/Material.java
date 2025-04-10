package EntregaProyecto;

public class Material {
    protected String nombre;
    protected int cantidad;
    protected double precio;

    public Material(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void agregarStock(int cantidad) {
        this.cantidad += cantidad;
    }

    public boolean reducirStock(int cantidad) {
       boolean res=false;
        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
            res= true;
        } else {
            System.out.println("Stock insuficiente para " + nombre);
            res = false;
        }
        return res;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void mostrarInfo() {
        System.out.println("Material: " + nombre + " | Cantidad: " + cantidad + " | Precio: " + precio);
    }
}