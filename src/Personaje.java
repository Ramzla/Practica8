public class Personaje implements Destruible, ElementoDinamico {
    private String nombre;
    private int vida;
    private int posicionX;
    private int posicionY;

    public Personaje(String nombre, int vida,
                     int posicionX, int posicionY) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío.");
        }

        if (vida < 0) {
            throw new IllegalArgumentException(
                    "La vida no puede ser negativa.");
        }

        this.nombre = nombre;
        this.vida = vida;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicion(int x, int y) {
        posicionX = x;
        posicionY = y;
    }

    public void recibirDaño(int daño) {
        if (daño < 0) {
            throw new IllegalArgumentException(
                    "El daño no puede ser negativo.");
        }

        vida = Math.max(0, vida - daño);

        if (vida == 0) {
            destruye();
        }
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

        System.out.println("  Personaje " + nombre);
        System.out.println("    Movimiento: " + direccion
                + " / " + distancia + " unidades");
        System.out.println("    Posición final: ("
                + posicionX + ", " + posicionY + ")");
    }

    @Override
    public void destruye() {
        vida = 0;
        System.out.println("Personaje destruido: " + nombre);
    }

    @Override
    public String toString() {
        return "Personaje " + nombre
                + " (" + posicionX + ", " + posicionY + ")"
                + " - vida: " + vida;
    }
}