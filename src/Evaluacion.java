import java.util.Scanner;

public class Evaluacion {

    String nombreAsignatura;
    double[] listaNotas;


    //Constructor

    Evaluacion(String nombreAsignatura) {
        setNombreAsignatura(nombreAsignatura);
    }

    Evaluacion(String nombreAsignatura, double[] listaNotas) {
        setNombreAsignatura(nombreAsignatura);
        setListaNotas(listaNotas);
    }


    //Métodos

    void leerNotas(int totalAlumnos) {
        //Flujo de entrada
        Scanner sc = new Scanner(System.in);
        String nuevasNotas;

        //Existe
        if (!(listaNotas == null)) {
            System.out.println("¿Notas ya introducidas desea introducirlas de nuevo(s/n)?");
            nuevasNotas = sc.next();
            //¿Volver a crear? Sí
            if (nuevasNotas.equalsIgnoreCase("s")) {
                crearListaNotas(totalAlumnos);
            }
            //NO existe
        } else {
            crearListaNotas(totalAlumnos);
        }

        //Mostrar notas
        mostrarListaNotas();
        sc.close();


    }

    private void crearListaNotas(int totalAlumnos) {
        // Flujo de entrada
        Scanner sc = new Scanner(System.in);
        // Crear la lista del objeto con longitud que se pasa.
        double[] listaNotas = new double[totalAlumnos];

        //Leer de 1 (indice 0) a "n" notas.
        for (int i = 0; i < totalAlumnos; i++) {

            listaNotas[i] = sc.nextDouble();

        }
        sc.close();

    }

    private void mostrarListaNotas() {
        // Muestra todas las notas
        for (int i = 0; i < listaNotas.length; i++) {

            System.out.println(listaNotas[i]);

        }
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
