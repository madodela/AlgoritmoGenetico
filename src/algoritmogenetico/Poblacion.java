package algoritmogenetico;

import java.util.ArrayList;

public class Poblacion {

    private static int id_poblacion = 0;
    private ArrayList<Cromosoma> poblacion;
//    private final int TAMANIO = 50;

    public Poblacion(ArrayList<Cromosoma> poblacion) {
        this.poblacion = poblacion;
        this.id_poblacion++;
    }

    public void toStrings(int id) {
        System.out.println("----   POBLACION " + id + "  ----");
        for (int i = 0, len_p = this.poblacion.size(); i < len_p; i++) {
            Cromosoma crom = this.poblacion.get(i);
            System.out.println(crom.arrayToString());
        }
    }

    public ArrayList<Cromosoma> getPoblacion() {
        return poblacion;
    }
    
    
}
