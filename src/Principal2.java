import java.util.Scanner;

public class Principal2 {

    public static void main(String[] args) {
        int opc;
        Grupo grupo = new Grupo("DAM1k",24,5);

        do{
            Scanner sc = new Scanner(System.in);

            System.out.println("""
                    1- Leer Alumnos
                    2- Leer Notas y Asignaturas
                    3- Mostrar Grupo y Notas
                    4- Ver asignaturas
                    5- Ver media asignaturas
                    6- Ver asignatura menor mínimo
                    7- Ver asignatura mayor máximo
                    8- Mostrar el alumno con mejor media
                    9- Muestra media delos alumnos
                    10- Muestra repetidores
                    11- Analiza Asignaturas
                    """);

                opc = sc.nextInt();




                switch (opc){
                    case 1 -> grupo.leerAlumnos();
                    case 2 -> grupo.mostrarAlumnos();

                }

        }while(opc != 13);
    }

















}