package TSP;
import java.io.*;

public class geneticoV2 {

    private int num_G;
    private double pMuta;
    private Poblacion pobActual;
    private int tamPob;

    public geneticoV2(int num_G,double pMuta,int tamPob, int ci, int n){
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        // generamos la población inicial como aleatoria
        this.pobActual = new Poblacion(tamPob, ci ,n);

    }

    public void evolucionar(){

        // proceso evolutivo donde se generan nuevas poblaciones
        Individuo mejor = null;
        Individuo mj = null;


        for(int g=1; g<this.num_G; g++){
            Poblacion nueva = new Poblacion();
            // se agregan los individuos de la poblaciÃƒÂ³n

            for(int i=0; i<this.tamPob;i++){
                // proceso de SelecciÃƒÂ³n


                Individuo madre = seleccion.seleccionAleatoria(this.pobActual);
                Individuo padre = seleccion.seleccionAleatoria(this.pobActual);
                // proceso de Cruza
//                Individuo hijo1 = cruza.Asexual(mascara, madre, madre);
//                Individuo hijo2 = cruza.Asexual(mascara, padre, padre);
                Individuo hijo1 = cruza.Asexual(padre, madre);
                Individuo hijo2 = cruza.Asexual(padre, padre);
                // proceso de MutaciÃƒÂ³n

                if(Math.random()<this.pMuta){
                    Muta.mutaGen(pMuta,hijo1);
                    Muta.mutaGen(pMuta,hijo2);
                    // mutar por referencia al hijo
                }
                // el hijo generado se agregar a la nueva poblaciÃƒÂ³n
                nueva.getPoblacion().add(hijo1);
                nueva.getPoblacion().add(hijo2);

                if (hijo1.getFitness()<hijo2.getFitness()){
                    mejor = new Individuo(hijo1.getGenotipo());
                    mj = new Individuo(hijo1.getGenotipo());
                }
            }
            // System.out.println("///////////////////////////////////////////////////////");

            for(int y=0; y<mejor.getGenotipo().length; y++)
                System.out.print(" "+mj.getGenotipo()[y]);

            System.out.println("G"+g+"-"+mejor.toString());
            // actualizar la poblaciÃƒÂ³n actual
            this.pobActual = new Poblacion(nueva);


        }

        System.out.println();

        guardarYalmacenar(mj.getGenotipo()[0],mj.getGenotipo().length,mj);
    }

    public void guardarYalmacenar(int ci, int n, Individuo I){

        String temp ="";
//    int [] matriz = null;
//    for(int i = 0;i<n; i++){
//        matriz[i]=I.getGenotipo()[i];
//    }
        temp = temp + "Ciudades: " + n+ "\n Ci: " + ci + "\n Fitness: " + I.getFitness() + "  \n Genotipo: "+ I.getGenotipo()[0]+","+I.getGenotipo()[1]+","+I.getGenotipo()[2]+","+I.getGenotipo()[3]+","+I.getGenotipo()[4]+","+I.getGenotipo()[5]+","+I.getGenotipo()[6]+","+I.getGenotipo()[7]+","+I.getGenotipo()[8]+","+I.getGenotipo()[10]+","+I.getGenotipo()[11]+","+I.getGenotipo()[12]+","+I.getGenotipo()[13]+","+I.getGenotipo()[14]+","+I.getGenotipo()[15]+","+I.getGenotipo()[16]+","+I.getGenotipo()[17]+","+I.getGenotipo()[18]+","+I.getGenotipo()[19];


        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        try{
            f=new File("i_80_1.txt");
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
}



