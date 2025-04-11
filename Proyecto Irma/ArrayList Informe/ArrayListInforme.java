import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListInforme {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<InformeFinanciero> informes = new ArrayList<>();

        System.out.print("Ingrese la cantidad de informes a registrar: ");
        int cantidad = scanner.nextInt();

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingrese los datos del informe " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            System.out.print("Fecha de generación: ");
            String fechaGeneracion = scanner.nextLine();
            System.out.print("Costos: ");
            double costos = scanner.nextDouble();
            System.out.print("Ingresos: ");
            double ingresos = scanner.nextDouble();

            informes.add(new InformeFinanciero(id, fechaGeneracion, costos, ingresos));
        }

        System.out.println("\nVisualización de informes:");
        for (InformeFinanciero informe : informes) {
            informe.generar();
            informe.visualizar();
            System.out.println();
        }

        scanner.close();
    }
}

class InformeFinanciero {
    private int id;
    private String fechaGeneracion;
    private double costos;
    private double ingresos;
    private double rentabilidad;

    public InformeFinanciero(int id, String fechaGeneracion, double costos, double ingresos) {
        this.id = id;
        this.fechaGeneracion = fechaGeneracion;
        this.costos = costos;
        this.ingresos = ingresos;
        calcularRentabilidad();
    }

    public void generar() {
        System.out.println("Generando informe financiero...");
    }

    public void visualizar() {
        System.out.println("Informe ID: " + id);
        System.out.println("Fecha de generación: " + fechaGeneracion);
        System.out.println("Costos: " + costos + ", Ingresos: " + ingresos + ", Rentabilidad: " + rentabilidad);
    }

    public void calcularRentabilidad() {
        rentabilidad = ingresos - costos;
    }
}
