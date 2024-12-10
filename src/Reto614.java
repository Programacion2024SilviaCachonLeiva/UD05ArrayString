import java.util.Scanner;

public class Reto614 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int longTren;  // Longitud del tren
        int longAnden; // Longitud del andén
        int[] arrayAnden; // Array para almacenar la cantidad de pasajeros en cada posición del andén

        do {
            longTren = sc.nextInt();  // Leer la longitud del tren
            longAnden = sc.nextInt();  // Leer la longitud del andén
            arrayAnden = new int[longAnden]; // Inicializar el array con la longitud del andén

            // Leer la cantidad de pasajeros en cada posición del andén
            for (int a = 0; a < arrayAnden.length; a++) {
                arrayAnden[a] = sc.nextInt();
            }

            int minCosto = Integer.MAX_VALUE;  // Inicializar minCosto con un valor muy grande

            // Recorrer todas las posiciones posibles donde el tren puede detenerse
            // El tren debe detenerse en un rango que permita que el tren tenga la longitud 'longTren'
            for (int inicioTren = 0; inicioTren <= longAnden - longTren; inicioTren++) {
                int costo = 0;  // Inicializamos el costo para esta posición

                // Calcular el costo total para la posición 'inicioTren'
                for (int posicionAnden = 0; posicionAnden < longAnden; posicionAnden++) {
                    if (posicionAnden < inicioTren) {
                        // Si la posición del pasajero es antes de donde empieza el tren:
                        // Los pasajeros se mueven hacia el inicio del tren
                        costo += (inicioTren - posicionAnden) * arrayAnden[posicionAnden];
                    } else if (posicionAnden >= inicioTren + longTren) {
                        // Si la posición del pasajero es después del final del tren:
                        // Los pasajeros se mueven hacia el final del tren
                        costo += (posicionAnden - (inicioTren + longTren - 1)) * arrayAnden[posicionAnden];
                    }
                }

                // Actualizar el mínimo costo, si el costo calculado es menor que el mínimo actual
                if (costo < minCosto) {
                    minCosto = costo;
                }
            }

            // Imprimir el costo mínimo para este caso de prueba
            if(longTren != 0 && longAnden != 0){
            System.out.println(minCosto);
            }

        } while (longTren != 0 && longAnden != 0);  // Termina cuando longTren y longAnden son cero
    }
}
