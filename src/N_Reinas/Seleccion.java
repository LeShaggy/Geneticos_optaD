package N_Reinas;
import java.util.Random;

public final class Seleccion {
    
    public static Individuo seleccionRuleta(Poblacion pob){
        Individuo aux = null;
        int fitnessPob = pob.getFitnessPoblacion();
              double posicion = fitnessPob * Math.random();
        
              double suma = 0;
              // generando la ruleta
        for (Individuo ind: pob.getPoblacion()){
          suma += ind.getFitness();
          
          if (suma>=posicion){
            aux = new Individuo(ind.getGenotipo());
          }
                 
        }
       aux = new Individuo(pob.getPoblacion().get(0).getGenotipo());
       return aux;
    }
    
    public static Individuo seleccionAleatoria(Poblacion pob){
        Individuo aux = null;
        Random ran = new Random();
        int pos = ran.nextInt(pob.getTamPob());
        aux = new Individuo(pob.getPoblacion().get(pos).getGenotipo());
        return aux;
    }
   
    
    public enum TipoSeleccion{
        RULETA,ALEATORIO,TORNEO
    }
    
} // End class
