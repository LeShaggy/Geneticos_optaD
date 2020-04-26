import TSP.Individuo;
import TSP.geneticoV2;
import extras.GenerarInstancias;

public class Main {

    public static void main(String[] args) {
        try {
            Individuo.matrizDistancias = GenerarInstancias.cargarMatriz();
            System.out.println();
            Individuo i = new Individuo(new int[] {4,600,897,997});
            i.Asexual(997,1000);
            System.out.println();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("\n \n \n");
        geneticoV2 gen = new geneticoV2(10000,0.25,20,997,1000);
        gen.evolucionar();


    }
}