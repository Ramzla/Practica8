public class CheckPoint {
    private String nombre;
    private int posicionX;
    private int posicionY;
    private boolean activado;

    public CheckPoint(String nombre, int posicionX, int posicionY) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío.");
        }

        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public boolean isActivado() {
        return activado;
    }

    public void activar() {
        activado = true;
        System.out.println("Checkpoint activado: " + nombre);
    }

    @Override
    public String toString() {
        return nombre
                + " (" + posicionX + ", " + posicionY + ")"
                + " - activado: " + (activado ? "Sí" : "No");
    }
}