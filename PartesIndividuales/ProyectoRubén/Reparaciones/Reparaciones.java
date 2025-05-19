public class Reparaciones{
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

   
   Reparaciones(){
    descripcionProblema = "";
    equipoAfectado = "";
    diagnostico = "";
    estadoReparac = "";
    asignarReparadores="";
    asignarMateriales= "";
    costeObra=0;
    materiales=0;
    tiempo=0;
    reporte="";
    tipoRep="";
    frecuencia=0;
   }

//Punto 1
   public void setDescripcion(String descPro){
    descripcionProblema = descPro;
   }
   public void setEquipoAfectado(String eqAfec){
    equipoAfectado = eqAfec;
   }
   public void setDiagnostico(String diagn){
    diagnostico = diagn;
   }
   public String getDatosReparacion(){
    return "El problema de "+equipoAfectado+ " es el siguiente : "+ descripcionProblema+ ", tanbién sabemos su diagnóstico que es el siguiente "+ diagnostico;
   }
//Punto 2
   public void setAsignarReparadores(String reparador){
    asignarReparadores = reparador;
   }
   public void setAsignarMateriales(String material){
    asignarMateriales = material;
   }
   public String getAsignado(){
    return "Los materiales asignados para la reparación son los siguientes: "+asignarMateriales+ "\n Los reparadores asignados para realizar esta reparación son los siguientes "+asignarReparadores;
   }
//Punto 3
   public void setEstadoReparación(String estado){
    estadoReparac = estado;
   }

   public String getEstadoReparación(){
    return "El estado de tu reparación es el siguiente "+ estadoReparac;
   }
//Punto 4
public void setCosteObra(double coste){
  if(coste < 0){
   costeObra=0;
  }
   costeObra = coste;
}
public void setMateriales ( double materiales){
   if(materiales < 0){
      this.materiales=0;
     }
   this.materiales = materiales;
}
public void setTiempo(double tiempo){
   if(tiempo < 0){
      this.tiempo=0;
     }
   this.tiempo = tiempo;
}
public String getEstimacion(){
   return "El coste de obra de la reparación es la siguiente "+costeObra + " euros, los costes para materiales son "+materiales+ " y el tiempo necesario estimado es el siguiente "+tiempo+ " dias";
}
//Punto 5

public void setReporte(String reporte){
   this.reporte = reporte;
}
public void setTipodeReparac(String reparacion){
   tipoRep = reparacion;
}
public void setFrecuencia(double frecuencia){
   if(frecuencia < 0){
      this.frecuencia=0;
   }
   this.frecuencia = frecuencia;
}
public String getReportes(){
return "El reporte del cliente es el siguiente "+reporte+ ", además el tipo de reparación necesario es el siguiente: "+tipoRep+", por último sabemos que la frecuencia es de "+frecuencia + " dias";
}
}