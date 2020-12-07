package clasificadores;

import java.util.ArrayList;

import Interfaces.Clusterizacion;
import data.Patron;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class CMeans implements Clusterizacion{
        private ArrayList<Patron> instancias;
        private int c;
        private ArrayList<Patron []> centroides;
        int [] contadores;

        public CMeans(ArrayList<Patron> instancias, int c){
            this.instancias = instancias;
            this.c = c;
            this.centroides = new ArrayList<>();
        }

        @Override
        public void clusterizar(ArrayList<Patron> instancias) {
            // TODO Auto-generated method stub
                    // generar mis centroidesIniciales iniciales aleatorios 
            Random ran = new Random();
            Patron[] centroidesIniciales = new Patron[c];
            for (int x=0; x < this.c;x++){
                int pos = ran.nextInt(this.instancias.size());
                centroidesIniciales[x] = new Patron("Centroide "+x,"",this.instancias.get(pos).getVectorC().clone());
            }
            // agregamos a la coleccion de centroidesIniciales los centroidesIniciales iniciales
            this.getCentroides().add(centroidesIniciales);
            calcularClusters();

        }

        public ArrayList<Patron[]> getCentroides() {
            return centroides;
        }

        private void dividirUltimosCentroides(int[] contadores) {
            Patron[] aux = this.getCentroides().get(this.getCentroides().size()-1);
            
            for (int x=0; x < aux.length;x++){
             double[] vector = aux[x].getVectorC();
              for (int y=0;y<vector.length;y++){
               vector[y]/=contadores[x];
              }
            }
              
        }

        private double[] sumaVectores(double[] vector, double[] vector0) {
            double aux[] = new double[vector.length];
            for (int x=0; x < aux.length;x++)
                aux[x] = vector[x]+vector0[x];
            
            return aux;
         }

        private void inicializarNuevosCentroides(Patron[] centroidesNuevos) {
            // recorro el arreglo 
            for (int x=0; x < centroidesNuevos.length;x++){
              centroidesNuevos[x] = new Patron(this.getCentroides().get(this.getCentroides().size()-1)[x].getClase(),"",new double[this.instancias.get(0).getVectorC().length]);
            }
        }

          private boolean verificaCentroides() {
            // verificar si los centroidesIniciales nuevos
            // son iguales a los anteriores
           int numCentroides = this.getCentroides().size();
           Patron[] ultimo = this.getCentroides().get(numCentroides-1);
           Patron[] penultimo = this.getCentroides().get(numCentroides-2);
           for (int x=0; x < ultimo.length;x++){
               if (!ultimo[x].equals(penultimo[x]))
                   return false;
           }
           System.out.println("Convergen los centroides!");
           return true;
        }

        private void etiquetar (Patron[] centroides){
            // recorrer las instancias y etiquetar 
            // cada una de ellas en base a distancias
            for (Patron patron: this.instancias){
               double menor = patron.calcularDistancia(centroides[0]);
               patron.setClase(centroides[0].getClase());
               for (int x=1; x < this.c; x++){
                    // calculamos distancias
                    double dist = patron.calcularDistancia(centroides[x]);
                    if (dist< menor){
                        menor = dist;
                        patron.setClase(centroides[x].getClase());
                    }
               }
              
            }
          
        }

        private void calcularClusters (){
    
            // etiquetar por primera ocasiÃ³n (clasificar por primera ocasiÃ³n)
            etiquetar(this.centroides.get(0));
            // generar un proceso iterativo 
            // que modifique o ajuste los centroidesIniciales
            int contador = 0;
            
            do {
               // recalcular centroidesIniciales
               // necesitamos donde acumular 
               Patron[] centroidesNuevos = new Patron[c];
               contadores = new int[c];
               inicializarNuevosCentroides(centroidesNuevos);
               // acumulamos(recorrer todas las instancias) 
               for (Patron instancia: this.instancias){
                   String nombreCluster = instancia.getClase();
                   forCentroides: for (int x=0; x < centroidesNuevos.length;x++){
                    if (centroidesNuevos[x].getClase().equals(nombreCluster)){
                      centroidesNuevos[x].setVectorC(sumaVectores(centroidesNuevos[x].getVectorC(),instancia.getVectorC()));
                      contadores[x]++;
                      break forCentroides;
                    }
                   }
               }
               // agregar los centroidesIniciales a la coleccion
               this.getCentroides().add(centroidesNuevos);
               // dividimos 
               dividirUltimosCentroides(contadores);
                       
               // re etiquetar 
              etiquetar(this.getCentroides().get(this.getCentroides().size()-1));
              //System.out.println(contador++);
             
            }while (!verificaCentroides()&&contador<500);
               
           
        }

        public void clasifica(Patron[] centroidesIniciales){
            this.getCentroides().add(centroidesIniciales);
            calcularClusters();
        } 

        public void imprimir(){
            for(int x =0; x<instancias.size(); x++){

                System.out.println("Clase "+x+" = "+instancias.get(x).getClase()+" -> Clase Resultante = "+instancias.get(x).getClaseResultante());
                
           }
        }
        
}