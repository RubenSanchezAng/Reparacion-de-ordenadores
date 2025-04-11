import java.util.*;
public class Usuario_Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        Usuario p1 = new Usuario();

        //Le pregunto al usuario para que ponga sus datos para registrar su información
        System.out.println("Vamos hacer el registro de cliente, dime en este orden tu: Nombre, Dirección, Contacto, Tipo cliente(particular o constitucional)");
        String nombre = teclado.nextLine();
        p1.setNombre(nombre);
        String direccion = teclado.nextLine();
        p1.setDireccion(direccion);

        //Compruebo que el contacto tenga 9 dígitos pudiendo poner espacios
        String contactoString;
        do {
            contactoString = teclado.nextLine().replace(" ", ""); // Elimina todos los espacios que contiene el contacto
            if (contactoString.length() != 9 || !contactoString.matches("\\d+")) { //El método matches verifica que la expresion \\d contenga en el String números y no letras
                System.out.println("El contacto debe tener 9 números y no debe contener letras.");
            }
        } while (contactoString.length() != 9 || !contactoString.matches("\\d+")); 
        int contacto = Integer.parseInt(contactoString); // Método parseInt convierte un String a un int para así meter el valor de contactoString a contacto
        p1.setContacto(contacto);

        //Compruebo si el tipo de cliente está bien puesto entre las 2 opciones posibles
        String tipo_cliente = " ";
        do{
        tipo_cliente = teclado.nextLine();
        if (!tipo_cliente.toLowerCase().equals("particular") && !tipo_cliente.toLowerCase().equals("constitucional")){
            System.out.println("El tipo de cliente debe ser o particular o constitucional, no hay más opciones");
        }
        } while (!tipo_cliente.toLowerCase().equals("particular") && !tipo_cliente.toLowerCase().equals("constitucional"));
        p1.setTipo_Cliente(tipo_cliente);
        
        System.out.println(p1.toString());


        teclado.close();
    }
}
