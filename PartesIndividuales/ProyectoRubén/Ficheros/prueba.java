/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ficheros;

/**
 *
 * @author ruben
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class prueba{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estimacion> estimacions = new ArrayList<>();
        int x =0;

        do{
            System.out.println("1. Agregar Mano de Obra\n2.Agregar Material\n3. Mostrar todas las estimaciones\n4. Guardar estimaciones en archivo HTML");
            x=scanner.nextInt();
            scanner.nextLine();
            switch (x) {
                case 1:
                    // Agregar Mano de Obra
                    System.out.print("Ingrese el nombre de la mano de obra: ");
                    String nombreManoObra = scanner.nextLine();
                    System.out.print("Ingrese el costo de la mano de obra: ");
                    double costoManoObra = scanner.nextDouble();
                    scanner.nextLine();  // Limpiar el buffer
                    estimacions.add(new ManoObra(nombreManoObra, costoManoObra));
                    System.out.println("Mano de obra agregada.");
                    break;

                case 2:
                    // Agregar Material
                    System.out.print("Ingrese el nombre del material: ");
                    String nombreMaterial = scanner.nextLine();
                    System.out.print("Ingrese el costo del material: ");
                    double costoMaterial = scanner.nextDouble();
                    scanner.nextLine();  // Limpiar el buffer
                    estimacions.add(new Material(nombreMaterial, costoMaterial));
                    System.out.println("Material agregado.");
                    break;

                case 3:
                    if (estimacions.isEmpty()) {
                        System.out.println("No hay estimaciones.");
                    } else {
                        leerFileReader("./estimacion.html");
                    }
                    break;

                case 4:
                    escribirFileWriter(estimacions, "./estimacion.html");
                    System.out.println("Estimaciones guardadas en estimacion.html");
                    break;
            }
        }while(x!=0);

        
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
 }
