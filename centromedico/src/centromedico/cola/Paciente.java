package centromedico.cola;

public class Paciente {
    private String dni;
    private String nombre;
    private String motivo;

    public Paciente(String dni, String nombre, String motivo) {
        this.dni = dni;
        this.nombre = nombre;
        this.motivo = motivo;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getMotivo() { return motivo; }

    @Override
    public String toString() {
        return "DNI: " + dni + " - " + nombre + " (" + motivo + ")";
    }
}
