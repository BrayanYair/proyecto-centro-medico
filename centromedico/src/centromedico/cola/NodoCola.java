package centromedico.cola;
import centromedico.cola.Paciente;

public class NodoCola {
    public Paciente dato;
    public NodoCola siguiente;

    public NodoCola(Paciente dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}