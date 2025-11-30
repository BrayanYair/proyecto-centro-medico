/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centromedico.arreglos;


public class Horario {
    private int dia; 
    private int medicoId;

    public Horario(int dia, int medicoId) {
        this.dia = dia;
        this.medicoId = medicoId;
    }

    public int getDia() { return dia; }
    public int getMedicoId() { return medicoId; }
}
