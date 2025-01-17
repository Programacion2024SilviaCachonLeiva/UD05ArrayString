package Reto137;

import java.util.List;
import java.util.Scanner;

public class Reto137 {

    Scanner sc = new Scanner(System.in);
    int[][] mapa;
    Barco[] barcos;
    Cordenada actual ;
    Cordenada busqueda;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Reto137 reto = new Reto137();
        int valor = sc.nextInt();

        while(valor!= 0){
        reto.crearBarcos(valor);
        reto.introducirValoresMapa();

        valor = sc.nextInt();
        }
    }

    void crearBarcos(int cantidad){
        barcos = new Barco[cantidad];
        for(Barco b : barcos){
            b.asignarTamañoBarco(sc.nextInt());
        }
    }

    void generarMapa(int tamaño){
        this.mapa = new int[tamaño][tamaño];
    }
    void introducirValoresMapa(){
        for(int[] a: mapa){
            for(int b: a){
                b = sc.nextInt();
            }
        }
    }







}
