/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centromedico.arreglos;


public class MatrizHorarios {

    private int[][] matriz;

    public MatrizHorarios(int dias, int numMedicos) {
        matriz = new int[dias][numMedicos];
    }

   
    public void asignarHorario(int dia, int medicoIndex, int valor) {

      
        if (dia < 0 || dia >= matriz.length) {
            System.out.println("Error: el dia no existe (0 a " + (matriz.length - 1) + ").");
            return;
        }

        if (medicoIndex < 0 || medicoIndex >= matriz[0].length) {
            System.out.println("Error: la posicion del medico no es valida (0 a " + (matriz[0].length - 1) + ").");
            return;
        }

        if (valor != 0 && valor != 1) {
            System.out.println("Valor invalido. Solo 0 o 1.");
            return;
        }

        matriz[dia][medicoIndex] = valor;
        System.out.println("Horario asignado correctamente.");
    }

    public void mostrarHorarios() {
        System.out.println("\n=== Horarios (0 = Libre / 1 = Atiende) ===");

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Dia " + i + ": ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
