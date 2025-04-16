/**
 * @author Rubén Sánchez
 * @version 1.1
 * @date 14-04-2025
 * En este programa se registran las reparaciones de los equipos.
 * 
 */

public class Reparaciones{

   //Atributos:
   /**
    * <ul>
    * <li>descripcionProblema : Guarda la descripcion del problema de la reparacion</li> 
    *  <li>equipoAfectado : Guarda el equipo que se esta haciendo la reparacion</li> 
    * <li>diagnostico :Descripcion del problema del equipo</li> 
    * <li>estadoReparac : Guarda el estado de la reparacion</li> 
    * <li>asignarReparadores : Asigna técnicos a la reparacion</li> 
    * <li>asignarMateriales : Asigna los materiales necesarios para la reparacion</li> 
    * <li>materiales : Guarda los materiales usados en la reparacion</li> 
    * <li>tiempo : Guarda el tiempo de la reparacion</li> 
    * <li>reporte : Guarda el reporte de la reparacion</li> 
    * <li>tipoRep : Guarda el tipo de la reparacion</li> 
    * <li>frecuencia : Guarda la frecuencia de la reparacion</li> 
    *</ul>
    */
   private String descripcionProblema;
   private String equipoAfectado;
   private String diagnostico;
   private String estadoReparac;
   private String asignarReparadores;
   private String asignarMateriales;
   private double costeObra;
   private double materiales;
   private double tiempo;
   private String reporte;
   private String tipoRep;
   private double frecuencia;

   
   public Reparaciones(String descripcionProblema, String equipoAfectado, String diagnostico,  String asignarReparadores, String asignarMateriales, double costeObra, double materiales, int tiempo) {
        this.descripcionProblema = descripcionProblema;
        this.equipoAfectado = equipoAfectado;
        this.diagnostico = diagnostico;
        this.asignarReparadores = asignarReparadores;
        this.asignarMateriales = asignarMateriales;
        this.costeObra = costeObra;
        this.materiales = materiales;
        this.tiempo = tiempo;
        
    }

/**
 * Establece la descripción del problema.
 * @param descPro Descripción del problema.
 */
public void setDescripcion(String descPro){
   descripcionProblema = descPro;
}

/**
* Establece el equipo afectado.
* @param eqAfec Nombre del equipo afectado.
*/
public void setEquipoAfectado(String eqAfec){
   equipoAfectado = eqAfec;
}

/**
* Establece el diagnóstico.
* @param diagn Diagnóstico del problema.
*/
public void setDiagnostico(String diagn){
   diagnostico = diagn;
}

/**
* Devuelve un resumen del problema, el equipo afectado y el diagnóstico.
* @return Cadena de texto con los datos de la reparación.
*/
public String getDatosReparacion(){
   return "El problema de " + equipoAfectado + " es el siguiente : " + descripcionProblema +
          ", tanbién sabemos su diagnóstico que es el siguiente " + diagnostico;
}

// Punto 2

/**
* Asigna los reparadores a la reparación.
* @param reparador Nombre del trabajador.
*/
public void setAsignarReparadores(String reparador){
   asignarReparadores = reparador;
}

/**
* Asigna los materiales necesarios para la reparación.
* @param material Material asignado.
*/
public void setAsignarMateriales(String material){
   asignarMateriales = material;
}

/**
* Devuelve los materiales y reparadores asignados.
* @return Cadena de texto con los datos de asignación.
*/
public String getAsignado(){
   return "Los materiales asignados para la reparación son los siguientes: " + asignarMateriales +
          "\n Los reparadores asignados para realizar esta reparación son los siguientes " + asignarReparadores;
}

// Punto 3

/**
* Establece el estado actual de la reparación.
* @param estado Estado de la reparación.
*/
public void setEstadoReparación(String estado){
   estadoReparac = estado;
}

/**
* Devuelve el estado actual de la reparación.
* @return Cadena de texto con el estado de la reparación.
*/
public String getEstadoReparación(){
   return "El estado de tu reparación es el siguiente " + estadoReparac;
}

// Punto 4

/**
* Establece el coste de la obra. Si el valor es negativo, se asigna 0.
* @param coste Coste de la obra.
*/
public void setCosteObra(double coste){
   if (coste < 0) {
       costeObra = 0;
   }
   costeObra = coste;
}

/**
* Establece el coste de los materiales. Si el valor es negativo, se asigna 0.
* @param materiales Coste de los materiales.
*/
public void setMateriales(double materiales){
   if (materiales < 0) {
       this.materiales = 0;
   }
   this.materiales = materiales;
}

/**
* Establece el tiempo estimado para la reparación. Si el valor es negativo, se asigna 0.
* @param tiempo Tiempo estimado en días.
*/
public void setTiempo(double tiempo){
   if (tiempo < 0) {
       this.tiempo = 0;
   }
   this.tiempo = tiempo;
}

/**
* Devuelve una estimación de coste de obra, materiales y tiempo.
* @return Cadena de texto con la estimación de la reparación.
*/
public String getEstimacion(){
   return "El coste de obra de la reparación es la siguiente " + costeObra +
          " euros, los costes para materiales son " + materiales +
          " y el tiempo necesario estimado es el siguiente " + tiempo + " dias";
}

// Punto 5

/**
* Establece el reporte del cliente.
* @param reporte Texto del reporte del cliente.
*/
public void setReporte(String reporte){
   this.reporte = reporte;
}

/**
* Establece el tipo de reparación requerida.
* @param reparacion Tipo de reparación.
*/
public void setTipodeReparac(String reparacion){
   tipoRep = reparacion;
}

/**
* Establece la frecuencia de ocurrencia del problema. Si el valor es negativo, se asigna 0.
* @param frecuencia Frecuencia en días.
*/
public void setFrecuencia(double frecuencia){
   if (frecuencia < 0) {
       this.frecuencia = 0;
   }
   this.frecuencia = frecuencia;
}

/**
* Devuelve el reporte del cliente, el tipo de reparación y la frecuencia.
* @return Cadena de texto con los datos del reporte.
*/
public String getReportes(){
   return "El reporte del cliente es el siguiente " + reporte +
          ", además el tipo de reparación necesario es el siguiente: " + tipoRep +
          ", por último sabemos que la frecuencia es de " + frecuencia + " dias";
}
}
