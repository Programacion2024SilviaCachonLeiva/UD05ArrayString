import java.util.Scanner;

public class Principal2 {

    public static void main(String[] args) {
        int opc;
        Grupo grupo = new Grupo("DAM1k",5,3);

        do{
            Scanner sc = new Scanner(System.in);

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
                    """);

            opc = sc.nextInt();




            switch (opc){
                case 1 -> grupo.leerAlumnos();
                case 2 -> grupo.leerAsignaturas();
                case 3 -> System.out.println(grupo);
                case 4 -> grupo.mostrarAsignaturas();
                case 5-> grupo.mostrarMedias();
                case 6 -> System.out.println(grupo.dameAsignaturaMinima());
                case 7 -> System.out.println(grupo.dameAsignaturaMaxima());
                case 8 -> System.out.println(grupo.dameMejorAlumnoMedia());
                case 9 -> grupo.muestraMediaAlumnos();
                case 10 -> grupo.muestraRepartidores();
                case 11 -> grupo.analizarAsignaturas();
                case 12 -> grupo.analizarCurso();



            }

        }while(opc != 13);
    }

















}