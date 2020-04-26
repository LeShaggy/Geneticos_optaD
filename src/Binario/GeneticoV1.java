package Binario;

public class GeneticoV1{

    private int num_G;
    private double pMuta;
    private Poblacion pobActual;
    private int tamPob;

    public GeneticoV1(int num_G,double pMuta,int tamPob){
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        // generamos la población inicial como aleatoria
        this.pobActual = new Poblacion(tamPob);

    }

    public void evolucionar(){
        int mascara [] = new int[]{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1};
        // proceso evolutivo donde se generan nuevas poblaciones
        Individuo mejor;
        for(int g=0; g<this.num_G; g++){
            Poblacion nueva = new Poblacion();
            // se agregan los individuos de la población
            mejor = new Individuo(new int[31]);
            for(int i=0; i<this.tamPob;i++){
                // proceso de Selección
                Individuo madre = Seleccion.seleccionAleatoria(this.pobActual);
                Individuo padre = Seleccion.seleccionAleatoria(this.pobActual);
                // proceso de Cruza
                Individuo hijo = Cruza.cruzaPorMascara(mascara, madre, padre);
                // proceso de Mutación

                if(Math.random()<this.pMuta){
                    Muta.aplicarMutaAleatoria(hijo);
                    // mutar por referencia al hijo
                }
                // el hijo generado se agregar a la nueva población
                nueva.getPoblacion().add(hijo);
                if (hijo.getFitness()>mejor.getFitness()){
                    mejor = new Individuo(hijo.getGenotipo());
                }
            }
            System.out.println("G"+g+"-"+mejor.toString());
            // actualizar la población actual
            this.pobActual = new Poblacion(nueva);

        }
        System.out.println();

    }


}