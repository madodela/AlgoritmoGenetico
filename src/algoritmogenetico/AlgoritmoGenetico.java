package algoritmogenetico;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AlgoritmoGenetico {

    public static final int TAM_POB = 50;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int cont = 0;
        System.out.print("Número de poblaciones: ");
        int n_p = cin.nextInt();
        ArrayList poblacion = new ArrayList(TAM_POB);
        Poblacion poblacion1 = new Poblacion(poblacion);
        Poblacion[] poblaciones = new Poblacion[n_p];
        /**
         * ************GENERAR PRIMERA GENERACION**********
         */
        //crea 50 cromosomas para primer poblacion
        for (int i = 0; i < TAM_POB; i++) {
            poblacion.add(new Cromosoma());
        }
        poblaciones[cont] = new Poblacion(poblacion);
        //mutar uno
        print(n_p, poblaciones);
        mutar(poblacion1);
//        do {
//            /**
//             * ********CREAR OTRAS POBLACIONES*********
//             *
//             * //funcion que reciba poblacion y crea cruzas (50 hijos)
//             */
//
//            cont++;
//        } while (cont < n_p - 1);

        print(n_p, poblaciones);
    }

    public static Poblacion procrear(Poblacion padres) {
        ArrayList<Cromosoma> cromosomas = new ArrayList<Cromosoma>();
        for (int i = 0; i < TAM_POB; i++) {

            Cromosoma padre1 = padres.getPoblacion().get(i);
            Cromosoma padre2 = padres.getPoblacion().get(i + 1);
            i++;
            int[] nuevoCromosoma = new int[20];
            for (int j = 0; j < 12; j++) {
                nuevoCromosoma[j] = (padre1.getCromosoma()[j]);
            }
            for (int j = 12; j < 20; j++) {
                nuevoCromosoma[j] = (padre2.getCromosoma()[j]);
            }

            Cromosoma hijo = new Cromosoma(nuevoCromosoma);
            cromosomas.add(hijo);
        }
        Poblacion nuevaPoblacion = new Poblacion(cromosomas);
        return nuevaPoblacion;
                
    }

    public static void print(int n_p, Poblacion[] poblaciones) {
        for (int i = 0; i < n_p; i++) {
            poblaciones[i].toStrings(i);
        }
    }

    private static void mutar(Poblacion poblacion) {
        Random r = new Random();
        int hijo = poblacion.getPoblacion().get(r.nextInt(50)).getCromosoma()[7];
        if (hijo == 0) {
            hijo = 1;
        } else {
            hijo = 0;
        }
        poblacion.getPoblacion().get(r.nextInt(50)).getCromosoma()[7] = hijo;
    }
}
