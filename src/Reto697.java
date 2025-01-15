import java.util.Scanner;

/**
 * La clase Reto697 resuelve el problema de recorrer una matriz en espiral y sumar los elementos en el recorrido.
 */
public class Reto697 {

    int[][] matriz; // Matriz de enteros para almacenar los valores ingresados.
    int tamaño; // Tamaño de la matriz (n x n).
    Scanner sc = new Scanner(System.in); // Scanner para leer entradas del usuario.

    /**
     * Método principal que gestiona la creación de la matriz y el recorrido en espiral.
     * El ciclo continúa hasta que el tamaño ingresado sea 0.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner para leer entradas del usuario.
        Reto697 reto = new Reto697(); // Instancia de la clase Reto697.

        do {
            // Crear una matriz de tamaño indicado por el usuario.
            reto.crearMatriz(reto.sc.nextInt());
            if (reto.tamaño != 0) {
                // Solicitar los valores de la matriz.
                reto.solicitarValoresMatriz();
                // Mostrar la suma de los elementos recorridos en espiral.
                System.out.println(reto.recorrerEspiral());
            }
        } while (reto.tamaño != 0); // Repetir mientras el tamaño sea distinto de 0.
    }

    /**
     * Crea una matriz cuadrada de tamaño n x n.
     *
     * @param tamaño El tamaño de la matriz.
     */
    public void crearMatriz(int tamaño) {
        matriz = new int[tamaño][tamaño]; // Crear la matriz con las dimensiones dadas.
        this.tamaño = tamaño; // Asignar el tamaño de la matriz.
    }

    /**
     * Solicita al usuario que ingrese los valores para llenar la matriz.
     */
    public void solicitarValoresMatriz() {
        // Recorrer cada fila y columna de la matriz.
        for (int fila = 0; fila < tamaño; fila++) {
            for (int col = 0; col < tamaño; col++) {
                // Asignar el valor ingresado a la matriz.
                matriz[fila][col] = sc.nextInt();
            }
        }
    }

    /**
     * Enumeración que representa los posibles movimientos en espiral: arriba, derecha, abajo, izquierda.
     */
    public enum Movimiento {
        ARRIBA, DERECHA, ABAJO, IZQUIERDA
    }

    /**
     * Recorre la matriz en espiral y suma los elementos encontrados durante el recorrido.
     * El recorrido sigue el patrón: Arriba > Derecha > Abajo > Izquierda.
     *
     * @return La suma de los elementos encontrados en el recorrido espiral.
     */
    public int recorrerEspiral() {
        int mitad = tamaño / 2; // Se trunca para obtener el centro de la matriz.

        int fila = mitad; // Posición inicial de la fila (mitad de la matriz).
        int col = mitad; // Posición inicial de la columna (mitad de la matriz).

        boolean continuar = true; // Controla si el recorrido continúa.
        Movimiento movimiento = Movimiento.ARRIBA; // Dirección inicial.
        int veces = 1; // Número de pasos a seguir en cada dirección.

        // Sumar el valor inicial del centro de la matriz.
        int suma = matriz[fila][col];

        while (continuar) {
            switch (movimiento) {
                case ARRIBA:
                    if (fila - veces < 0) {
                        veces--;
                        continuar = false; // Detener si se sale de la matriz.
                    }
                    break;
                case DERECHA:
                    if (matriz.length - 1 < col + veces) {
                        veces--;
                        continuar = false; // Detener si se sale de la matriz.
                    }
                    break;
                case ABAJO:
                    if (fila + veces > matriz[fila].length - 1) {
                        veces--;
                        continuar = false; // Detener si se sale de la matriz.
                    }
                    break;
                case IZQUIERDA:
                    if (col - veces < 0) {
                        veces--;
                        continuar = false; // Detener si se sale de la matriz.
                    }
                    break;
            }

            // Recorrer en la dirección indicada y sumar los elementos.
            for (int i = 1; i <= veces; i++) {
                switch (movimiento) {
                    case ARRIBA:
                        fila--; // Moverse hacia arriba.
                        break;
                    case DERECHA:
                        col++; // Moverse hacia la derecha.
                        break;
                    case ABAJO:
                        fila++; // Moverse hacia abajo.
                        break;
                    case IZQUIERDA:
                        col--; // Moverse hacia la izquierda.
                        break;
                }

                suma += matriz[fila][col]; // Sumar el valor de la celda actual.
            }

            // Cambiar la dirección del movimiento: Arriba > Derecha > Abajo > Izquierda.
            movimiento = movimiento == Movimiento.ARRIBA ? Movimiento.DERECHA :
                    movimiento == Movimiento.DERECHA ? Movimiento.ABAJO :
                            movimiento == Movimiento.ABAJO ? Movimiento.IZQUIERDA : Movimiento.ARRIBA;

            veces++; // Incrementar el número de pasos para la siguiente dirección.
        }

        return suma; // Retornar la suma total de los valores en espiral.
    }
}
