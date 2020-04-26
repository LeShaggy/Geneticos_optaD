package TSP;
import java.util.Random;
import java.util.ArrayList;


public class cruza {

    public static Individuo Asexual(Individuo padre,Individuo madre){
        int genotipo1[] = new int[padre.getGenotipo().length-1];
        // creo la mascara de Ã­ndices
        for(int i=0;i<genotipo1.length;i++){
            genotipo1[i] = -1;
        }
        for (int j=1; j<= genotipo1.length;j++){
            int ind = generarIndiceValido(genotipo1);
            genotipo1[ind]=j;
        }



        int geno1[] = new int[padre.getGenotipo().length];
        int geno2[] = new int[madre.getGenotipo().length];
        geno1[0] = padre.getGenotipo()[0];
        geno2[0] = madre.getGenotipo()[0];
        // construimos los nuevos genotipos
        for (int x=1;x<geno1.length;x++){
            geno1[genotipo1[x-1]]=padre.getGenotipo()[x];
            geno2[genotipo1[x-1]]=madre.getGenotipo()[x];
        }
        Individuo hijo1 =  new Individuo(geno1);
        Individuo hijo2 =  new Individuo(geno2);

        ArrayList<Individuo> lista = new ArrayList<>();
        lista.add(madre);
        lista.add(padre);
        lista.add(hijo1);
        lista.add(hijo2);
        return retornaMejor(lista);
    }

    private static Individuo retornaMejor(ArrayList<Individuo> lista) {
        Individuo mejor = lista.get(0);

        for (int x=1; x<lista.size();x++){
            if(lista.get(x).getFitness()<mejor.getFitness()){
                mejor =lista.get(x);
            }
        }
        return mejor;
    }

    public static int generarIndiceValido(int[] ruta) {
        Random r = new Random();
        int indice = r.nextInt(ruta.length);
        while(ruta[indice] != -1){
            indice = r.nextInt(ruta.length);
        }

        return indice;
    }

}


