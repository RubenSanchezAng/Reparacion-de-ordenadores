import java.util.*;

public class Test{
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\nMenú: \n0. Salir \n1. Añadir Cliente \n2. Añadir Equipo a Cliente \n3. Ver Clientes \n4. Ver Equipos");
            opcion = tec.nextInt();
            tec.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Nombre del cliente: ");
                    String nombre = tec.nextLine();
                    System.out.println("Contacto del cliente: ");
                    String contacto = tec.nextLine();

                    Cliente nuevoCliente = new Cliente(nombre, contacto);
                    clientes.add(nuevoCliente);
                    break;
                case 2:
                if (clientes.isEmpty()) {
                    System.out.println("Primero debes añadir un cliente.");
                    break;
                }
                System.out.println("Selecciona un cliente para añadir el equipo:");
                int contador = 1;
                for (Cliente cliente : clientes) {
                    System.out.println(contador + ". " + cliente.getNombre());
                    contador++;
                }

                System.out.print("Número del cliente: ");
                int seleccion = tec.nextInt();
                tec.nextLine();

                if (seleccion > 0 && seleccion <= clientes.size()) {
                    Cliente clienteSeleccionado = clientes.get(seleccion - 1);
                    System.out.println("Introduce los datos del equipo:");
                    System.out.println("Tipo de equipo: ");
                    String tipo = tec.nextLine();
                    System.out.println("Modelo: ");
                    String modelo = tec.nextLine();
                    System.out.println("Marca: ");
                    String marca = tec.nextLine();
                    System.out.println("Estado: ");
                    String estado = tec.nextLine();

                    Equipo nuevoEquipo = new Equipo(tipo, modelo, marca, estado);
                    clienteSeleccionado.agregarEquipo(nuevoEquipo);
                    System.out.println("Equipo añadido al cliente.");
                }
                break;
                case 3:
                if (clientes.isEmpty()) {
                    System.out.println("No hay clientes registrados.");
                } else {
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println(clientes.get(i));
                    }
                }
                break;
                case 4:
                    boolean hayEquipos = false;
                    for (Cliente cliente : clientes) {
                        for (Equipo equipo : cliente.getEquipos()) {
                            System.out.println(equipo + " (Propietario: " + cliente.getNombre() + ")");
                            hayEquipos = true;
                        }
                    }
                    if (!hayEquipos) {
                        System.out.println("No hay equipos registrados.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }

   
}
