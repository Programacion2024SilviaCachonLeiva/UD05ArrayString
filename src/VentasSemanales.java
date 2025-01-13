public class VentasSemanales {
    int numSemanas;
    int[][] seguimiento;


    public VentasSemanales(int semanas) {
        this.numSemanas = semanas;
        this.seguimiento = new int[semanas][7];
    }

    public void guardarVenta(int semana, int dia, int valor) {
        seguimiento[semana][dia] = valor;
    }

    public void inicializarVentas() {
        for (int[] a : seguimiento) {
            for (int b : a) {
                a[b] = 0;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

    }

}
