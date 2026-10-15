import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventario {
    private int capacidadMaxima;
    private List<Inventariable> items;

    public Inventario(int capacidadMaxima) {
        if (capacidadMaxima < 0) {
            throw new IllegalArgumentException(
                    "La capacidad no puede ser negativa.");
        }

        this.capacidadMaxima = capacidadMaxima;
        items = new ArrayList<>();
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public List<Inventariable> getItems() {
        return Collections.unmodifiableList(items);
    }

    public boolean agregarItem(Inventariable item) {
        if (item == null
                || items.size() >= capacidadMaxima
                || items.contains(item)) {
            return false;
        }

        items.add(item);
        item.registrar();
        return true;
    }

    public boolean eliminarItem(Inventariable item) {
        if (items.remove(item)) {
            item.borrar();
            return true;
        }

        return false;
    }

    public void listarItems() {
        System.out.println("Inventario ("
                + items.size() + "/" + capacidadMaxima + "):");

        if (items.isEmpty()) {
            System.out.println("  Vacío");
        }

        for (Inventariable item : items) {
            System.out.println("  - " + item);
        }
    }
}