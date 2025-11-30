package centromedico.cola;

import centromedico.cola.Paciente;
import centromedico.cola.ColaPacientes;
import centromedico.pila.PilaHistorial;
import java.util.Scanner;

public class MenuColayPila {

    static ColaPacientes colaPrincipal = new ColaPacientes();
    static PilaHistorial pilaHistorial = new PilaHistorial();
    static Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n========================================");
            System.out.println("   SISTEMA DE ATENCION MEDICA");
            System.out.println("========================================");
            System.out.println("1. Registrar Paciente ");
            System.out.println("2. Atender Siguiente Paciente");
            System.out.println("3. Ver Cola de Espera");
            System.out.println("4. Ver Historial de Acciones ");
            System.out.println("5. Deshacer Ultima Accion ");
            System.out.println("0. Salir");
            System.out.println("========================================");
            System.out.print("Ingrese una opcion: ");
            
            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("¡Error! Debe ingresar un numero.");
                sc.nextLine();
                opcion = -1;
                continue;
            }

            System.out.println("\n--- Resultado ---");
            switch (opcion) {
                case 1: registrarPaciente(); break;
                case 2: atenderPaciente(); break;
                case 3: verCola(); break;
                case 4: verHistorial(); break;
                case 5: deshacerAccion(); break;
                case 0: System.out.println("Cerrando sistema..."); break;
                default: System.out.println("Opción no válida. Intente de nuevo.");
            }

            if(opcion != 0) {
                System.out.print("\n[Presione Enter para volver al menu]");
                sc.nextLine();
            }

        } while (opcion != 0);
    }


    private static void registrarPaciente() {
        System.out.println("REGISTRO DE NUEVO PACIENTE");
        System.out.print("- Ingrese DNI: ");
        String dni = sc.nextLine();
        System.out.print("- Ingrese Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("- Ingrese Motivo: ");
        String motivo = sc.nextLine();

        if (dni.isEmpty() || nombre.isEmpty()) {
            System.out.println("¡ERROR! DNI y Nombre son obligatorios.");
            return;
        }

        Paciente p = new Paciente(dni, nombre, motivo);
        colaPrincipal.encolar(p);

        pilaHistorial.push("Registro: Se añadió a la cola a " + nombre);
        
        System.out.println("Paciente registrado exitosamente.");
    }

    private static void atenderPaciente() {
        if (colaPrincipal.estaVacia()) {
            System.out.println(" La cola está vacía. No hay nadie para atender.");
            return;
        }

        Paciente p = colaPrincipal.desencolar();

        if (p != null) {

            pilaHistorial.push("Atención: Se atendió a " + p.getNombre());

            System.out.println("ATENDIENDO A PACIENTE:");
            System.out.println("   Nombre: " + p.getNombre());
            System.out.println("   Motivo: " + p.getMotivo());
            System.out.println("\n   [SIMULACION] El paciente ha sido derivado a la Lista Enlazada.");
        }
    }

    private static void verCola() {
        System.out.println("ESTADO ACTUAL DE LA COLA:");

        System.out.println(colaPrincipal.obtenerListadoCola());
    }

    private static void verHistorial() {
        System.out.println("HISTORIAL DE ACCIONES (Recientes arriba):");
        System.out.println(pilaHistorial.obtenerListadoHistorial());
    }

    private static void deshacerAccion() {
        if (pilaHistorial.estaVacia()) {
            System.out.println(" Historial vacio. Nada que deshacer.");
            return;
        }
        String accion = pilaHistorial.pop();
        System.out.println("️ ACCION DESHECHA (Eliminada del registro):");
        System.out.println("   \"" + accion + "\"");
    }
}