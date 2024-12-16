import java.util.Arrays;
import java.util.Scanner;

/**
 * Representa un grupo de alumnos con sus asignaturas y notas.
 */
public class Grupo {

    private String nombreGrupo;
    private String[] alumnos;
    private Asignatura[] asignaturas;
    private int totalAlumnos;
    private int totalAsignaturas;
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructor para inicializar un grupo con el nombre, número de alumnos y asignaturas.
     *
     * @param nombreGrupo Nombre del grupo.
     * @param totalAlumnos Número total de alumnos en el grupo.
     * @param totalAsignaturas Número total de asignaturas.
     */
    public Grupo(String nombreGrupo, int totalAlumnos, int totalAsignaturas) {
        this.totalAlumnos = totalAlumnos;
        this.totalAsignaturas = totalAsignaturas;
        this.nombreGrupo = nombreGrupo;
        this.alumnos = new String[this.totalAlumnos];
        this.asignaturas = new Asignatura[this.totalAsignaturas];
    }

    /**
     * Lee los nombres de los alumnos y los ordena alfabéticamente.
     */
    public void leerAlumnos() {
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("Nombre del alumno " + (i + 1) + ": ");
            alumnos[i] = sc.next();
        }

        Arrays.sort(alumnos);
    }

    /**
     * Muestra los nombres de todos los alumnos en el grupo.
     */
    public void mostrarAlumnos() {
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("Nombre del alumno " + (i + 1) + ": " + alumnos[i]);
        }
    }

    /**
     * Lee las asignaturas y las notas de los alumnos.
     */
    public void leerAsignaturas() {
        for (int i = 0; i < asignaturas.length; i++) {
            System.out.println("Nombre de la asignatura " + (i + 1) + ":");
            asignaturas[i] = new Asignatura(sc.next());
            asignaturas[i].leerNotas(totalAlumnos);
        }
    }

    /**
     * Muestra los nombres de todas las asignaturas.
     */
    public void mostrarAsignaturas() {
        for (int i = 0; i < asignaturas.length; i++) {
            System.out.println(asignaturas[i].getNombreAsignatura());
        }
    }

    /**
     * Devuelve una representación en formato de tabla con los nombres de los alumnos
     * y las notas correspondientes a cada asignatura.
     *
     * @return Cadena con la representación en formato de tabla.
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        // Encabezado
        string.append(String.format("%-15s", "Alumno")); // Nombre del alumno, 15 caracteres mínimo
        for (int a = 0; a < asignaturas.length; a++) {
            string.append(String.format("%-15s", asignaturas[a].getNombreAsignatura())); // 15 caracteres para cada asignatura
        }
        string.append("\n");

        // Filas de alumnos y sus notas
        for (int i = 0; i < alumnos.length; i++) {
            string.append(String.format("%-15s", alumnos[i])); // Nombre del alumno
            for (int j = 0; j < asignaturas.length; j++) {
                string.append(String.format("%-15.2f", asignaturas[j].notaAlumno(i))); // Nota con 2 decimales
            }
            string.append("\n");
        }

        return string.toString();
    }

    /**
     * Muestra la media de las notas de cada asignatura.
     */
    public void mostrarMedias() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < asignaturas.length; i++) {
            string.append(String.format("%-15s", asignaturas[i].getNombreAsignatura()));
        }
        string.append("\n");
        for (int i = 0; i < asignaturas.length; i++) {
            string.append(String.format("%-15.2f", asignaturas[i].media()));
        }
        System.out.println(string);
    }

    /**
     * Devuelve el nombre de la asignatura con la media más baja.
     *
     * @return Nombre de la asignatura con la media más baja.
     */
    public String dameAsignaturaMinima() {
        int min = -1;
        double notaMin = 11;
        for (int i = 0; i < asignaturas.length; i++) {

            if (asignaturas[i].media() < notaMin) {
                notaMin = asignaturas[i].media();
                min = i;
            }
        }

        return asignaturas[min].getNombreAsignatura();
    }

    /**
     * Devuelve el nombre de la asignatura con la media más alta.
     *
     * @return Nombre de la asignatura con la media más alta.
     */
    public String dameAsignaturaMaxima() {
        int max = -1;
        double notaMax = -1;
        for (int i = 0; i < asignaturas.length; i++) {

            if (asignaturas[i].media() > notaMax) {
                notaMax = asignaturas[i].media();
                max = i;
            }
        }

        return asignaturas[max].getNombreAsignatura();
    }

    /**
     * Devuelve la media de la asignatura en el índice proporcionado.
     *
     * @param i Índice de la asignatura.
     * @return Media de la asignatura.
     */
    public double dameMediaAsignatura(int i) {
        return asignaturas[i].media();
    }

    /**
     * Devuelve la media de las notas de un alumno especificado por su índice.
     *
     * @param i Índice del alumno.
     * @return Media de las notas del alumno.
     */
    public double dameAlumnoMedia(int i) {
        double media = 0;

        for (int j = 0; j < asignaturas.length; j++) {
            media += asignaturas[j].notaAlumno(i);
        }

        return media / asignaturas.length;
    }

    /**
     * Devuelve el número de asignaturas suspensas de un alumno especificado por su índice.
     *
     * @param i Índice del alumno.
     * @return Número de asignaturas suspensas.
     */
    public double dameAlumnoSuspensos(int i) {
        double suspensos = 0;

        for (int j = 0; j < asignaturas.length; j++) {

            if (asignaturas[j].notaAlumno(i) < 5) {
                suspensos++;
            }
        }

        return suspensos;
    }

    /**
     * Devuelve el nombre del mejor alumno basado en su media de notas.
     *
     * @return Nombre del mejor alumno.
     */
    public String dameMejorAlumnoMedia() {
        int mejor = -1;
        double mejorMedia = -1;
        for (int i = 0; i < alumnos.length; i++) {

            if (dameAlumnoMedia(i) > mejorMedia) {
                mejorMedia = dameAlumnoMedia(i);
                mejor = i;
            }
        }

        return alumnos[mejor];
    }

    /**
     * Muestra la media de todos los alumnos.
     */
    public void muestraMediaAlumnos() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < alumnos.length; i++) {
            string.append(String.format("%-15s", alumnos[i])).append(String.format("%-15.2f", dameAlumnoMedia(i))).append("\n");
        }

        System.out.println(string);
    }

    /**
     * Muestra los nombres de los alumnos que han suspendido más de dos asignaturas.
     */
    public void muestraRepartidores() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < alumnos.length; i++) {
            if (dameAlumnoSuspensos(i) > 2) {
                string.append(String.format("%-15s", alumnos[i])).append("\n");
            }
        }

        System.out.println(string);
    }

    /**
     * Analiza y muestra las estadísticas del grupo en cada asignatura.
     */
    public void analizarAsignaturas() {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < asignaturas.length; i++) {
            stringBuilder.append(String.format("%-15s", asignaturas[i])).append(String.format("%-15s", asignaturas[i].analizaGrupoS())).append("\n");
        }

        System.out.println(stringBuilder);
    }

    /**
     * Analiza el rendimiento del curso y muestra sugerencias basadas en la media de cada alumno.
     */
    public void analizarCurso() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < alumnos.length; i++) {
            stringBuilder.append((String.format("%-15s", alumnos[i])));

            if (dameAlumnoMedia(i) > 7) {
                stringBuilder.append((String.format("%-15s", "VAMOS FENOMENAL")));
            } else if (dameAlumnoMedia(i) < 7 && dameAlumnoMedia(i) >= 5) {
                stringBuilder.append((String.format("%-15s", "SIGUE ASI")));
            } else {
                stringBuilder.append((String.format("%-15s", "REFUERZA")));
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
