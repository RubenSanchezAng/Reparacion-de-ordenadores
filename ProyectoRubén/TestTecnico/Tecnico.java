public class Tecnico{
    private String descripcionProblema;
    private String equipoAfectado;
    private String diagnostico;
    private String estadoReparac;
    private String disponible;
    private String asignarMateriales;
    private String reporte;
    private String tipoRep;
    
    Tecnico(){
        descripcionProblema="";
        equipoAfectado="";
        diagnostico="";
        estadoReparac="";
        disponible="";
        asignarMateriales="";
        reporte="";
        tipoRep="";
    }
    Tecnico(String desc, String equipo, String diag, String estado, String dispon, String asignar, String report, String reparacion){
        descripcionProblema= desc;
        equipoAfectado= equipo;
        diagnostico= diag;
        estadoReparac= estado;
        disponible=dispon;
        asignarMateriales= asignar;
        reporte= report;
        tipoRep= reparacion;
    }
    Tecnico(Tecnico t1){
        this.descripcionProblema= t1.descripcionProblema;
        equipoAfectado= t1.equipoAfectado;
        diagnostico= t1.diagnostico;
        estadoReparac= t1.estadoReparac;
        disponible= t1.disponible;
        asignarMateriales= t1.asignarMateriales;
        reporte= t1.reporte;
        tipoRep= t1.tipoRep;
    }
    

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
       public void setEstadoReparación(String estado){
        estadoReparac = estado;
       }
      public String disponible(boolean disponibilidad){
        if(disponibilidad==true){
            disponible="El técnico esta disponible";
        }else if(disponibilidad== false){
                disponible="El técnico no esta disponible";
            }else
                disponible="Se ha equivocado";
            
            return disponible;
      }
      
       public void setAsignarMateriales(String material){
        asignarMateriales = material;
       }
       public String getAsignado(){
        return "Los materiales asignados para la reparación son los siguientes: "+asignarMateriales;
       }
       public void setReporte(String reporte){
        this.reporte = reporte;
     }
     public void setTipodeReparac(String reparacion){
        tipoRep = reparacion;
     }
     public String getReportes(){
        return "El reporte del cliente es el siguiente "+reporte+ ", además el tipo de reparación necesario es el siguiente: "+tipoRep;
        }
}