package N_Reinas;

import java.util.Random;

public class Muta {
     public static void cruza2Puntos(Individuo ind){
        Random ran = new Random();
        int p1 = ran.nextInt(ind.getGenotipo().length);
        int p2 = ran.nextInt(ind.getGenotipo().length);
        
        while(p1==p2){
         
         p2 = ran.nextInt(ind.getGenotipo().length);
        
        }
        int aux = ind.getGenotipo()[p1];
        ind.getGenotipo()[p1] = ind.getGenotipo()[p2];
        ind.getGenotipo()[p2]=aux;
        
    }
} // End class
