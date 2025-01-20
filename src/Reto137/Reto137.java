package Reto137;

import java.util.Scanner;

public class Reto137 {

    boolean mapaOK = true;
    int [][] mapa;
    int numCoordenadas = 0 ;
    Coordenada[] conBarco;
    Coordenada[] usadas;
    int numBarcosCorrecto;
    int numBarcosEncontrados;
    Barco[] barcos;


    void iniciarMapa(){
        Scanner sc = new Scanner(System.in);
        for (int[] fila : mapa){
            for(int posicion : fila){

                posicion = sc.nextInt();
                if (posicion == 1){
                    numCoordenadas++;
                }

            }
        }

        conBarco = new Coordenada[numCoordenadas];

        int posicionArray = 0;
        for (int fila = 0; fila < mapa.length; fila++){
            for(int posicion = 0; posicion < mapa[fila].length; posicion++){

                if (posicion == 1){
                    conBarco[posicionArray] = new Coordenada(fila, posicion);
                    posicionArray++;
                }

            }
        }
    }


    void buscarBarcos(){
        int posicionUsadas = 0;
        for (Coordenada coordenada : conBarco){
            if(!(estaUsada(coordenada))){
                usadas[posicionUsadas] = coordenada;
                posicionUsadas++;
                if(numBarcosEncontrados < numBarcosCorrecto) {

                    Coordenada comienzo = coordenada;
                    Coordenada fin;

                    if ((coordenada.posicion + 1) == 1) {
                        int movimiento = 1;
                        while ()


                    } else if ((coordenada.fila + 1) == 1) {

                    } else {


                    }



                }else {
                    mapaOK = false;
                }

            }
        }




    }

    boolean estaUsada(Coordenada coordenada){
        boolean esta = false;
        for (Coordenada a : usadas){
            if(coordenada.equals(a)){
                esta= true;

            }
        }
        return esta;

    }


}
