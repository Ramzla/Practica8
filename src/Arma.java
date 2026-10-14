public class Arma implements Inventariable {
    private String nombre;
    private int daño;
    private double alcance;

    public Arma(String nombre, int daño, double alcance) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío.");
        }

        if (daño < 0 || !Double.isFinite(alcance) || alcance < 0) {
            throw new IllegalArgumentException(
                    "Daño y alcance deben ser válidos y no negativos.");
        }

        this.nombre = nombre;
        this.daño = daño;
        this.alcance = alcance;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDaño() {
        return daño;
    }

    public double getAlcance() {
        return alcance;
    }

    @Override
    public void registrar() {
        System.out.println("Arma registrada: " + nombre);
    }

    @Override
    public void borrar() {
        System.out.println("Arma eliminada: " + nombre);
    }

    @Override
    public String toString() {
        return "Arma: " + nombre
                + ", daño: " + daño
                + ", alcance: " + alcance;
    }
}