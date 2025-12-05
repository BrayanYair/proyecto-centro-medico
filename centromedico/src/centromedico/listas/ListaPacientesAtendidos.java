/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centromedico.listas;

/**
 *
 * @author Dayana
 */
public class ListaPacientesAtendidos {
    private NodoPaciente inicio;
    private NodoPaciente fin;

    public ListaPacientesAtendidos() {
        inicio = null;
        fin = null;
    }

    public void insertarFinal(Paciente p) {
        NodoPaciente nuevo = new NodoPaciente(p);
        if (inicio == null) {
            inicio = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public void insertarInicio(Paciente p) {
        NodoPaciente nuevo = new NodoPaciente(p);
        if (inicio == null) {
            inicio = fin = nuevo;
        } else {
            nuevo.siguiente = inicio;
            inicio = nuevo;
        }
    }

    public boolean eliminarPorDNI(String dni) {
        if (inicio == null) return false;

        if (inicio.paciente.getDni().equals(dni)) {
            inicio = inicio.siguiente;
            if (inicio == null) fin = null;
            return true;
        }

        NodoPaciente actual = inicio;
        while (actual.siguiente != null && !actual.siguiente.paciente.getDni().equals(dni)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            if (actual.siguiente == fin) fin = actual;
            actual.siguiente = actual.siguiente.siguiente;
            return true;
        }

        return false;
    }

    public NodoPaciente buscar(String dato) {
        NodoPaciente actual = inicio;
        while (actual != null) {
            if (actual.paciente.getNombre().equalsIgnoreCase(dato) || actual.paciente.getDni().equals(dato)) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void mostrarLista() {
        if (inicio == null) {
            System.out.println("La lista esta vacia.");
            return;
        }
        NodoPaciente actual = inicio;
        while (actual != null) {
            System.out.println(actual.paciente);
            actual = actual.siguiente;
        }
    }

    public void ordenarPorPrioridad() {
        if (inicio == null || inicio.siguiente == null) return;
        boolean cambio;
        do {
            NodoPaciente actual = inicio;
            NodoPaciente anterior = null;
            cambio = false;
            while (actual != null && actual.siguiente != null) {
                if (actual.paciente.getPrioridad() < actual.siguiente.paciente.getPrioridad()) {
                    NodoPaciente temp = actual.siguiente;
                    actual.siguiente = temp.siguiente;
                    temp.siguiente = actual;
                    if (anterior == null) inicio = temp;
                    else anterior.siguiente = temp;
                    anterior = temp;
                    cambio = true;
                } else {
                    anterior = actual;
                    actual = actual.siguiente;
                }
            }
        } while (cambio);
    }

    public ListaPacientesAtendidos clonar() {
        ListaPacientesAtendidos clon = new ListaPacientesAtendidos();
        NodoPaciente actual = inicio;
        while (actual != null) {
            clon.insertarFinal(new Paciente(actual.paciente.getNombre(), actual.paciente.getDni(), actual.paciente.getPrioridad()));
            actual = actual.siguiente;
        }
        return clon;
    }

    public void fusionar(ListaPacientesAtendidos otra) {
        NodoPaciente actual = otra.inicio;
        while (actual != null) {
            this.insertarFinal(new Paciente(actual.paciente.getNombre(), actual.paciente.getDni(), actual.paciente.getPrioridad()));
            actual = actual.siguiente;
        }
    }
} 

