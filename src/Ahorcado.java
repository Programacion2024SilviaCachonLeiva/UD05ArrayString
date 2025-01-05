import java.util.Scanner;  // Importamos la clase Scanner para leer datos desde la entrada del usuario
/**
 * Clase que representa el juego del ahorcado.
 * El objetivo es adivinar una palabra antes de quedarse sin vidas.
 */
public class Ahorcado {

    // Declaramos las variables necesarias para el juego
    Scanner sc = new Scanner(System.in);  // Creamos un objeto Scanner para leer la entrada del usuario
    String palabra;  // La palabra que el jugador debe adivinar
    int vidas;  // Número de vidas que tiene el jugador
    /**
     * Constructor que establece la palabra a adivinar y da 5 vidas por defecto.
     *
     * @param palabra La palabra que debe ser adivinada.
     */
    public Ahorcado(String palabra){
        this.palabra = palabra;  // Asignamos la palabra que se pasa como parámetro
        vidas = 5;  // El jugador comienza con 5 vidas por defecto
    }

    /**
     * Constructor que también permite establecer un número personalizado de vidas.
     *
     * @param palabra La palabra que debe ser adivinada.
     * @param vidas El número de vidas que el jugador tendrá.
     */    public Ahorcado(String palabra, int vidas){
        this.palabra = palabra;  // Asignamos la palabra que se pasa como parámetro
        this.vidas = vidas;  // Asignamos el número de vidas que se pasa como parámetro
    }

    /**
     * Método que inicia el juego del ahorcado.
     * El juego permite al jugador adivinar la palabra, ingresando letras una por una.
     * El jugador pierde vidas por cada letra incorrecta.
     * Si adivina la palabra antes de quedarse sin vidas, gana.
     */    void iniciarJuego(){
        StringBuilder letrasAdivinadas = new StringBuilder();  // StringBuilder para guardar las letras que el jugador ha adivinado
        int vidasRetantes = vidas;  // Establecemos el número de vidas restantes

        // Mostramos la palabra con guiones bajos, uno por cada letra en la palabra
        System.out.println("_".repeat(palabra.length()));  // Mostramos la palabra con guiones bajos, uno por cada letra de la palabra

        boolean adivinada = false;  // Variable para verificar si la palabra fue adivinada
        while(vidasRetantes > 0 && !adivinada){  // El juego continuará mientras haya vidas y no se haya adivinado la palabra

            // Pedimos al jugador que ingrese una letra
            System.out.println("Introduce una letra: ");
            char letra = sc.next().charAt(0);  // Leemos la letra ingresada por el jugador

            // Verificamos que la letra sea válida (solo letras del alfabeto)
            while(!(Character.isLetter(letra))){  // Si no es una letra válida, pedimos que ingrese otra letra
                System.out.println("Letra no válida");  // Mensaje de error si la entrada no es válida
                letra = sc.next().charAt(0);  // Leemos nuevamente la letra
            }

            String letraS = String.valueOf(letra);  // Convertimos la letra a String para compararla con la palabra

            // Comprobamos si la letra está en la palabra
            if(palabra.contains(letraS) && letrasAdivinadas.indexOf(letraS) == -1){  // Si la letra está en la palabra y no se ha adivinado antes
                letrasAdivinadas.append(letraS);  // Añadimos la letra a las letras adivinadas
            } else if (!palabra.contains(letraS)) {  // Si la letra no está en la palabra
                vidasRetantes--;  // Restamos una vida
            }

            // Construimos la palabra en pantalla con guiones bajos para las letras que aún no se han adivinado
            StringBuilder palabraPantalla = new StringBuilder();  // StringBuilder para construir la palabra a mostrar
            for (int i = 0; i < palabra.length(); i++) {  // Recorremos cada letra de la palabra
                if (letrasAdivinadas.indexOf(String.valueOf(palabra.charAt(i))) != -1) {  // Si la letra ya ha sido adivinada
                    palabraPantalla.append(palabra.charAt(i));  // Mostramos la letra
                } else {  // Si la letra no ha sido adivinada
                    palabraPantalla.append("_");  // Mostramos un guion bajo
                }
            }

            // Mostramos la palabra con las letras adivinadas y los guiones bajos para las letras faltantes
            System.out.println("Palabra: " + palabraPantalla);
            // Mostramos las vidas restantes
            System.out.println("Vidas: " + vidasRetantes);

            // Si ya no hay guiones bajos, significa que la palabra ha sido completamente adivinada
            if(!palabraPantalla.toString().contains("_")){
                adivinada = true;  // La palabra ha sido adivinada
            }
        }

        // Mensaje final dependiendo si ganó o perdió
        if (vidasRetantes == 0){  // Si se quedan sin vidas, el jugador ha perdido
            System.out.println("Has perdido");
            // Preguntamos si el jugador quiere reiniciar el juego
            System.out.println("""
                    ¿Reintentar?
                    1. Sí
                    2. No
                    """);
            // Si el jugador elige 1, reiniciamos el juego
            if(sc.nextInt() == 1){
                iniciarJuego();  // Llamamos al método para reiniciar el juego
            }
        } else {  // Si la palabra fue adivinada y el jugador aún tiene vidas
            System.out.println("Has ganado");  // El jugador ha ganado
        }
    }
}
