/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centromedico.arreglos;

import java.util.Scanner;

public class MenuArreglos {

    private Scanner sc = new Scanner(System.in);
    private RegistroMedicos registro;
    private MatrizHorarios horarios;

    public MenuArreglos() {
        registro = new RegistroMedicos(20);  
        horarios = new MatrizHorarios(7, 20); 
    }

   public void mostrarMenu() {
    int opcion;
        do {
            System.out.println("\n====== MENU - GESTION DE MEDICOS ======");
            System.out.println("1. Registrar medico");
            System.out.println("2. Mostrar medicos");
            System.out.println("3. Buscar medico");
            System.out.println("4. Actualizar especialidad");
            System.out.println("5. Eliminar medico");
            System.out.println("6. Asignar horario");
            System.out.println("7. Mostrar horarios");
            System.out.println("8. Volver");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> registrarMedico();
                case 2 -> registro.mostrarMedicos();
                case 3 -> buscarMedico();
                case 4 -> actualizarEspecialidad();
                case 5 -> eliminarMedico();
                case 6 -> asignarHorario();
                case 7 -> horarios.mostrarHorarios();
                case 8 -> System.out.println("Volviendo...");
                default -> System.out.println("Opcion invalida.");
            }

        } while (opcion != 8);
    }


    private void registrarMedico() {
        System.out.print("ID del médico: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Especialidad: ");
        String esp = sc.nextLine();

        boolean ok = registro.agregarMedico(new Medico(id, nombre, esp));

        if (ok) System.out.println("Médico registrado.");
    }

    private void buscarMedico() {
        System.out.print("Ingrese ID: ");
        int id = sc.nextInt();

        Medico m = registro.buscarPorId(id);

        if (m != null) System.out.println(m);
        else System.out.println("No encontrado.");
    }

    private void actualizarEspecialidad() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nueva especialidad: ");
        String esp = sc.nextLine();

        if (registro.actualizarEspecialidad(id, esp))
            System.out.println("Especialidad actualizada.");
        else
            System.out.println("Médico no encontrado.");
    }

    private void eliminarMedico() {
        System.out.print("ID: ");
        int id = sc.nextInt();

        if (registro.eliminar(id))
            System.out.println("Médico eliminado.");
        else
            System.out.println("Médico no encontrado.");
    }

    private void asignarHorario() {
        if (registro.getContador() == 0) {
            System.out.println("No hay médicos registrados.");
            return;
        }

        System.out.print("Día (0=Lun ... 6=Dom): ");
        int dia = sc.nextInt();

        if (dia < 0 || dia > 6) {
            System.out.println("Día inválido. Solo 0 a 6.");
            return;
        }

        System.out.print("Posición del médico (0 a " + (registro.getContador() - 1) + "): ");
        int pos = sc.nextInt();

        if (pos < 0 || pos >= registro.getContador()) {
            System.out.println("Posición inválida.");
            return;
        }

        System.out.print("Valor (0=libre, 1=atiende): ");
        int val = sc.nextInt();

        horarios.asignarHorario(dia, pos, val);
    }
}
