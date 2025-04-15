import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        ArrayList<Materiales> materiales = new ArrayList<>();
        ArrayList<Almacen> almacenes = new ArrayList<>();
        ArrayList<Proveedor>proveedores = new ArrayList<>();
        

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
        Materiales mat2 = new Materiales("Cable eléctrico", "Cable de cobre 2.5mm", 45, 2, 60, 20, 40, prov1,almacen2);
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
       
        System.out.println("1.Añadir material");
        System.out.println("2.Eliminar Material");
        System.out.println("3.Eliminar Proveedor");
        System.out.println("4.Añadir Almacen");
        System.out.println("5.Añadir Material a Almacen");
        System.out.println("6.Generar Informe de materiales");
        System.out.println("7.Generar informe de Almacen");
        System.out.println("0.Salir");


        int opcion = tec.nextInt();


        do {
            switch (opcion) {
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


            opcion = tec.nextInt();

            
        } while (opcion!=0);
        tec.close();
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
}
