public class Ejercicio6 {


    public static void main(String[] args) {
       int[][] a = {{4,5,6},{5,9,7},null};
        imprimirArray(a);
    }


    private static void imprimirArray(int[][] array) {

        for (int[] a : array) {
            if (a == null) {
                System.out.println("Fila vacía");
            } else {
                for (int b : a) {
                    System.out.print(b);
                }
                System.out.println();
            }
        }


    }


}
