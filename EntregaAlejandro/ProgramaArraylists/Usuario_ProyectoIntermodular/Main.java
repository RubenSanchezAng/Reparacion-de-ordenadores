import java.util.*;
public class Main {
    public static void main(String[] args) {

        ArrayList<Cliente> arrayCliente = new ArrayList<>();
        ArrayList<Institucion> arrayInstitucion = new ArrayList<>();


        Scanner teclado = new Scanner(System.in);
        Usuario persona1 = new Usuario();  // 🔹 Creas un objeto Usuario para almacenar los datos

        //Le pregunto al usuario para que ponga sus datos para registrar su información
        System.out.println("Vamos hacer el registro de cliente, dime en este orden tu: Nombre, Dirección, Contacto, Tipo cliente(particular o institucional)");

        //Le pregunto el nombre
        String nombre = teclado.nextLine();
        persona1.setNombre(nombre);

        //Le pregunto la dirección
        String direccion = teclado.nextLine();
        persona1.setDireccion(direccion);

        //Compruebo que el contacto tenga 9 dígitos pudiendo poner espacios
        String contacto;
        do {
            System.out.println("El contacto debe tener 9 números y no debe contener letras.");
            contacto = teclado.nextLine();
        } while (contacto.length() != 9);
        persona1.setContacto(contacto);

        //Compruebo si el tipo de cliente está bien puesto entre las 2 opciones posibles
        String tipoCliente = "";
        do {
            tipoCliente = teclado.nextLine();
            if (!tipoCliente.toLowerCase().equals("particular") && !tipoCliente.toLowerCase().equals("institucional")) {
                System.out.println("El tipo de cliente debe ser o particular o institucional, no hay más opciones");
            }
        } while (!tipoCliente.toLowerCase().equals("particular") && !tipoCliente.toLowerCase().equals("institucional"));
        persona1.setTipoCliente(tipoCliente);

        if (tipoCliente.equals("particular")) {
            System.out.println("Ingresa la última reparación realizada (o escribe 'ninguna' si es un nuevo cliente):");
            String ultimaReparacion = teclado.nextLine();

            Cliente cliente = new Cliente(persona1.getNombre(), persona1.getDireccion(), persona1.getContacto(), persona1.getTipoCliente(), ultimaReparacion);
            arrayCliente.add(cliente);

        } else {
            System.out.println("Ingresa el sector de la institución:");
            String sector = teclado.nextLine();

            Institucion cliente = new Institucion(persona1.getNombre(), persona1.getDireccion(), persona1.getContacto(), persona1.getTipoCliente(), sector);
            arrayInstitucion.add(cliente);
        }


        System.out.println(persona1.toString());

        teclado.close();
    }
}
