// Importación de la clase Scanner para leer datos desde la consola.

import java.util.Scanner;

/**
 * Clase Evaluacion para gestionar las notas de alumnos en una asignatura.
 */
public class Asignatura {

    // Variable para almacenar el nombre de la asignatura.
    private String nombreAsignatura;

    // Arreglo que almacena las notas de los alumnos.
    private double[] listaNotas;

    /**
     * Constructor que inicializa la asignatura sin notas.
     *
     * @param nombreAsignatura Nombre de la asignatura.
     */
    Asignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    /**
     * Constructor que inicializa la asignatura con un arreglo de notas.
     *
     * @param nombreAsignatura Nombre de la asignatura.
     * @param listaNotas       Arreglo de notas inicial.
     */
    Asignatura(String nombreAsignatura, double[] listaNotas) {
        this.nombreAsignatura = nombreAsignatura;
        this.listaNotas = listaNotas;
    }

    /**
     * Método para leer las notas de los alumnos.
     *
     * @param totalAlumnos Número total de alumnos.
     */
    void leerNotas(int totalAlumnos) {
        Scanner sc = new Scanner(System.in);
        String nuevasNotas;

        // Verifica si ya hay notas introducidas.
        if (!(listaNotasNull())) {
            System.out.println("¿Notas ya introducidas desea introducirlas de nuevo(s/n)?");
            nuevasNotas = sc.next();

            // Si el usuario decide sobrescribir, crea una nueva lista de notas.
            if (nuevasNotas.equalsIgnoreCase("s")) {
                crearListaNotas(totalAlumnos);
            }
        } else {
            // Si no hay notas, las crea.
            crearListaNotas(totalAlumnos);
        }

        // Imprime el estado actual del objeto.
        System.out.println(this);
    }

    /**
     * Método para crear un arreglo de notas introducidas por el usuario.
     *
     * @param totalAlumnos Número total de alumnos.
     */
    public void crearListaNotas(int totalAlumnos) {
        Scanner sc = new Scanner(System.in);
        listaNotas = new double[totalAlumnos];
        double num;

        // Ciclo para introducir las notas de cada alumno.
        for (int i = 0; i < totalAlumnos; i++) {
            System.out.println("Alumno " + (i + 1) + ":");
            num = sc.nextDouble();

            // Valida que la nota esté entre 0 y 10.
            if (0 <= num && num <= 10) {
                listaNotas[i] = num;
            } else {
                listaNotas[i] = 0; // Si no es válida, asigna 0.
            }
        }
    }

    /**
     * Verifica si la lista de notas está vacía.
     *
     * @return {@code true} si la lista de notas está vacía, de lo contrario {@code false}.
     */
    public boolean listaNotasNull() {
        return (listaNotas == null);
    }

    /**
     * Calcula la media de las notas.
     *
     * @return Media de las notas o -1 si no hay notas.
     */
    public double media() {
        double media;
        if (listaNotasNull()) {
            media = -1; // Indica que no hay notas.
        } else {
            double sum = 0;
            for (int i = 0; i < listaNotas.length; i++) {
                sum += listaNotas[i];
            }
            media = sum / listaNotas.length; // Calcula el promedio.
        }
        return media;
    }

    /**
     * Encuentra la nota mínima en la lista.
     *
     * @return Nota mínima o -1 si no hay notas.
     */
    public double minimo() {
        double min = 10; // Nota máxima posible.
        if (listaNotasNull()) {
            min = -1; // Indica que no hay notas.
        } else {
            for (int i = 0; i < listaNotas.length; i++) {
                if (listaNotas[i] < min) {
                    min = listaNotas[i];
                }
            }
        }
        return min;
    }

    /**
     * Encuentra la nota máxima en la lista.
     *
     * @return Nota máxima o -1 si no hay notas.
     */
    public double maximo() {
        double max = 0; // Nota mínima posible.
        if (listaNotasNull()) {
            max = -1; // Indica que no hay notas.
        } else {
            for (int i = 0; i < listaNotas.length; i++) {
                if (listaNotas[i] > max) {
                    max = listaNotas[i];
                }
            }
        }
        return max;
    }

    /**
     * Cuenta el número total de suspensos.
     *
     * @return Total de suspensos o -1 si no hay notas.
     */
    public int totalSuspensos() {
        int suspensos = 0;
        if (listaNotasNull()) {
            suspensos = -1; // Indica que no hay notas.
        } else {
            for (int i = 0; i < listaNotas.length; i++) {
                if (listaNotas[i] < 5) {
                    suspensos++;
                }
            }
        }
        return suspensos;
    }

    /**
     * Cuenta el número total de aprobados.
     *
     * @return Total de aprobados o -1 si no hay notas.
     */
    public int totalAprobados() {
        int aprobados = 0;
        if (listaNotasNull()) {
            aprobados = -1; // Indica que no hay notas.
        } else {
            for (int i = 0; i < listaNotas.length; i++) {
                if (listaNotas[i] >= 5) {
                    aprobados++;
                }
            }
        }
        return aprobados;
    }

    /**
     * Cambia la nota de un alumno en la lista de notas.
     *
     * @param nota   La nueva nota del alumno.
     * @param alumno El índice del alumno (basado en 1).
     *               Si el índice no es válido, no se realiza ningún cambio.
     */
    public void cambiarNota(double nota, int alumno) {
        if (listaNotasNull()) {
            System.out.println("No hay notas");
        } else {
            // Valida que el índice del alumno sea válido.
            if (alumno > 0 && alumno <= listaNotas.length) {
                listaNotas[alumno - 1] = nota;
            } else {
                System.out.println("Alumno no válido");
            }
        }
    }

    /**
     * Devuelve el índice del mejor alumno basado en la nota más alta.
     *
     * @return El índice del mejor alumno (0 basado en el array).
     * Devuelve -1 si no hay notas registradas.
     */
    public int mejorAlumno() {
        double max = 0;
        int mejorAlumno = 0;
        if (listaNotasNull()) {
            mejorAlumno = -1; // Indica que no hay notas.
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

    /**
     * Devuelve el índice del peor alumno basado en la nota más baja.
     *
     * @return El índice del peor alumno (0 basado en el array).
     * Devuelve -1 si no hay notas registradas.
     */
    public int peorAlumno() {
        double min = 10;
        int peorAlumno = 0;
        if (listaNotasNull()) {
            peorAlumno = -1; // Indica que no hay notas.
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

    /**
     * Obtiene la nota de un alumno dado su índice.
     *
     * @param indiceAlumno El índice del alumno en el array (basado en 0).
     * @return La nota del alumno si el índice es válido. Devuelve -1 si el índice es inválido
     * o no hay notas registradas.
     */
    public double notaAlumno(int indiceAlumno) {
        double nota;
        if (listaNotasNull()) {
            nota = -1; // Indica que no hay notas.
        } else {
            // Valida que el índice sea válido.
            if (indiceAlumno >= 0 && indiceAlumno < listaNotas.length) {
                nota = listaNotas[indiceAlumno];
            } else {
                nota = -1;
            }
        }
        return nota;
    }

    /**
     * Obtiene un array con los índices de los alumnos aprobados.
     *
     * @return Un array con los índices de los alumnos aprobados (notas >= 5).
     * Si no hay aprobados, devuelve un array vacío.
     */
    public int[] dameAprobados() {
        int indice = 0; // Índice para llenar el arreglo de aprobados.
        int tamaño = totalAprobados(); // Obtiene la cantidad total de aprobados.

        if (tamaño < 0) {
            tamaño = 1; // Si el tamaño es negativo (algo raro), se ajusta a 1.
        }

        int[] aprobados = new int[tamaño]; // Crea un arreglo del tamaño necesario para los aprobados.

        if (totalAprobados() > 0) { // Si hay al menos un aprobado.
            for (int i = 0; i < listaNotas.length; i++) { // Recorre todas las notas.
                if (notaAlumno(i) >= 5) { // Si la nota es igual o mayor a 5.
                    aprobados[indice] = i; // Guarda el índice del alumno aprobado.
                    indice++; // Avanza al siguiente espacio del arreglo.
                }
            }
        } else {
            aprobados = new int[0]; // Si no hay aprobados, crea un arreglo vacío.
        }

        return aprobados; // Devuelve el arreglo con los índices de los alumnos aprobados.
    }

    /**
     * Obtiene un array con los índices de los alumnos suspensos.
     *
     * @return Un array con los índices de los alumnos suspensos (notas < 5).
     * Si no hay suspensos, devuelve un array vacío.
     */
    public int[] dameSuspensos() {
        int indice = 0; // Índice para llenar el arreglo de suspensos.
        int tamaño = totalSuspensos(); // Obtiene la cantidad total de suspensos.

        if (tamaño < 0) {
            tamaño = 1; // Si el tamaño es negativo, se ajusta a 1.
        }

        int[] suspensos = new int[tamaño]; // Crea un arreglo del tamaño necesario para los suspensos.

        if (totalSuspensos() > 0) { // Si hay al menos un suspenso.
            for (int i = 0; i < listaNotas.length; i++) { // Recorre todas las notas.
                if (notaAlumno(i) < 5) { // Si la nota es menor a 5.
                    suspensos[indice] = i; // Guarda el índice del alumno suspenso.
                    indice++; // Avanza al siguiente espacio del arreglo.
                }
            }
        } else {
            suspensos = new int[0]; // Si no hay suspensos, crea un arreglo vacío.
        }

        return suspensos; // Devuelve el arreglo con los índices de los alumnos suspensos.
    }

    /**
     * Encuentra el índice del primer alumno con una nota menor a la especificada.
     *
     * @param nota La nota de referencia.
     * @return El índice del primer alumno con una nota menor, o -1 si no hay notas
     * menores a la especificada o no hay alumnos.
     */
    public int primerMenor(double nota) {
        int indice = 0; // Comienza desde el primer índice.
        int primerMenor = -1; // Inicializa con -1 (indicando que no se encontró).

        while (indice < listaNotas.length && primerMenor == -1) {
            // Recorre las notas mientras no se encuentre un valor menor.
            if (listaNotas[indice] < nota) { // Si encuentra una nota menor.
                primerMenor = indice; // Guarda el índice del primer menor.
            }
            indice++; // Avanza al siguiente índice.
        }

        return primerMenor; // Devuelve el índice del primer menor, o -1 si no se encontró.
    }

    /**
     * Ordena las notas de los alumnos en orden ascendente utilizando el método de burbuja.
     *
     * @return Un array con las notas ordenadas en orden ascendente.
     */
    public double[] ordenar() {
        double[] notasOrdenadas = listaNotas; // Crea un arreglo para las notas.

        for (int i = 0; i < notasOrdenadas.length - 1; i++) {
            // Recorre el arreglo para realizar el ordenamiento (burbuja).
            for (int j = 0; j < notasOrdenadas.length - 1 - i; j++) {
                // Compara cada par de elementos adyacentes.
                if (notasOrdenadas[j] > notasOrdenadas[j + 1]) {
                    // Si un elemento es mayor que el siguiente.
                    double swap = notasOrdenadas[j]; // Intercambia los valores.
                    notasOrdenadas[j] = notasOrdenadas[j + 1];
                    notasOrdenadas[j + 1] = swap;
                }
            }
        }

        return notasOrdenadas; // Devuelve el arreglo ordenado.
    }

    /**
     * Analiza el rendimiento del grupo y proporciona una recomendación basada en
     * la distribución de notas.
     * <ul>
     *   <li>Si más de 2/3 tienen notas mayores a 7: "VAMOS FENOMENAL".</li>
     *   <li>Si más de 2/3 tienen notas entre 5 y 7: "REPASAR EJERCICIOS CON DIFICULTAD".</li>
     *   <li>Si más de 2/3 tienen notas menores a 5: "VAMOS MAL... REPEMOS EL TEMARIO".</li>
     *   <li>En cualquier otro caso: "HACER SUBGRUPOS CON TAREAS DE DIFERENTE DIFICULTAD".</li>
     * </ul>
     */
    public void analizaGrupo() {
        int mas7 = 0; // Contador de alumnos con notas mayores a 7.
        int de5a7 = 0; // Contador de alumnos con notas entre 5 y 7 (inclusive).
        int menos5 = 0; // Contador de alumnos con notas menores a 5.

        for (int i = 0; i < listaNotas.length; i++) { // Recorre todas las notas.
            if (listaNotas[i] > 7) {
                mas7++; // Incrementa el contador de notas mayores a 7.
            } else if (listaNotas[i] <= 7 && listaNotas[i] >= 5) {
                de5a7++; // Incrementa el contador de notas entre 5 y 7.
            } else if (listaNotas[i] < 5) {
                menos5++; // Incrementa el contador de notas menores a 5.
            }
        }

        double dostercios = (listaNotas.length * 2) / 3.0; // Calcula dos tercios del total de alumnos.

        if (mas7 >= dostercios) { // Si más de dos tercios tienen notas mayores a 7.
            System.out.println("VAMOS FENOMENAL");
        } else if (de5a7 >= dostercios) {
            // Si más de dos tercios tienen notas entre 5 y 7.
            System.out.println("REPASAR EJERCICIOS CON DIFICULTAD");
        } else if (menos5 >= dostercios) {
            // Si más de dos tercios tienen notas menores a 5.
            System.out.println("VAMOS MAL... REPEMOS EL TEMARIO");
        } else {
            // Si no se cumple ninguna de las anteriores, propone hacer subgrupos.
            System.out.println("HACER SUBGRUPOS CON TAREAS DE DIFERENTE DIFICULTAD");
        }
    }

    /**
     * Devuelve una representación en forma de String del grupo, mostrando el nombre
     * de la asignatura y las notas de cada alumno.
     *
     * @return Un String con el nombre de la asignatura y las notas de los alumnos.
     * Si no hay notas registradas, devuelve "Sin notas por el momento".
     */
    @Override
    public String toString() {
        StringBuilder notas = new StringBuilder(); // Crea un StringBuilder para las notas.

        if (listaNotas == null || listaNotas.length == 0) {
            // Si no hay notas registradas, indica que no hay notas.
            notas.append("Sin notas por el momento");
        } else {
            for (int i = 0; i < listaNotas.length; i++) {
                // Recorre las notas y las añade al StringBuilder.
                notas.append("Alumno ").append(i + 1).append(": ").append(listaNotas[i]).append("\n");
            }
        }

        return nombreAsignatura + "\n" + notas.toString();
        // Devuelve el nombre de la asignatura y las notas como un String.
    }


    public String getNombreAsignatura(){
        return nombreAsignatura;
    }

}
