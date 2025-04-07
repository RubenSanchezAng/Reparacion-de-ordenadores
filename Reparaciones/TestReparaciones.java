import java.util.Scanner;

public class TestReparaciones{
    public static void main(String[]args){
       Scanner scanner = new Scanner(System.in);
        int n=0; 
        int n1=1;
        
        Reparaciones r1 = new Reparaciones();
        do{
            System.out.println("Eres cliente o trabajador? \nSi eres cliente pulse 1 \nSi eres trabajador pulse 2\n0Salir");
            n = scanner.nextInt();
            do{
                if(n==1){
                    System.out.println("Que quieres hacer? \n1.Ver el estado de reparación\n2.Ver el coste y el tiempo estimado.\n0.Salir");
                    n1=scanner.nextInt();
                    switch (n1) {
                        case 0:
                            System.out.println("Gracias por confiar en nosotros");
                        case 1:
                            System.out.println(r1.getEstadoReparación());
                            break;
                        case 2:
                            System.out.println(r1.getEstimacion());
                        default:
                            System.out.println("Se ha equivocado de numero");
                            break;
                    }
                
                }else
                    if(n==2){
                        System.out.println("Que quieres hacer?\n0.Salir\n1.Introducir equipo, diagnostico y descripción del problema\n2.Ver los datos del problema\n3.Asignar reparadores\n4.Ver reparadores asignados\n5.Introducir estado de la reparación\n6.Introducir costes y tiempo de entrega estimado\n7.Ver costes y tiempo de entrega estimado\n8.Introducir el reporte, el tipo de reparacion y la frecuencia\n9.Ver el reporte, el tipo de reparacion y la frecuencia");
                        n1=scanner.nextInt();
                        switch (n1) {
                            case 0:
                                System.out.println("Gracias por confiar en nosotros");
                                break;
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
                                System.out.println("Quien va a hacer esa reparación?");
                                String asignar=scanner.nextLine();
                                r1.setAsignarReparadores(asignar);
                                System.out.println("Dime los materiales para esa reparación");
                                String materiales=scanner.nextLine();
                                r1.setAsignarMateriales(materiales);
    
                                break;
                            case 4:
                                System.out.println( r1.getAsignado());
                                break;
                            case 5:
                            scanner.nextLine();
                                System.out.println("Dime el estado de la reparación");
                                String estado= scanner.nextLine();
                                r1.setEstadoReparación(estado);
                                break;
                            case 6:
                                System.out.println("Dime los costes de mano de obra de la reparación");
                                double costeMano = scanner.nextDouble();
                                r1.setCosteObra(costeMano);
                                System.out.println("Dime los costes materiales de la reparación");
                                double costeMateriales=scanner.nextDouble();
                                r1.setMateriales(costeMateriales);
                                System.out.println("Dime el tiempo estimado");
                                double tiempoEs = scanner.nextInt();
                                r1.setTiempo(tiempoEs);
    
                                break;
                            case 7:
                                System.out.println(r1.getEstimacion());
                                break;
                            case 8:
                            scanner.nextLine();
                                System.out.println("Introduzca el reporte");
                                String reporte = scanner.nextLine();
                                r1.setReporte(reporte);
                                System.out.println("Introduzca el tipo de reparación");
                                String tipoReparacion= scanner.nextLine();
                                r1.setTipodeReparac(tipoReparacion);
                                System.out.println("Introduzca la frecuencia");
                                double frecuencia= scanner.nextDouble();
                                r1.setFrecuencia(frecuencia);
                                break;
                            case 9:
                            System.out.println(r1.getReportes());
                                break;
                            
                            default:
                                System.out.println("Se ha equivocado de numero");
                               
                        }
                    }else
                    System.out.println("Has puesto un numero incorrecto");
        
            }while(n1!=0);
        } while(n!=0);
       
            
        }
    }
