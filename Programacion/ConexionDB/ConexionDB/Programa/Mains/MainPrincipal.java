package Mains;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Client;

import BaseDatos.*;

public class MainPrincipal {
    public static void main(String[] args) {
        try (Connection con = ConexionDB.obtenerConexion();
             Scanner scanner = new Scanner(System.in)) {

            int n = 1;

            do {
                System.out.println("Que quieres hacer?");
                System.out.println("MENÚ PRINCIPAL\n1. Administrativos\n2. Almacenes\n3. Clientes\n4. Empleados\n5. Equipos\n6. Facturas\n7. Líneas de Compra\n8. Materiales\n9. Órdenes de Compra\n10. Presupuestos\n11. Proveedores\n12. Técnicos\n0. Salir");
                n = scanner.nextInt();

                switch (n) {
                    case 1:
                        do {
                            System.out.println("MENÚ ADMINISTRATIVOS\n1. Insertar administrativo\n2. Ver todos los administrativo\n3. Ver por ID del administrativo\n4. Borrar por ID del administrativo\n5.Modificar nombre del administrativo\n6. Modificar teléfono del administrativo\n0. Volver");
                            n = scanner.nextInt();
                            scanner.nextLine();

                            try {
                                switch (n) {
                                    case 1: 
                                        System.out.println("ID: ");
                                        int id = scanner.nextInt();
                                        scanner.nextLine();
                                        //El cargo no lo pregunto porque esta claro
                                        String cargo = "administrativo";
                                        System.out.println("Nombre: ");
                                        String nombre = scanner.nextLine();
                                        System.out.println("Teléfono: ");
                                        String tlf = scanner.nextLine();
                                        AdministrativoDB.insertarAdministrativo(con, id, cargo, nombre, tlf);
                                        break;
                                    
                                    case 2:
                                        AdministrativoDB.verAdministrativos(con);
                                        break;
                                    case 3: 
                                        System.out.println("ID a buscar: ");
                                         id = scanner.nextInt();
                                        scanner.nextLine();
                                        AdministrativoDB.verAdministrativoPorId(con, id);
                                        break;
                                    
                                    case 4: 
                                        AdministrativoDB.verAdministrativos(con);
                                        System.out.println("Dime el id del administrador a borrar: ");
                                         id = scanner.nextInt();
                                        scanner.nextLine();
                                        AdministrativoDB.borrarAdministrativoPorId(con, id);
                                        break;
                                    
                                    case 5: 
                                        AdministrativoDB.verAdministrativos(con); 
                                        System.out.println("ID: del administrador que le quieres cambiar el nombre");
                                         id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo nombre: ");
                                         nombre = scanner.nextLine();
                                        AdministrativoDB.modificarNombre(con, id, nombre);
                                        break;
                                    
                                    case 6: 
                                        AdministrativoDB.verAdministrativos(con);
                                        System.out.println("ID del administrador que le quieres cambiar el teléfono :");
                                         id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo teléfono: ");
                                        String tel = scanner.nextLine();
                                        AdministrativoDB.modificarTelefono(con, id, tel);
                                        break;
                                    
                                    case 0:
                                        System.out.println("Volviendo al menu");
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                        break;
                                }
                            } catch (SQLException e) {
                                System.out.println("Error SQL: " + e.getMessage());
                            }

                        } while (n != 0);
                        break;
                    case 2:
                            do {
                                System.out.println("MENÚ ALMACENES\n1. Insertar almacen\n2. Ver todos los almacen\n3. Ver por ID de almacen\n4. Borrar por ID de almacen\n5. Modificar fecha\n6. Modificar ubicaciónLeer archivo y añadir datos a la base de datos\n7.Leer datos del fichero y añadir a la base de datos\n8.Añadir datos de la base de datos a un fichero\n0. Volver");
                                n = scanner.nextInt();
                                scanner.nextLine();

                                try {
                                    switch (n) {
                                        case 1: 
                                            System.out.println("ID: ");
                                            int id = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Fecha (aaaa-mm-dd): ");
                                            String fechaStr = scanner.nextLine();
                                            java.sql.Date fecha = java.sql.Date.valueOf(fechaStr);
                                            System.out.println("Ubicación: ");
                                            String ubicacion = scanner.nextLine();

                                            AlmacenDB.insertarAlmacen(con, id, fecha, ubicacion);
                                            break;
                                        
                                        case 2:
                                            AlmacenDB.verAlmacenes(con);
                                            break;
                                        case 3: 
                                            System.out.println("ID a buscar: ");
                                            id = scanner.nextInt();
                                            scanner.nextLine();
                                            AlmacenDB.verAlmacenPorId(con, id);
                                            break;
                                        
                                        case 4: 
                                            AlmacenDB.verAlmacenes(con);  
                                            System.out.println("Dime el id del almacén a borrar: ");
                                            id = scanner.nextInt();
                                            scanner.nextLine();
                                            AlmacenDB.borrarAlmacenPorId(con, id);
                                            break;
                                        
                                        case 5: 
                                            AlmacenDB.verAlmacenes(con); 
                                            System.out.println("ID del almacén para modificar fecha: ");
                                            id = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Nueva fecha (aaaa-mm-dd): ");
                                            String nuevaFechaStr = scanner.nextLine();
                                            java.sql.Date nuevaFecha = java.sql.Date.valueOf(nuevaFechaStr);

                                            AlmacenDB.modificarFecha(con, id, nuevaFecha);
                                            break;
                                        
                                        case 6: 
                                            AlmacenDB.verAlmacenes(con); 
                                            System.out.println("ID del almacén para modificar ubicación: ");
                                            id = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Nueva ubicación: ");
                                            String nuevaUbicacion = scanner.nextLine();

                                            AlmacenDB.modificarUbicacion(con, id, nuevaUbicacion);
                                            break;
                                         case 7:
                                            System.out.println("Dime el nombre del fichero:");
                                            String fichero = scanner.nextLine(); 
                                            String rutaCompleta = "Programa/Informes/"+ fichero;

                                            AlmacenDB.leerAlmacenesDesdeArch(con, rutaCompleta);
                                            break;
                                        case 8:
                                            System.out.println("Dime el nombre del fichero:");
                                            fichero = scanner.nextLine(); 
                                             rutaCompleta = "Programa/Informes/"+ fichero;

                                            AlmacenDB.escribirAlmacenesEnArch(con, rutaCompleta);
                                            break;
                                        case 0:
                                            System.out.println("Volviendo al menú");
                                            break;
                                        default:
                                        System.out.println("Opción no válida");
                                    }
                                } catch (SQLException e) {
                                    System.out.println("Error SQL: " + e.getMessage());
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Formato de fecha no valido");
                                }

                            } while (n != 0);
                        break;
                    case 3:
                    do {
                                System.out.println("MENÚ CLIENTES\n1. Insertar cliente\n2. Ver todos los clientes\n3. Ver por ID del cliente\n4. Borrar por ID del cliente\n5. Modificar correo del cliente\n6. Modificar nombre del cliente\n7.Modificar dirección del cliente\n8.Leer archivo y añadir datos a la base de datos\n9.Añadir datos de la base de datos a un fichero\n0. Volver");
                                n = scanner.nextInt();
                                scanner.nextLine();

                                try {
                                    switch (n) {
                                        case 1: 
                                            System.out.println("ID del cliente: ");
                                            int id = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Correo del cliente ");
                                            String correo = scanner.nextLine();
                                            System.out.println("Nombre del cliente: ");
                                            String nombre = scanner.nextLine();
                                            System.out.println("Dirección del cliente: ");
                                            String calle = scanner.nextLine();
                                            ClienteDB.insertarCliente(con, id, correo, nombre, calle);
                                            break;
                                        
                                        case 2:
                                            ClienteDB.verClientes(con);
                                            break;
                                        case 3: 
                                            System.out.println("ID del cliente a buscar: ");
                                            id = scanner.nextInt();
                                            scanner.nextLine();
                                            ClienteDB.mostrarClientePorId(con, id);
                                            break;
                                        
                                        case 4: 
                                            ClienteDB.verClientes(con);  
                                            System.out.println("Dime el id del cliente a borrar: ");
                                            id = scanner.nextInt();
                                            scanner.nextLine();
                                             ClienteDB.borrarClientePorId(con, id);
                                            break;
                                        
                                        case 5: 
                                            ClienteDB.verClientes(con);  
                                            System.out.println("ID del cliente para modificar correo: ");
                                            id = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Nuevo correo: ");
                                            String nuevoCorreo = scanner.nextLine();
                                            ClienteDB.modificarCorreo(con, id, nuevoCorreo);
                                            break;
                                        
                                        case 6: 
                                                ClienteDB.verClientes(con);  
                                                System.out.println("ID del cliente para modificar nombre: ");
                                                id = scanner.nextInt();
                                                scanner.nextLine();
                                                System.out.println("Nuevo nombre: ");
                                                String nuevoNombre = scanner.nextLine();
                                                ClienteDB.modificarNombre(con, id, nuevoNombre);
                                            break;
                                        
                                        case 7:
                                            ClienteDB.verClientes(con);  
                                            System.out.println("ID del cliente para modificar la dirección: ");
                                            id = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Nueva dirección: ");
                                            String nuevadireccion = scanner.nextLine();

                                            ClienteDB.modificarDireccion(con, id, nuevadireccion);
                                            break;
                                        case 8:
                                            System.out.println("Dime el nombre del fichero:");
                                            String fichero = scanner.nextLine(); 
                                            String rutaCompleta = "Programa/Informes/"+ fichero;

                                            ClienteDB.leerClientesDesdeArch(con, rutaCompleta);
                                            break;
                                        case 9:
                                            System.out.println("Dime el nombre del fichero:");
                                            fichero = scanner.nextLine(); 
                                             rutaCompleta = "Programa/Informes/"+ fichero;

                                            ClienteDB.escribirClientesEnArch(con, rutaCompleta);
                                            break;
                                        case 0:
                                            System.out.println("Volviendo al menú");
                                            break;
                                        default:
                                        System.out.println("Opción no válida");
                                    }
                                } catch (SQLException e) {
                                    System.out.println("Error SQL: " + e.getMessage());
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Formato de fecha no valido");
                                }

                            } while (n != 0);
                        break;
                    case 4:
                        do {
                            System.out.println("MENÚ EMPLEADOS\n1. Insertar empleado\n2. Ver todos los empleados\n3. Ver por ID\n4. Borrar por ID del empleado\n5 .Modificar teléfono del empleado\n6. Modificar nombre del empleado\n0. Volver");
                            n = scanner.nextInt();
                            scanner.nextLine(); 
                            try {
                                switch (n) {
                                    case 1: 
                                        System.out.println("ID del empleado: ");
                                        int id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Cargo del empleado: ");
                                        String cargo = scanner.nextLine();
                                        System.out.println("Nombre del empleado: ");
                                        String nombre = scanner.nextLine();
                                        System.out.println("Teléfono del empleado: ");
                                        String tlf = scanner.nextLine();
                                        EmpleadoDB.insertarEmpleado(con, id, cargo, nombre, tlf);
                                        break;
                                    
                                    case 2:
                                        EmpleadoDB.verTodosEmpleados(con);
                                        break;
                                    case 3: 
                                        System.out.println("ID del empleado a buscar: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        EmpleadoDB.verEmpleadoPorId(con, id);
                                        break;
                                    
                                    case 4: 
                                        EmpleadoDB.verTodosEmpleados(con);
                                        System.out.println("ID del empleado a borrar: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        EmpleadoDB.borrarEmpleadoPorId(con, id);
                                        break;
                                    
                                    case 5: 
                                        EmpleadoDB.verTodosEmpleados(con);
                                        System.out.println("ID del empleado para modificar teléfono: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo teléfono: ");
                                        String nuevoTelefono = scanner.nextLine();
                                        EmpleadoDB.modificarTelefono(con, id, nuevoTelefono);
                                        break;
                                    
                                    case 6: 
                                        EmpleadoDB.verTodosEmpleados(con);
                                        System.out.println("ID del empleado para modificar nombre: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo nombre: ");
                                        String nuevoNombre = scanner.nextLine();
                                        EmpleadoDB.modificarNombre(con, id, nuevoNombre);
                                        break;
                                    
                                   
                                    case 0:
                                        System.out.println("Volviendo al menú");
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                }
                            } catch (SQLException e) {
                                System.out.println("Error SQL: " + e.getMessage());
                            } catch (IllegalArgumentException e) {
                                System.out.println("Entrada no válida: " + e.getMessage());
                            }

                        } while (n != 0);
                        break;
                    case 5:
                     do {
                           System.out.println("MENÚ EQUIPOS\n1. Insertar equipo\n2. Ver todos los equipos\n3. Ver por ID\n4. Borrar por ID el equipo\n5. Modificar fecha del equipo\n6. Modificar estado del equipo\n7. Modificar modelo del equipo\n8. Modificar marca del equipo\n9.Modificar id del técnico asignado\n10.Escribir datos de la base de datos en un archivo\n0. Volver");
                            n = scanner.nextInt();
                            scanner.nextLine(); 
                            try {
                                switch (n) {
                                    case 1: 
                                        System.out.println("ID del equipo: ");
                                        int id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Estado del equipo: ");
                                        String estado = scanner.nextLine();
                                        System.out.println("Fecha (yyyy-mm-dd): ");
                                        String fechaStr = scanner.nextLine();
                                        Date fecha = Date.valueOf(fechaStr); 
                                        System.out.println("Modelo del equipo: ");
                                        String modelo = scanner.nextLine();
                                        System.out.println("Marca del equipo: ");
                                        String marca = scanner.nextLine();

                                        System.out.println("Técnico a asignaer");
                                        TecnicoDB.verTecnicos(con); 
                                        System.out.println("ID del técnico asignado: ");
                                        int idT = scanner.nextInt();
                                        scanner.nextLine();
                                        EquipoDB.insertarEquipo(con, id, estado, fecha, modelo, marca, idT);
                                        break;
                                    
                                    case 2:
                                        EquipoDB.verEquipos(con);
                                        break;
                                    case 3: 
                                        System.out.println("ID del equipo a buscar: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        EquipoDB.verEquipoPorId(con, id);
                                        break;
                                    
                                    case 4: 
                                        EquipoDB.verEquipos(con);
                                        System.out.println("ID del equipo a borrar: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        EquipoDB.borrarEquipoPorId(con, id);
                                        break;
                                    
                                    case 5: 
                                        EquipoDB.verEquipos(con);
                                        System.out.println("ID del equipo para modificar fecha: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Nueva fecha (yyyy-mm-dd): ");
                                        fechaStr = scanner.nextLine();
                                        Date nuevaFecha = Date.valueOf(fechaStr);
                                        EquipoDB.modificarFecha(con, id, nuevaFecha);
                                        break;
                                    
                                    case 6: 
                                        EquipoDB.verEquipos(con);
                                        System.out.println("ID del equipo para modificar estado: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo estado: ");
                                        String nuevoEstado = scanner.nextLine();
                                        EquipoDB.modificarEstado(con, id, nuevoEstado);
                                        break;
                                    
                                    case 7: 
                                        EquipoDB.verEquipos(con);
                                        System.out.println("ID del equipo para modificar modelo: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo modelo: ");
                                        String nuevoModelo = scanner.nextLine();
                                        EquipoDB.modificarModelo(con, id, nuevoModelo);
                                        break;
                                    
                                    case 8: 
                                        EquipoDB.verEquipos(con);
                                        System.out.println("ID del equipo para modificar marca: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nueva marca: ");
                                        String nuevaMarca = scanner.nextLine();
                                        EquipoDB.modificarMarca(con, id, nuevaMarca);
                                        break;
                                    
                                     case 9:
                                        EquipoDB.verEquipos(con); 
                                        System.out.println("ID del equipo para modificar ID Técnico: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo Técnico: ");
                                        int nuevoIdT = scanner.nextInt();
                                        scanner.nextLine();
                                        EquipoDB.modificarIdT(con, id, nuevoIdT);
                                        break;
                                    case 10:
                                           System.out.println("Dime el nombre del fichero:");
                                            String nombreArchivo = scanner.nextLine(); 
                                            String rutaCompletaParaEscritura = "Programa/Informes/"+ nombreArchivo;

                                            EquipoDB.escribirEquiposEnArch(con, rutaCompletaParaEscritura);
                                            
                                        break;
                                    case 0:
                                        System.out.println("Volviendo al menú principal");
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                }
                            } catch (SQLException e) {
                                System.out.println("Error SQL: " + e.getMessage());
                            } catch (IllegalArgumentException e) {
                                System.out.println("Entrada no válida: " + e.getMessage());
                            }

                         } while (n != 0);
                        break;
                    case 6:
                        do {
                            System.out.println("MENÚ FACTURAS\n1. Insertar factura\n2. Ver todas las facturas\n3. Ver por ID la factura\n4. Borrar por ID la factura\n5. Modificar cantidad\n6.Modificar id del administrador asignado\n7.Leer archivo y añadirlo a la base de datos\n0. Volver");
                            n = scanner.nextInt();
                            scanner.nextLine(); 

                            try {
                                switch (n) {
                                    case 1: 
                                        System.out.println("ID de la factura: ");
                                        int id = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Cantidad: ");
                                        Double cantidad = scanner.nextDouble();
                                        scanner.nextLine();

                                        System.out.println("Administrativos:");
                                        AdministrativoDB.verAdministrativos(con);

                                        System.out.println("ID del administrativo: ");
                                        int idA = scanner.nextInt();
                                        scanner.nextLine();

                                        FacturaDB.insertarFactura(con, id, cantidad, idA);
                                        break;
                                    
                                    case 2:
                                        FacturaDB.verFacturas(con);
                                        break;
                                    case 3: 
                                        System.out.println("ID de la factura a buscar: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        FacturaDB.verFacturaPorId(con, id);
                                        break;
                                    
                                    case 4: 
                                        FacturaDB.verFacturas(con);
                                        System.out.println("ID de la factura a borrar: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        FacturaDB.borrarFacturaPorId(con, id);
                                        break;
                                    
                                    case 5: 
                                        FacturaDB.verFacturas(con);
                                        System.out.println("ID de la factura para modificar cantidad: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Nueva cantidad: ");
                                        Double nuevaCantidad = scanner.nextDouble();
                                        scanner.nextLine();

                                        FacturaDB.modificarCantidad(con, id, nuevaCantidad);
                                        break;
                                    
                                    case 6:
                                        FacturaDB.verFacturas(con); 
                                        System.out.println("ID de la factura para modificar ID Administrador: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo ID Administrador: ");
                                        int nuevoIdA = scanner.nextInt();
                                        scanner.nextLine();
                                        FacturaDB.modificarIdA(con, id, nuevoIdA);
                                        break;
                                    
                                    case 7:
                                           System.out.println("Dime el nombre del fichero:");
                                            String fichero = scanner.nextLine(); 
                                            String rutaCompleta = "Programa/Informes/"+ fichero;

                                            FacturaDB.leerFacturasDesdeArch(con, rutaCompleta);
                                        break;
                                    case 0:
                                        System.out.println("Volviendo al menú principal");
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                }
                            } catch (SQLException e) {
                                System.out.println("Error SQL: " + e.getMessage());
                            } catch (IllegalArgumentException e) {
                                System.out.println("Entrada no válida: " + e.getMessage());
                            }

                        } while (n != 0);
                        break;
                    case 7:
                        do {
                            System.out.println("MENÚ LÍNEAS DE COMPRA\n1. Insertar lineas de compra\n2. Ver todas las lineas de compra\n3. Ver por ID las lineas de compra\n4. Borrar por ID las lineas de compra\n5. Modificar número de líneas\n6.Modificar id del administrador asignado\n7.Modificar id del material asignado\n0. Volver");
                            n = scanner.nextInt();
                            scanner.nextLine(); 

                            try {
                                switch (n) {
                                    case 1: 
                                        System.out.println("ID de la línea de compra: ");
                                        int id = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Número de líneas: ");
                                        int nlineas = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Administrativos:");
                                        AdministrativoDB.verAdministrativos(con);  

                                        System.out.println("ID del administrativo: ");
                                        int ida = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Materiales:");
                                        MaterialesDB.verMateriales(con);  

                                        System.out.println("ID del material: ");
                                        int idM = scanner.nextInt();
                                        scanner.nextLine();

                                        LineaCompraDB.insertarLineaCompra(con, id, nlineas, ida, idM);
                                        break;
                                    
                                    case 2:
                                        LineaCompraDB.verLineasCompra(con);
                                        break;
                                    case 3: 
                                        System.out.println("ID de la línea de compra a buscar: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        LineaCompraDB.verLineaCompraPorId(con, id);
                                        break;
                                    
                                    case 4: 
                                        LineaCompraDB.verLineasCompra(con);
                                        System.out.println("ID de la línea de compra a borrar: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        LineaCompraDB.borrarLineaCompraPorId(con, id);
                                        break;
                                    
                                    case 5: 
                                        LineaCompraDB.verLineasCompra(con);
                                        System.out.println("ID de la línea de compra para modificar número de líneas: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Nuevo número de líneas: ");
                                        int nuevaNlineas = scanner.nextInt();
                                        scanner.nextLine();

                                        LineaCompraDB.modificarNlineas(con, id, nuevaNlineas);
                                        break;
                                    
                                    case 6:
                                        LineaCompraDB.verLineasCompra(con); 
                                        System.out.println("ID de la linea de compra para modificar ID Administrador: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo ID Administrador: ");
                                        int nuevoIdA = scanner.nextInt();
                                        scanner.nextLine();
                                        LineaCompraDB.modificarIdA(con, id, nuevoIdA);
                                        break;
                                    
                                    
                                    case 7:
                                        LineaCompraDB.verLineasCompra(con); 
                                        System.out.println("ID de la linea de compra para modificar ID Material: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo ID Material: ");
                                        int nuevoIdM = scanner.nextInt();
                                        scanner.nextLine();
                                        LineaCompraDB.modificarIdM(con, id, nuevoIdM);
                                        break;
                                    
                                    case 0:
                                        System.out.println("Volviendo al menú principal");
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                }
                            } catch (SQLException e) {
                                System.out.println("Error SQL: " + e.getMessage());
                            } catch (IllegalArgumentException e) {
                                System.out.println("Entrada no válida: " + e.getMessage());
                            }

                        } while (n != 0);

                        break;
                    case 8:
                    do {
                        System.out.println("MENÚ MATERIALES\n1. Insertar material\n2. Ver todos los materiales\n3. Ver material por ID\n4. Borrar material por ID\n5. Modificar material\n0. Volver");
                        
                        n = scanner.nextInt();
                        scanner.nextLine();

                        try {
                            switch (n) {
                                case 1: 
                                    System.out.println("ID del material: ");
                                    int id = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("Nombre del material: ");
                                    String nombre = scanner.nextLine();

                                    System.out.println("Stock: ");
                                    int stock = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("Coste: ");
                                    double coste = scanner.nextDouble();
                                    scanner.nextLine();
                                        
                                    System.out.println("Almacenes:");
                                    AlmacenDB.verAlmacenes(con);

                                    System.out.println("ID del almacén: ");
                                    int idA = scanner.nextInt();
                                    scanner.nextLine();

                                    MaterialesDB.insertarMaterial(con, id, nombre, stock, coste, idA);
                                    break;
                                
                                case 2:
                                    MaterialesDB.verMateriales(con);
                                    break;

                                case 3: 
                                    System.out.println("ID del material a buscar: ");
                                    id = scanner.nextInt();
                                    scanner.nextLine();

                                    MaterialesDB.verMaterialPorId(con, id);
                                    break;
                                
                                case 4: 
                                    MaterialesDB.verMateriales(con);
                                    System.out.println("ID del material a borrar: ");
                                    id = scanner.nextInt();
                                    scanner.nextLine();

                                    MaterialesDB.borrarMateriaPorId(con, id);
                                    break;
                                
                                case 5: 
                                    MaterialesDB.verMateriales(con);
                                    System.out.println("ID del material a modificar: ");
                                    id = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("¿Qué quieres modificar?");
                                    System.out.println("1. Nombre");
                                    System.out.println("2. Stock");
                                    System.out.println("3. Coste");
                                    System.out.println("4. ID del almacén");
                                    int campo = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (campo) {
                                        case 1:
                                            System.out.println("Nuevo nombre: ");
                                            String nuevoNombre = scanner.nextLine();
                                            MaterialesDB.modificarNombre(con, id, nuevoNombre);
                                            break;
                                        case 2:
                                            System.out.println("Nuevo stock: ");
                                            int nuevoStock = scanner.nextInt();
                                            scanner.nextLine();
                                            MaterialesDB.modificarStock(con, id, nuevoStock);
                                            break;
                                        case 3:
                                            System.out.println("Nuevo coste: ");
                                            double nuevoCoste = scanner.nextDouble();
                                            scanner.nextLine();
                                            MaterialesDB.modificarCoste(con, id, nuevoCoste);
                                            break;
                                        case 4:
                                            System.out.println("Nuevo ID del almacén: ");
                                            int nuevoIdA = scanner.nextInt();
                                            scanner.nextLine();
                                            MaterialesDB.modificarIdA(con, id, nuevoIdA);
                                            break;
                                        default:
                                            System.out.println("Opción no válida");
                                    }
                                    break;
                                
                                case 0:
                                    System.out.println("Volviendo al menú principal");
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                            }
                        } catch (SQLException e) {
                            System.out.println("Error SQL: " + e.getMessage());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Entrada no válida: " + e.getMessage());
                        }

                    } while (n != 0);
                        break;
                    case 9:
                        do {
                            System.out.println("MENÚ ORDENES DE COMPRA\n1. Insertar orden de compra\n2. Ver todas las ordenes de compra\n3. Ver por ID la orden de compra \n4. Borrar por ID la orden de compra\n5. Modificar Fecha\n6.Modificar id del administrador asignado\n7.Modificar id del proveedor asignado\n0. Volver");
                            n = scanner.nextInt();
                            scanner.nextLine();

                            try {
                                switch (n) {
                                    case 1: 
                                        System.out.println("ID de la orden de compra: ");
                                        int id = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Lista de Presupuestos:");
                                        PresupuestoDB.verPresupuestos(con);

                                        System.out.println("ID del presupuesto asociado:");
                                        int idP = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Lista de Administrativos:");
                                        AdministrativoDB.verAdministrativos(con);

                                        System.out.println("ID del administrativo responsable:");
                                        int idA = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Fecha (yyyy-mm-dd):");
                                        String fechaStr = scanner.nextLine();
                                        Date fecha = Date.valueOf(fechaStr); 

                                        OrdenCompraDB.insertarOrdenCompra(con, id, fecha, idP, idA);
                                        break;
                                    
                                    case 2:
                                        OrdenCompraDB.verOrdenesCompra(con);
                                        break;
                                    case 3: 
                                        System.out.println("ID de la orden a buscar:");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        OrdenCompraDB.verOrdenCompraPorId(con, id);
                                        break;
                                
                                    case 4: 
                                        OrdenCompraDB.verOrdenesCompra(con);
                                        System.out.println("ID de la orden a borrar:");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        OrdenCompraDB.borrarOrdenCompraPorId(con, id);
                                        break;
                                    
                                    case 5: 
                                        OrdenCompraDB.verOrdenesCompra(con);
                                        System.out.println("ID de la orden a modificar la fecha:");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nueva fecha (yyyy-mm-dd):");
                                        fechaStr = scanner.nextLine();
                                        Date nuevaFecha = Date.valueOf(fechaStr);
                                        OrdenCompraDB.modificarFechaOrden(con, id, nuevaFecha);
                                        break;
                                    
                                    case 6:
                                        OrdenCompraDB.verOrdenesCompra(con);
                                        System.out.println("ID de la orden de compra para modificar ID Administrador: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo ID Administrador: ");
                                        int nuevoIdA = scanner.nextInt();
                                        scanner.nextLine();
                                        OrdenCompraDB.modificarIdA(con, id, nuevoIdA);
                                        break;
                                    
                                    case 7:
                                        OrdenCompraDB.verOrdenesCompra(con);
                                        System.out.println("ID de la orden de compra para modificar ID proveedor: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo ID proveedor: ");
                                        int nuevoIdP = scanner.nextInt();
                                        scanner.nextLine();
                                        OrdenCompraDB.modificarIdP(con, id, nuevoIdP);
                                        break;
                                    
                                    case 0:
                                        System.out.println("Volviendo al menú");
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                }
                            } catch (SQLException e) {
                                System.out.println("Error SQL: " + e.getMessage());
                            } catch (IllegalArgumentException e) {
                                System.out.println("Formato de fecha incorrecto. Use yyyy-mm-dd.");
                            }

                        } while (n != 0);                    
                        break;
                    case 10:
                        do {
                            System.out.println("\nMENÚ PRESUPUESTOS\n1. Insertar presupuesto\n2. Ver todos los presupuestos\n3. Ver por ID el presupuesto\n4. Borrar por ID el presupuesto\n5. Modificar cantidad\n6.Modificar ID Cliente\n7. Modificar ID Equipo\n8. Modificar ID Factura\n0. Volver");
                            n = scanner.nextInt();
                            scanner.nextLine();
                            try {
                                switch (n) {
                                    case 1: 
                                        System.out.println("ID del presupuesto: ");
                                        int id = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Cantidad: ");
                                        double cantidad = scanner.nextDouble();
                                        scanner.nextLine();

                                        System.out.println("\nEquipos disponibles");
                                        EquipoDB.verEquipos(con);
                                        System.out.println("ID del equipo: ");
                                        int idE = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("\nClientes disponibles");
                                        ClienteDB.verClientes(con);
                                        System.out.println("ID del cliente: ");
                                        int idC = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("\nFacturas disponibles");
                                        FacturaDB.verFacturas(con);
                                        System.out.println("ID de la factura: ");
                                        int idF = scanner.nextInt();
                                        scanner.nextLine();

                                        PresupuestoDB.insertarPresupuesto(con, id, cantidad, idE, idC, idF);
                                        break;
                                    

                                    case 2:
                                        PresupuestoDB.verPresupuestos(con);
                                        break;

                                    case 3: 
                                        System.out.println("ID del presupuesto a buscar: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        PresupuestoDB.verPresupuestoPorId(con, id);
                                        break;
                                    

                                    case 4: 
                                        PresupuestoDB.verPresupuestos(con);
                                        System.out.println("ID del presupuesto a borrar: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        PresupuestoDB.borrarPresupuestoPorId(con, id);
                                        break;
                                    

                                    case 5: 
                                        PresupuestoDB.verPresupuestos(con);
                                        System.out.println("ID del presupuesto para modificar la cantidad: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Nueva cantidad: ");
                                        double nuevaCantidad = scanner.nextDouble();
                                        scanner.nextLine();

                                        PresupuestoDB.modificarCantidad(con, id, nuevaCantidad);
                                        break;
                                    
                                    case 6: 
                                        PresupuestoDB.verPresupuestos(con);
                                        System.out.println("ID del presupuesto para modificar ID cliente: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo ID cliente: ");
                                        int nuevoIdC = scanner.nextInt();
                                        scanner.nextLine();
                                        PresupuestoDB.modificarIdC(con, id, nuevoIdC);
                                        break;
                                    
                                    case 7: 
                                        PresupuestoDB.verPresupuestos(con);
                                        System.out.println("ID del presupuesto para modificar ID equipo: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo ID equipo: ");
                                        int nuevoIdE = scanner.nextInt();
                                        scanner.nextLine();
                                        PresupuestoDB.modificarIdE(con, id, nuevoIdE);
                                        break;
                                    
                                    case 8: 
                                        PresupuestoDB.verPresupuestos(con);
                                        System.out.println("ID del presupuesto para modificar ID factura: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo ID factura: ");
                                        int nuevoIdF = scanner.nextInt();
                                        scanner.nextLine();
                                        PresupuestoDB.modificarIdF(con, id, nuevoIdF);
                                        break;
                                    

                                    case 0:
                                        System.out.println("Volviendo al menú principal.");
                                        break;

                                    default:
                                        System.out.println("Opción no válida.");
                                }
                            } catch (SQLException e) {
                                System.out.println("Error SQL: " + e.getMessage());
                            } catch (IllegalArgumentException e) {
                                System.out.println("Entrada no válida: " + e.getMessage());
                            }

                        } while (n != 0);                    
                        break;
                    case 11:
                        do {
                            System.out.println("MENÚ PROVEEDORES\n1. Insertar proveedor\n2. Ver todos los proveedores\n3. Ver por ID el proveedor\n4. Borrar por ID el proveedor\n5. Modificar nombre\n6. Modificar teléfono\n0. Volver");
                            n = scanner.nextInt();
                            scanner.nextLine();

                            try {
                                switch (n) {
                                    case 1: 
                                        System.out.println("ID del proveedor: ");
                                        int id = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Nombre del proveedor: ");
                                        String nombre = scanner.nextLine();

                                        System.out.println("Teléfono del proveedor: ");
                                        String telefono = scanner.nextLine();

                                        ProveedorDB.insertarProveedor(con, id, nombre, telefono);
                                        break;
                                    
                                    case 2:
                                        ProveedorDB.verProveedores(con);
                                        break;
                                    case 3: 
                                        System.out.println("ID del proveedor a buscar: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        ProveedorDB.verProveedorPorId(con, id);
                                        break;
                                    
                                    case 4: 
                                        ProveedorDB.verProveedores(con);
                                        System.out.println("ID del proveedor a borrar: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        ProveedorDB.borrarProveedorPorId(con, id);
                                        break;
                                    
                                    case 5: 
                                        ProveedorDB.verProveedores(con);
                                        System.out.println("ID del proveedor para modificar nombre: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo nombre: ");
                                        String nuevoNombre = scanner.nextLine();
                                        ProveedorDB.modificarNombre(con, id, nuevoNombre);
                                        break;
                                    
                                    case 6: 
                                        ProveedorDB.verProveedores(con);
                                        System.out.println("ID del proveedor para modificar teléfono: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo teléfono: ");
                                        String nuevoTelefono = scanner.nextLine();
                                        ProveedorDB.modificarTelefono(con, id, nuevoTelefono);
                                        break;
                                    
                                    case 0:
                                        System.out.println("Volviendo al menú principal");
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                }
                            } catch (SQLException e) {
                                System.out.println("Error SQL: " + e.getMessage());
                            } catch (IllegalArgumentException e) {
                                System.out.println("Entrada no válida: " + e.getMessage());
                            }

                        } while (n != 0);
                        
                        break;
                    case 12:
                        do {
                            System.out.println("MENÚ TÉCNICOS\n1. Insertar técnico\n2. Ver todos los técnicos\n3. Ver por ID el técnico\n4. Borrar por ID un técnico\n5. Modificar Nombre\n6. Modificar Teléfono\n7.Leer datos de un archivo y añadir a la base de datos\n8.Añadir datos de la base de datos a un fichero\n0. Volver");
                            n = scanner.nextInt();
                            scanner.nextLine();

                            try {
                                switch (n) {
                                    case 1: 
                                        System.out.println("ID: ");
                                        int id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nombre: ");
                                        String nombre = scanner.nextLine();
                                        System.out.println("Teléfono: ");
                                        String tlf = scanner.nextLine();
                                        TecnicoDB.insertarTecnico(con, id, tlf, nombre, tlf);
                                        break;
                                    
                                    case 2:
                                        TecnicoDB.verTecnicos(con);
                                        break;
                                    case 3: 
                                        System.out.println("ID a buscar: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        TecnicoDB.verTecnicoPorId(con, id);
                                        break;
                                    
                                    case 4: 
                                        TecnicoDB.verTecnicos(con);
                                        System.out.println("Dime el id del técnico a borrar: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        TecnicoDB.borrarTecnicoPorId(con, id);
                                        break;
                                    
                                    case 5: 
                                        TecnicoDB.verTecnicos(con);
                                        System.out.println("ID del técnico que quieres cambiar el nombre: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo nombre: ");
                                        nombre = scanner.nextLine();
                                        TecnicoDB.modificarNombre(con, id, nombre);
                                        break;
                                    
                                    case 6: 
                                        TecnicoDB.verTecnicos(con);
                                        System.out.println("ID del técnico que quieres cambiar el teléfono: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nuevo teléfono: ");
                                        String tel = scanner.nextLine();
                                        TecnicoDB.modificarTelefono(con, id, tel);
                                        break;
                                     case 7:
                                            System.out.println("Dime el nombre del fichero:");
                                            String fichero = scanner.nextLine(); 
                                            String rutaCompleta = "Programa/Informes/"+ fichero;

                                            TecnicoDB.leerTecnicosDesdeArch(con, rutaCompleta);
                                            break;
                                    case 8:
                                            System.out.println("Dime el nombre del fichero:");
                                            fichero = scanner.nextLine(); 
                                             rutaCompleta = "Programa/Informes/"+ fichero;

                                            TecnicoDB.escribirTecnicosEnArch(con, rutaCompleta);
                                            break;
                                    case 0:
                                        System.out.println("Volviendo al menú principal");
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                        break;
                                }
                            } catch (SQLException e) {
                                System.out.println("Error SQL: " + e.getMessage());
                            }
                        } while (n != 0);                    
                        break;
                    case 0:
                        System.out.println("Cerrando aplicación...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
                System.out.println("Que quieres hacer?");
                System.out.println("MENÚ PRINCIPAL\n1. Administrativos\n2. Almacenes\n3. Clientes\n4. Empleados\n5. Equipos\n6. Facturas\n7. Líneas de Compra\n8. Materiales\n9. Órdenes de Compra\n10. Presupuestos\n11. Proveedores\n12. Técnicos\n0. Salir");
                n = scanner.nextInt();
            } while (n != 0);

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}
