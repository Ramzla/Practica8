public class Recompensa implements Inventariable {
    private String nombre;
    private int valor;
    private String tipo;

    public Recompensa(String nombre, int valor, String tipo) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío.");
        }

        if (valor < 0) {
            throw new IllegalArgumentException(
                    "El valor no puede ser negativo.");
        }

        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El tipo no puede estar vacío.");
        }

        this.nombre = nombre;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void registrar() {
        System.out.println("Recompensa registrada: " + nombre);
    }

    @Override
    public void borrar() {
        System.out.println("Recompensa eliminada: " + nombre);
    }

    @Override
    public String toString() {
        return "Recompensa: " + nombre
                + ", valor: " + valor
                + ", tipo: " + tipo;
    }
}