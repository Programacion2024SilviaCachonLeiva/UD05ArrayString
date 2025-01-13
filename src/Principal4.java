import java.util.Scanner;

public class Principal4 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Crear una instancia de VentasSemanales
            System.out.println("Ingrese el número de semanas a gestionar: ");
            int numSemanas = scanner.nextInt();
            VentasSemanales ventas = new VentasSemanales(numSemanas);

            int opcion;

            // Menú interactivo
            do {
                System.out.println("\n=== MENÚ DE PRUEBA ===");
                System.out.println("1. Inicializar ventas a 0");
                System.out.println("2. Guardar una venta");
                System.out.println("3. Mostrar ventas en formato tabla");
                System.out.println("4. Total de ventas de una semana específica");
                System.out.println("5. Total de ventas de un día específico");
                System.out.println("6. Media de ventas de un día específico");
                System.out.println("7. Mostrar total de ventas por día (tabla)");
                System.out.println("8. Mostrar media de ventas por día (tabla)");
                System.out.println("0. Salir");
                System.out.print("Elija una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        ventas.inicializarVentas();
                        System.out.println("Ventas inicializadas a 0.");
                        break;

                    case 2:
                        System.out.println("Ingrese la semana (1 a " + numSemanas + "): ");
                        int semana = scanner.nextInt();
                        System.out.println("Ingrese el día (0 para lunes, 6 para domingo): ");
                        int dia = scanner.nextInt();
                        System.out.println("Ingrese el valor de la venta: ");
                        int valor = scanner.nextInt();
                        ventas.guardarVenta(semana, dia, valor);
                        System.out.println("Venta guardada.");
                        break;

                    case 3:
                        System.out.println("\n=== Ventas Semanales ===");
                        System.out.println(ventas);
                        break;

                    case 4:
                        System.out.println("Ingrese la semana (1 a " + numSemanas + "): ");
                        semana = scanner.nextInt();
                        int totalSemana = ventas.totalSemana(semana);
                        if (totalSemana != -1) {
                            System.out.println("Total de ventas en la semana " + semana + ": " + totalSemana);
                        }
                        break;

                    case 5:
                        System.out.println("Ingrese el día (0 para lunes, 6 para domingo): ");
                        dia = scanner.nextInt();
                        int totalDia = ventas.totalDiaSemana(dia);
                        if (totalDia != -1) {
                            System.out.println("Total de ventas en el día " + dia + ": " + totalDia);
                        }
                        break;

                    case 6:
                        System.out.println("Ingrese el día (0 para lunes, 6 para domingo): ");
                        dia = scanner.nextInt();
                        double mediaDia = ventas.mediaDiaSemana(dia);
                        if (mediaDia != -1) {
                            System.out.printf("Media de ventas en el día %d: %.2f%n", dia, mediaDia);
                        }
                        break;

                    case 7:
                        System.out.println("\n=== Total de Ventas por Día ===");
                        System.out.println(ventas.totalSemanaTabla());
                        break;

                    case 8:
                        System.out.println("\n=== Media de Ventas por Día ===");
                        System.out.println(ventas.mediaSemanaTabla());
                        break;

                    case 0:
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } while (opcion != 0);

            scanner.close();
        }
    }


