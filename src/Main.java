public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario(5);

        inventario.agregarItem(
                new Arma("Espada", 25, 1.5));

        inventario.agregarItem(
                new Recompensa("Moneda de oro", 100, "moneda"));

        Nivel nivel = new Nivel(
                "Bosque encantado", 1, "Normal", inventario);

        nivel.agregarObstaculo(
                new Obstaculo("Roca", 10, 5, 8));

        nivel.agregarObstaculo(
                new Obstaculo("Espinas", 20, 12, 6));

        nivel.agregarCheckPoint(
                new CheckPoint("Entrada", 0, 0));

        nivel.agregarCheckPoint(
                new CheckPoint("Puente", 15, 10));

        nivel.agregarElementoDinamico(
                new Personaje("Heroe", 100, 0, 0));

        nivel.agregarElementoDinamico(
                new Personaje("Enemigo", 60, 10, 10));

        nivel.agregarElementoDinamico(
                new Utileria(
                        "Plataforma", "Transporta al personaje", 3, 4));

        System.out.println("\nANTES DE MOVER:");
        nivel.mostrarEstado();

        System.out.println("\nMOVIMIENTOS ALEATORIOS:");
        nivel.moverElementosDinamicos();

        System.out.println("\nDESPUÉS DE MOVER:");
        nivel.mostrarEstado();
    }
}