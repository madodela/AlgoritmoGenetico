package algoritmogenetico;

import java.util.ArrayList;

public class Poblacion {

    private final int TAMANIO = 50;
    public ArrayList<Cromosoma> poblacion = new ArrayList<>(TAMANIO);

    public Poblacion() {
        this.poblacion = new ArrayList<>(TAMANIO);
    }

    public void toStrings(int id) {
        System.out.println("----   POBLACION " + id + "  ----");
        for (int i = 0, len_p = this.poblacion.size(); i < len_p; i++) {
            Cromosoma crom = this.poblacion.get(i);
            System.out.println(crom.toString());
        }
    }
}
