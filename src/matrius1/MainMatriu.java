package matrius1;

import java.util.Scanner;
import matrius1.FilMatriu;

public class MainMatriu {
    public static void main() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Numero Files (Matriu 1, que sigui entre 1-20): ");
        int filesMatriu1 = scan.nextInt();

        System.out.println("Numero Columnes (Matriu 1, que sigui entre 1-20): ");
        int columnesMatriu1 = scan.nextInt();

        System.out.println("Numero Files (Matriu 2, que sigui entre 1-20): ");
        int filesMatriu2 = scan.nextInt();

        System.out.println("Numero Columnes (Matriu 2, que sigui entre 1-20): ");
        int columnesMatriu2 = scan.nextInt();

        if (filesMatriu1 > 20 || 1 > filesMatriu1 || filesMatriu2 > 20 || 1 > filesMatriu2 || columnesMatriu1 > 20 || 1 > columnesMatriu1 || columnesMatriu2 > 20 || 1 > columnesMatriu2) {
            System.out.println("T'has passat de files/columnes!");
            System.exit(1); // amb 1 de parametre ja que es amb error el exit.
        }
        else if (!(columnesMatriu1 == filesMatriu2)) {
            System.out.println("Columnes de la Matriu 1 no son igual a les files de la Matriu 2!");
            System.exit(1); // amb 1 de parametre ja que es amb error el exit.
        }

        int[][] Matriu1 = new int[filesMatriu1][columnesMatriu1];
        int[][] Matriu2 = new int[filesMatriu2][columnesMatriu2];

        for (int i = 0; i < filesMatriu1; i++){


        }




        //  for (int i = 0; i < fil; i++) {
        //  try {
        //       fils[i].join(); // s'ha de fer el join apart perque si n'ho es fa tot sincronitzat es a dir, es fa de forma secuencial,
                // fins que no acabi el 1 no es fara el 2, en canvi si ho fem amb un bucle extern, inicia els 5 seguits
        //   } catch (InterruptedException e) {
        //       System.out.println("Error fent el Join!");
        //   }
        }
    }