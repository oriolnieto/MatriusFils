package matrius1;

public class FilMatriu extends Thread {

    private int [][] Matriu1;
    private int [][] Matriu2;
    private int fila;
    private int columna;
    private int [][] resultat;


    public FilMatriu(int[][] matriu1, int[][] matriu2, int fila, int columna, int[][] resultat) {
        Matriu1 = matriu1;
        Matriu2 = matriu2;
        this.fila = fila;
        this.columna = columna;
        this.resultat = resultat;
    }

    @Override
    public void run() {
            int suma = 0;
            for (int f = 0; f < Matriu1[0].length; f++) {
                suma += Matriu1[fila][f] * Matriu2[f][columna];
            }
            resultat[fila][columna] = suma;
        }
    }