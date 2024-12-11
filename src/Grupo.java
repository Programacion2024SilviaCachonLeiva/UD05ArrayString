import java.util.Arrays;
import java.util.Scanner;

public class Grupo {

    private String nombreGrupo;
    private String[] alumnos;
    private Asignatura[] asignaturas;
    private int totalAlumnos;
    private int totalAsignaturas;
    private Scanner sc = new Scanner(System.in);

    //Constructor
    public Grupo(String nombreGrupo, int totalAlumnos, int totalAsignaturas){
        this.totalAlumnos = totalAlumnos;
        this.totalAsignaturas = totalAsignaturas;

        this.nombreGrupo = nombreGrupo;
        this.alumnos = new String[this.totalAlumnos];
        this.asignaturas = new Asignatura[this.totalAsignaturas];
    }

    //Métodos
    public void leerAlumnos(){
        for(int i = 0; i < alumnos.length; i++){
            System.out.println("Nombre del alumno "+(i+1)+": ");
            alumnos[i] = sc.next();
        }

        Arrays.sort(alumnos);
    }
    public void mostrarAlumnos(){
        for(int i = 0; i < alumnos.length; i++){
            System.out.println("Nombre del alumno "+(i+1)+": "+ alumnos[i]);
        }

    }
    public void leerAsignaturas(){
        for(int i = 0; i < asignaturas.length; i++){
            System.out.println("Nombre de la asignatura "+(i+1)+":");
            asignaturas[i] = new Asignatura(sc.next());
            asignaturas[i].leerNotas(totalAlumnos);
        }

    }
    public void mostrarAsignaturas(){
        for(int i = 0; i < asignaturas.length;i++){
            System.out.println(asignaturas[i].getNombreAsignatura());
        }
    }

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


    public void mostrarMedias(){}
    public String dameAsignaturaMinima(){}
    public String dameAsignaturaMaxima(){}
    public double dameMediaAsignatura(){}
    public double dameAlumnoMedia(){}
    public double dameAlumnoSuspensos(){}
    public String dameMejorAlumnoMedia(){}
    public void muestraMediaAlumnos(){}
    public void muestraRepartidores(){}
    public void analizarAsignaturas(){}

}
