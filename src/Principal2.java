import java.util.Scanner;

/**
 * Clase principal del programa que gestiona un grupo de estudiantes y realiza diversas operaciones
 * como la lectura de alumnos, asignaturas, cálculo de estadísticas y análisis de datos.
 */
public class Principal2 {

    /**
     * Método principal que presenta un menú interactivo para realizar diferentes operaciones
     * relacionadas con un grupo de estudiantes.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        // Variable para la opción del menú.
        int opc;

        // Creación de un grupo con nombre, número de alumnos y número de asignaturas.
        Grupo grupo = new Grupo("DAM1k", 5, 3);

        // Bucle que presenta el menú hasta que el usuario elija la opción de salida (13).
        do {
            // Creación del objeto Scanner para leer la entrada del usuario.
            Scanner sc = new Scanner(System.in);

            // Menú de opciones.
            System.out.println("""
                    1- Leer Alumnos
                    2- Leer Notas Asignaturas
                    3- Mostrar Grupo y Notas
                    4- Ver asignaturas
                    5- Ver media asignaturas
                    6- Ver asignatura menor mínimo
                    7- Ver asignatura mayor máximo
                    8- Mostrar el alumno con mejor media
                    9- Muestra media de los alumnos
                    10- Muestra repetidores
                    11- Analiza Asignaturas
                    12- Analizar Curso
                    13- Salir
                    """);

            // Lectura de la opción seleccionada por el usuario.
            opc = sc.nextInt();

            // Estructura switch para ejecutar la acción correspondiente a cada opción.
            switch (opc) {
                case 1 -> grupo.leerAlumnos(); // Leer datos de los alumnos.
                case 2 -> grupo.leerAsignaturas(); // Leer las notas de las asignaturas.
                case 3 -> System.out.println(grupo); // Mostrar el grupo y las notas.
                case 4 -> grupo.mostrarAsignaturas(); // Mostrar las asignaturas.
                case 5 -> grupo.mostrarMedias(); // Mostrar las medias de las asignaturas.
                case 6 -> System.out.println(grupo.dameAsignaturaMinima()); // Mostrar asignatura con la nota más baja.
                case 7 -> System.out.println(grupo.dameAsignaturaMaxima()); // Mostrar asignatura con la nota más alta.
                case 8 -> System.out.println(grupo.dameMejorAlumnoMedia()); // Mostrar el alumno con mejor media.
                case 9 -> grupo.muestraMediaAlumnos(); // Mostrar la media de todos los alumnos.
                case 10 -> grupo.muestraRepartidores(); // Mostrar alumnos que están repitiendo.
                case 11 -> grupo.analizarAsignaturas(); // Analizar las asignaturas.
                case 12 -> grupo.analizarCurso(); // Analizar el curso completo.
            }

        } while (opc != 13); // Salir del bucle cuando se selecciona la opción 13.
    }
}
