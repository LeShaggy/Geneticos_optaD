package TSP;
import java.util.LinkedList;

public class Poblacion {

    private LinkedList<Individuo> poblacion;
    private int i;

    // creacion aleatoria de la poblaciÃƒÂ³n
    public Poblacion(int i, int ci, int n){
        this.i = i;
        this.poblacion = new LinkedList<>();
        inicializarAleatorimente(ci,n);
    }

    // creacion  poblaciÃƒÂ³n con muestreo
    public Poblacion(LinkedList<Individuo> muestra, int i){
        this.poblacion = new LinkedList<>();
        for(int x=0;x<muestra.size();x++){
            this.poblacion.add(new Individuo(muestra.get(x).getGenotipo()));
        }
        // ver como se resolverÃƒÂ¡ el
    }

    // creacion  poblaciÃƒÂ³n con muestreo
    public Poblacion(){
        this.poblacion = new LinkedList<>();

    }

    public Poblacion(Poblacion n){
        this.poblacion = new LinkedList<>();
        // crear un nueva poblaciÃƒÂ³n en base a otra
        for(Individuo aux: n.getPoblacion()){
            this.poblacion.add(new Individuo(aux.getGenotipo()));

        }

    }

    public void inicializarAleatorimente(int ci, int n){

        // un proceso iterativo con respecto a i
        for(int x=0; x< this.i; x++){
            this.poblacion.add(new Individuo(ci,n));

        }

    }




    public LinkedList<Individuo> getPoblacion(){

        return poblacion;
    }
}

