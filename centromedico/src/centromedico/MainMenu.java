/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centromedico;

import java.util.Scanner;
import centromedico.arreglos.MenuArreglos;

// import centromedico.listas.MenuListas;
   import centromedico.cola.MenuColayPila;


public class MainMenu {

    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("\n========== MENÚ PRINCIPAL ==========");
            System.out.println("1. Gestión de Médicos (Arreglos y Matriz)");
            System.out.println("2. Pacientes Atendidos (Lista Enlazada)");
            System.out.println("3. Atención de Pacientes (Cola y Pila)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> {
                    MenuArreglos menuA = new MenuArreglos();
                    menuA.mostrarMenu();
                }

                case 2 -> {
                    System.out.println(">> Módulo de Listas no está integrado aún.");
                    // CUANDO TU COMPAÑERO TE PASE SU CÓDIGO:
                    // MenuListas menuL = new MenuListas();
                    // menuL.mostrarMenu();
                }

                case 3 -> {
                     MenuColayPila menuCyP = new MenuColayPila();
                     menuCyP.mostrarMenu();
                }

                case 4 -> System.out.println("Saliendo del sistema...");

                default -> System.out.println("❌ Opción no válida.");
            }

        } while (opcion != 4);
    }
}
