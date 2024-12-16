/**
 * Clase principal del programa para gestionar una evaluación de alumnos.
 * Permite realizar diversas operaciones como leer notas, calcular la media,
 * encontrar el mejor o peor alumno, entre otras.
 */
import java.util.Scanner;

public class Principal {
    /**
     * Método principal donde se ejecuta el programa.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Asignatura evaluacion = null; // Objeto que representará la evaluación.

        int opcion; // Variable para almacenar la opción seleccionada por el usuario.

        do {
            // Menú principal del programa.
            System.out.println("""
                    1- Crear Evaluación
                    2- Leer Notas
                    3- Mostrar Notas
                    4- Mostrar Media
                    5- Mostrar Nota Mínima
                    6- Mostrar Nota Máxima
                    7- Total Suspensos
                    8- Total Aprobados
                    9- Cambiar Nota
                    10- Mejor Alumno
                    11- Peor Alumno
                    12- Nota de un Alumno
                    13- Aprobados (índices)
                    14- Suspensos (índices)
                    15- Primer Alumno con Nota Menor
                    16- Notas Ordenadas
                    17- Analizar Grupo
                    0- Salir
                    Elige una opción: 
                    """);

            opcion = sc.nextInt(); // Leer la opción seleccionada.

            switch (opcion) {
                case 1 -> {
                    // Crear una nueva evaluación.
                    System.out.print("Introduce el nombre de la asignatura: ");
                    String nombreAsignatura = sc.next();
                    evaluacion = new Asignatura(nombreAsignatura);
                    System.out.println("Evaluación creada.");
                }
                case 2 -> {
                    // Leer las notas de los alumnos.
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.print("Introduce el número de alumnos: ");
                        int totalAlumnos = sc.nextInt();
                        evaluacion.leerNotas(totalAlumnos);
                    }
                }
                case 3 -> {
                    // Mostrar todas las notas de la evaluación.
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.println(evaluacion);
                    }
                }
                case 4 -> {
                    // Mostrar la media de las notas.
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.println("Media: " + evaluacion.media());
                    }
                }
                case 5 -> {
                    // Mostrar la nota mínima.
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.println("Nota mínima: " + evaluacion.minimo());
                    }
                }
                case 6 -> {
                    // Mostrar la nota máxima.
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.println("Nota máxima: " + evaluacion.maximo());
                    }
                }
                case 7 -> {
                    // Mostrar el total de suspensos.
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.println("Total suspensos: " + evaluacion.totalSuspensos());
                    }
                }
                case 8 -> {
                    // Mostrar el total de aprobados.
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.println("Total aprobados: " + evaluacion.totalAprobados());
                    }
                }
                case 9 -> {
                    // Cambiar la nota de un alumno.
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.print("Introduce el índice del alumno: ");
                        int indice = sc.nextInt();
                        System.out.print("Introduce la nueva nota: ");
                        double nuevaNota = sc.nextDouble();
                        evaluacion.cambiarNota(nuevaNota, indice);
                    }
                }
                case 10 -> {
                    // Mostrar el índice del mejor alumno.
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.println("Mejor alumno (índice): " + evaluacion.mejorAlumno());
                    }
                }
                case 11 -> {
                    // Mostrar el índice del peor alumno.
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.println("Peor alumno (índice): " + evaluacion.peorAlumno());
                    }
                }
                case 12 -> {
                    // Mostrar la nota de un alumno.
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.print("Introduce el índice del alumno: ");
                        int alumnoIndice = sc.nextInt();
                        System.out.println("Nota del alumno: " + evaluacion.notaAlumno(alumnoIndice));
                    }
                }
                case 13 -> {
                    // Mostrar los índices de los alumnos aprobados.
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        int[] aprobados = evaluacion.dameAprobados();
                        System.out.println("Aprobados (índices): " + java.util.Arrays.toString(aprobados));
                    }
                }
                case 14 -> {
                    // Mostrar los índices de los alumnos suspensos.
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        int[] suspensos = evaluacion.dameSuspensos();
                        System.out.println("Suspensos (índices): " + java.util.Arrays.toString(suspensos));
                    }
                }
                case 15 -> {
                    // Mostrar el índice del primer alumno con una nota menor que el límite.
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.print("Introduce la nota límite: ");
                        double limiteNota = sc.nextDouble();
                        System.out.println("Primer alumno con nota menor: " + evaluacion.primerMenor(limiteNota));
                    }
                }
                case 16 -> {
                    // Mostrar las notas ordenadas.
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        double[] notasOrdenadas = evaluacion.ordenar();
                        System.out.println("Notas ordenadas: " + java.util.Arrays.toString(notasOrdenadas));
                    }
                }
                case 17 -> {
                    // Realizar un análisis general del grupo.
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        evaluacion.analizaGrupo();
                    }
                }
                case 0 -> System.out.println("Saliendo del programa. ¡Hasta luego!");
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
