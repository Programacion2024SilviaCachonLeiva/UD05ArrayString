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
    public void leerAlumnos(){}
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
    public void muestraRepartidor(){}
    public void analizarAsignatura(){}

}
