package matrius1;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
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

            System.out.println("Com vols introduir les dades?");
            System.out.println(" - Manualment per Consola (PREM 1) ");
            System.out.println(" - Llegir a partir d'un fitxer de text (PREM 2) ");
            System.out.println("Opcio: ");
            int entrada = scan.nextInt();

            switch (entrada) {
                case 1:
                    for (int i = 0; i < filesMatriu1; i++) {
                        for (int j = 0; j < columnesMatriu1; j++) {
                            System.out.println("Introdueix per a la Matriu 1 - Fila " + (i+1) + " Columna " + (j+1) + ":");
                            Matriu1[i][j] = scan.nextInt();
                        }
                    }

                    for (int z = 0; z < filesMatriu2; z++) {
                        for (int y = 0; y < columnesMatriu2; y++){
                            System.out.println("Introdueix per a la Matriu 2 - Fila " + (z+1) + " Columna " + (y+1) + ":");
                            Matriu2[z][y] = scan.nextInt();
                        }
                    }
                    break;

                case 2:
                    System.out.println("Introdueix el nom del fitxer de text per la Matriu 1: ");
                    String nom = scan.next();
                    try {
                        Scanner sc = new Scanner (new File(nom));
                        for (int i = 0; i < filesMatriu1; i++) {
                            for (int j = 0; j < columnesMatriu1; j++) {
                                if (sc.hasNextInt()) Matriu1[i][j] = sc.nextInt();
                            }
                        }
                        sc.close();

                    } catch (Exception e) {
                        System.out.println("No s'ha trobat el fitxer " + nom);
                        throw new RuntimeException(e);
                    }

                    System.out.println("Introdueix el nom del fitxer de text per la Matriu 2: ");
                    String nom2 = scan.next();

                    try {
                        Scanner sc2 = new Scanner (new File(nom2));
                        for (int z = 0; z < filesMatriu2; z++) {
                            for (int y = 0; y < columnesMatriu2; y++) {
                                if (sc2.hasNextInt()) Matriu2[z][y] = sc2.nextInt();
                            }
                        }
                        sc2.close();
                    } catch (Exception e) {
                        System.out.println("No s'ha trobat el fitxer " + nom2);
                        throw new RuntimeException(e);
                    }
                    break;

                default:
                    throw new RuntimeException("Opcio no valida");
            }


            // Gestio de fils

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

                System.out.println();
                System.out.println("MATRIU RESULTANT: ");

                for (int l = 0; l < filesMatriu1; l++) {
                    for (int d = 0; d < columnesMatriu2; d++){
                        System.out.print(Resultat[l][d] + " ");
                    }
                    System.out.println();
        }


                // EMMAGATZEMAR LES DADES AL FITXER
                System.out.println("Vols emmagatzemar dins el fitxer la matriu resultant? (3/4)");
                System.out.println("3. Guardar el Nom del fitxer de sortida");
                System.out.println("4. No guardar el fitxer");
                int opcioGuardar = scan.nextInt();

                switch (opcioGuardar) {
                    case 3:
                        System.out.println("Nom del Fitxer de sortida: ");
                        String nomSortida = scan.next();
                        try {
                            PrintWriter escriuFitxer = new PrintWriter(nomSortida); // comando per escriure la matriu resultant dins el fitxer
                            for (int l = 0; l < filesMatriu1; l++) {
                                for (int d = 0; d < columnesMatriu1; d++) {
                                    escriuFitxer.print(Matriu1[l][d] + " ");
                                }
                                escriuFitxer.println(); // Salt de linea
                            }
                            escriuFitxer.close();
                            System.out.println("Nom del fitxer de sortida: " + nomSortida);

                        } catch (FileNotFoundException e) {
                            System.out.println("Error al crear el fitxer " + nomSortida);
                        }
                        break;

                    case 4:
                        System.out.println("No es guardara el fitxer");
                        break;

                  default:
                        throw new RuntimeException("Opcio no valida");

                }


                // BUCLE CONTINUACIO
                boolean seguir = true;
                while (seguir) {
                    System.out.println("Vols seguir amb una altra multiplicació amb les mateixes dimensions o sortir? (S/N)");
                    String resposta = scan.next();
                    if (resposta.equals("S")) {
                        for (int i = 0; i < filesMatriu1; i++) {
                            for (int j = 0; j < columnesMatriu1; j++){
                                System.out.println("Introdueix per a la Matriu 1 - Fila " + (i+1) + " Columna " + (j+1) + ":");
                                Matriu1[i][j] = scan.nextInt();
                            }
                        }

                        for (int z = 0; z < filesMatriu2; z++) {
                            for (int y = 0; y < columnesMatriu2; y++){
                                System.out.println("Introdueix per a la Matriu 2 - Fila " + (z+1) + " Columna " + (y+1) + ":");
                                Matriu2[z][y] = scan.nextInt();
                            }
                        }

                        FilMatriu[][] fils2 = new FilMatriu[filesMatriu1][columnesMatriu2];

                        for (int o = 0; o < filesMatriu1; o++) {
                            for (int u = 0; u < columnesMatriu2; u++){
                                fils2[o][u] = new FilMatriu(Matriu1,Matriu2,o,u,Resultat);
                                fils2[o][u].start();
                            }
                        }

                        for (int y = 0; y < filesMatriu1; y++) {
                            for (int p = 0; p < columnesMatriu2; p++){
                                try {
                                    fils2[y][p].join();
                                }
                                catch (InterruptedException e) {
                                    System.out.println("Error amb els joins.");
                                }
                            }
                        }

                        System.out.println();

                        for (int l = 0; l < filesMatriu1; l++) {
                            for (int d = 0; d < columnesMatriu2; d++){
                                System.out.print(Resultat[l][d] + " ");
                            }
                            System.out.println();
                        }
                    }
                    else {
                        seguir = false;
                        System.exit(0); // es tanca amb codi 0, que vol dir de forma correcta.
                    }
                }
    }
}