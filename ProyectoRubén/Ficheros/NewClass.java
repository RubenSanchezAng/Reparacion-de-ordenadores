/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ficheros;

/**
 *
 * @author ruben
 */
 abstract class Estimacion {
    protected String descripcion;
    protected double costo;

    public Estimacion(String descripcion, double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public abstract String getTipo();

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }
}
