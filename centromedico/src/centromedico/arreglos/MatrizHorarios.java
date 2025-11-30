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

    // Registrar horario con validación
    public void asignarHorario(int dia, int medicoIndex, int valor) {

        // Validación de rangos
        if (dia < 0 || dia >= matriz.length) {
            System.out.println("❌ Error: el día no existe (0 a " + (matriz.length - 1) + ").");
            return;
        }

        if (medicoIndex < 0 || medicoIndex >= matriz[0].length) {
            System.out.println("❌ Error: la posición del médico no es válida (0 a " + (matriz[0].length - 1) + ").");
            return;
        }

        if (valor != 0 && valor != 1) {
            System.out.println("❌ Valor inválido. Solo 0 o 1.");
            return;
        }

        matriz[dia][medicoIndex] = valor;
        System.out.println("✔ Horario asignado correctamente.");
    }

    public void mostrarHorarios() {
        System.out.println("\n=== Horarios (0 = Libre / 1 = Atiende) ===");

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Día " + i + ": ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
