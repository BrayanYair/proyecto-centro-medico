/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centromedico.listas;

/**
 *
 * @author Dayana
 */
public class Paciente {
  private String nombre;
    private String dni;
    private int prioridad; // mayor = mas urgente

    public Paciente(String nombre, String dni, int prioridad) {
        this.nombre = nombre;
        this.dni = dni;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return "Paciente [nombre=" + nombre + ", DNI=" + dni + ", prioridad=" + prioridad + "]";
    }
}  

