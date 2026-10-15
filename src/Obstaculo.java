public class Obstaculo implements Destruible {
    private String nombre;
    private int daño;
    private int posicionX;
    private int posicionY;
    private boolean destruido;

    public Obstaculo(String nombre, int daño,
                     int posicionX, int posicionY) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío.");
        }

        if (daño < 0) {
            throw new IllegalArgumentException(
                    "El daño no puede ser negativo.");
        }

        this.nombre = nombre;
        this.daño = daño;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDaño() {
        return daño;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public boolean isDestruido() {
        return destruido;
    }

    @Override
    public void destruye() {
        destruido = true;
        System.out.println("Obstáculo destruido: " + nombre);
    }

    @Override
    public String toString() {
        return nombre
                + " (" + posicionX + ", " + posicionY + ")"
                + " - daño: " + daño
                + " - destruido: " + (destruido ? "Sí" : "No");
    }
}