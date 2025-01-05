import static java.lang.Character.*;
/**
 * La clase Tarea3String proporciona varias funciones de manipulación de cadenas de texto.
 * Estas funciones incluyen validación de NIF, manipulación de cadenas como quitar vocales, espacios sobrantes,
 * invertir texto, contar caracteres, cifrar y descifrar cadenas, entre otras.
 */
public class Tarea3String {

    /**
     * Verifica si un NIF es válido según las reglas españolas.
     *
     * @param nif El NIF a comprobar.
     * @return true si el NIF es válido, false en caso contrario.
     */
    static boolean esCorrectoNIF(String nif) {

        //Variable para devolver un booleano de acuerdo a si es válido o no el nif
        boolean valido;

        //Si la longitud no es 9 no es válido
        //Si es 9 sigue
        if (nif.length() != 9) {
            valido = false;

            //Si lo anterior no se cumple de momento es válido,
            //entonces se comprueba sí los 8 primeros caracteres no son todos dígitos
            //Si los 8 primeros caracteres son dígitos sigue, si no es inválido
        } else if (!(ochoPrimerosDigitos(nif))) {
            valido = false;

            //Si lo anterior no se cumple de momento es válido,
            //entonces se comprueba sí el último caracter no es una letra
            //Si el último caracter es una letra sigue, si no es inválido
        } else if (!(isLetter(nif.charAt(8)))) {
            valido = false;

            //Si lo anterior no se cumple de momento es válido,
            //entonces se comprueba sí el último caracter no se corresponde con su letra correcta
            //Si es la letra correcta sigue, si no es inválido
        } else if (!(letraCorrecta(nif))) {
            valido = false;

            //Si todas las negaciones resultan ser falsas esto quiere decir que
            //se cumplen todas las condiciones para ser un nif válido
            //Como resultado devuelve un verdadero
        } else {
            valido = true;
        }

        return valido;
    }

    /**
     * Comprueba si los primeros 8 caracteres del NIF son dígitos.
     *
     * @param nif El NIF a comprobar.
     * @return true si los 8 primeros caracteres son dígitos, false en caso contrario.
     */
    private static boolean ochoPrimerosDigitos(String nif) {

        //Si no se dice lo contrario hay 8 dígitos
        boolean valido = true;

        //Se mira caracter por caracter los 8 primeros
        for (int i = 0; i < 8; i++) {

            //Si alguno no es un dígito ya no es correcto y se deja de comprobar
            if (!(isDigit(nif.charAt(i)))) {
                valido = false;
                i = 8;
            }
        }

        return valido;
    }
    /**
     * Comprueba si la letra final del NIF es la correcta según los primeros 8 dígitos.
     *
     * @param nif El NIF a comprobar.
     * @return true si la letra es correcta, false en caso contrario.
     */
    private static boolean letraCorrecta(String nif) {

        //Selecciona los primeros 8 caracteres para los cálculos
        String digitos = nif.substring(0, 8);

        //Selecciona la letra para comprobarla después y la pone en máyuscula
        char letra = nif.charAt(8);
        letra = toUpperCase(letra);

        //String (Array de char) con las letras válidas, cada una en la posición del módulo de 23 que le corresponde
        String letrasCorrectas = "TRWAGMYFPDXBNJZSQVHLCKE";

        //Convierte los dígitos a un entero en vez de String
        int num = Integer.parseInt(digitos);

        //Cálcula cúal es la posición de la letra correcta
        int posicion = num % 23;

        //Variable con el resultado de sí la letra es válida o no
        boolean valido = false;

        //Si coincide es válida
        if (letrasCorrectas.charAt(posicion) == letra) {
            valido = true;
        }

        return valido;
    }

    /**
     * Elimina todas las vocales (tanto mayúsculas como minúsculas) de la cadena proporcionada.
     *
     * @param frase La cadena de texto a modificar.
     * @return La cadena sin vocales.
     */
    static String quitaVocales(String frase) {

        //String con los caracteres a eliminar
        String eliminar = "aeiouAEIOUáéíóúÁÉÍÓÚ";

        //StringBuilder para crear la nueva frase sin los caracteres especificados anteriormente
        StringBuilder nuevaFrase = new StringBuilder();

        //Bucle que recorre toda la frase y mira caracter por caracter
        for (int i = 0; i < frase.length(); i++) {

            //Cada caracter se almacena como String para compararlo
            String letraActual = String.valueOf(frase.charAt(i));

            //Si el caracter no aparece se concatenará en la nueva frase
            if (!(eliminar.contains(letraActual))) {
                nuevaFrase.append(letraActual);
            }

        }

        //Se devuelve la frase en formato String
        return String.valueOf(nuevaFrase);

    }
    /**
     * Elimina los espacios sobrantes en la cadena, dejando solo un asterisco '*' en lugar de múltiples espacios.
     *
     * @param frase La cadena de texto a modificar.
     * @return La cadena con espacios sobrantes reemplazados por asteriscos.
     */
    static String quitaEspaciosSobrantes(String frase) {

        //Se crea un interrupter ya que una vez que se ponga un asterisco no se podrá poner otro hasta
        // que se haya comprobado otro caracter que no sea un espacio
        boolean asterisco = true;

        //StringBuilder para hacer las concatenaciones
        StringBuilder nuevaFrase = new StringBuilder();

        //Bucle que comprobará caracter por caracter
        for (int i = 0; i < frase.length(); i++) {

            //Si no es un espacio se añade y se activará el asterisco para el próximo espacio
            if (!(isWhitespace(frase.charAt(i)))) {
                nuevaFrase.append(frase.charAt(i));
                asterisco = true;

                //Si es un espacio se pondrá un asterisco siempre y cuando sea el primero,
                //ya que en los siquientes queda desactivado si no hay otro caracter entre medias
            } else if ((isWhitespace(frase.charAt(i)) && asterisco)) {
                nuevaFrase.append('*');
                asterisco = false;
            }
        }

        //Se transforma a String
        return String.valueOf(nuevaFrase);

    }

    /**
     * Invierte el orden de los caracteres en la cadena proporcionada.
     *
     * @param frase La cadena de texto a invertir.
     * @return La cadena con los caracteres invertidos.
     */
    static String invertir(String frase) {

        //StringBuilder para las concatenaciones
        StringBuilder nuevaFrase = new StringBuilder();

        //Se recorre la frase a la inversa; se resta uno porque la longitud es uno más que el índice superior del Array
        for (int i = frase.length(); i > 0; i--) {

            nuevaFrase.append(frase.charAt(i - 1));

        }

        //Se transforma a String
        return String.valueOf(nuevaFrase);

    }

    /**
     * Cuenta cuántas veces aparece una palabra dentro de una frase.
     *
     * @param frase La cadena de texto donde buscar.
     * @param palabra La palabra a contar.
     * @return El número de veces que aparece la palabra en la frase.
     */
    static int repeticiones(String frase, String palabra) {

        //Contador con las veces que se repite la palabra
        int contador = 0;

        //Longitud de la palabra para poder recortarla
        int longitudPalabra = palabra.length();

        //Donde comienza la primera aparición de la palabra en cuestión.
        int indice;

        //Mientras la palabra este en la frase se sumará uno a las repeticiones
        while (frase.contains(palabra)) {
            contador++;

            //Se buscará donde comienza esa palabra
            indice = frase.indexOf(palabra);

            //Se recortará la frase teniendo en cuenta que el nuevo principio será el carácter después de la palabra
            frase = frase.substring(indice + longitudPalabra);


            //Si hay más repeticiones el bucle se volverá a ejecutar

        }

        return contador;
    }

    /**
     * Verifica si una cadena es un palíndromo, ignorando mayúsculas y minúsculas.
     *
     * @param frase La cadena de texto a comprobar.
     * @return true si la cadena es un palíndromo, false en caso contrario.
     */
    static boolean palindromo(String frase) {
        //Booleano con el resultado
        boolean palindromo = false;

        //Si coincide el derecho con el revés sin tener en cuenta mayúsculas son palíndromos
        if (frase.equalsIgnoreCase(invertir(frase))) {
            palindromo = true;
        }

        return palindromo;
    }
    /**
     * Cifra una cadena de texto utilizando el cifrado César con un desplazamiento de 3.
     *
     * @param frase La cadena de texto a cifrar.
     * @return La cadena cifrada.
     */
    static String cifrar(String frase) {
        // StringBuilder para las concatenaciones
        StringBuilder nuevaFrase = new StringBuilder();

        // Recorre los caracteres de la frase
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);

            // Solo cifrar letras mayúsculas
            if (Character.isUpperCase(c)) {
                c = (char) ((c - 'A' + 3) % 26 + 'A'); // Desplazamiento para mayúsculas
            }
            // Solo cifrar letras minúsculas
            else if (Character.isLowerCase(c)) {
                c = (char) ((c - 'a' + 3) % 26 + 'a'); // Desplazamiento para minúsculas
            }

            // Concatenar el carácter cifrado (o no cifrado si no era letra)
            nuevaFrase.append(c);
        }

        // Devuelve en formato String
        return nuevaFrase.toString();
    }
    /**
     * Descifra una cadena de texto cifrada con el cifrado César con un desplazamiento de 3.
     *
     * @param frase La cadena de texto a descifrar.
     * @return La cadena descifrada.
     */
    static String desCifrar(String frase) {
        // StringBuilder para las concatenaciones
        StringBuilder nuevaFrase = new StringBuilder();

        // Recorre los caracteres de la frase
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);

            // Solo descifrar letras mayúsculas
            if (Character.isUpperCase(c)) {
                c = (char) ((c - 'A' - 3 + 26) % 26 + 'A'); // Desplazamiento inverso para mayúsculas
            }
            // Solo descifrar letras minúsculas
            else if (Character.isLowerCase(c)) {
                c = (char) ((c - 'a' - 3 + 26) % 26 + 'a'); // Desplazamiento inverso para minúsculas
            }

            // Concatenar el carácter descifrado (o no cifrado si no era letra)
            nuevaFrase.append(c);
        }

        // Devuelve en formato String
        return nuevaFrase.toString();
    }


    /**
     * Cuenta la cantidad de veces que cada letra del abecedario aparece en la frase.
     *
     * @param frase La cadena de texto donde contar las letras.
     */
    static void cuentaCaracteres(String frase) {
        // Convierte toda la frase a minúsculas
        frase = frase.toLowerCase();

        // String con las letras que se van a contar (solo minúsculas)
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        // Array de contadores
        int[] veces = new int[abecedario.length()];

        // Bucle para mirar cada letra de la frase
        for (int i = 0; i < frase.length(); i++) {

            // Busca el carácter de la posición que se está revisando de la frase
            char c = frase.charAt(i);

            // Se busca la posición que tiene en el abecedario si es una letra
            int p = abecedario.indexOf(c);

            // Si es una letra, se suma 1 en esa posición en el array de veces
            if (p != -1) {
                veces[p]++;
            }
        }

        // Se imprimen todas las cantidades
        for (int j = 0; j < veces.length; j++) {

            // Si es 0 no se imprime
            if (veces[j] != 0) {

                // Imprime la letra correspondiente y la cantidad
                System.out.print(abecedario.charAt(j) + ": " + veces[j]);

                // Si es 1 se pone vez en lugar de veces
                if (veces[j] == 1) {
                    System.out.println(" vez");
                } else {
                    System.out.println(" veces");
                }
            }
        }
    }


}
