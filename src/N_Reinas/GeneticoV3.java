package N_Reinas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneticoV3{
    // campos obligados
    private int tamPob,generaciones;
    private double probMuta;
    private Poblacion poblacion;
    private int noReinas;

    
    public GeneticoV3(int generaciones, int tamPob, double probMuta,int noReinas){
      this.generaciones = generaciones;
      this.tamPob = tamPob;
      this.probMuta = probMuta;
      this.noReinas = noReinas;
    
    }
    // ejecucion inicial
    public void evoluciona(){
    
        // generar la población inicial
        
        this.poblacion = new Poblacion(tamPob, noReinas);
        this.poblacion.generarPoblacionInicial();
        // arreglo para graficar
        int mejores[] = new int[this.generaciones];
        
        for(int x=0;x<this.generaciones;x++){
            
             // construir la generacion
            Poblacion pobAux = new Poblacion(tamPob, noReinas);
            int mascara[] = Cruza.generaMascaraAleatoria(noReinas);
            for(int y=0;y<this.tamPob;y++){
               // seleccionar
                Individuo padre = Seleccion.seleccionAleatoria(this.poblacion);
                Individuo madre = Seleccion.seleccionAleatoria(this.poblacion);
               //cruzar
                Individuo hijo = Cruza.cruzMascara(mascara, padre, madre);
           
                if (verificarMuta()){
                    Muta.cruza2Puntos(hijo);
                }
                 pobAux.getPoblacion().add(hijo);
                //agregamos al ind a pobAux
            }
            // actualizar la población
            this.poblacion.actualizarPoblacion(pobAux.getPoblacion());
            mejores[x] = this.poblacion.getMejor().getFitness();
            System.out.println("E:"+x+" Fitness:"+mejores[x]);
            if (mejores[x]==0){
                break;
            }
        }
        
        System.out.println(this.poblacion.getMejor().toString());
        
        guardarYalmacenar(this.poblacion.getMejor().getGenotipo().length,this.poblacion.getMejor());
        
        
    }

    private boolean verificarMuta() {
        if (probMuta>=Math.random()){
            return true;
        }else{
            return false;
        }
    }

        public void guardarYalmacenar(int n, Individuo I){
    
        String temp ="";
//    int [] matriz = null;
//    for(int i = 0;i<n; i++){
//        matriz[i]=I.getGenotipo()[i];
//    }
        temp = temp + "\n Numero De Reinas:"+n+" \n Fitness: " + I.getFitness() + "  \n Genotipo: "+ I.getGenotipo()[0]+","+I.getGenotipo()[1]+","+I.getGenotipo()[2]+","+I.getGenotipo()[3]+","+I.getGenotipo()[4]+","+I.getGenotipo()[5]+","+I.getGenotipo()[6]+","+I.getGenotipo()[7]+","+I.getGenotipo()[8]+","+I.getGenotipo()[10]+","+I.getGenotipo()[11]+","+I.getGenotipo()[12]+","+I.getGenotipo()[13]+","+I.getGenotipo()[14]+","+I.getGenotipo()[15]+","+I.getGenotipo()[16]+","+I.getGenotipo()[17]+","+I.getGenotipo()[18]+","+I.getGenotipo()[19];
       

            File f;
            FileWriter w;
            BufferedWriter bw;
            PrintWriter wr;
            try{
             f=new File("i_"+n+"_Reinas.txt");
             w = new FileWriter(f, true);
             bw=new BufferedWriter(w);
             wr=new PrintWriter(bw);
        
            wr.write(temp);
            bw.close();
             w.close();
        
            }catch(IOException e){
                e.printStackTrace();
            
            }
    }
} // End class
