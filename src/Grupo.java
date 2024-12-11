import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Grupo {

    private String nombreGrupo;
    private String[] alumnos;
    private Asignatura[] asignaturas;
    private int totalAlumnos;
    private int totalAsignaturas;

    //Constructor
    public Grupo(String nombreGrupo, int totalAlumnos, int totalAsignaturas){
        this.nombreGrupo = nombreGrupo;
        this.alumnos = new String[totalAlumnos];
        this.asignaturas = new Asignatura[totalAsignaturas];
    }

    //Métodos
    public void leerAlumnos(){
        Scanner sc =new Scanner(System.in);

        for(int i = 0; i < alumnos.length; i++){
            System.out.println("Nombre del alumno "+(i+1)+": ");
            alumnos[i] = sc.next();
        }

        Arrays.sort(alumnos);
    }
    public void mostrarAlumnos(){}
    public void leerAsignaturas(){}
    public void mostrarAsignaturas(){}

    @Override
    public String toString(){
        return
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
