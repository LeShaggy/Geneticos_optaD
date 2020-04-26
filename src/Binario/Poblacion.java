package Binario;
import java.util.LinkedList;
import java.util.Random;

public class Poblacion{

    private LinkedList<Individuo> poblacion;
    private int i;

    // creacion aleatoria de la población
    public Poblacion(int i){
        this.i = i;
        this.poblacion = new LinkedList<>();
        inicializarAleatorimente();
    }

    // creacion  población con muestreo
    public Poblacion(LinkedList<Individuo> muestra, int i){
        this.poblacion = new LinkedList<>();
        for(int x=0;x<muestra.size();x++){
            this.poblacion.add(new Individuo(muestra.get(x).getGenotipo()));
        }
        // ver como se resolverá el
    }

    // creacion  población con muestreo
    public Poblacion(){
        this.poblacion = new LinkedList<>();

    }

    public Poblacion(Poblacion n){
        this.poblacion = new LinkedList<>();
        // crear un nueva población en base a otra
        for(Individuo aux: n.getPoblacion()){
            this.poblacion.add(new Individuo(aux.getGenotipo()));

        }

    }

    public void inicializarAleatorimente(){

        // un proceso iterativo con respecto a i
        for(int x=0; x< this.i; x++){
            this.poblacion.add(new Individuo(31));

        }

    }
    public LinkedList<Individuo> generarMuestraAleatoria(double p){
        int c = (int)((this.i*p)/100);
        LinkedList<Individuo> muestra = new LinkedList<>();
        int pa = 0;
        Random ran = new Random();
        for(int x=0; x<c;x++){
            pa = ran.nextInt(this.i);
            muestra.add(this.poblacion.get(pa));

        }
        return muestra;
    }

    public LinkedList<Individuo> generarMuestraMejores(double p){
        int c = (int)((this.i*p)/100);
        LinkedList<Individuo> muestra = new LinkedList<>();
        // ordenar los elementos
        return muestra;
    }

    public LinkedList<Individuo> getPoblacion(){

        return poblacion;
    }




}
