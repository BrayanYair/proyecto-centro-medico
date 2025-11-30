/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centromedico.arreglos;

import java.util.Scanner;


/**
 * Maneja un arreglo estático de médicos.
 */
public class RegistroMedicos {

    private Medico[] lista;
    private int contador;

    public RegistroMedicos(int capacidad) {
        lista = new Medico[capacidad];
        contador = 0;
    }

    // Insertar médico
    public boolean agregarMedico(Medico m) {
        if (contador >= lista.length) {
            System.out.println("No hay espacio para más médicos.");
            return false;
        }
        lista[contador] = m;
        contador++;
        return true;
    }

    // Buscar por ID
    public Medico buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (lista[i].getId() == id) {
                return lista[i];
            }
        }
        return null;
    }

    // Eliminar por ID
    public boolean eliminar(int id) {
        for (int i = 0; i < contador; i++) {
            if (lista[i].getId() == id) {
                // Compactar arreglo
                for (int j = i; j < contador - 1; j++) {
                    lista[j] = lista[j + 1];
                }
                lista[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }

    // Actualizar especialidad
    public boolean actualizarEspecialidad(int id, String nueva) {
        Medico m = buscarPorId(id);
        if (m != null) {
            m.setEspecialidad(nueva);
            return true;
        }
        return false;
    }

    // Mostrar todos
    public void mostrarMedicos() {
        if (contador == 0) {
            System.out.println("No hay médicos registrados.");
            return;
        }
        for (int i = 0; i < contador; i++) {
            System.out.println(lista[i]);
        }
    }

    public int getContador() { return contador; }
}

