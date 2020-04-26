package N_Reinas;
import java.util.Random;

public class Individuo {
    
    private int genotipo[];
    private int fitness;
    private int n;
    

    public Individuo(int n){
        this.n = n;
        this.genotipo = generarGenotipoAleatorio();
         calcularFitness();
    }
    public Individuo(int genotipo[]){
         this.n = genotipo.length;
         this.genotipo = genotipo.clone();
         calcularFitness();
    }
    public int[] generarGenotipoAleatorio() {
        int aux [] = new int[this.n];
        Random ran = new Random();
        for(int x=0; x<aux.length;x++)
            aux[x]= ran.nextInt(this.n);
        return aux;

    }
    public void calcularIndividuoSinConflicto() {
        //creacion individuo aleatorio sin conflicto
        // de renglones
        // posicion 
        Random ran = new Random();
        
        for (int x =0; x <this.genotipo.length;x++){
        
            int aux = ran.nextInt(this.genotipo.length);
            // garantizando que todo el cromosoma sea 
            // llenado
            while(this.genotipo[aux]!=0){
              aux = ran.nextInt(this.genotipo.length);
            }
            this.genotipo[aux]=x;
           
        }
    }
    public void actualizarIndividuo(){
    
       calcularFitness();
    }
    
    public int[] getGenotipo() {
        return genotipo;
    }

    public int getFitness() {
        return fitness;
    }
    
    public void inicializarRand() {
        //Crear genotipo random
        Random r = new Random();
        for (int i = 0; i < this.genotipo.length; i++) {
            this.genotipo[i] = r.nextInt(this.genotipo.length);
        }
    }
    
    private void calcularFitness() {
       //Calcular el grado de bondad
        //Calcular ataques horizontales
        int cont = 0;
        for (int i = 0; i < genotipo.length; i++) {
            for (int j = 0; j < genotipo.length; j++) {
                if (i != j) {
                    if (this.genotipo[i] == this.genotipo[j]) {
                        cont += 1;
                    }
                    if (this.genotipo[i] - i == this.genotipo[j] - j) {
                        cont += 1;
                    }
                    if (this.genotipo[i] + i == this.genotipo[j] + j) {
                        cont += 1;
                    }
                }
            }
        }
        //Calcular ataques diagonales
        this.fitness = cont;
            
    }

} // End class
