package Binario;

import java.util.Random;

public class Seleccion{

    public static Individuo seleccionAleatoria(Poblacion pob){
        Random ran = new Random();
        int pos = ran.nextInt(pob.getPoblacion().size());

        return new Individuo(pob.getPoblacion().get(pos).getGenotipo());
    }

}