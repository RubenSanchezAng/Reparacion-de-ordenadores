package EntregaProyecto;

import java.util.ArrayList;

public class Inventario {
    private ArrayList <Material> materiales;
    
    
    public Inventario(int maxReparaciones) {
        materiales = new ArrayList<>();
        
    }

    public void registrarMaterial(Material material) {
        materiales.add(material);
    }

    public void mostrarInventario() {
        for (Material m : materiales) {
            m.mostrarInfo();
        }
    }

    

    
            

    
}
