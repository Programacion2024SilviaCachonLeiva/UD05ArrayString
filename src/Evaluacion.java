import java.util.Scanner;

public class Evaluacion {

    String nombreAsignatura; // Nombre de la asignatura
    double[] listaNotas; // Arreglo que almacena las notas de los alumnos

    Evaluacion(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }


    Evaluacion(String nombreAsignatura, double[] listaNotas) {
        this.nombreAsignatura = nombreAsignatura;
        this.listaNotas = listaNotas;
    }


    void leerNotas(int totalAlumnos) {
        Scanner sc = new Scanner(System.in);
        String nuevasNotas;

        if (!(listaNotasNull())) {
            System.out.println("¿Notas ya introducidas desea introducirlas de nuevo(s/n)?");
            nuevasNotas = sc.next();
            if (nuevasNotas.equalsIgnoreCase("s")) {
                crearListaNotas(totalAlumnos);
            }
        } else {
            crearListaNotas(totalAlumnos);
        }

        System.out.println(this);

    }

    public void crearListaNotas(int totalAlumnos) {
        Scanner sc = new Scanner(System.in);
        listaNotas = new double[totalAlumnos];
        double num;

        for (int i = 0; i < totalAlumnos; i++) {

            System.out.println("Alumno " + (i+ 1) + ":");
            num = sc.nextDouble();
            if (0 <= num && num <= 10) {
                listaNotas[i] = num;
            } else {
                listaNotas[i] = 0;
            }

        }
    }


    public boolean listaNotasNull() {
        return (listaNotas == null);
    }

    public double media() {
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


    public double minimo() {
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

    public double maximo() {
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


    public int totalSuspensos() {
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


    public int totalAprobados() {
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


    public void cambiarNota(double nota, int alumno) {
        if (listaNotasNull()) {
            System.out.println("No hay notas");
        } else {
            if (alumno > 0 && alumno <= listaNotas.length) {
                listaNotas[alumno - 1] = nota;
            } else {
                System.out.println("Alumno no válido");
            }
        }
    }


    public int mejorAlumno() {
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


    public int peorAlumno() {
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


    public double notaAlumno(int indiceAlumno) {
        double nota;
        if (listaNotasNull()) {
            nota = -1;
        } else {
            if (indiceAlumno >= 0 && indiceAlumno <= listaNotas.length) {
                nota = listaNotas[indiceAlumno];
            } else {
                nota = -1;
            }
        }
        return nota;
    }


    public int[] dameAprobados() {
        int indice = 0;
        int tamaño = totalAprobados();

        if (tamaño < 0) {
            tamaño = 1;
        }

        int[] aprobados = new int[tamaño];

        if (totalAprobados() > 0) {
            for (int i = 0; i < listaNotas.length; i++) {
                if (notaAlumno(i) >= 5) {
                    aprobados[indice] = i;
                    indice++;
                }
            }
        } else {
            aprobados = new int[0];
        }

        return aprobados;
    }

    public int[] dameSuspensos() {
        int indice = 0;
        int tamaño = totalSuspensos();

        if (tamaño < 0) {
            tamaño = 1;
        }

        int[] suspensos = new int[tamaño];

        if (totalSuspensos() > 0) {
            for (int i = 0; i < listaNotas.length; i++) {
                if (notaAlumno(i) < 5) {
                    suspensos[indice] = i;
                    indice++;
                }
            }
        } else {
            suspensos = new int[0];
        }

        return suspensos;
    }



    public int primerMenor(double nota) {
        int indice = 0;
        int primerMenor = -1;

        while (indice < listaNotas.length && primerMenor == -1) {
            if (listaNotas[indice] < nota) {
                primerMenor = indice;
            }
            indice++;
        }

        return primerMenor;
    }





    public double[] ordenar() {
        double[] notasOrdenadas = listaNotas;

        for (int i = 0; i < notasOrdenadas.length - 1; i++) {
            for (int j = 0; j < notasOrdenadas.length - 1 - i; j++) {
                if (notasOrdenadas[j] > notasOrdenadas[j + 1]) {
                    double swap = notasOrdenadas[j];
                    notasOrdenadas[j] = notasOrdenadas[j + 1];
                    notasOrdenadas[j + 1] = swap;
                }
            }
        }

        return notasOrdenadas;
    }



    public void analizaGrupo() {
        int mas7 = 0;
        int de5a7 = 0;
        int menos5 = 0;

        for (int i = 0; i < listaNotas.length; i++) {
            if (listaNotas[i] > 7) {
                mas7++;
            } else if (listaNotas[i] <= 7 && listaNotas[i] >= 5) {
                de5a7++;
            } else if (listaNotas[i] < 5) {
                menos5++;
            }
        }

        double dostercios = (listaNotas.length * 2) / 3.0;

        if (mas7 >= dostercios) {
            System.out.println("VAMOS FENOMENAL");
        } else if (de5a7 >= dostercios) {
            System.out.println("REPASAR EJERCICIOS CON DIFICULTAD");
        } else if (menos5 >= dostercios) {
            System.out.println("VAMOS MAL... REPEMOS EL TEMARIO");
        } else {
            System.out.println("HACER SUBGRUPOS CON TAREAS DE DIFERENTE DIFICULTAD");
        }
    }

    @Override
    public String toString() {
        StringBuilder notas = new StringBuilder();

        if (listaNotas == null || listaNotas.length == 0) {
            notas.append("Sin notas por el momento");
        } else {
            for (int i = 0; i < listaNotas.length; i++) {
                notas.append("Alumno ").append(i + 1).append(": ").append(listaNotas[i]).append("\n");
            }
        }

        return nombreAsignatura + "\n" + notas.toString();
    }


}
