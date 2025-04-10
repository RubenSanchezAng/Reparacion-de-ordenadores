package EntregaProyecto;

public class GestionMateriales {
    public static void main(String[] args) {
        Inventario inventario = new Inventario(5);
        
        inventario.registrarMaterial(new Material("Cable HDMI", 20, 5.99));
        inventario.registrarMaterial(new Repuesto("Disco Duro SSD", 10, 45.50, "Almacenamiento"));
        inventario.registrarMaterial(new Repuesto("Memoria RAM 8GB", 15, 30.00, "Memoria"));
        
        inventario.mostrarInventario();
        
       
    }
}