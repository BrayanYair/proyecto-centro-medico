package centromedico.pila;

public class PilaHistorial {
    private NodoPila cima;

    public PilaHistorial() {
        this.cima = null;
    }

    public void push(String accion) {
        NodoPila nuevo = new NodoPila(accion);
        if (cima == null) {
            cima = nuevo;
        } else {
            nuevo.abajo = cima;
            cima = nuevo;
        }
    }

    public String pop() {
        if (cima == null) {
            return null;
        }
        String accionSacada = cima.accion;
        cima = cima.abajo;
        return accionSacada;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public String obtenerListadoHistorial() {
        if (cima == null) return "  [Historial vacío]";
        
        StringBuilder sb = new StringBuilder();
        NodoPila actual = cima;
        while (actual != null) {
            sb.append("  > ").append(actual.accion).append("\n");
            actual = actual.abajo;
        }
        return sb.toString();
    }
}
