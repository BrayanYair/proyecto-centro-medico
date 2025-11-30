package centromedico.pila;

public class NodoPila {
    public String accion;
    public NodoPila abajo;

    public NodoPila(String accion) {
        this.accion = accion;
        this.abajo = null;
    }
}