/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centromedico.listas;
import java.util.Scanner;

/**
 *
 * @author Dayana
 */
public class MenuListas {
   private ListaPacientesAtendidos lista;
    private Scanner sc;

    public MenuListas() {
        lista = new ListaPacientesAtendidos();
        sc = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menu Pacientes Atendidos ---");
            System.out.println("1. Registrar paciente atendido (insercion)");
            System.out.println("2. Eliminar paciente por DNI");
            System.out.println("3. Buscar paciente");
            System.out.println("4. Mostrar lista de pacientes atendidos");
            System.out.println("5. Volver al menu principal");
            System.out.print("Ingrese opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch(opcion) {
                case 1: registrarPaciente(); break;
                case 2: eliminarPaciente(); break;
                case 3: buscarPaciente(); break;
                case 4: lista.mostrarLista(); break;
                case 5: System.out.println("Volviendo al menu principal..."); break;
                default: System.out.println("Opcion invalida.");
            }
        } while (opcion != 5);
    }

    private void registrarPaciente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.print("Prioridad (numero entero, mayor = mas urgente): ");
        int prioridad = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        System.out.print("Emergencia? (s/n): ");
        String resp = sc.nextLine();
        Paciente p = new Paciente(nombre, dni, prioridad);
        if (resp.equalsIgnoreCase("s")) lista.insertarInicio(p);
        else lista.insertarFinal(p);
        System.out.println("Paciente registrado.");
    }

    private void eliminarPaciente() {
        System.out.print("Ingrese DNI del paciente a eliminar: ");
        String dni = sc.nextLine();
        if (lista.eliminarPorDNI(dni)) System.out.println("Paciente eliminado.");
        else System.out.println("Paciente no encontrado.");
    }

    private void buscarPaciente() {
        System.out.print("Ingrese nombre o DNI del paciente a buscar: ");
        String dato = sc.nextLine();
        NodoPaciente encontrado = lista.buscar(dato);
        if (encontrado != null) System.out.println("Paciente encontrado: " + encontrado.paciente);
        else System.out.println("Paciente no encontrado.");
    }

    public static void main(String[] args) {
        MenuListas menu = new MenuListas();
        menu.mostrarMenu();
    }
} 

