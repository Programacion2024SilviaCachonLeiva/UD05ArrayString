package Reto137;

import java.util.Scanner;

public class Reto137 {

    boolean mapaOK;
    int[][] mapa;
    int numBarcosCorrecto;
    int[] tamanosBarcos;
    int numBarcosEncontrados;
    int[][] usadas; // Coordenadas ya verificadas
    int usadasCount;

    public Reto137(int tamMapa, int numBarcos, int[] tamanosBarcos) {
        this.mapa = new int[tamMapa][tamMapa];
        this.numBarcosCorrecto = numBarcos;
        this.tamanosBarcos = tamanosBarcos;
        this.mapaOK = true;
        this.usadas = new int[tamMapa * tamMapa][2];
        this.usadasCount = 0;
    }

    public void iniciarMapa() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                mapa[i][j] = sc.nextInt();
            }
        }
    }

    public void buscarBarcos() {
        numBarcosEncontrados = 0;

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j] == 1 && !estaUsada(i, j)) {
                    if (numBarcosEncontrados >= numBarcosCorrecto) {
                        mapaOK = false;
                        return;
                    }
                    if (!verificarBarco(i, j)) {
                        mapaOK = false;
                        return;
                    }
                    numBarcosEncontrados++;
                }
            }
        }

        if (numBarcosEncontrados != numBarcosCorrecto) {
            mapaOK = false;
        }
    }

    private boolean verificarBarco(int x, int y) {
        int tamActual = 0;
        int[][] posicionesBarco = new int[mapa.length * mapa.length][2];
        int posicionesCount = 0;

        // Verificar dirección horizontal
        if (y + 1 < mapa.length && mapa[x][y + 1] == 1) {
            int j = y;
            while (j < mapa.length && mapa[x][j] == 1 && !estaUsada(x, j)) {
                if (!esValido(x, j)) return false;
                posicionesBarco[posicionesCount][0] = x;
                posicionesBarco[posicionesCount][1] = j;
                posicionesCount++;
                tamActual++;
                j++;
            }
        }
        // Verificar dirección vertical
        else if (x + 1 < mapa.length && mapa[x + 1][y] == 1) {
            int i = x;
            while (i < mapa.length && mapa[i][y] == 1 && !estaUsada(i, y)) {
                if (!esValido(i, y)) return false;
                posicionesBarco[posicionesCount][0] = i;
                posicionesBarco[posicionesCount][1] = y;
                posicionesCount++;
                tamActual++;
                i++;
            }
        }
        // Caso de un barco de una sola celda
        else {
            if (!esValido(x, y)) return false;
            posicionesBarco[posicionesCount][0] = x;
            posicionesBarco[posicionesCount][1] = y;
            posicionesCount++;
            tamActual++;
        }

        // Comprobar si el tamaño coincide con la flota
        boolean tamanoValido = false;
        for (int i = 0; i < tamanosBarcos.length; i++) {
            if (tamanosBarcos[i] == tamActual) {
                tamanosBarcos[i] = -1; // Marcamos este tamaño como usado
                tamanoValido = true;
                break;
            }
        }
        if (!tamanoValido) return false;

        // Marcar posiciones usadas
        for (int i = 0; i < posicionesCount; i++) {
            usadas[usadasCount][0] = posicionesBarco[i][0];
            usadas[usadasCount][1] = posicionesBarco[i][1];
            usadasCount++;
        }

        return true;
    }

    private boolean estaUsada(int x, int y) {
        for (int i = 0; i < usadasCount; i++) {
            if (usadas[i][0] == x && usadas[i][1] == y) {
                return true;
            }
        }
        return false;
    }

    private boolean esValido(int x, int y) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;
                if (nx >= 0 && ny >= 0 && nx < mapa.length && ny < mapa.length) {
                    if (mapa[nx][ny] == 1 && !estaUsada(nx, ny) && (i != 0 || j != 0)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int numBarcos = sc.nextInt();
            if (numBarcos == 0) break;

            int[] tamanosBarcos = new int[numBarcos];
            for (int i = 0; i < numBarcos; i++) {
                tamanosBarcos[i] = sc.nextInt();
            }

            int tamMapa = sc.nextInt();
            Reto137 juego = new Reto137(tamMapa, numBarcos, tamanosBarcos);

            juego.iniciarMapa();
            juego.buscarBarcos();

            System.out.println(juego.mapaOK ? "SI" : "NO");
        }
    }
}
