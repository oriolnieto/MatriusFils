package matrius1;

// falta fer demanar opció, la que he fet ja que es demanant per consola i la que falta mitjançant arxiu, mirar mauri i irene practiques passades <3


import java.util.Scanner;
import matrius1.FilMatriu;

public class MainMatriu {
    public static void main (String[] args) {

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
        int[][] Resultat = new int[filesMatriu1][columnesMatriu2];

        for (int i = 0; i < filesMatriu1; i++) {
            for (int j = 0; j < columnesMatriu1; j++){
                System.out.println("Introdueix per a la Matriu 1 - Fila " + i + " Columna " + j + ":");
                Matriu1[i][j] = scan.nextInt();
        }

        for (int z = 0; z < filesMatriu2; z++) {
            for (int y = 0; y < columnesMatriu2; y++){
                System.out.println("Introdueix per a la Matriu 2 - Fila " + z + " Columna " + y + ":");
                Matriu2[z][y] = scan.nextInt();
                }
        }

            FilMatriu[][] fils = new FilMatriu[filesMatriu1][columnesMatriu2];

            for (int o = 0; o < filesMatriu1; o++) {
                for (int u = 0; u < columnesMatriu2; u++){
                    fils[o][u] = new FilMatriu(Matriu1,Matriu2,o,u,Resultat);
                    fils[o][u].start();
                }
            }

                for (int y = 0; y < filesMatriu1; y++) {
                    for (int p = 0; p < columnesMatriu2; p++){
                        try {
                            fils[y][p].join();
                        }
                        catch (InterruptedException e) {
                            System.out.println("Error amb els joins.");
                        }
                    }
                    }

                for (int l = 0; l < filesMatriu1; l++) {
                    for (int d = 0; d < columnesMatriu2; d++){
                        System.out.print(Resultat[l][d] + " ");
                    }
                    System.out.println();
        }
    }
}
    }