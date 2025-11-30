/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centromedico.arreglos;

/**
 * Representa un horario asignado a un médico.
 */
public class Horario {
    private int dia;   // 0 = Lunes ... 6 = Domingo
    private int medicoId;

    public Horario(int dia, int medicoId) {
        this.dia = dia;
        this.medicoId = medicoId;
    }

    public int getDia() { return dia; }
    public int getMedicoId() { return medicoId; }
}
