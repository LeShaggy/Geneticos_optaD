package TSP;

import java.util.ArrayList;
import java.util.Random;

public class Individuo{

    public static int[][] matrizDistancias;

    private int [] genotipo;
    private int fitness;

    public static int[][] getMatrizDistancias() {
        return matrizDistancias;
    }

    public static void setMatrizDistancias(int[][] matrizDistancias) {
        Individuo.matrizDistancias = matrizDistancias;
    }

    public int[] getGenotipo() {
        return genotipo;
    }

    public void setGenotipo(int[] genotipo) {
        this.genotipo = genotipo;

    }

    public Individuo(int ci, int n){
        genotipo = new int[n];
        genotipo[0]=ci;
        inicializarAleatoriamente();
        calcularFitness();

    }
    public Individuo(int[] genotipo){
        this.genotipo = genotipo.clone();
        calcularFitness();


    }

    public int getFitness() {
        return fitness;
    }
    public void calcularFitness(){
        if(matrizDistancias!=null){
            this.fitness = 0;
            // recorremos el genotipo 
            for(int x=0; x<=this.genotipo.length-2;x++){
                int d = matrizDistancias[this.genotipo[x]][this.genotipo[x+1]];
                this.fitness+= d;

            }
            this.fitness+= matrizDistancias[this.genotipo[this.genotipo.length-1]][this.genotipo[0]];

        }

    }
    public void inicializarAleatoriamente(){
        ArrayList<Integer> ciudades = new ArrayList<>();
        for(int x =0; x < genotipo.length; x++){
            ciudades.add(x);
        }
        ciudades.remove(this.genotipo[0]);
        Random ran = new Random();
        // llenar los espacios vacios restantes del genotipo 
        for(int x=1; x<genotipo.length;x++){
            int pos = ran.nextInt(ciudades.size());
            int c = ciudades.get(pos);
            this.genotipo[x] = c;
            // eliminamos de las ciudades
            ciudades.remove(pos);
        }

    }
/*
       public void Asexual(int ci, int n){
      
       Individuo madre = new Individuo(ci,n);
           madre.inicializarAleatoriamente();
        Individuo padre = new Individuo(ci,n);
            padre.inicializarAleatoriamente();
        
            int mascara [] = new int[]{0,0,0,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,1,1};
            
            Individuo mejor;
            
        int genotipo1 [] = new int[mascara.length];
        int genotipo2 [] = new int[mascara.length];
       
            
        // recorremos la mascara de cruza 
        for (int b=0; b < mascara.length; b++){
            if(mascara[b]==1){
                genotipo1[b]=madre.getGenotipo()[b];
                genotipo2[b] =padre.getGenotipo()[b];
            }
       else{
                genotipo1[b]=madre.getGenotipo()[b];
                genotipo2[b] = padre.getGenotipo()[b];

            }
        }
        /////////////Encontramos hijo1
        Individuo hijo1 = new Individuo(genotipo1);
        System.out.println("Genotipo Hijo 1 antes: "+genotipo1[0]+","+genotipo1[1]+","+genotipo1[2]+","+genotipo1[3]+","+genotipo1[4]+","+genotipo1[5]+","+genotipo1[6]+","+genotipo1[7]+","+genotipo1[8]+","+genotipo1[9]+","+genotipo1[10]+","+genotipo1[11]+","+genotipo1[12]+","+genotipo1[13]+","+genotipo1[14]+","+genotipo1[15]+","+genotipo1[16]+","+genotipo1[17]+","+genotipo1[18]+","+genotipo1[19]);
        System.out.println("Fitnes Hijo1  antes: "+hijo1.getFitness());
        
        
         ///////cambiar pos en el hijo////////////////////
         Random r = new Random();
         Random s = new Random();
         int pos = r.nextInt(hijo1.getGenotipo().length);
         int pos2 = r.nextInt(hijo1.getGenotipo().length);
        
        Individuo r1 = new Individuo(4,20);
        r1.getGenotipo()[1]=hijo1.getGenotipo()[pos];
        r1.getGenotipo()[2]=hijo1.getGenotipo()[pos2];
        
        /*
        System.out.println("Posr Hijo 1 : "+hijo1.getGenotipo()[pos]);
        System.out.println("PosS Hijo 1 : "+hijo1.getGenotipo()[pos2]);
        System.out.println("R1_1 Hijo 1 : "+r1.getGenotipo()[1]);
        System.out.println("R2_2 Hijo 1 : "+r1.getGenotipo()[2]);
        */
        /*
        //cambio de pos en el HIJO1 //////////////////////////
        hijo1.getGenotipo()[pos]= r1.getGenotipo()[2];
        hijo1.getGenotipo()[pos2] = r1.getGenotipo()[1]; 

        
        System.out.println("Posr Hijo 1 ahora: "+hijo1.getGenotipo()[pos]);
        System.out.println("PosS Hijo 1 ahora: "+hijo1.getGenotipo()[pos2]);
        ////////Cambiar pos en el hijo 2////////////////////
        Individuo hijo2 = new Individuo(genotipo2);
        
        System.out.println("Fitness Hijo 1 ahora: "+hijo1.getFitness());
        System.out.print("soy el hijo1:"+hijo1.getGenotipo()[0]);
        
        
        for(int i =1; i<20;i++)
           System.out.print(", "+hijo1.getGenotipo()[i]);
        
        
        
//System.out.println("Genotipo Hijo 1 ahora: "+hijo1.getGenotipo()[0]+","+hijo1.getGenotipo()[0]+","+hijo1.getGenotipo()[0]+","+hijo1.getGenotipo()[0]+","+hijo1.getGenotipo()[0]+","+genotipo1[5]+","+genotipo1[6]+","+genotipo1[7]+","+genotipo1[8]+","+genotipo1[9]+","+genotipo1[10]+","+genotipo1[11]+","+genotipo1[12]+","+genotipo1[13]+","+genotipo1[14]+","+genotipo1[15]+","+genotipo1[16]+","+genotipo1[17]+","+genotipo1[18]+","+genotipo1[19]);
        System.out.println("\n Fitness Hijo2: "+hijo2.getFitness());
       // System.out.println("Genotipo Hijo 2: "+genotipo2[0]+","+genotipo2[1]+","+genotipo2[2]+","+genotipo2[3]);
        
        if (hijo1.getFitness()<hijo2.getFitness()){
            System.out.println("El mejor es: "+hijo1.getFitness());
            
        } else {
            System.out.println("El mejor es: "+hijo2.getFitness());
            
        }
          }
*/

    public void Asexual(int ci, int n){

        Individuo madre = new Individuo(ci,n);
        madre.inicializarAleatoriamente();
        Individuo padre = new Individuo(ci,n);
        padre.inicializarAleatoriamente();

        int mascara [] = new int[]{0,0,0,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,1,1};


        int genotipo1 [] = new int[mascara.length];
        int genotipo2 [] = new int[mascara.length];


        // recorremos la mascara de cruza 
        for (int b=0; b < mascara.length; b++){
            if(mascara[b]==1){
                genotipo1[b]=madre.getGenotipo()[b];
                genotipo2[b] =padre.getGenotipo()[b];
            }
            else{
                genotipo1[b]=madre.getGenotipo()[b];
                genotipo2[b] = padre.getGenotipo()[b];

            }
        }
        /////////////Encontramos hijo1////////////////////////////////////////////////////////
        Individuo hijo1 = new Individuo(genotipo1);
        //System.out.println("Genotipo Hijo 1 antes: "+genotipo1[0]+","+genotipo1[1]+","+genotipo1[2]+","+genotipo1[3]+","+genotipo1[4]+","+genotipo1[5]+","+genotipo1[6]+","+genotipo1[7]+","+genotipo1[8]+","+genotipo1[9]+","+genotipo1[10]+","+genotipo1[11]+","+genotipo1[12]+","+genotipo1[13]+","+genotipo1[14]+","+genotipo1[15]+","+genotipo1[16]+","+genotipo1[17]+","+genotipo1[18]+","+genotipo1[19]);

        System.out.print("soy el hijo1 antes:"+hijo1.getGenotipo()[0]);
        for(int o =1; o<20;o++)
            System.out.print(","+hijo1.getGenotipo()[o]);

        System.out.println("");
        hijo1.calcularFitness();
        System.out.println("Fitness Hijo1  antes: "+hijo1.getFitness());


        ///////cambiar pos en el hijo////////////////////
        Random r = new Random();
        Random s = new Random();
        int pos = r.nextInt(hijo1.getGenotipo().length);
        int pos2 = r.nextInt(hijo1.getGenotipo().length);

        Individuo r1 = new Individuo(4,20);
        r1.getGenotipo()[1]=hijo1.getGenotipo()[pos];
        r1.getGenotipo()[2]=hijo1.getGenotipo()[pos2];
        
        /*
        System.out.println("Posr Hijo 1 : "+hijo1.getGenotipo()[pos]);
        System.out.println("PosS Hijo 1 : "+hijo1.getGenotipo()[pos2]);
        System.out.println("R1_1 Hijo 1 : "+r1.getGenotipo()[1]);
        System.out.println("R2_2 Hijo 1 : "+r1.getGenotipo()[2]);
        */

        //cambio de pos en el HIJO1 //////////////////////////
        hijo1.getGenotipo()[pos]= r1.getGenotipo()[2];
        hijo1.getGenotipo()[pos2] = r1.getGenotipo()[1];

        System.out.println("");
        System.out.println("Pos1 Hijo 1 cambia: "+hijo1.getGenotipo()[pos]);
        System.out.println("Pos2 Hijo 1 cambia: "+hijo1.getGenotipo()[pos2]);



        System.out.println("");
        System.out.print("Soy el Hijo 1 ahora:"+hijo1.getGenotipo()[0]);
        for(int i =1; i<20;i++)
            System.out.print(", "+hijo1.getGenotipo()[i]);


        System.out.println("");
        hijo1.calcularFitness();
        System.out.println("Fitness Hijo 1 ahora: "+hijo1.getFitness());

        System.out.println("");
        System.out.println("");
        System.out.println("");

//System.out.println("Genotipo Hijo 1 ahora: "+hijo1.getGenotipo()[0]+","+hijo1.getGenotipo()[0]+","+hijo1.getGenotipo()[0]+","+hijo1.getGenotipo()[0]+","+hijo1.getGenotipo()[0]+","+genotipo1[5]+","+genotipo1[6]+","+genotipo1[7]+","+genotipo1[8]+","+genotipo1[9]+","+genotipo1[10]+","+genotipo1[11]+","+genotipo1[12]+","+genotipo1[13]+","+genotipo1[14]+","+genotipo1[15]+","+genotipo1[16]+","+genotipo1[17]+","+genotipo1[18]+","+genotipo1[19]);

/////////////////////AHORA PARA EL HIJO 2 /////////////////////////////////////////////
////////Encontramos al hijo 2////////////////////
        Individuo hijo2 = new Individuo(genotipo2);


        System.out.print("Soy el Hijo2 antes:"+hijo2.getGenotipo()[0]);
        for(int l =1; l<20;l++)
            System.out.print(", "+hijo2.getGenotipo()[l]);

        System.out.println("");
        hijo2.calcularFitness();//System.out.println("Genotipo Hijo 2 antes: "+genotipo1[0]+","+genotipo1[1]+","+genotipo1[2]+","+genotipo1[3]+","+genotipo1[4]+","+genotipo1[5]+","+genotipo1[6]+","+genotipo1[7]+","+genotipo1[8]+","+genotipo1[9]+","+genotipo1[10]+","+genotipo1[11]+","+genotipo1[12]+","+genotipo1[13]+","+genotipo1[14]+","+genotipo1[15]+","+genotipo1[16]+","+genotipo1[17]+","+genotipo1[18]+","+genotipo1[19]);
        System.out.println("Fitnes Hijo 2  antes: "+hijo2.getFitness());
        System.out.println("");
        ///////cambiar pos en el hijo////////////////////
        Random i = new Random();
        Random j = new Random();
        int pos3 = i.nextInt(hijo2.getGenotipo().length);
        int pos4 = j.nextInt(hijo2.getGenotipo().length);

        Individuo r2 = new Individuo(4,20);
        r2.getGenotipo()[1]=hijo1.getGenotipo()[pos3];
        r2.getGenotipo()[2]=hijo1.getGenotipo()[pos4];


        //cambio de pos en el HIJO2 //////////////////////////
        hijo2.getGenotipo()[pos3]= r2.getGenotipo()[2];
        hijo2.getGenotipo()[pos4] = r2.getGenotipo()[1];

        System.out.println("");
        System.out.println("Pos1 Hijo 2 cambia: "+hijo2.getGenotipo()[pos3]);
        System.out.println("Pos2 Hijo 2 cambia: "+hijo2.getGenotipo()[pos4]);



        System.out.println("");
        System.out.print("soy el hijo 2 ahora:"+hijo2.getGenotipo()[0]);
        for(int k=1; k<20;k++)
            System.out.print(", "+hijo2.getGenotipo()[k]);


        System.out.println("");
        hijo2.calcularFitness();
        System.out.println("Fitness Hijo 2 ahora: "+hijo2.getFitness());
        // System.out.println("Genotipo Hijo 2: "+genotipo2[0]+","+genotipo2[1]+","+genotipo2[2]+","+genotipo2[3]);


        hijo1.calcularFitness();
        hijo2.calcularFitness();
        System.out.println("");
        System.out.println("");
        //////////////////////////////COMPARACIÃ“N//////////////////////////////////////////////////////////
        if (hijo1.getFitness()<hijo2.getFitness()){
            System.out.println("El mejor es: "+hijo1.getFitness());

        } else {
            System.out.println("El mejor es: "+hijo2.getFitness());

        }
    }




    @Override
    public String toString() {

        String aux = "Fitness: "+this.fitness;
        return aux;
    }
}

