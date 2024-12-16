import java.util.Scanner;

/**
 * Esta clase contiene el método principal para interactuar con el grupo de estudiantes y sus asignaturas.
 * El programa permite gestionar los datos de los alumnos, sus asignaturas, y realizar análisis de sus notas.
 */
public class Principal2 {

    public static void main(String[] args) {
        int opc; // Variable para almacenar la opción seleccionada por el usuario
        Grupo grupo = new Grupo("DAM1k", 5, 3); // Creación de un grupo con 5 alumnos y 3 asignaturas

        // Bucle do-while para mostrar el menú y ejecutar las acciones basadas en la opción seleccionada
        do {
            // Crear el objeto Scanner una sola vez fuera del bucle
            Scanner sc = new Scanner(System.in);

            // Imprimir las opciones disponibles
            System.out.println("""
                    1- Leer Alumnos
                    2- Leer Notas Asignaturas
                    3- Mostrar Grupo y Notas
                    4- Ver asignaturas
                    5- Ver media asignaturas
                    6- Ver asignatura menor mínima
                    7- Ver asignatura mayor máxima
                    8- Mostrar el alumno con mejor media
                    9- Muestra media de los alumnos
                    10- Muestra repetidores
                    11- Analiza Asignaturas
                    13- Salir
                    """);

            // Leer la opción seleccionada por el usuario
            opc = sc.nextInt();

            // Ejecutar la acción correspondiente según la opción seleccionada
            switch (opc) {
                case 1 -> grupo.leerAlumnos(); // Llamar al método para leer los alumnos
                case 2 -> grupo.leerAsignaturas(); // Llamar al método para leer las asignaturas y sus notas
                case 3 -> System.out.println(grupo); // Mostrar el grupo con sus alumnos y notas
                case 4 -> grupo.mostrarAsignaturas(); // Mostrar las asignaturas
                case 5 -> grupo.mostrarMedias(); // Mostrar las medias de las asignaturas
                case 6 -> System.out.println(grupo.dameAsignaturaMinima()); // Mostrar la asignatura con la menor media
                case 7 -> System.out.println(grupo.dameAsignaturaMaxima()); // Mostrar la asignatura con la mayor media
                case 8 -> System.out.println(grupo.dameMejorAlumnoMedia()); // Mostrar el alumno con la mejor media
                case 9 -> grupo.muestraMediaAlumnos(); // Mostrar las medias de todos los alumnos
                case 10 -> grupo.muestraRepartidores(); // Mostrar los alumnos con más de 2 suspensos
                case 11 -> grupo.analizarAsignaturas(); // Analizar las asignaturas
                case 13 -> System.out.println("Saliendo..."); // Mensaje de salida
                default -> System.out.println("Opción no válida. Intente de nuevo."); // Mensaje para opciones no válidas
            }

            // Continuar mientras la opción seleccionada no sea 13 (salir)
        } while (opc != 13);
    }
}
