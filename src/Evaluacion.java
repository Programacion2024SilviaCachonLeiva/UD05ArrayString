import java.util.Scanner;

/**
 * La clase Evaluacion gestiona las notas de una asignatura, permitiendo leer, modificar,
 * y calcular estadísticas relacionadas con las notas de los alumnos.
 */
public class Evaluacion {

    String nombreAsignatura; // Nombre de la asignatura
    double[] listaNotas; // Arreglo que almacena las notas de los alumnos

    /**
     * Constructor que inicializa el nombre de la asignatura.
     * @param nombreAsignatura El nombre de la asignatura.
     */
    Evaluacion(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    /**
     * Constructor que inicializa tanto el nombre de la asignatura como la lista de notas.
     * @param nombreAsignatura El nombre de la asignatura.
     * @param listaNotas El arreglo con las notas de los alumnos.
     */
    Evaluacion(String nombreAsignatura, double[] listaNotas) {
        this.nombreAsignatura = nombreAsignatura;
        this.listaNotas = listaNotas;
    }

    /**
     * Lee las notas de los alumnos. Si las notas ya han sido introducidas, pregunta
     * si se desean modificar.
     * @param totalAlumnos El número total de alumnos cuya nota se va a ingresar.
     */
    void leerNotas(int totalAlumnos) {
        Scanner sc = new Scanner(System.in);
        String nuevasNotas;

        // Si ya existen notas, preguntar si desea introducirlas de nuevo
        if (!(listaNotasNull())) {
            System.out.println("¿Notas ya introducidas desea introducirlas de nuevo(s/n)?");
            nuevasNotas = sc.next();
            // Si el usuario decide introducir nuevas notas, se llama al método para crear la lista
            if (nuevasNotas.equalsIgnoreCase("s")) {
                crearListaNotas(totalAlumnos);
            }
        } else {
            // Si no existen notas, crear nuevas
            crearListaNotas(totalAlumnos);
        }

        // Imprime el estado actual de las notas
        System.out.println(this);
        sc.close();
    }

    /**
     * Crea una nueva lista de notas, pidiendo la entrada del usuario para cada nota.
     * @param totalAlumnos El número total de alumnos cuya nota se va a ingresar.
     */
    private void crearListaNotas(int totalAlumnos) {
        Scanner sc = new Scanner(System.in);
        // Crear el arreglo de notas con el número de alumnos especificado
        double[] listaNotas = new double[totalAlumnos];
        double num;

        // Leer las notas de cada alumno
        for (int i = 0; i < totalAlumnos; i++) {

            num = sc.nextDouble();

            // Las notas deben estar entre 0 y 10, de lo contrario se asigna 0
            if (0 <= num && num <= 10) {
                listaNotas[i] = num;
            } else {
                listaNotas[i] = 0;
            }

        }

        sc.close();
    }

    /**
     * Verifica si la lista de notas es nula.
     * @return true si la lista de notas es nula, false en caso contrario.
     */
    private boolean listaNotasNull() {
        return (listaNotas == null);
    }

    /**
     * Calcula la media de las notas de los alumnos.
     * @return La media de las notas o -1 si la lista de notas es nula.
     */
    private double media() {
        double media;
        if (listaNotasNull()) {
            media = -1;
        } else {
            double sum = 0;
            // Sumar todas las notas
            for (int i = 0; i < listaNotas.length; i++) {
                sum += listaNotas[i];
            }
            media = sum / listaNotas.length;
        }
        return media;
    }

    /**
     * Calcula la nota mínima de los alumnos.
     * @return La nota mínima o -1 si la lista de notas es nula.
     */
    private double minimo() {
        double min = 10;
        if (listaNotasNull()) {
            min = -1;
        } else {
            // Buscar la nota mínima
            for (int i = 0; i < listaNotas.length; i++) {
                if (listaNotas[i] < min) {
                    min = listaNotas[i];
                }
            }
        }
        return min;
    }

    /**
     * Calcula la nota máxima de los alumnos.
     * @return La nota máxima o -1 si la lista de notas es nula.
     */
    private double maximo() {
        double max = 0;
        if (listaNotasNull()) {
            max = -1;
        } else {
            // Buscar la nota máxima
            for (int i = 0; i < listaNotas.length; i++) {
                if (listaNotas[i] > max) {
                    max = listaNotas[i];
                }
            }
        }
        return max;
    }

    /**
     * Calcula el número total de suspensos (notas menores a 5).
     * @return El número de suspensos o -1 si la lista de notas es nula.
     */
    private int totalSuspensos() {
        int suspensos = 0;
        if (listaNotasNull()) {
            suspensos = -1;
        } else {
            // Contar los suspensos
            for (int i = 0; i < listaNotas.length; i++) {
                if (listaNotas[i] < 5) {
                    suspensos++;
                }
            }
        }
        return suspensos;
    }

    /**
     * Calcula el número total de aprobados (notas mayores o iguales a 5).
     * @return El número de aprobados o -1 si la lista de notas es nula.
     */
    private int totalAprobados() {
        int aprobados = 0;
        if (listaNotasNull()) {
            aprobados = -1;
        } else {
            // Contar los aprobados
            for (int i = 0; i < listaNotas.length; i++) {
                if (listaNotas[i] >= 5) {
                    aprobados++;
                }
            }
        }
        return aprobados;
    }

    /**
     * Cambia la nota de un alumno especificado por su índice.
     * @param nota La nueva nota a asignar.
     * @param alumno El índice del alumno cuya nota se va a cambiar.
     */
    private void cambiarNota(double nota, int alumno) {
        // Verificar si el índice del alumno es válido
        if (nota > 0 && nota <= listaNotas.length) {
            listaNotas[alumno - 1] = nota;
        } else {
            System.out.println("Alumno no válido");
        }
    }

    /**
     * Encuentra el índice del mejor alumno (con la nota más alta).
     * @return El índice del mejor alumno o -1 si la lista de notas es nula.
     */
    private int mejorAlumno() {
        double max = 0;
        int mejorAlumno = 0;
        if (listaNotasNull()) {
            mejorAlumno = -1;
        } else {
            // Buscar al mejor alumno
            for (int i = 0; i < listaNotas.length; i++) {
                if (listaNotas[i] > max) {
                    max = listaNotas[i];
                    mejorAlumno = i;
                }
            }
        }
        return mejorAlumno;
    }

    /**
     * Encuentra el índice del peor alumno (con la nota más baja).
     * @return El índice del peor alumno o -1 si la lista de notas es nula.
     */
    private int peorAlumno() {
        double min = 10;
        int peorAlumno = 0;
        if (listaNotasNull()) {
            peorAlumno = -1;
        } else {
            // Buscar al peor alumno
            for (int i = 0; i < listaNotas.length; i++) {
                if (listaNotas[i] < min) {
                    min = listaNotas[i];
                    peorAlumno = i;
                }
            }
        }
        return peorAlumno;
    }

    /**
     * Obtiene la nota de un alumno especificado por su índice.
     * @param indiceAlumno El índice del alumno.
     * @return La nota del alumno o -1 si el índice es inválido o si la lista de notas es nula.
     */
    private double notaAlumno(int indiceAlumno){
        double nota;
        if (listaNotasNull()) {
            nota = -1;
        } else {
            // Verificar si el índice es válido
            if (indiceAlumno > 0 && indiceAlumno <= listaNotas.length) {
                nota = listaNotas[indiceAlumno];
            } else {
                nota = -1;
            }
        }
        return nota;
    }

    /**
     * Devuelve los índices de los alumnos aprobados.
     * @return Un arreglo con los índices de los alumnos aprobados o null si no hay aprobados.
     */
    private int[] dameAprobados(){
        int indice = 0;
        int[] aprobados = new int[totalAprobados()];

        if(totalAprobados() > 0){
            for(int i = 0; i < listaNotas[i]; i++){
                if(notaAlumno(i) >= 5){
                    aprobados[indice] = i;
                    indice++;
                }
            }
        }else{
            aprobados = null;
        }

        return aprobados;
    }

    /**
     * Devuelve los índices de los alumnos suspensos.
     * @return Un arreglo con los índices de los alumnos suspensos o null si no hay suspensos.
     */
    private int[] dameSuspensos(){
        int indice = 0;
        int[] suspensos = new int[totalSuspensos()];

        if(totalSuspensos() > 0){
            for(int i = 0; i < listaNotas[i]; i++){
                if(notaAlumno(i) < 5){
                    suspensos[indice] = i;
                    indice++;
                }
            }
        }else{
            suspensos = null;
        }
        return suspensos;
    }

    /**
     * Busca el primer alumno cuya nota sea menor que la nota proporcionada.
     * Si no se encuentra un alumno con una nota menor, devuelve -1.
     *
     * @param nota La nota con la que se comparan las notas de los alumnos.
     * @return El índice del primer alumno cuya nota sea menor que la nota dada, o -1 si no hay ninguno.
     */
    private int primerMenor(double nota) {
        boolean noEncontrado = true;
        int indice = 0;
        int primerMenor = -1;

        // Buscar la primera nota menor que la proporcionada
        while (noEncontrado) {
            if (listaNotas[indice] < nota) {
                noEncontrado = false;
                primerMenor = indice;
            }
            // Si se alcanza el final del array sin encontrar, terminar la búsqueda
            if (listaNotas.length == indice) {
                noEncontrado = false;
                primerMenor = -1;
            }
            indice++;
        }

        return primerMenor;
    }

    /**
     * Devuelve una representación en cadena de texto de la evaluación,
     * mostrando el nombre de la asignatura y las notas de los alumnos.
     * Si no se han introducido notas, indica que no hay notas disponibles.
     *
     * @return Una cadena que representa la asignatura y las notas de los alumnos.
     */
    @Override
    public String toString() {
        String notas = "";

        // Verifica si las notas son nulas
        if (listaNotasNull()) {
            notas = "Sin notas por el momento";
        } else {
            // Si existen notas, las agrega al String
            for (int i = 0; i < listaNotas.length; i++) {
                notas += "Alumno " + (i + 1) + ": " + listaNotas[i] + "\n";
            }
        }

        // Retorna el nombre de la asignatura junto con las notas
        return nombreAsignatura + "\n" + notas;
    }

}
