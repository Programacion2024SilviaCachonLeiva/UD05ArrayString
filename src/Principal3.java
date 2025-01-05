import java.util.Scanner;

/**
 * Clase principal que ejecuta el menú de opciones para realizar diversas tareas.
 * El programa ofrece un menú interactivo para realizar validaciones de NIF, manipular frases, jugar al ahorcado y más.
 */
public class Principal3 {
    /**
     * Método principal que ejecuta el menú de opciones.
     * Este método permite al usuario elegir una opción y realizar diferentes tareas como validar NIF,
     * quitar vocales a una frase, contar repeticiones de una palabra, cifrar y descifrar frases, etc.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Menú principal
            System.out.println("\n--- Menú de Pruebas ---");
            System.out.println("1. Validar NIF");
            System.out.println("2. Quitar vocales");
            System.out.println("3. Quitar espacios sobrantes");
            System.out.println("4. Invertir frase");
            System.out.println("5. Contar repeticiones de palabra");
            System.out.println("6. Verificar si es palíndromo");
            System.out.println("7. Cifrar frase");
            System.out.println("8. Descifrar frase");
            System.out.println("9. Contar caracteres");
            System.out.println("10. Jugar al Ahorcado");
            System.out.println("11. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el NIF: ");
                    String nif = scanner.nextLine();
                    boolean esValido = Tarea3String.esCorrectoNIF(nif);
                    System.out.println("El NIF es " + (esValido ? "válido" : "inválido"));
                    break;

                case 2:
                    System.out.print("Introduce una frase: ");
                    String fraseSinVocales = scanner.nextLine();
                    System.out.println("Frase sin vocales: " + Tarea3String.quitaVocales(fraseSinVocales));
                    break;

                case 3:
                    System.out.print("Introduce una frase: ");
                    String fraseConEspacios = scanner.nextLine();
                    System.out.println("Frase sin espacios sobrantes: " + Tarea3String.quitaEspaciosSobrantes(fraseConEspacios));
                    break;

                case 4:
                    System.out.print("Introduce una frase: ");
                    String fraseParaInvertir = scanner.nextLine();
                    System.out.println("Frase invertida: " + Tarea3String.invertir(fraseParaInvertir));
                    break;

                case 5:
                    System.out.print("Introduce una frase: ");
                    String fraseParaRepeticiones = scanner.nextLine();
                    System.out.print("Introduce la palabra a buscar: ");
                    String palabra = scanner.nextLine();
                    int repeticiones = Tarea3String.repeticiones(fraseParaRepeticiones, palabra);
                    System.out.println("La palabra \"" + palabra + "\" se repite " + repeticiones + " veces.");
                    break;

                case 6:
                    System.out.print("Introduce una frase: ");
                    String posiblePalindromo = scanner.nextLine();
                    boolean esPalindromo = Tarea3String.palindromo(posiblePalindromo);
                    System.out.println("La frase es " + (esPalindromo ? "un palíndromo" : "no es un palíndromo"));
                    break;

                case 7:
                    System.out.print("Introduce una frase: ");
                    String fraseParaCifrar = scanner.nextLine();
                    System.out.println("Frase cifrada: " + Tarea3String.cifrar(fraseParaCifrar));
                    break;

                case 8:
                    System.out.print("Introduce una frase cifrada: ");
                    String fraseParaDescifrar = scanner.nextLine();
                    System.out.println("Frase descifrada: " + Tarea3String.desCifrar(fraseParaDescifrar));
                    break;

                case 9:
                    System.out.print("Introduce una frase: ");
                    String fraseParaContar = scanner.nextLine();
                    System.out.println("Conteo de caracteres:");
                    Tarea3String.cuentaCaracteres(fraseParaContar);
                    break;

                case 10:
                    // Iniciar el juego del Ahorcado
                    System.out.print("Introduce la palabra para el juego: ");
                    String palabraAdivinar = scanner.nextLine();
                    Ahorcado ahorcado = new Ahorcado(palabraAdivinar); // Crear una instancia de Ahorcado con la palabra introducida
                    ahorcado.iniciarJuego();  // Iniciar el juego del Ahorcado
                    break;

                case 11:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        } while (opcion != 11);  // Cambié la condición para que termine al seleccionar la opción 11

        scanner.close();
    }
}
