/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Matt
 */
public class Plato {
    
    private int idPlato;
    private String nombre;
    private String categoria;
    private double precio;
    private boolean disponible;

    public Plato(int idPlato, String nombre, String categoria, double precio, boolean disponible) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return idPlato + " - " + nombre + " - $" + precio;
    }
}
    

