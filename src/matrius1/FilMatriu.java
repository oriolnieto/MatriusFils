package matrius1;

public class FilMatriu extends Thread{

    private int fila;
    private int columna;
    private int resultat;

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

    public FilMatriu (int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public void run() {
        resultat = fila * columna;
    }
}