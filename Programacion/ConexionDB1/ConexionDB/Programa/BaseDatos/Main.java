public class Main {
    public static void main(String[] args) {
        ClienteDB.insertarCliente(10, "carlos@mail.com", "Juan", "Calle 123");
        ClienteDB.mostrarClientes();
        ClienteDB.buscarClientePorId(1);  
        ClienteDB.borrarClientePorId(10);

    }
}