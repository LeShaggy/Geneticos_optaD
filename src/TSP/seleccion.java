package TSP;

import java.util.Random;
public class seleccion {
     public static TSP.Individuo seleccionAleatoria(TSP.Poblacion pob){
        Random ran = new Random();
       int pos = ran.nextInt(pob.getPoblacion().size());

       return new TSP.Individuo(pob.getPoblacion().get(pos).getGenotipo());
    }
}
