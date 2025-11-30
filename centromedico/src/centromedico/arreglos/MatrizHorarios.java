/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centromedico.arreglos;

/**
 * Manejo de matriz de horarios: 7 días × médicos registrados.
 * 0 = no atiende, 1 = atiende
 */
public class MatrizHorarios {

    private int[][] matriz;

    public MatrizHorarios(int dias, int numMedicos) {
        matriz = new int[dias][numMedicos];
    }

    // Registrar horario
    public void asignarHorario(int dia, int medicoIndex, int valor) {
        matriz[dia][medicoIndex] = valor;
    }

    // Mostrar matriz completa
    public void mostrarHorarios() {
        System.out.println("=== Horarios (0 = Libre / 1 = Atiende) ===");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Día " + i + ": ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
