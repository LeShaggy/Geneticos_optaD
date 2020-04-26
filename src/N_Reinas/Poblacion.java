package N_Reinas;

import java.util.ArrayList;
import java.util.Random;

public class Poblacion {
    private ArrayList<Individuo> indivduos;
    private int tamPob;
    private int n;
    private int fitnessPoblacion;
    
    public Poblacion(int numInd, int n) {
        this.tamPob = numInd;
        this.n = n;
        this.indivduos = new ArrayList<>();
        for(int x=0; x<numInd;x++)
            this.indivduos.add(new Individuo(n));
        
    }
    public Poblacion(Poblacion n){
        this.indivduos = new ArrayList<>();
        // crear un nueva población en base a otra
        for(Individuo aux: n.getPoblacion()){
            this.indivduos.add(new Individuo(aux.getGenotipo()));

        }

    }
    public Poblacion(ArrayList<Individuo> aux){
        this.indivduos = (ArrayList<Individuo>)aux.clone();
    }
    
    public Poblacion(){
        this.indivduos = new ArrayList<>();
        
    }
    
    public void generarPoblacionInicial(){
        for (int x=0;x<tamPob;x++){
          Individuo aux = new Individuo(n);
          aux.inicializarRand();
          this.indivduos.add(aux);
        }
    }
    
    public ArrayList<Individuo> getNMejores(int n){
        // validar que n <= tamaño de la población
      if(n<this.indivduos.size()){
      // ordenar a la población
      ordenarPoblacionActual();
      // creamos un coleccion nueva de individuos
      ArrayList<Individuo> muestra = new ArrayList<>();
        
       for(int x=0;x<n;x++){
       
       Individuo e = new Individuo(this.indivduos.get(x).getGenotipo());
       muestra.add(e);
       }   
      return muestra;
      }
      
        return (ArrayList<Individuo>) this.indivduos.clone();
    }
    public Individuo getMejor(){
        int idMejor = 0;
        for(int x=1;x<this.indivduos.size();x++){
            if(this.indivduos.get(x).getFitness()<this.indivduos.get(idMejor).getFitness()){
            idMejor = x;
            }
        }
     return new Individuo(this.indivduos.get(idMejor).getGenotipo());
       
    }
    
    public ArrayList<Individuo> getPoblacion() {
        return indivduos;
    }
    
    public ArrayList<Individuo> getMuestraAleatoria(int n){
      // validar que n <= tamaño de la población
      if(n<this.indivduos.size()){
      // creamos un coleccion nueva de individuos
      ArrayList<Individuo> muestra = new ArrayList<>();
          Random ran = new Random();
       for(int x=0;x<n;x++){
       int pos = ran.nextInt(this.indivduos.size());
       Individuo e = new Individuo(this.indivduos.get(pos).getGenotipo());
       muestra.add(e);
       }   
      return muestra;
      }
      
        return (ArrayList<Individuo>) this.indivduos.clone();
    }
    
    public void actualizarPoblacion(ArrayList<Individuo> pob){
        // eliminamos los elementos de la lista
        this.indivduos.clear();
        for (Individuo aux: pob){
        
        this.indivduos.add(new Individuo(aux.getGenotipo()));
        }
       
    }
    
    public int getTamPob(){
        return tamPob;
    }
    
    public ArrayList<Individuo> getIndivduos() {
        return indivduos;
    }

    private void ordenarPoblacionActual() {
     for(int z = 1; z < this.indivduos.size(); ++z) {
      for(int v = 0; v < (this.indivduos.size() - z); ++v) {
         
         if(this.indivduos.get(v).getFitness()
                 > this.indivduos.get(v+1).getFitness()){
            Individuo aux = new Individuo(this.indivduos.get(v).getGenotipo());
            this.indivduos.set(v,new Individuo(this.indivduos.get(v+1).getGenotipo()));
            this.indivduos.set(v+1,aux);
           
         }
      }
    }
            
    }
    
    public int getFitnessPoblacion(){
        this.fitnessPoblacion = calculaFitnessPoblacion();
        return this.fitnessPoblacion;
    }
    
    private int calculaFitnessPoblacion() {
       // recorremos la poblacion
      int suma=0;
      for (Individuo aux: this.indivduos)
          suma += aux.getFitness();
    
      return suma;
    }

} // End class
