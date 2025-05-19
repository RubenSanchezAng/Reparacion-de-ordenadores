public class Materiales {
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;

    public Materiales() {
        this.nombre = "";
        this.descripcion = "";
        this.cantidad = 0;
        this.precioUnitario = 0.0;
    }

    public Materiales(String nombre, String descripcion, int cantidad, double precioUnitario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
    public Materiales(Materiales otro) {
        this.nombre = otro.nombre;
        this.descripcion = otro.descripcion;
        this.cantidad = otro.cantidad;
        this.precioUnitario = otro.precioUnitario;
    }

    
    public void agregarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public void quitarCantidad(int cantidad) {
        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
        } else {
            System.out.println("No hay suficiente material en stock.");
        }
    }

    public String toString() {
        return "Nombre: " + this.nombre + "\n" +
               "Descripción: " + this.descripcion + "\n" +
               "Cantidad disponible: " + this.cantidad + "\n" +
               "Precio unitario: $" + this.precioUnitario;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    
    public boolean verificarBajoStock() {
        return this.cantidad < 5;
    }
}
