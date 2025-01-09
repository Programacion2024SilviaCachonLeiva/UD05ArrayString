import java.util.Arrays;
import java.util.Scanner;

public class Reto695 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean ok = true;
        while (ok) {
            // Leer el número de entrada
            String numS = sc.nextLine();

            // Salir del bucle si la entrada es "0"
            if (numS.equals("0")) {
                ok = false;
            }else{

            // Ordenar los dígitos de menor a mayor
            char[] num = numS.toCharArray();
            Arrays.sort(num);

            // Convertir el número ordenado al mínimo y luego invertirlo para obtener el máximo
            String minS = String.valueOf(num);
            String maxS = invertir(minS);

            // Convertir los valores mínimo y máximo a enteros
            int min = Integer.parseInt(minS);
            int max = Integer.parseInt(maxS);

            // Calcular la resta y el cociente
            int resta = max - min;
            int cociente = resta / 9;

            // Mostrar el resultado
            System.out.println(max + " - " + min + " = " + resta + " = " + cociente + " x 9");
            }
        }
    }

    static String invertir(String frase) {
        // Usar StringBuilder para invertir la cadena
        return new StringBuilder(frase).reverse().toString();
    }
}
