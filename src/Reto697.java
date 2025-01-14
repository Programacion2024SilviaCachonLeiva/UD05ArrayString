import java.util.Scanner;

public class Reto697 {

    int[][] matriz;
    int tamaño;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Reto697 reto = new Reto697();
        reto.crearMatriz(sc.nextInt());
        reto.solicitarValoresMatriz();
        System.out.println(reto.recorrerEspiral());


    }


    public void crearMatriz(int tamaño) {
        matriz = new int[tamaño][tamaño];
        this.tamaño = tamaño;
    }

    public void solicitarValoresMatriz() {
        Scanner sc = new Scanner(System.in);
        for (int columna = 0; columna < tamaño; columna++) {
            for (int fila = 0; fila < tamaño; fila++) {
                matriz[columna][fila] = sc.nextInt();
            }
        }
    }

    public enum Movimiento {
        ARRIBA, DERECHA, ABAJO, IZQUIERDA
    }

    public int recorrerEspiral() {
        int mitad = tamaño / 2; //Se trunca


        int columna = mitad;
        int fila = mitad;


        boolean continuar = true;
        Movimiento movimiento = Movimiento.ARRIBA;
        int veces = 1;

        //Suma el inicial
        int suma = matriz[columna][fila];

        while (continuar) {

            switch (movimiento) {
                case ARRIBA ->
                case DERECHA -> {
                    if (matriz[fila].length - 1 < columna + veces) {
                   veces --;
                   continuar = false;
                    }
                }
                case ABAJO ->
                case IZQUIERDA ->
            }

            for (int i = 1; i <= veces; i++) {
                switch (movimiento) {
                    case ARRIBA -> fila++;
                    case DERECHA -> columna++;
                    case ABAJO -> fila--;
                    case IZQUIERDA -> columna--;
                }

                suma += matriz[columna][fila];
            }

            // Arriba > Derecha > Abajo > Izquierda
            movimiento = movimiento == Movimiento.ARRIBA ? Movimiento.DERECHA :
                    movimiento == Movimiento.DERECHA ? Movimiento.ABAJO :
                            movimiento == Movimiento.ABAJO ? Movimiento.IZQUIERDA : Movimiento.ARRIBA;


            veces++;
        }


        return suma;


    }


}
