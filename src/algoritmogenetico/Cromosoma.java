package algoritmogenetico;

import java.util.ArrayList;
import java.util.Random;

public class Cromosoma {

    private int[] cromosoma;
    private int aptitud = 0;
    private final int TAMANIO = 20;

    public Cromosoma() {
        this.cromosoma = new int[this.TAMANIO];
        Random r = new Random();
        int gen;
        for (int i = 0; i < this.TAMANIO; i++) {
            gen = r.nextInt(2);
            this.cromosoma[i]= gen;
            this.aptitud += gen;
        }
    }

    public Cromosoma(int[] cromosoma){
        this.cromosoma=cromosoma;
    }
    public int[] getCromosoma() {
        return cromosoma;
    }

    public String arrayToString() {
        return this.cromosoma.toString() + " => Aptitud: " + String.valueOf(this.aptitud);
    }

}
