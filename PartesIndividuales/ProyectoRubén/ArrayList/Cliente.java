import java.util.*;


class Cliente {
    private String nombre;
    private String contacto;
    private ArrayList<Equipo> equipos = new ArrayList();;

    public Cliente(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
        
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public String toString() {
        System.out.println("Nombre: " + nombre + "Contaco " + contacto);
        if (!equipos.isEmpty()) {
            System.out.println("Equipos:")
            for (Equipo equipo : equipos) {
                System.out.println(equipo.toString());
            }
        }
        return "";
    }
}