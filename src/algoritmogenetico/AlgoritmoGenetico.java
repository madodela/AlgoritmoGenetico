package algoritmogenetico;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AlgoritmoGenetico {

    public static final int TAM_POB = 20;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int cont = 0;
        System.out.print("Número de poblaciones: ");
        int numeroPoblaciones = cin.nextInt();
        ArrayList<Poblacion> universo = new ArrayList(numeroPoblaciones);
        Poblacion poblacionInicial = new Poblacion();
        /**
         * ************GENERAR PRIMERA GENERACION**********
         */
        //crea 50 cromosomas para primer poblacion
        for (int i = 0; i < TAM_POB; i++) {
            poblacionInicial.poblacion.add(new Cromosoma());
        }
        //agregamos la poblacionInicial al universo
        universo.add(poblacionInicial);
        do {
            /**
             * ********CREAR OTRAS POBLACIONES*********
             *
             * //funcion que reciba poblacion y crea cruzas (50 hijos)
             */
            universo.add(procrear(universo.get(cont)));
            cont++;
        } while (cont < numeroPoblaciones - 1);

        printUniverso(numeroPoblaciones, universo);
    }

    public static Poblacion procrear(Poblacion padres) {
        Poblacion poblacionHijos = new Poblacion();
        for (int i = 0; i < TAM_POB; i++) {

            Cromosoma padre1 = padres.poblacion.get(i);
            Cromosoma padre2 = padres.poblacion.get(i + 1);
            i++;
            int[] nuevoCromosoma = new int[20];
            for (int j = 0; j < 12; j++) {
                nuevoCromosoma[j] = (padre1.cromosoma[j]);
            }
            for (int j = 12; j < 20; j++) {
                nuevoCromosoma[j] = (padre2.cromosoma[j]);
            }

            Cromosoma hijo = new Cromosoma(nuevoCromosoma);
            poblacionHijos.poblacion.add(hijo);
        }
        for (int i = 0; i < TAM_POB / 2 ; i++) {

            Cromosoma padre1 = padres.poblacion.get(i);
            Cromosoma padre2 = padres.poblacion.get(i + 2);
            //i++;
            int[] nuevoCromosoma = new int[20];
            for (int j = 0; j < 12; j++) {
                nuevoCromosoma[j] = (padre1.cromosoma[j]);
            }
            for (int j = 12; j < 20; j++) {
                nuevoCromosoma[j] = (padre2.cromosoma[j]);
            }

            Cromosoma hijo = new Cromosoma(nuevoCromosoma);
            poblacionHijos.poblacion.add(hijo);
        }
        mutar(poblacionHijos);
        return poblacionHijos;

    }

    private static void mutar(Poblacion poblacion) {
        Random r = new Random();
        int index = r.nextInt(TAM_POB);
        int genHijo = poblacion.poblacion.get(index).cromosoma[7];
        if (genHijo == 0) {
            genHijo = 1;
        } else {
            genHijo = 0;
        }
        poblacion.poblacion.get(index).cromosoma[7] = genHijo;
        poblacion.poblacion.get(index).mutado = true;
    }

    public static void printUniverso(int n_p, ArrayList<Poblacion> universo) {
        for (int i = 0; i < n_p; i++) {
            universo.get(i).toStrings(i + 1);
        }
    }
}
