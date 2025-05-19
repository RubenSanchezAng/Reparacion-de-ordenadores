/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ficheros;

/**
 *
 * @author ruben
 */
public class Material extends Estimacion {
    public Material(String descripcion, double costo) {
        super(descripcion, costo);
    }

    @Override
    public String getTipo() {
        return "Material";
    }
}