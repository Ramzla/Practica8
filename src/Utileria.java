public class Utileria implements ElementoDinamico {
    private String nombre;
    private String descripcion;
    private int posicionX;
    private int posicionY;
    private boolean usada;

    public Utileria(String nombre, String descripcion,
                    int posicionX, int posicionY) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío.");
        }

        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La descripción no puede estar vacía.");
        }

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public boolean isUsada() {
        return usada;
    }

    public void usar() {
        usada = true;
        System.out.println("Usando " + nombre + ": " + descripcion);
    }

    @Override
    public void mover(String direccion, int distancia) {
        if (direccion == null || distancia < 0) {
            throw new IllegalArgumentException(
                    "Direccion requerida y distancia no negativa.");
        }

        switch (direccion.toLowerCase(java.util.Locale.ROOT)) {
            case "norte":
                posicionY += distancia;
                break;

            case "sur":
                posicionY -= distancia;
                break;

            case "este":
                posicionX += distancia;
                break;

            case "oeste":
                posicionX -= distancia;
                break;

            default:
                throw new IllegalArgumentException(
                        "Direccion no valida: " + direccion);
        }

        System.out.println("  Utilería " + nombre);
        System.out.println("    Movimiento: " + direccion
                + " / " + distancia + " unidades");
        System.out.println("    Posición final: ("
                + posicionX + ", " + posicionY + ")");
    }

    @Override
    public String toString() {
        return "Utilería " + nombre
                + " (" + posicionX + ", " + posicionY + ")"
                + " - " + descripcion
                + " - usada: " + (usada ? "Sí" : "No");
    }
}