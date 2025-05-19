/**
 * <h1>Clase Materiales</h1>
 * <p>Representa los materiales gestionados en el sistema de almacén.
 * Contiene información sobre stock, umbrales, proveedores y almacenes asociados.</p>
 * 
 * @author Manu
 * @author Irma
 * @author Alejandro
 * @author Lucas
 * @version 0.5
 * @since 2025/04/15
 */
public class Materiales {
     
    /**
     * <h2>Enumeración Color</h2>
     * <p>Representa los diferentes niveles de stock</p>
     * <ul>
     *   <li>verde - Stock óptimo</li>
     *   <li>amarillo - Stock bajo (advertencia)</li>
     *   <li>rojo - Stock crítico</li>
     * </ul>
     */
    public enum Color {verde, amarillo, rojo};
    
    private Color stock;
    private String nombre, descripcion;
    private Integer tipo_reparacion, cantidad, stockverde, stockrojo, stockamarillo;
    private Proveedor proveedor;
    private Almacen almacen;

    /**
     * <h2>Constructor completo</h2>
     * <p>Crea una instancia de Materiales con todos sus atributos</p>
     * 
     * @param nombre <code>String</code> - Nombre del material
     * @param descripcion <code>String</code> - Descripción detallada
     * @param cantidad <code>Integer</code> - Cantidad actual en stock
     * @param tipo_reparacion <code>int</code> - Tipo de reparación asociada
     * @param stockverde <code>Integer</code> - Umbral para stock óptimo
     * @param stockrojo <code>Integer</code> - Umbral para stock crítico
     * @param stockamarillo <code>Integer</code> - Umbral para stock de advertencia
     * @param proveedor <code>Proveedor</code> - Proveedor asociado
     * @param almacen <code>Almacen</code> - Almacén donde se guarda
     */
    public Materiales(String nombre, String descripcion, Integer cantidad, int tipo_reparacion, 
                     Integer stockverde, Integer stockrojo, Integer stockamarillo, 
                     Proveedor proveedor, Almacen almacen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.tipo_reparacion = tipo_reparacion;
        this.stockverde = stockverde;
        this.stockrojo = stockrojo;
        this.stockamarillo = stockamarillo;
        this.proveedor = proveedor;
        this.almacen = almacen;
        
        if (cantidad >= stockverde) {
            stock = Color.verde;
        } else if (cantidad <= stockamarillo && cantidad > stockrojo) {
            stock = Color.amarillo;
        } else {
            stock = Color.rojo;
        }
    }

    /**
     * <h2>Constructor vacío</h2>
     * <p>Crea una instancia de Materiales sin inicializar atributos</p>
     */
    public Materiales() {
        descripcion = null;
        stock = null;
        stockverde = null;
        stockamarillo = null;
        stockrojo = null;
        proveedor = null;
        almacen = null;
    }

    /**
     * <h2>Establece la cantidad</h2>
     * <p>Actualiza la cantidad actual del material en stock</p>
     * 
     * @param cantidad <code>Integer</code> - Nueva cantidad del material
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * <h2>Obtiene la cantidad</h2>
     * <p>Devuelve la cantidad actual del material en stock</p>
     * 
     * @return <code>Integer</code> - Cantidad actual del material
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * <h2>Establece la descripción</h2>
     * <p>Actualiza la descripción del material</p>
     * 
     * @param descripcion <code>String</code> - Nueva descripción
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * <h2>Obtiene la descripción</h2>
     * <p>Devuelve la descripción del material</p>
     * 
     * @return <code>String</code> - Descripción del material
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * <h2>Establece el almacén</h2>
     * <p>Asigna un almacén al material</p>
     * 
     * @param almacen <code>Almacen</code> - Almacén asociado
     */
    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    /**
     * <h2>Obtiene el almacén</h2>
     * <p>Devuelve el almacén asociado al material</p>
     * 
     * @return <code>Almacen</code> - Almacén donde se guarda
     */
    public Almacen getAlmacen() {
        return almacen;
    }

    /**
     * <h2>Establece el nombre</h2>
     * <p>Actualiza el nombre del material</p>
     * 
     * @param nombre <code>String</code> - Nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * <h2>Obtiene el nombre</h2>
     * <p>Devuelve el nombre del material</p>
     * 
     * @return <code>String</code> - Nombre del material
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <h2>Establece umbral amarillo</h2>
     * <p>Actualiza el umbral para nivel de stock amarillo</p>
     * 
     * @param stockamarillo <code>Integer</code> - Nuevo umbral
     */
    public void setStockamarillo(Integer stockamarillo) {
        this.stockamarillo = stockamarillo;
    }

    /**
     * <h2>Obtiene umbral amarillo</h2>
     * <p>Devuelve el umbral para nivel de stock amarillo</p>
     * 
     * @return <code>Integer</code> - Umbral amarillo
     */
    public Integer getStockamarillo() {
        return stockamarillo;
    }

    /**
     * <h2>Establece umbral rojo</h2>
     * <p>Actualiza el umbral para nivel de stock rojo</p>
     * 
     * @param stockrojo <code>Integer</code> - Nuevo umbral
     */
    public void setStockrojo(Integer stockrojo) {
        this.stockrojo = stockrojo;
    }

    /**
     * <h2>Obtiene umbral rojo</h2>
     * <p>Devuelve el umbral para nivel de stock rojo</p>
     * 
     * @return <code>Integer</code> - Umbral rojo
     */
    public Integer getStockrojo() {
        return stockrojo;
    }

    /**
     * <h2>Establece umbral verde</h2>
     * <p>Actualiza el umbral para nivel de stock verde</p>
     * 
     * @param stockverde <code>Integer</code> - Nuevo umbral
     */
    public void setStockverde(Integer stockverde) {
        this.stockverde = stockverde;
    }

    /**
     * <h2>Obtiene umbral verde</h2>
     * <p>Devuelve el umbral para nivel de stock verde</p>
     * 
     * @return <code>Integer</code> - Umbral verde
     */
    public Integer getStockverde() {
        return stockverde;
    }

    /**
     * <h2>Obtiene nivel de stock</h2>
     * <p>Devuelve el nivel actual de stock (verde, amarillo o rojo)</p>
     * 
     * @return <code>Color</code> - Nivel de stock actual
     */
    public Color getStock() {
        return stock;
    }

    /**
     * <h2>Obtiene tipo de reparación</h2>
     * <p>Devuelve el tipo de reparación asociado al material</p>
     * 
     * @return <code>Integer</code> - Tipo de reparación
     */
    public Integer getTipo_reparacion() {
        return tipo_reparacion;
    }

    /**
     * <h2>Establece tipo de reparación</h2>
     * <p>Actualiza el tipo de reparación asociado al material</p>
     * 
     * @param tipo_reparacion <code>Integer</code> - Nuevo tipo
     */
    public void setTipo_reparacion(Integer tipo_reparacion) {
        this.tipo_reparacion = tipo_reparacion;
    }

    /**
     * <h2>Establece proveedor</h2>
     * <p>Asigna un proveedor al material</p>
     * 
     * @param proveedor <code>Proveedor</code> - Proveedor asociado
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * <h2>Obtiene proveedor</h2>
     * <p>Devuelve el proveedor asociado al material</p>
     * 
     * @return <code>Proveedor</code> - Proveedor del material
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * <h2>Representación en String</h2>
     * <p>Devuelve una representación detallada del material</p>
     * 
     * @return <code>String</code> - Información del material
     */
    public String toString() {
        return "Materiales {\n" +
           "  Nombre: " + nombre + "\n" +
           "  Descripción: " + descripcion + "\n" +
           "  Cantidad actual: " + cantidad + "\n" +
           "  Tipo de reparación: " + tipo_reparacion + "\n" +
           "  Stock Verde (umbral): " + stockverde + "\n" +
           "  Stock Amarillo (umbral): " + stockamarillo + "\n" +
           "  Stock Rojo (umbral): " + stockrojo + "\n" +
           "  Nivel de stock actual: " + stock + "\n" +
           "  Proveedor: " + (proveedor != null ? proveedor.toString() : "Ninguno") + "\n" +
           "}";
    }
}