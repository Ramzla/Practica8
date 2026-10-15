import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Objects;

public class Nivel {
    private String nombre;
    private int numero;
    private String dificultad;
    private List<Obstaculo> obstaculos;
    private List<CheckPoint> checkPoints;
    private List<ElementoDinamico> elementosDinamicos;
    private Inventario inventario;
    private final Random aleatorio = new Random();

    public Nivel(String nombre, int numero,
                 String dificultad, Inventario inventario) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío.");
        }

        if (numero < 1) {
            throw new IllegalArgumentException(
                    "El número de nivel debe ser positivo.");
        }

        if (dificultad == null || dificultad.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La dificultad no puede estar vacía.");
        }

        this.nombre = nombre;
        this.numero = numero;
        this.dificultad = dificultad;
        this.inventario = Objects.requireNonNull(inventario);

        obstaculos = new ArrayList<>();
        checkPoints = new ArrayList<>();
        elementosDinamicos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void agregarObstaculo(Obstaculo obstaculo) {
        obstaculos.add(Objects.requireNonNull(obstaculo));
    }

    public void agregarCheckPoint(CheckPoint checkPoint) {
        checkPoints.add(Objects.requireNonNull(checkPoint));
    }

    public void agregarElementoDinamico(ElementoDinamico elemento) {
        elementosDinamicos.add(Objects.requireNonNull(elemento));
    }

    public void moverElementosDinamicos() {
        String[] direcciones = {"norte", "sur", "este", "oeste"};

        for (ElementoDinamico elemento : elementosDinamicos) {
            String direccion =
                    direcciones[aleatorio.nextInt(direcciones.length)];

            int distancia = aleatorio.nextInt(10) + 1;
            elemento.mover(direccion, distancia);
        }
    }

    public void moverElementosDinamicos(String direccion, int distancia) {
        for (ElementoDinamico elemento : elementosDinamicos) {
            elemento.mover(direccion, distancia);
        }
    }

    public void mostrarEstado() {
        System.out.println("\n===== ESTADO DEL NIVEL =====");
        System.out.println("Nombre: " + nombre);
        System.out.println("Número: " + numero);
        System.out.println("Dificultad: " + dificultad);

        System.out.println("\nObstáculos:");
        for (Obstaculo obstaculo : obstaculos) {
            System.out.println("  " + obstaculo);
        }

        System.out.println("\nCheckPoints:");
        for (CheckPoint checkPoint : checkPoints) {
            System.out.println("  " + checkPoint);
        }

        System.out.println("\nElementos dinámicos:");
        for (ElementoDinamico elemento : elementosDinamicos) {
            System.out.println("  " + elemento);
        }

        System.out.println();
        inventario.listarItems();
        System.out.println("============================");
    }
}