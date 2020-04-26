package Binario;

public class Cruza{

    public static Individuo cruzaPorMascara(int mascara[], Individuo madre, Individuo padre){
        int genotipo1 [] = new int[mascara.length];
        int genotipo2 [] = new int[mascara.length];

        // recorremos la maskara de cruza
        for (int b=0; b < mascara.length; b++){
            if(mascara[b]==1){
                genotipo1[b]=madre.getGenotipo()[b];
                genotipo2[b] = padre.getGenotipo()[b];
            } else{
                genotipo1[b]=padre.getGenotipo()[b];
                genotipo2[b] = madre.getGenotipo()[b];

            }
        }
        Individuo hijo1 = new Individuo(genotipo1);
        Individuo hijo2 = new Individuo(genotipo2);
        if (hijo1.getFitness()>hijo2.getFitness()){
            return hijo1;
        } else {
            return hijo2;
        }

    }
}