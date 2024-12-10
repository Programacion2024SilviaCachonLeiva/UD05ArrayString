import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Asignatura evaluacion = null;

        int opcion;

        do {
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

            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.print("Introduce el nombre de la asignatura: ");
                    String nombreAsignatura = sc.next();
                    evaluacion = new Asignatura(nombreAsignatura);
                    System.out.println("Evaluación creada.");
                }
                case 2 -> {
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.print("Introduce el número de alumnos: ");
                        int totalAlumnos = sc.nextInt();
                        evaluacion.leerNotas(totalAlumnos);
                    }
                }
                case 3 -> {
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.println(evaluacion);
                    }
                }
                case 4 -> {
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.println("Media: " + evaluacion.media());
                    }
                }
                case 5 -> {
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.println("Nota mínima: " + evaluacion.minimo());
                    }
                }
                case 6 -> {
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.println("Nota máxima: " + evaluacion.maximo());
                    }
                }
                case 7 -> {
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.println("Total suspensos: " + evaluacion.totalSuspensos());
                    }
                }
                case 8 -> {
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.println("Total aprobados: " + evaluacion.totalAprobados());
                    }
                }
                case 9 -> {
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
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.println("Mejor alumno (índice): " + evaluacion.mejorAlumno());
                    }
                }
                case 11 -> {
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.println("Peor alumno (índice): " + evaluacion.peorAlumno());
                    }
                }
                case 12 -> {
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.print("Introduce el índice del alumno: ");
                        int alumnoIndice = sc.nextInt();
                        System.out.println("Nota del alumno: " + evaluacion.notaAlumno(alumnoIndice));
                    }
                }
                case 13 -> {
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        int[] aprobados = evaluacion.dameAprobados();
                        System.out.println("Aprobados (índices): " + java.util.Arrays.toString(aprobados));
                    }
                }
                case 14 -> {
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        int[] suspensos = evaluacion.dameSuspensos();
                        System.out.println("Suspensos (índices): " + java.util.Arrays.toString(suspensos));
                    }
                }
                case 15 -> {
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        System.out.print("Introduce la nota límite: ");
                        double limiteNota = sc.nextDouble();
                        System.out.println("Primer alumno con nota menor: " + evaluacion.primerMenor(limiteNota));
                    }
                }
                case 16 -> {
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        double[] notasOrdenadas = evaluacion.ordenar();
                        System.out.println("Notas ordenadas: " + java.util.Arrays.toString(notasOrdenadas));
                    }
                }
                case 17 -> {
                    if (evaluacion == null) {
                        System.out.println("Primero debes crear una evaluación.");
                    } else {
                        evaluacion.analizaGrupo();
                    }
                }
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }
}
