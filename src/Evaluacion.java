import java.util.Scanner;

public class Evaluacion {

    String nombreAsignatura;
    double[] listaNotas;


    //Constructor

    Evaluacion(String nombreAsignatura){
            setNombreAsignatura(nombreAsignatura);
    }

    Evaluacion(String nombreAsignatura, double[] listaNotas){
        setNombreAsignatura(nombreAsignatura);
        setListaNotas(listaNotas);
    }


    //Métodos

    void leerNotas(int totalAlumnos){

        Scanner sc = new Scanner(System.in);
        String nuevasNotas;

        if(!(listaNotas == null)){
            System.out.println("¿Notas ya introducidas desea introducirlas de nuevo(s/n)?");
            nuevasNotas = sc.next();

            if(nuevasNotas.equalsIgnoreCase("s"){

            }



        }else{

        }


        System.out.println();
        sc.close();


    }

    private static double[] crearListaNotas(int totalAlumnos){
        Scanner sc = new Scanner(System.in);
        double[] listaNotas = new double[totalAlumnos];

        for(int i = 0; i < totalAlumnos; i++){

            listaNotas[i] = sc.nextDouble();

        }


        sc.close();



    }





    //Setter y Getter

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public double[] getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(double[] listaNotas) {
        this.listaNotas = listaNotas;
    }
}
