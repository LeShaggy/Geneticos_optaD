package TSP;

import java.util.Random;


public class Muta {


    public static void mutaGen(double prob,Individuo ind){
        double aux = Math.random();
        if(aux<=prob){
            // modificar un bit del genotipo
            Random ran = new Random();
            int posGen = ran.nextInt(ind.getGenotipo().length-1)+1;
            int valor =ind.getGenotipo()[posGen];
            int posGen2= ran.nextInt(ind.getGenotipo().length-1)+1;
            ind.getGenotipo()[posGen] = ind.getGenotipo()[posGen2];
            ind.getGenotipo()[posGen2] = valor;

            // actualizamos el fenotipo y el fitness
//        ind.actualizarIndividuo();
            ind.calcularFitness();

        }
    }




     public static void aplicarMutaAleatoria(Individuo p){
        Random ran = new Random();
        int pos = ran.nextInt(p.getGenotipo().length);
        if(p.getGenotipo()[pos]==1){
            p.getGenotipo()[pos]=0;

        }else {
            p.getGenotipo()[pos]=1;
        }
        // actualizar el genotipo, fenotipo y fitness
        p.calcularFitness();

    }
}
