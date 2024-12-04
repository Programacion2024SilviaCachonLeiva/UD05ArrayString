import java.util.Scanner;

public class Evaluacion {

    String nombreAsignatura;
    double[] listaNotas;


    //Constructor

    Evaluacion(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    Evaluacion(String nombreAsignatura, double[] listaNotas) {
        this.nombreAsignatura = nombreAsignatura;
        this.listaNotas = listaNotas;
    }


    //Métodos
    void leerNotas(int totalAlumnos) {
        //Flujo de entrada
        Scanner sc = new Scanner(System.in);
        String nuevasNotas;

        //Existe
        if (!(listaNotasNull())) {
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

        System.out.println(this);
        sc.close();


    }

    private void crearListaNotas(int totalAlumnos) {
        // Flujo de entrada
        Scanner sc = new Scanner(System.in);
        // Crear la lista del objeto con longitud que se pasa.
        double[] listaNotas = new double[totalAlumnos];
        double num;

        //Leer de 1 (indice 0) a "n" notas.
        for (int i = 0; i < totalAlumnos; i++) {

            num = sc.nextDouble();

            //Laa notas son entre 0 y 10
            if (0 <= num && num <= 10) {
                listaNotas[i] = num;
            } else {//Por defecto 0
                listaNotas[i] = 0;
            }

        }

        sc.close();
    }

    private boolean listaNotasNull() {
        return (listaNotas == null);
    }


    private double media() {
        double media;
        if (listaNotasNull()) {

            media = -1;
        } else {


            double sum = 0;
            for (int i = 0; i < listaNotas.length; i++) {

                sum += listaNotas[i];

            }

            media = sum / listaNotas.length;
        }
        return media;

    }

    private double minimo() {
        double min = 10;
        if (listaNotasNull()) {

            min = -1;

        } else {

            for (int i = 0; i < listaNotas.length; i++) {

                if (listaNotas[i] < min) {
                    min = listaNotas[i];
                }

            }

        }
        return min;

    }

    private double maximo() {
        double max = 0;
        if (listaNotasNull()) {

            max = -1;

        } else {

            for (int i = 0; i < listaNotas.length; i++) {

                if (listaNotas[i] > max) {
                    max = listaNotas[i];
                }

            }

        }
        return max;

    }

    private int totalSuspensos() {
        int suspensos = 0;
        if (listaNotasNull()) {

            suspensos = -1;

        } else {

            for (int i = 0; i < listaNotas.length; i++) {

                if (listaNotas[i] < 5) {
                    suspensos++;
                }

            }

        }
        return suspensos;
    }

    private int totalAprobados() {
        int aprobados = 0;
        if (listaNotasNull()) {

            aprobados = -1;

        } else {

            for (int i = 0; i < listaNotas.length; i++) {

                if (listaNotas[i] >= 5) {
                    aprobados++;
                }

            }

        }
        return aprobados;
    }

    private void cambiarNota(double nota, int alumno) {

        if (nota > 0 && nota <= listaNotas.length) {
            listaNotas[alumno - 1] = nota;
        } else {
            System.out.println("Alumno no válido");
        }
    }

    private int mejorAlumno() {
        double max = 0;
        int mejorAlumno = 0;
        if (listaNotasNull()) {

            mejorAlumno = -1;

        } else {

            for (int i = 0; i < listaNotas.length; i++) {

                if (listaNotas[i] > max) {
                    max = listaNotas[i];
                    mejorAlumno = i;
                }

            }

        }
        return mejorAlumno;

    }

    private int peorAlumno() {
        double min = 10;
        int peorAlumno = 0;
        if (listaNotasNull()) {

            peorAlumno = -1;

        } else {

            for (int i = 0; i < listaNotas.length; i++) {

                if (listaNotas[i] < min) {
                    min = listaNotas[i];
                    peorAlumno = i;
                }

            }

        }
        return peorAlumno;

    }






    @Override
    public String toString() {
        String notas = "";

        if (listaNotasNull()) {
            notas = "Sin notas por el momento";

        } else {

            for (int i = 0; i < listaNotas.length; i++) {

                notas += "Alumno " + (i + 1) + ": " + listaNotas[i] + "\n";


            }
        }

        return nombreAsignatura + "\n" + notas;
    }

}
