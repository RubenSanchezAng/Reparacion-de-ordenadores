import java.util.Scanner;

public class TestTecnico {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int n1=1;

        Tecnico r1 = new Tecnico();
        do{
            System.out.println("Que quieres hacer?\n0.Salir\n1.Introducir equipo, diagnostico y descripción del problema\n2.Ver los datos del problema\n3.Introducir estado de la reparación\n4.Modificar disponibilidad\n5.Introducir materiales utilizados\n6.Introducir el reporte y el tipo de reparacion");
            n1=scanner.nextInt();
            switch (n1) {
                case 1:
                scanner.nextLine();
                    System.out.println("Dime el equipo que hay que reparar");
                    String equipo = scanner.nextLine();
                    r1.setEquipoAfectado(equipo);
                    System.out.println("Cual el diagnostico");
                    String diagnostico= scanner.nextLine();
                    r1.setDiagnostico(diagnostico);
                    System.out.println("Cual es la descripcion");
                    String descripcion = scanner.nextLine();
                    r1.setDescripcion(descripcion);
                    break;
                case 2:
                    System.out.println(r1.getDatosReparacion());
                    break;
                case 3:
                     scanner.nextLine();
                    System.out.println("Dime el estado de la reparación");
                    String estado= scanner.nextLine();
                    r1.setEstadoReparación(estado);

                    break;
                case 4:
                    System.out.println("Usted esta disponible (True or false)");
                    boolean dispon = scanner.nextBoolean();
                    r1.disponible(dispon);
                    break;
                case 5:
                scanner.nextLine();
                    System.out.println("Dime los  materiales de la reparación");
                    String material = scanner.nextLine();
                    r1.setAsignarMateriales(material);
                    break;
                case 6:
                scanner.nextLine();
                    System.out.println("Introduzca el reporte");
                    String reporte = scanner.nextLine();
                    r1.setReporte(reporte);
                    System.out.println("Introduzca el tipo de reparación");
                    String tipoReparacion= scanner.nextLine();
                    r1.setTipodeReparac(tipoReparacion);
                    break;
                    default:
                    System.out.println("Se ha equivocado de numero");   
            }
        }while(n1!=0);
    }
}
