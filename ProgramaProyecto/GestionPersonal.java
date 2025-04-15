import java.util.ArrayList;

public class GestionPersonal {
    private ArrayList<Empleado> empleados;

    public GestionPersonal() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public void generarInformeGeneral() {
        System.out.println("===== INFORME DE EMPLEADOS =====");
        for (Empleado e : empleados) {
            System.out.println(e.generarInforme());
        }
    }

    public boolean eliminarEmpleado(String nombre) {
        for (Empleado e : empleados) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                empleados.remove(e);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return empleados;
    }
}
