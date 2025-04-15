import java.util.ArrayList;

/**
 * <h1>Clase Almacen</h1>
 * <p>Representa un almacén donde se guardan materiales.
 * Contiene información sobre capacidad y materiales almacenados.</p>
 */
public class Almacen {
    private static int contadorId = 0; 
    private int id;
    private String nombre;
    private String direccion;
    private int capacidad;
    ArrayList<Materiales> materiales;

    /**
     * <h2>Constructor completo</h2>
     * <p>Crea una instancia de Almacén con todos sus atributos</p>
     * 
     * @param nombre <code>String</code> - Nombre del almacén
     * @param direccion <code>String</code> - Dirección física
     * @param capacidad <code>int</code> - Capacidad máxima
     * @param materiales <code>ArrayList&lt;Materiales&gt;</code> - Lista de materiales almacenados
     */
    public Almacen(String nombre, String direccion, int capacidad, ArrayList<Materiales> materiales) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.materiales = materiales;
    }

    /**
     * <h2>Constructor vacío</h2>
     * <p>Crea una instancia de Almacén sin inicializar atributos</p>
     */
    public Almacen() {
        materiales = null;
    }

    /**
     * <h2>Obtiene ID</h2>
     * <p>Devuelve el identificador único del almacén</p>
     * 
     * @return <code>int</code> - ID del almacén
     */
    public int getId() {
        return id;
    }

    /**
     * <h2>Obtiene nombre</h2>
     * <p>Devuelve el nombre del almacén</p>
     * 
     * @return <code>String</code> - Nombre actual
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <h2>Establece nombre</h2>
     * <p>Actualiza el nombre del almacén</p>
     * 
     * @param nombre <code>String</code> - Nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * <h2>Obtiene dirección</h2>
     * <p>Devuelve la dirección del almacén</p>
     * 
     * @return <code>String</code> - Dirección actual
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * <h2>Establece dirección</h2>
     * <p>Actualiza la dirección del almacén</p>
     * 
     * @param direccion <code>String</code> - Nueva dirección
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * <h2>Obtiene capacidad</h2>
     * <p>Devuelve la capacidad máxima del almacén</p>
     * 
     * @return <code>int</code> - Capacidad actual
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * <h2>Establece capacidad</h2>
     * <p>Actualiza la capacidad máxima del almacén</p>
     * 
     * @param capacidad <code>int</code> - Nueva capacidad
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * <h2>Añadir material</h2>
     * <p>Agrega un material a la lista de materiales del almacén</p>
     * 
     * @param material <code>Materiales</code> - Material a añadir
     */
    public void anyadirMaterial(Materiales material) {
        materiales.add(material);
    }

    /**
     * <h2>Representación en String</h2>
     * <p>Devuelve una representación básica del almacén</p>
     * 
     * @return <code>String</code> - Información del almacén
     */
    @Override
    public String toString() {
        return "Almacen{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}