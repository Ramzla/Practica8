# Práctica: videojuego con interfaces

Implementación en Java del diagrama proporcionado. Contiene 12 archivos Java:
3 interfaces, 8 clases del modelo y Main. No necesita librerías externas.

## Organización
- Inventariable: contrato registrar() y borrar().
- Arma y Recompensa: objetos que se guardan en el inventario.
- Destruible: contrato destruye().
- Obstaculo: conserva su estado destruido.
- Personaje: tiene vida, recibe daño y puede moverse.
- ElementoDinamico: contrato mover(String direccion, int distancia).
- Utileria: objeto móvil que puede usarse y conserva el estado usada.
- CheckPoint: conserva su estado activado.
- Inventario: almacena objetos Inventariable hasta su capacidad máxima.
- Nivel: contiene obstáculos, checkpoints y elementos dinámicos; usa un inventario.
- Main: construye todas las partes de un nivel, muestra su estado inicial,
  invoca moverElementosDinamicos() y muestra su estado final.

## Decisiones de implementación
El documento contiene versiones distintas de las firmas de movimiento.
Se sigue la instrucción principal y la tabla de métodos:
Nivel.moverElementosDinamicos() sin argumentos y
ElementoDinamico.mover(String direccion, int distancia).

Cada elemento recibe independientemente una dirección aleatoria y una distancia
entera de 1 a 10 unidades. Norte aumenta Y, sur reduce Y, este aumenta X y oeste
reduce X. Se permiten coordenadas negativas, pues el enunciado no fija límites.
No se agregan reglas de colisiones ni activación automática no solicitadas.

Inventario realiza la inserción y eliminación de la lista y llama registrar()
o borrar() para informar la operación; esos métodos por sí solos no modifican
una lista que no reciben. getItems() devuelve una vista no modificable para
evitar que se omita la validación de capacidad. No admite el mismo objeto dos veces.

Los atributos son privados, y toString() permite mostrar el estado de los objetos.
La vida nunca baja de cero. destruye() pone la vida del personaje en cero o marca
el obstáculo como destruido. activar() y usar() actualizan sus banderas.

## Validación
Compilado y ejecutado con Java 17. Comprobados los cuatro sentidos de movimiento,
vida mínima cero, estados de destrucción/activación/uso, capacidad del inventario,
eliminación y parámetros válidos del movimiento aleatorio.
Salida_ejemplo.txt contiene una ejecución real; los movimientos varían al ejecutar.
