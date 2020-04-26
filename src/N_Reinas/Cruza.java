package N_Reinas;

import java.util.Random;

public class Cruza {
    public enum TipoCruza {
       MASCARA,INDICE
       
    }
    public static int[] generaMascaraAleatoria(int dim){
    
        int mascara[] = new int[dim];
        Random ran = new Random();
        for (int x = 0 ; x < dim; x++)
            mascara[x] = ran.nextInt(2);
        
        return mascara;
    }
    
    public static Individuo cruzaIndice(int n, Individuo padre,Individuo madre){
        
        int auxGeno2[] = new int[padre.getGenotipo().length];
        int auxGeno[] = new int[padre.getGenotipo().length];
        // recorremos el genotipo/cromosoma
        for (int x=0; x <n;x++){
            auxGeno[x] += padre.getGenotipo()[x];
            auxGeno2[x] += madre.getGenotipo()[x];
                           
        }
        
        for (int x=padre.getGenotipo().length-1; x >=n;x--){
            auxGeno[x] += madre.getGenotipo()[x];
            auxGeno2[x] += padre.getGenotipo()[x];
        }
        //verificar que hijo es el mejor
        Individuo hijo1 = new Individuo(auxGeno);
        Individuo hijo2 = new Individuo(auxGeno2);
        // retornamos el mejor hijo        
        if (hijo1.getFitness()>= hijo2.getFitness()){
            return hijo1;}
        else {
        return hijo2;
        }        
    }
    
    public static Individuo cruzMascara(int[]mascara,Individuo padre, Individuo madre){
        int aux[]= new int[mascara.length];    
        // recorremos las mascara
        for (int x =0 ; x < mascara.length;x++){       
            if (mascara[x]==1){
             aux[x]= padre.getGenotipo()[x];
             } else{
            aux[x] = madre.getGenotipo()[x];
            }   
        }
        return new Individuo(aux);
    }
} // End class
