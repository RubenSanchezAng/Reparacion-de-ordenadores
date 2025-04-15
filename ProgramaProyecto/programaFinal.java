import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class programaFinal{
    public static void main(String[]args){
    Scanner tec = new Scanner(System.in);
        ArrayList<Reparaciones> reparaciones = new ArrayList<>();
        ArrayList<Estimacion> estimaciones = new ArrayList<>();
        ArrayList<Cliente> arrayCliente = new ArrayList<>();
        ArrayList<Institucion> arrayInstitucion = new ArrayList<>();
        ArrayList<Materiales> materiales = new ArrayList<>();
        ArrayList<Almacen> almacenes = new ArrayList<>();
        ArrayList<Proveedor>proveedores = new ArrayList<>();
        GestionPersonal personal = new GestionPersonal();
        
        Usuario persona1 = new Usuario();
        
        // Cliente 1 - Con reparación reciente
        arrayCliente.add(new Cliente("Juan Pérez", "Calle Mayor 123, Madrid", "912345678", "particular", "Cambio de tuberías en baño - 15/03/2025"
        ));

        // Cliente 2 - Sin reparaciones registradas
        arrayCliente.add(new Cliente("María García", "Avenida Libertad 45, Barcelona", "934567890", "particular", "No hay reparaciones registradas"
        ));

        // Cliente 3 - Con múltiples reparaciones
        arrayCliente.add(new Cliente("Carlos Rodríguez", "Plaza España 7, Valencia", "963214578", "particular", "Revisión eléctrica completa - 01/04/2025"
        ));

        // Cliente 4 - Reparación antigua
        arrayCliente.add(new Cliente("Ana López", "Calle Sol 12, Sevilla", "954321654", "particular", "Pintura de salón - 10/12/2024"
        ));

        // Cliente 5 - Nuevo cliente
        arrayCliente.add(new Cliente("David Fernández", "Gran Vía 89, Bilbao", "944567123", "particular", "ninguna"
        ));

        Almacen almacen1 = new Almacen("Almacén Central", "Calle Principal 100", 500, null);
        Almacen almacen2 = new Almacen("Almacén Norte", "Avenida Secundaria 200", 300, null);
        Almacen almacen3 = new Almacen("Almacén Este", "Calle Lateral 50", 200, null);


        Proveedor prov1 = new Proveedor("Ferretería López", "Calle Mayor 10", 912345678, new ArrayList<>());
        Proveedor prov2 = new Proveedor("Materiales Construcción S.A.", "Avenida Industrial 25", 934567890, new ArrayList<>());
        Proveedor prov3 = new Proveedor("Suministros Técnicos", "Calle Tecnología 7", 917894561, new ArrayList<>());
        Proveedor prov4 = new Proveedor("El Almacén del Electricista", "Plaza Voltios 3", 918765432, new ArrayList<>());
        Proveedor prov5 = new Proveedor("Hidráulica Moderna", "Calle Fontaneros 15", 919876543, new ArrayList<>());

        // Añadir proveedores a la lista
        proveedores.add(prov1);
        proveedores.add(prov2);
        proveedores.add(prov3);
        proveedores.add(prov4);
        proveedores.add(prov5);

        // Crear materiales
        Materiales mat1 = new Materiales("Tornillos acero", "Tornillos cabeza hexagonal 10mm", 150, 1, 100, 30, 50, prov1,almacen1);
        Materiales mat2 = new Materiales("Cable eléctrico", "Cable de cobre 2.5mm", 45, 2, 60, 20, 40, prov2,almacen2);
        Materiales mat3 = new Materiales("Tubo PVC", "Tubo para desagües 40mm", 25, 3, 40, 10, 20, prov3,almacen3);
        Materiales mat4 = new Materiales("Interruptor", "Interruptor simple 10A", 35, 2, 50, 15, 30, prov4,almacen1);
        Materiales mat5 = new Materiales("Válvula agua", "Válvula de bola 1/2 pulgada", 12, 3, 30, 5, 15, prov5,almacen2);

        // Añadir materiales a la lista
        materiales.add(mat1);
        materiales.add(mat2);
        materiales.add(mat3);
        materiales.add(mat4);
        materiales.add(mat5);

        // Asignar materiales a proveedores
        prov1.anyadirMaterial(mat1);
        prov2.anyadirMaterial(mat2);
        prov3.anyadirMaterial(mat3);
        prov4.anyadirMaterial(mat4);
        prov5.anyadirMaterial(mat5);


    int opcion;
        do{
            System.out.println("Que quieres hacer?\n1Gestionar Materiales\n2.Gestionar personal\n3.Gestion reparaciones\n4.Gestion usuario\n5.Generación de Informes");
            opcion = tec.nextInt();
            switch (opcion) {
                case 1:
                System.out.println("1.Añadir material");
                System.out.println("2.Eliminar Material");
                System.out.println("3.Eliminar Proveedor");
                System.out.println("4.Añadir Almacen");
                System.out.println("5.Añadir Material a Almacen");
                System.out.println("6.Generar Informe de materiales");
                System.out.println("7.Generar informe de Almacen");
                System.out.println("0.Salir");
        
        
                int opcion_materiales = tec.nextInt();
        
        
                do {
                    switch (opcion_materiales) {
                        case 1:
        
                            System.out.println("Dime el nombre del material");
                            String matnom = tec.nextLine();
                            System.out.println("Dime la descripcion del material");
                            String matdesc = tec.nextLine();
                            System.out.println("Cantidad de material");
                            int matcant = tec.nextInt();
                            System.out.println("A que tipo de reparaciones sera asignadas?\n 1.Opcion\n2.Opcion\n3.Opcion");
                            int mattipo = tec.nextInt();
                            System.out.println("A partir de cuanto el stock estara en verde?");
                            int matstockverde = tec.nextInt();
                            System.out.println("A partir de cuanto el stock estara en amarillo?");
                            int matstockamarillo = tec.nextInt();
                            System.out.println("A partir de cuanto el stock estara en rojo?");
                            int matstockrojo = tec.nextInt();
                            System.out.println("Tiene proveedor? \n 1.Si\n2.No");
                            int opmatprov = tec.nextInt();
                            tec.nextLine();
                            Materiales material = new Materiales(matnom, matdesc, matcant, mattipo, matstockverde,matstockrojo , matstockamarillo, null,null);
                            switch (opmatprov) {
                                case 1:
                                    System.out.println("Como se llama el Proveedor");
                                    String nomprov1 = tec.nextLine();
                                    int pos = buscarProveedor(proveedores,nomprov1);
                                    if (pos>=0) {
                                        material.setProveedor(proveedores.get(pos));
                                        System.out.println("Proveedor asignado correctamente");    
                                    } else {
                                        System.out.println("No existe el proveedor");
                                    }
                                    
        
                                    
        
        
                                    break;
                                case 2:
                                
                                System.out.println("Como se llama el proveedor?");
                                String nomprov2 = tec.nextLine();
                                System.out.println("Cual es su direccion? ");
                                String dirprov = tec.nextLine();
                                System.out.println("Cual es su telefono?");
                                int telefonoprov = tec.nextInt();
                                
                                ArrayList<Materiales> materialesprov = new ArrayList<>();
                                materialesprov.add(material);
                                Proveedor prov = new Proveedor(nomprov2, dirprov, telefonoprov, materialesprov);
                                material.setProveedor(prov);
                                materiales.add(material);
                                proveedores.add(prov);
                                tec.nextLine();
                                    break;
        
                                default:
                                    break;
                            }
        
                        case 2:
        
                            System.out.println("Dime el nombre del material a eliminar");
                            String matelimin = tec.nextLine();
                            int posmatelimin = buscarMaterial(materiales, matelimin);
                            if (posmatelimin>=0) {
                                materiales.remove(posmatelimin);
                                
                                System.out.println("Material eliminado");    
                            }else {
                                System.out.println("Material no encontrado");
                            }
                            break;
                        case 3: 
                            System.out.println("Dame el nombre del proveedor a eliminar");
                            String provelim = tec.nextLine();
                            int posprovelim = buscarProveedor(proveedores, provelim);
                            if (posprovelim>=0) {
                                proveedores.remove(posprovelim);
                                for(int i =0;i<materiales.size();i++){
                                    if (materiales.get(i).getProveedor().getNombre().equals(provelim)) {
                                        materiales.get(i).setProveedor(null);
                                    }
                                }
        
                                
                                System.out.println("Proveedor eliminado");
                            }else{
                                System.out.println("Proveedor no encotrado");
                            }
                            break;
                        case 4:
                            System.out.println("Nombre del almacen a añadir");
                            String nomalmacen = tec.nextLine();
                            System.out.println("Direcion del almacen");
                            String diralmacen = tec.nextLine();
                            System.out.println("Capacidad del almacen");
                            int capacialmacen = tec.nextInt();
                            tec.nextLine();
                            ArrayList<Materiales> materialesalmacen = new ArrayList<>();
                            Almacen almacen = new Almacen(nomalmacen, diralmacen, capacialmacen, materialesalmacen);
                            almacenes.add(almacen);
                            break;
                        case 5:
        
                            System.out.println("En que almacen quieres añadir el material");
                            String almabusca = tec.nextLine();
                            int posalmaaniamat = buscarAlmacen(almacenes, almabusca);
                            System.out.println("Que material quieres añadir en el almacen?");
                            String matbusca = tec.nextLine();
                            int posmataniadir = buscarMaterial(materiales, matbusca);
                            materiales.get(posmataniadir).setAlmacen(almacenes.get(posalmaaniamat));
                            almacenes.get(posalmaaniamat).anyadirMaterial(materiales.get(posmataniadir));
        
        
        
                        case 6: 
        
                        generarInformeMaterialesHTML(materiales, "./Informes/informe_materiales.html");
                        System.out.println("Informe de materiales generado como 'informe_materiales.html'");
                        break;
        
                        case 7:
        
                            generarInformeProveedoresHTML(proveedores,  "./Informes/informe_proveedores.html");
                        System.out.println("Informe de materiales generado como 'informe_proveedores.html'");
                        break;
                        
                    
                        default:
                            break;
                    }
        
                    System.out.println("1.Añadir material");
                    System.out.println("2.Eliminar Material");
                    System.out.println("3.Eliminar Proveedor");
                    System.out.println("4.Añadir Almacen");
                    System.out.println("5.Añadir Material a Almacen");
                    System.out.println("6.Generar Informe de materiales");
                    System.out.println("7.Generar informe de Almacen");
                    System.out.println("0.Salir");
        
        
                    opcion_materiales = tec.nextInt();
        
                    
                } while (opcion_materiales!=0);
                    break;
                case 2:
                int opcion_empleado;

                do {
                    System.out.println("\n=== MENÚ DE GESTIÓN DE PERSONAL ===");
                    System.out.println("1. Registrar Empleado");
                    System.out.println("2. Buscar Empleado");
                    System.out.println("3. Dar de Baja Empleado");
                    System.out.println("4. Generar Informe de Personal");
                    System.out.println("0. Salir");
                    System.out.print("Elige una opción: ");
                    opcion_empleado = tec.nextInt();
                    tec.nextLine(); // Limpiar buffer
        
                    switch (opcion_empleado) {
                        case 1:
                            System.out.println("1. Técnico");
                            System.out.println("2. Administrativo");
                            System.out.print("Elige el tipo de empleado: ");
                            int tipo = tec.nextInt();
                            tec.nextLine(); // Limpiar buffer
        
                            System.out.print("Nombre del empleado: ");
                            String nombre = tec.nextLine();
                            System.out.print("Horas trabajadas: ");
                            int horas = tec.nextInt();
                            tec.nextLine(); // Limpiar buffer
        
                            if (tipo == 1) {
                                personal.agregarEmpleado(new Tecnico(nombre, horas));
                            } else if (tipo == 2) {
                                personal.agregarEmpleado(new Administrativo(nombre, horas));
                            } else {
                                System.out.println("Tipo no válido.");
                            }
                            break;
        
                        case 2:
                            System.out.print("Introduce el nombre del empleado a buscar: ");
                            String nombreBusqueda = tec.nextLine();
                            boolean encontrado = false;
                            for (Empleado e : personal.getListaEmpleados()) {
                                if (e.getNombre().equalsIgnoreCase(nombreBusqueda)) {
                                    System.out.println("Empleado encontrado:");
                                    System.out.println(e.generarInforme());
                                    encontrado = true;
                                    break;
                                }
                            }
                            if (!encontrado) {
                                System.out.println("Empleado no encontrado.");
                            }
                            break;
        
                        case 3:
                            System.out.print("Introduce el nombre del empleado a dar de Baja: ");
                            String nombreEliminar = tec.nextLine();
                            boolean eliminado = personal.eliminarEmpleado(nombreEliminar);
                            if (eliminado) {
                                System.out.println("Empleado eliminado correctamente.");
                            } else {
                                System.out.println("No se encontró el empleado.");
                            }
                            break;
        
                        case 4:
                            personal.generarInformeGeneral();
                            break;
        
                        case 0:
                            System.out.println("Saliendo del sistema...");
                            break;
        
                        default:
                            System.out.println("Opción no válida.");
                    }
        
                } while (opcion_empleado != 0);
                    
                    break;
                case 3:
                    System.out.println("Que quieres hacer?\n1.Registrar reparaciones\n2.Seguir el estado\n3.Estimacion de coste\n4.Reportes\n5.Reportes\n6.Ver costes");
                    opcion = tec.nextInt();
                    switch (opcion) {
                        case 1:
                        tec.nextLine();
                        System.out.println("Dime el equipo que hay que reparar");
                        String equipo = tec.nextLine();
                        System.out.println("Cual el diagnostico");
                        String diagnostico = tec.nextLine();
                        System.out.println("Cual es la descripcion");
                        String descripcion = tec.nextLine();
                        System.out.println("Quien va a hacer esa reparación?");
                        String asignar = tec.nextLine();
                        System.out.println("Dime los materiales para esa reparación");
                        String mater = tec.nextLine();
                        System.out.println("Dime los costes de mano de obra de la reparación");
                        double costeMano = tec.nextDouble();
                        System.out.println("Dime los costes materiales de la reparación");
                        double costeMateriales = tec.nextDouble();
                        System.out.println("Dime el tiempo estimado");
                        int tiempoEs = tec.nextInt();
                        reparaciones.add(new Reparaciones(descripcion, equipo, diagnostico, asignar, mater, costeMano, costeMateriales, tiempoEs));
                        break;
                         case 2:
                            int x =0 ;
                            System.out.println("Cual es tu equipo");
                            for(int i=0; i<reparaciones.size();i++){
                                System.out.println(i);
                                 x = tec.nextInt();
                                System.out.println(reparaciones.get(x).toString());
                            }
                            System.out.println("Estimacion");
                            System.out.println(reparaciones.get(x).getEstadoReparación());
                            break;
                         case 3:
                          x =0 ;
                         System.out.println("Cual es tu equipo");
                         for(int i=0; i<reparaciones.size();i++){
                             System.out.println(i);
                              x = tec.nextInt();
                             System.out.println(reparaciones.get(x).toString());
                         }
                         System.out.println("Estimacion");
                         System.out.println(reparaciones.get(x).getEstimacion());
                            break; 
                         case 4:
                          x =0 ;
                         System.out.println("Cual es tu equipo");
                         for(int i=0; i<reparaciones.size();i++){
                             System.out.println(i);
                              x = tec.nextInt();
                             System.out.println(reparaciones.get(x).toString());
                         }
                         System.out.println("Haga su reporte");
                          String reporte = tec.nextLine();
                         reparaciones.get(x).setReporte(reporte);
                         System.out.println("Introduzca el tipo de reparación");
                         String tipoReparacion = tec.nextLine();
                         reparaciones.get(x).setTipodeReparac(tipoReparacion);
                         System.out.println("Introduzca la frecuencia");
                         double frecuencia = tec.nextDouble();
                         reparaciones.get(x).setFrecuencia(frecuencia);
                            break;
                         case 5:
                         x =0 ;
                         System.out.println("De que equipo quieres ver el reporte");
                         for(int i=0; i<reparaciones.size();i++){
                             System.out.println(i);
                              x = tec.nextInt();
                             System.out.println(reparaciones.get(x).getReportes());
                         }
                         break;
                         case 6:
                         estimaciones.add(new ManoObra("Instalación eléctrica",  25.0));
                         estimaciones.add(new Material("Cableado",  20));
                         estimaciones.add(new ManoObra("Pintura interior", 30.0));
                         estimaciones.add(new Material("Pintura blanca",  4));
                     
                         escribirFileWriter(estimaciones, "./Informes/estimacion.html");
                         System.out.println("Estimaciones guardadas en estimacion.html");
                     
                         leerFileReader("./Informes/estimacion.html");
                         break;
                        default:
                            break;
                    }
                    break; 
                case 4:
                    int opcionUsuario = 0;
                    do {
                    
                        System.out.println("Que quieres hacer?\n1.Añadir usuario\n2.Hacer informe\n3.Salir");
                        opcionUsuario = tec.nextInt();
                        tec.nextLine();
                        switch (opcionUsuario) {
                            case 1:
                                // Nombre
                                System.out.println("Dime tu nombre: ");
                                String nombre = tec.nextLine();
                                persona1.setNombre(nombre);

                                // Dirección
                                System.out.println("Dime tu dirección: ");
                                String direccion = tec.nextLine();
                                persona1.setDireccion(direccion);

                                // Validación del contacto
                                String contacto;
                                do {
                                    System.out.println("Dime tu contacto (el contacto debe tener 9 números y no debe contener letras).");
                                    contacto = tec.nextLine();
                                } while (contacto.length() != 9);
                                persona1.setContacto(contacto);

                                // Validación del tipo de cliente
                                String tipoCliente = "";
                                do {
                                    System.out.println("Dime el tipo de cliente (particular o institucional): ");
                                    tipoCliente = tec.nextLine();
                                    if (!tipoCliente.toLowerCase().equals("particular") && !tipoCliente.toLowerCase().equals("institucional")) {
                                        System.out.println("El tipo de cliente debe ser o particular o institucional, no hay más opciones");
                                    }
                                } while (!tipoCliente.toLowerCase().equals("particular") && !tipoCliente.toLowerCase().equals("institucional"));
                                persona1.setTipoCliente(tipoCliente);

                                // Depende del tipo de cliente
                                if (tipoCliente.equals("particular")) {
                                    System.out.println("Ingresa la última reparación realizada (o escribe 'ninguna' si es un nuevo cliente):");
                                    String ultimaReparacion = tec.nextLine();

                                    Cliente cliente = new Cliente(persona1.getNombre(), persona1.getDireccion(), persona1.getContacto(), persona1.getTipoCliente(), ultimaReparacion);
                                    arrayCliente.add(cliente);

                                } else {
                                    System.out.println("Ingresa el sector de la institución:");
                                    String sector = tec.nextLine();

                                    Institucion cliente = new Institucion(persona1.getNombre(), persona1.getDireccion(), persona1.getContacto(), persona1.getTipoCliente(), sector);
                                    arrayInstitucion.add(cliente);
                                }

                                System.out.println(persona1.toString());
                                
                                break;
                            case 2:
                                escribirClientesHTML(arrayCliente, "./Informes/informe_clientes.html");
                                break;
                        }

                    } while (opcionUsuario != 3);

                    break;
                case 5:
                    
                    break;
                default:
                    break;
            }
            System.out.println("Que quieres hacer?\n1Gestionar Materiales\n2.Gestionar personal\n3.Gestion reparaciones\n4.Gestion usuario\n5.Generación de Informes");
            opcion = tec.nextInt();
        }while(opcion!=0);
        
    }
    public static void generarInformeMaterialesHTML(ArrayList<Materiales> materiales, String nombreFichero) {
        try {
            File fs = new File(nombreFichero);
            FileWriter fw = new FileWriter(fs);
            
            // Cabecera HTML
            String cabecera = "<!DOCTYPE html>\n<html>\n<head>\n" +
                             "  <title>Informe de Materiales</title>\n" +
                             "  <style>\n" +
                             "    body { font-family: Arial, sans-serif; margin: 20px; }\n" +
                             "    h1 { color: purple; }\n" +
                             "    table { width: 100%; border-collapse: collapse; margin-top: 20px; }\n" +
                             "    th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }\n" +
                             "    th { background-color: skyblue; color: white; }\n" +
                             "    tr:nth-child(even) { background-color: white; }\n" +
                             "    .verde { background-color: green; color: white; }\n" +
                             "    .amarillo { background-color: orange; }\n" +
                             "    .rojo { background-color: red; color: white; }\n" +
                             "  </style>\n" +
                             "</head>\n" +
                             "<body>\n" +
                             "  <h1>Informe de Materiales</h1>\n" +
                             "  <table>\n" +
                             "    <tr>\n" +
                             "      <th>Nombre</th>\n" +
                             "      <th>Descripción</th>\n" +
                             "      <th>Cantidad</th>\n" +
                             "      <th>Almacen</th>\n" +
                             "      <th>Tipo Reparación</th>\n" +
                             "      <th>Estado Stock</th>\n" +
                             "      <th>Proveedor</th>\n" +
                             "    </tr>\n";
            
            fw.write(cabecera);
            
            // Filas de datos
            for (Materiales material : materiales) {
                String estadoStock = material.getStock().toString();
                String claseColor = "";
                
                switch(estadoStock.toLowerCase()) {
                    case "verde": claseColor = "verde"; break;
                    case "amarillo": claseColor = "amarillo"; break;
                    case "rojo": claseColor = "rojo"; break;
                }
                
                String fila = "    <tr>\n" +
                             "      <td>" + material.getNombre() + "</td>\n" +
                             "      <td>" + material.getDescripcion() + "</td>\n" +
                             "      <td>" + material.getCantidad() + "</td>\n" +
                             "      <td>" + (material.getAlmacen()!=null ? material.getAlmacen().getNombre() : "Ninguno") + "</td>\n" +
                             "      <td>" + material.getTipo_reparacion() + "</td>\n" +
                             "      <td class='" + claseColor + "'>" + estadoStock + "</td>\n" +
                             "      <td>" + (material.getProveedor() != null ? material.getProveedor().getNombre() : "Ninguno") + "</td>\n" +
                             "    </tr>\n";
                
                fw.write(fila);
            }
            
            // Cierre HTML
            String cierre = "  </table>\n" +
                            "</body>\n" +
                            "</html>";
            
            fw.write(cierre);
            fw.close();
            
        } catch (IOException e) {
            System.out.println("Error al generar el informe: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void generarInformeProveedoresHTML(ArrayList<Proveedor> proveedores, String nombreFichero) {
        try {
            FileWriter fw = new FileWriter(nombreFichero);
            
            // Cabecera HTML con estilos simplificados
            String cabecera = "<!DOCTYPE html>\n<html>\n<head>\n" +
                            "  <title>Informe de Proveedores</title>\n" +
                            "  <style>\n" +
                            "    body { font-family: Arial, sans-serif; margin: 20px; }\n" +
                            "    h1 { color: black; text-align: center; }\n" +
                            "    .proveedor { border: 1px solid gray; padding: 15px; margin-bottom: 20px; }\n" +
                            "    h2 { color: blue; margin-top: 0; }\n" +
                            "    table { width: 100%; border-collapse: collapse; margin-top: 10px; }\n" +
                            "    th, td { border: 1px solid gray; padding: 8px; }\n" +
                            "    th { background-color: blue; color: white; }\n" +
                            "    .verde { background-color: green; color: white; }\n" +
                            "    .amarillo { background-color: yellow; }\n" +
                            "    .rojo { background-color: red; color: white; }\n" +
                            "    .contacto { margin-top: 10px; }\n" +
                            "  </style>\n" +
                            "</head>\n<body>\n" +
                            "<h1>Informe de Proveedores</h1>\n";
            
            fw.write(cabecera);
            
            // Contenido para cada proveedor
            for (Proveedor proveedor : proveedores) {
                fw.write("<div class='proveedor'>\n" +
                        "  <h2>" + proveedor.getNombre() + "</h2>\n" +
                        "  <div class='contacto'>\n" +
                        "    <p><strong>ID:</strong> " + proveedor.getId() + "</p>\n" +
                        "    <p><strong>Dirección:</strong> " + proveedor.getDireccion() + "</p>\n" +
                        "    <p><strong>Teléfono:</strong> " + proveedor.getTelefono() + "</p>\n" +
                        "    <p><strong>Materiales que provee:</strong> " + proveedor.materialesprov.size() + "</p>\n" +
                        "  </div>\n");
                
                // Tabla de materiales
                if (!proveedor.materialesprov.isEmpty()) {
                    fw.write("  <table>\n" +
                            "    <tr>\n" +
                            "      <th>Material</th>\n" +
                            "      <th>Descripción</th>\n" +
                            "      <th>Cantidad</th>\n" +
                            "      <th>Estado Stock</th>\n" +
                            "    </tr>\n");
                    
                    for (Materiales material : proveedor.materialesprov) {
                        String estadoStock = material.getStock().toString().toLowerCase();
                        String claseColor = estadoStock; // verde, amarillo o rojo
                        
                        fw.write("    <tr>\n" +
                                "      <td>" + material.getNombre() + "</td>\n" +
                                "      <td>" + material.getDescripcion() + "</td>\n" +
                                "      <td>" + material.getCantidad() + "</td>\n" +
                                "      <td class='" + claseColor + "'>" + estadoStock.toUpperCase() + "</td>\n" +
                                "    </tr>\n");
                    }
                    
                    fw.write("  </table>\n");
                } else {
                    fw.write("  <p>No provee materiales actualmente.</p>\n");
                }
                
                fw.write("</div>\n");
            }
            
            fw.write("</body>\n</html>");
            fw.close();
            
            System.out.println("Informe de proveedores generado: " + nombreFichero);
        } catch (IOException e) {
            System.out.println("Error al generar el informe: " + e.getMessage());
        }
    }
    
    public static int buscarProveedor(ArrayList<Proveedor>prov,String nombre){
        int res =-1;
        for (int i = 0;i<prov.size();i++) {
            if (prov.get(i).getNombre().equals(nombre)) {
                res = i;
                System.out.println("Proveedor encontrado");
            }
            
        }
        return res;
    }
    
    public static int buscarMaterial(ArrayList<Materiales>mat,String nombre){
        int res =-1;
        for (int i = 0;i<mat.size();i++) {
            if (mat.get(i).getNombre().equals(nombre)) {
                res = i;
                System.out.println("Material encontrado");
            }
            
        }
        return res;
    }
    public static int buscarAlmacen(ArrayList<Almacen>almacenes,String nombre){
        int res =-1;
        for (int i =0; i<almacenes.size();i++){
            if (almacenes.get(i).getNombre().equals(nombre)) {
                res = i;
                System.out.println("Almacen encontrado");
            }
        }
        return res;
    }
      public static void escribirFileWriter(ArrayList<Estimacion> estimacions, String nombreFichero){
        try {
            File fs = new File(nombreFichero);
            FileWriter fw = new FileWriter(fs,true);
            
            String cadena ="<html>\n<head>Listado Estimaciones</head>\n <body>\n<ol>\n";
            fw.write(cadena);
                fw.write("\r\n");
           
                for (Estimacion est : estimacions) {
                    String linea = "<li>" + est.getTipo() + ": " + est.getDescripcion() + " - " + est.getCosto() + "€</li>\n";
                    fw.write(linea);
                
            }
            cadena ="</ol>\n</body></html>\n";
            fw.write(cadena);
                fw.write("\r\n");
            if (fw != null) {fw.close();}
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void leerFileReader(String fichero){
        File fe = new File(fichero);
        if (fe.exists()){
            try {
                FileReader fr = new FileReader(fe);
                BufferedReader br = new BufferedReader(fr);
                String cadena;
                
                while ((cadena = br.readLine()) !=null) {
                    System.out.println(cadena);

                }
                if (fr != null) {fr.close();}

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Escribe los datos de una lista de clientes en un fichero HTML con formato profesional.
     *
     * @param clientes Lista de clientes particulares
     * @param nombreFichero Nombre del archivo donde se escribirá
     */
    public static void escribirClientesHTML(ArrayList<Cliente> clientes, String nombreFichero) {
        try {
            File archivo = new File(nombreFichero);
            FileWriter fw = new FileWriter(archivo);

            // Cabecera HTML con estilos CSS
            String cabecera = "<!DOCTYPE html>\n<html>\n<head>\n" +
                            "  <title>Informe de Clientes Particulares</title>\n" +
                            "  <style>\n" +
                            "    body { font-family: Arial, sans-serif; margin: 20px; }\n" +
                            "    h1 { color: #4a148c; text-align: center; }\n" +
                            "    table { width: 100%; border-collapse: collapse; margin-top: 20px; }\n" +
                            "    th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }\n" +
                            "    th { background-color: #7b1fa2; color: white; }\n" +
                            "    tr:nth-child(even) { background-color: #f2f2f2; }\n" +
                            "    tr:hover { background-color: #e1bee7; }\n" +
                            "    .sin-reparacion { color: #757575; font-style: italic; }\n" +
                            "    .header { background-color: #f3e5f5; padding: 10px; margin-bottom: 20px; }\n" +
                            "  </style>\n" +
                            "</head>\n<body>\n" +
                            "<div class='header'>\n" +
                            "  <h1>Informe de Clientes Particulares</h1>\n" +
                            "  <p>Fecha del informe: " + java.time.LocalDate.now() + "</p>\n" +
                            "  <p>Total de clientes: " + clientes.size() + "</p>\n" +
                            "</div>\n" +
                            "<table>\n" +
                            "  <tr>\n" +
                            "    <th>Nombre</th>\n" +
                            "    <th>Dirección</th>\n" +
                            "    <th>Contacto</th>\n" +
                            "    <th>Última Reparación</th>\n" +
                            "  </tr>\n";

            fw.write(cabecera);

            // Filas de datos para cada cliente
            for (Cliente cliente : clientes) {
                String ultimaRep = cliente.getUltimaReparacion();
                String claseRep = ultimaRep.equalsIgnoreCase("No hay reparaciones registradas") ? 
                                "class='sin-reparacion'" : "";
                
                String fila = "  <tr>\n" +
                            "    <td>" + cliente.getNombre() + "</td>\n" +
                            "    <td>" + cliente.getDireccion() + "</td>\n" +
                            "    <td>" + cliente.getContacto() + "</td>\n" +
                            "    <td " + claseRep + ">" + ultimaRep + "</td>\n" +
                            "  </tr>\n";
                
                fw.write(fila);
            }

            // Cierre HTML
            String cierre = "</table>\n" +
                            "<div style='margin-top: 30px; text-align: center; color: #757575; font-size: 0.9em;'>\n" +
                            "  <p>Sistema de Gestión de Clientes - © 2025</p>\n" +
                            "</div>\n" +
                            "</body>\n</html>";

            fw.write(cierre);
            fw.close();
            
            System.out.println("Informe de clientes generado correctamente: " + nombreFichero);
        } catch (IOException e) {
            System.out.println("Error al generar el informe de clientes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Lee y muestra por consola el contenido de un fichero HTML.
     *
     * @param nombreFichero Nombre del archivo a leer
     */
    public static void leerClientesHTML(String nombreFichero) {
        File archivo = new File(nombreFichero);
        if (archivo.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }
}