public class Main {
    public static void main(String[] args) {
       
        Materiales tornillo = new Materiales("Tornillo", "M001", 100);
        Repuesto placaBase = new Repuesto("Placa Base", "M002", 20, 120.0);

        
        System.out.println("Información de los materiales:");
        tornillo.mostrarInformacion();
        placaBase.mostrarInformacion();

        
        System.out.println("\nActualizando stock...");
        tornillo.setCantidad(120); 
        placaBase.setCantidad(25);  

        
        System.out.println("\nInformación después de actualizar el stock:");
        tornillo.mostrarInformacion();
        placaBase.mostrarInformacion();

        Repuesto memoriaRam = new Repuesto("Memoria RAM", "M003", 50, 80.0);

        
        System.out.println("\nNuevo repuesto añadido:");
        memoriaRam.mostrarInformacion();
    }
}
