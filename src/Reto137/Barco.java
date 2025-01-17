package Reto137;

public class Barco {

    int tamaño;
    Cordenada[] piezas;
    Cordenada inicio;
    Cordenada fin;



    void asignarTamañoBarco(int tamaño){
        this.tamaño = tamaño;
        piezas = new Cordenada[tamaño];
    }



}
