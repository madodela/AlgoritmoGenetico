package algoritmogenetico;

import java.util.ArrayList;

public class Poblacion {

    private final int TAMANIO = 50;
    public ArrayList<Cromosoma> poblacion = new ArrayList<>(TAMANIO);

    public Poblacion() {
        this.poblacion = new ArrayList<>(TAMANIO);
    }

    public void toStrings(int id) {
        int aptitudPoblacional = 0;
        System.out.println("\n                   ----   POBLACION " + id + "  ----");
        for (int i = 0, len_p = this.poblacion.size(); i < len_p; i++) {
            Cromosoma crom = this.poblacion.get(i);
            aptitudPoblacional += crom.getAptitud();
            System.out.println(crom.toString());
        }
        System.out.println("                    Aptitud poblacional: " + aptitudPoblacional);
    }
}
