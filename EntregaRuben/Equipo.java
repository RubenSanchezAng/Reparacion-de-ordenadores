class Equipo {
    private String tipo;
    private String modelo;
    private String marca;
    private String estado;

    public Equipo(String tipo, String modelo, String marca, String estado) {
        this.tipo = tipo;
        this.modelo = modelo;
        this.marca = marca;
        this.estado = estado;
    }

    public String toString() {
        return "Equipo: " + tipo + ", Modelo: " + modelo + ", Marca: " + marca + ", Estado: " + estado;
    }
}