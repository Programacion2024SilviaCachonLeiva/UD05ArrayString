/**
 * La clase VentasSemanales gestiona las ventas diarias de varias semanas.
 * Permite registrar las ventas, calcular totales y medias, y mostrar los datos en formato de tabla.
 */
public class VentasSemanales {
    /** Número total de semanas. */
    int numSemanas;

    /** Matriz que almacena las ventas diarias por semana. */
    int[][] seguimiento;

    /**
     * Constructor de la clase VentasSemanales.
     *
     * @param semanas Número de semanas a gestionar.
     */
    public VentasSemanales(int semanas) {
        this.numSemanas = semanas;
        this.seguimiento = new int[semanas][7]; // Cada semana tiene 7 días
    }

    /**
     * Registra una venta en un día y semana específicos.
     *
     * @param semana Número de la semana (1 a numSemanas).
     * @param dia    Día de la semana (0 para lunes, 6 para domingo).
     * @param valor  Valor de la venta a registrar.
     */
    public void guardarVenta(int semana, int dia, int valor) {
        if (semana > 0 && semana <= numSemanas && dia >= 0 && dia < 7) {
            seguimiento[semana - 1][dia] = valor; // Guardar la venta en la posición correspondiente
        } else {
            System.out.println("Semana o día fuera de rango."); // Mensaje de error si los valores son inválidos
        }
    }

    /**
     * Inicializa todas las ventas de la matriz a 0.
     */
    public void inicializarVentas() {
        for (int i = 0; i < seguimiento.length; i++) {
            for (int j = 0; j < seguimiento[i].length; j++) {
                seguimiento[i][j] = 0; // Todas las ventas se establecen en 0
            }
        }
    }

    /**
     * Representa la matriz de ventas como una tabla de texto.
     *
     * @return Una cadena con las ventas organizadas por semanas y días.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        // Encabezado de la tabla
        String[] encabezado = {"Semana", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for (String a : encabezado) {
            stringBuilder.append(String.format("%-10s", a)); // Formatear cada columna
        }
        stringBuilder.append("\n");

        // Agregar las ventas de cada semana
        for (int i = 0; i < seguimiento.length; i++) {
            stringBuilder.append(String.format("%-10s", "S" + (i + 1))); // Semana actual
            for (int c : seguimiento[i]) {
                stringBuilder.append(String.format("%-10d", c)); // Ventas del día
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    /**
     * Calcula el total de ventas para una semana específica.
     *
     * @param semana Número de la semana (1 a numSemanas).
     * @return Total de ventas de la semana o -1 si la semana está fuera de rango.
     */
    public int totalSemana(int semana) {
        int suma = -1; // Valor predeterminado en caso de error
        if (semana > 0 && semana <= numSemanas) {
            suma = 0;
            for (int venta : seguimiento[semana - 1]) {
                suma += venta; // Sumar todas las ventas de la semana
            }
        } else {
            System.out.println("Semana fuera de rango."); // Mensaje de error
        }
        return suma;
    }

    /**
     * Calcula el total de ventas para un día específico a lo largo de todas las semanas.
     *
     * @param dia Día de la semana (0 para lunes, 6 para domingo).
     * @return Total de ventas del día o -1 si el día está fuera de rango.
     */
    public int totalDiaSemana(int dia) {
        int suma = -1; // Valor predeterminado en caso de error
        if (dia >= 0 && dia < 7) {
            suma = 0;
            for (int[] semana : seguimiento) {
                suma += semana[dia]; // Sumar todas las ventas del día en todas las semanas
            }
        } else {
            System.out.println("Día fuera de rango."); // Mensaje de error
        }
        return suma;
    }

    /**
     * Calcula la media de ventas para un día específico a lo largo de todas las semanas.
     *
     * @param dia Día de la semana (0 para lunes, 6 para domingo).
     * @return Media de ventas del día o -1 si el día está fuera de rango.
     */
    public double mediaDiaSemana(int dia) {
        double media = -1; // Valor predeterminado en caso de error
        if (dia >= 0 && dia < 7) {
            int suma = 0;
            for (int[] semana : seguimiento) {
                suma += semana[dia]; // Sumar todas las ventas del día
            }
            media = (double) suma / numSemanas; // Calcular la media
        } else {
            System.out.println("Día fuera de rango."); // Mensaje de error
        }
        return media;
    }

    /**
     * Crea una tabla que muestra el total de ventas por día de la semana.
     *
     * @return Una cadena con los totales de ventas para cada día de la semana.
     */
    public String totalSemanaTabla() {
        StringBuilder stringBuilder = new StringBuilder();
        String[] encabezado = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for (String a : encabezado) {
            stringBuilder.append(String.format("%-10s", a)); // Encabezado
        }
        stringBuilder.append("\n");
        for (int i = 0; i < encabezado.length; i++) {
            stringBuilder.append(String.format("%-10d", totalDiaSemana(i))); // Total de cada día
        }
        return stringBuilder.toString();
    }

    /**
     * Crea una tabla que muestra la media de ventas por día de la semana.
     *
     * @return Una cadena con las medias de ventas para cada día de la semana.
     */
    public String mediaSemanaTabla() {
        StringBuilder stringBuilder = new StringBuilder();
        String[] encabezado = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for (String a : encabezado) {
            stringBuilder.append(String.format("%-10s", a)); // Encabezado
        }
        stringBuilder.append("\n");
        for (int i = 0; i < encabezado.length; i++) {
            stringBuilder.append(String.format("%-10.2f", mediaDiaSemana(i))); // Media de cada día
        }
        return stringBuilder.toString();
    }
}
