/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centromedico.arreglos;


public class Consultorio {
    private int numero;
    private String descripcion;

    public Consultorio(int numero, String descripcion) {
        this.numero = numero;
        this.descripcion = descripcion;
    }

    public int getNumero() { return numero; }
    public String getDescripcion() { return descripcion; }

    @Override
    public String toString() {
        return "Consultorio Nº " + numero + " - " + descripcion;
    }
}
