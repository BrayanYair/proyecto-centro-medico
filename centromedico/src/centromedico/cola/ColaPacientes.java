package centromedico.cola;

import centromedico.cola.Paciente;

public class ColaPacientes {
    private NodoCola frente, fin;

    public ColaPacientes() {
        this.frente = null;
        this.fin = null;
    }

    public void encolar(Paciente p) {
        NodoCola nuevo = new NodoCola(p);
        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public Paciente desencolar() {
        if (frente == null) {
            return null;
        }
        Paciente pacienteAtendido = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return pacienteAtendido;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public String obtenerListadoCola() {
        if (frente == null) return "  [Cola vacía]";
        
        StringBuilder sb = new StringBuilder();
        NodoCola actual = frente;
        int turno = 1;
        while (actual != null) {
            sb.append("  ").append(turno).append(". ").append(actual.dato.toString()).append("\n");
            actual = actual.siguiente;
            turno++;
        }
        return sb.toString();
    }
}