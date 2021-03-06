package Binario;

import java.util.Random;

public class Individuo {

    private int genotipo[];
    private long fenotipo;
    private long fitness;

    public int[]getGenotipo(){
        return genotipo;
    }
    public void setGenotipo(int[]genotipo){
        this.genotipo =genotipo;
    }
    public long getFenotipo(){
        return fenotipo;
    }
    public void setFenotipo(int fenotipo){
        this.fenotipo =fenotipo;
    }
    public long getFitness(){
        return fitness;
    }
    public void setFitness(long fitness){
        this.fitness =fitness;
    }

    public Individuo (int n){
        this.genotipo = new int[n];
        inicializarAleatoriamente();
        calcularFitness();
    }

    public Individuo (int aux[]){
        this.genotipo = aux.clone();
        calcularFitness();
    }

    public void calcularFitness(){
        calcularFenotipo();
        // evaluar el fenotipo en la función deseada (2x2+x+1)
        this.fitness = (2*this.fenotipo*this.fenotipo)+this.fenotipo+1;
    }

    private void calcularFenotipo(){
        // decodificación del genotipo
        // convertir el arreglo de bits a base 10
        this.fenotipo = 0;
        for(int x=0; x<this.genotipo.length;x++){
            if (this.genotipo[x]==1){
                this.fenotipo+= Math.pow(2,this.genotipo.length-1-x);
            }
        }

    }

    private void inicializarAleatoriamente(){
        Random ran = new Random();
        for(int x=0; x<this.genotipo.length;x++){
            this.genotipo[x]= ran.nextInt(2);
        }
    }

    @Override
    public String toString() {
        String aux = ""+this.fenotipo+": "+this.fitness;
        return aux;
    }

}
