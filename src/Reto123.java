import java.util.Scanner;

public class Reto123 {

    static String[][][] terminaciones = {
            {       {"o", "as", "a", "amos", "ais", "an"},
                    {"e", "aste", "o", "amos", "asteis", "aron"},
                    {"are", "aras", "ara", "aremos", "areis", "aran"}
            },
            {       {"o", "es", "e", "emos", "eis", "en"},
                    {"i", "iste", "io", "imos", "isteis", "ieron"},
                    {"ere", "eras", "era", "eremos", "ereis", "eran"}
            },
            {       {"o", "es", "e", "imos", "is", "en"},
                    {"i", "iste", "io", "imos", "isteis", "ieron"},
                    {"ire", "iras", "ira", "iremos", "ireis", "iran"}
            }
    };

    static String[] pronombres = {"yo", "tu", "el", "nosotros", "vosotros", "ellos"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String verbo, letra;

        do {
            verbo = sc.next();
            letra = sc.next();

            if (!letra.equals("T")) {
                String termina, raiz;
                termina = verbo.substring(verbo.length()-2);
                raiz = verbo.substring(0, verbo.length()-2);

                int x, y, z;

                x = termina.equals("ar") ? 0 : termina.equals("er") ? 1 : 2;
                y = letra.equals("A") ? 0 : letra.equals("P") ? 1 : 2;


                for (z = 0; z < 6; z++) {
                    System.out.println(pronombres[z] + " "+raiz+ terminaciones[x][y][z]);
                }

            }

        } while (!letra.equals("T"));

    }


}
