/**
 * <h1>Clase Proveedor</h1>
 * <p>Representa a un proveedor de materiales para el almacén.
 * Contiene información sobre los materiales que suministra.</p>
 */
import java.util.ArrayList;
public class Proveedor {
    ArrayList<Materiales> materialesprov = new ArrayList<Materiales>();
    Integer id;
    static Integer cant = 0;
    String nombre, direccion;
    Integer telefono;

    /**
     * <h2>Constructor completo</h2>
     * <p>Crea una instancia de Proveedor con todos sus atributos</p>
     * 
     * @param nombre <code>String</code> - Nombre del proveedor
     * @param direccion <code>String</code> - Dirección del proveedor
     * @param telefono <code>int</code> - Teléfono de contacto
     * @param materialesprov <code>ArrayList&lt;Materiales&gt;</code> - Lista de materiales que provee
     */
    public Proveedor(String nombre, String direccion, int telefono, ArrayList<Materiales> materialesprov) {
        cant++;
        id = cant;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.materialesprov = materialesprov;
    }

    /**
     * <h2>Constructor vacío</h2>
     * <p>Crea una instancia de Proveedor sin inicializar atributos</p>
     */
    public Proveedor() {
        materialesprov = null;
    }

    /**
     * <h2>Establece ID</h2>
     * <p>Asigna un identificador al proveedor</p>
     * 
     * @param id <code>Integer</code> - Nuevo ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <h2>Obtiene ID</h2>
     * <p>Devuelve el identificador del proveedor</p>
     * 
     * @return <code>Integer</code> - ID del proveedor
     */
    public Integer getId() {
        return id;
    }

    /**
     * <h2>Establece dirección</h2>
     * <p>Actualiza la dirección del proveedor</p>
     * 
     * @param direccion <code>String</code> - Nueva dirección
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * <h2>Obtiene dirección</h2>
     * <p>Devuelve la dirección del proveedor</p>
     * 
     * @return <code>String</code> - Dirección actual
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * <h2>Establece nombre</h2>
     * <p>Actualiza el nombre del proveedor</p>
     * 
     * @param nombre <code>String</code> - Nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * <h2>Obtiene nombre</h2>
     * <p>Devuelve el nombre del proveedor</p>
     * 
     * @return <code>String</code> - Nombre actual
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <h2>Añadir material</h2>
     * <p>Agrega un nuevo material a la lista de materiales que provee</p>
     * 
     * @param material <code>Materiales</code> - Material a añadir
     */
    public void anyadirMaterial(Materiales material) {
        materialesprov.add(material);
    }

    /**
     * <h2>Eliminar material</h2>
     * <p>Remueve un material de la lista por su posición</p>
     * 
     * @param posicion <code>int</code> - Índice del material a eliminar
     */
    public void eliminarMaterial(int posicion) {
        materialesprov.remove(posicion);
    }

    /**
     * <h2>Obtiene teléfono</h2>
     * <p>Devuelve el número de teléfono del proveedor</p>
     * 
     * @return <code>Integer</code> - Teléfono actual
     */
    public Integer getTelefono() {
        return telefono;
    }

    /**
     * <h2>Establece teléfono</h2>
     * <p>Actualiza el número de teléfono del proveedor</p>
     * 
     * @param telefono <code>Integer</code> - Nuevo teléfono
     */
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    /**
     * <h2>Buscar proveedor por material</h2>
     * <p>Busca un proveedor por el nombre en una lista de materiales</p>
     * 
     * @param mat <code>ArrayList&lt;Materiales&gt;</code> - Lista de materiales donde buscar
     * @param nombre <code>String</code> - Nombre del proveedor a buscar
     * @return <code>int</code> - Posición del material en la lista o -1 si no se encuentra
     */
    public int buscarProveedorMaterial(ArrayList<Materiales> mat, String nombre) {
        int res = -1;
        for (int i = 0; i < mat.size(); i++) {
            if (mat.get(i).getProveedor().getNombre().equals(nombre)) {
                res = i;
                System.out.println("Proveedor encontrado");
            }
        }
        return res;
    }

    /**
     * <h2>Representación en String</h2>
     * <p>Devuelve una representación detallada del proveedor</p>
     * 
     * @return <code>String</code> - Información del proveedor
     */
    public String toString() {
        String materialesInfo = "";
        if (materialesprov.isEmpty()) {
            materialesInfo = "    Ninguno\n";
        } else {
            for (Materiales m : materialesprov) {
                materialesInfo += "    - " + m.getNombre() + " (Cantidad: " + m.getCantidad() + ")\n";
            }
        }
    
        return "Proveedor {\n" +
               "  ID: " + id + "\n" +
               "  Nombre: " + nombre + "\n" +
               "  Dirección: " + direccion + "\n" +
               "  Teléfono: " + telefono + "\n" +
               "  Materiales que provee:\n" + materialesInfo +
               "}";
    }
}