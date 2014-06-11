package algoritmogenetico;

import java.util.Random;

public class Cromosoma {

    public int[] cromosoma;
    private int aptitud = 0;
    private final int TAMANIO = 20;
    public boolean mutado = false;

    public Cromosoma() {
        this.cromosoma = new int[this.TAMANIO];
        Random r = new Random();
        int gen;
        for (int i = 0; i < this.TAMANIO; i++) {
            gen = r.nextInt(2);
            this.cromosoma[i] = gen;
            this.aptitud += gen;
        }
    }

    public int getAptitud() {
        return aptitud;
    }

    public Cromosoma(int[] cromosoma) {
        this.cromosoma = cromosoma;
        for (int i = 0; i < this.TAMANIO; i++) {
            this.aptitud += cromosoma[i];
        }
    }

    @Override
    public String toString() {
        String cromosoma = "";
        if (this.mutado) {
            cromosoma += "\033[34m";
        }
        for (int i = 0; i < TAMANIO; i++) {
            if (i == 7 && this.mutado) {
                cromosoma += "\033[31m";
                cromosoma += this.cromosoma[i];
                cromosoma += "\033[34m";
            }else{
                cromosoma += this.cromosoma[i];
            }
            
        }
        return cromosoma + " => Aptitud: " + String.valueOf(this.aptitud);
    }
}
