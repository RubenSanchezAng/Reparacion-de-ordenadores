import java.util.Scanner;

public class Menumaterial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Materiales material = new Materiales();  

        
        System.out.println("\n===== Menú de Gestión de Materiales =====");
        System.out.println("1. Crear Material");
        System.out.println("2. Ver información del material");
        System.out.println("3. Cambiar nombre del material");
        System.out.println("4. Cambiar descripción del material");
        System.out.println("5. Cambiar cantidad del material");
        System.out.println("6. Cambiar precio unitario del material");
        System.out.println("7. Agregar material al inventario");
        System.out.println("8. Quitar material del inventario");
        System.out.println("9. Verificar bajo stock");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
        while (opcion !=0) {
            
            

            switch (opcion) {
                
                case 1:
                    // Crear un nuevo material
                    System.out.println("Ingrese los detalles del nuevo material:");
                    System.out.print("Nombre del material: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Descripción del material: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Cantidad del material: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("Precio unitario del material: ");
                    double precio = scanner.nextDouble();
                    material = new Materiales();  
                    material.setNombre(nombre);
                    material.setDescripcion(descripcion);
                    material.setCantidad(cantidad);
                    material.setPrecioUnitario(precio);
                    System.out.println("Nuevo material creado.");
                    break;

                case 2:
                    
                    System.out.println(material.toString());
                    break;

                case 3:
                    System.out.print("Ingrese el nuevo nombre del material: ");
                    String nuevoNombre = scanner.nextLine();
                    material.setNombre(nuevoNombre);
                    System.out.println("Nombre del material actualizado.");
                    break;

                case 4:
                    System.out.print("Ingrese la nueva descripción del material: ");
                    String nuevaDescripcion = scanner.nextLine();
                    material.setDescripcion(nuevaDescripcion);
                    System.out.println("Descripción del material actualizada.");
                    break;

                case 5:
                    System.out.print("Ingrese la nueva cantidad del material: ");
                    int nuevaCantidad = scanner.nextInt();
                    material.setCantidad(nuevaCantidad);
                    System.out.println("Cantidad del material actualizada.");
                    break;

                case 6:
                    System.out.print("Ingrese el nuevo precio unitario del material: ");
                    double nuevoPrecio = scanner.nextDouble();
                    material.setPrecioUnitario(nuevoPrecio);
                    System.out.println("Precio unitario del material actualizado.");
                    break;

                case 7:
                    System.out.print("Ingrese la cantidad a agregar: ");
                    int cantidadAgregar = scanner.nextInt();
                    material.agregarCantidad(cantidadAgregar);
                    System.out.println(cantidadAgregar + " unidades agregadas al inventario.");
                    break;

                case 8:
                    System.out.print("Ingrese la cantidad a quitar: ");
                    int cantidadQuitar = scanner.nextInt();
                    material.quitarCantidad(cantidadQuitar);
                    System.out.println(cantidadQuitar + " unidades quitadas del inventario.");
                    break;

                case 9:
                    if (material.verificarBajoStock()) {
                        System.out.println("¡Alerta! El material tiene bajo stock.");
                    } else {
                        System.out.println("Stock suficiente.");
                    }
                    break;

                

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            System.out.println("\n===== Menú de Gestión de Materiales =====");
            System.out.println("1. Crear Material");
            System.out.println("2. Ver información del material");
            System.out.println("3. Cambiar nombre del material");
            System.out.println("4. Cambiar descripción del material");
            System.out.println("5. Cambiar cantidad del material");
            System.out.println("6. Cambiar precio unitario del material");
            System.out.println("7. Agregar material al inventario");
            System.out.println("8. Quitar material del inventario");
            System.out.println("9. Verificar bajo stock");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
             opcion = scanner.nextInt();
            scanner.nextLine(); 
        }
    }
}
