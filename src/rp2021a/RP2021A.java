/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp2021a;

import clasificadores.Bayes;
import clasificadores.K_NN;
import clasificadores.CMeans;
import clasificadores.Cap;
import clasificadores.LernMatrix;
import data.LeerDatos;
import data.Patron;
import data.PatronBinario;
import java.util.ArrayList;
import clasificadores.MinimaDistancia;
import clasificadores.Min_Max;
/**
 *
 * @author jesua
 */
public class RP2021A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Patron> instancias = LeerDatos.tokenizarDataSet();
        ArrayList<Patron> instancias2 = instancias;
        ArrayList<Patron> instancias3= instancias;
        K_NN o = new K_NN(1);
        Bayes m = new Bayes();
        MinimaDistancia n = new MinimaDistancia();
        Min_Max e = new Min_Max(instancias2,3);
        Cap r = new Cap();
        LernMatrix lm = new LernMatrix();
        
        double[] distancias = new double[instancias.size()];
        ArrayList<PatronBinario> entrenamiento = new ArrayList<>();
        
        
        entrenamiento.add(new PatronBinario(new int[]{1,0,1,0,1},new int[]{1,0,0},new int[]{0,0,0}));
        entrenamiento.add(new PatronBinario(new int[]{1,1,0,0,1},new int[]{0,1,0},new int[]{0,0,0}));
        entrenamiento.add(new PatronBinario(new int[]{1,0,1,1,0},new int[]{0,0,1},new int[]{0,0,0}));
     
		
        // Patron j = new Patron("","", new double[]{2.4,3.3,5.6,7.8});  Iris.txt
        //Patron j = new Patron("","", new double[]{13.2,1.78,2.14,11.2,100,2.65,2.76,.26,1.28,4.38,1.05}); //Wine.txt
        //Patron j = new Patron("","", new double[]{0.455,0.365,0.095,0.514,0.2245,0.101,0.15,15}); //abalone.txt
        //Patron j = new Patron("","", new double[]{1.52101,13.64,4.49,1.1,71.78,0.06,8.75,0}); //glass.txt
        //Patron j = new Patron("","", new double[]{0,0,0,0,0,0,1,-1,0,0,-1,-1,0,0,0,0,1,1,-1,-1,0,0,0,0,1,1,1,1,0,0,1,1,0,0}); // inosfere.txt

        //Clasificador Bayes
        /*m.entrenar(instancias);
        m.clasificar(instancias);
        //Clasificador Knn
        o.entrenar(instancias2);
        o.clasificar(instancias2);
        //Clasificador Minima Distancia
        n.entrenar(instancias3);
        n.clasificar(instancias3);*/
        //Clusterizador C Means
       //e.clasifica();
       //Cap
//       r.aprendizaje(instancias);
//       r.recuperacion(instancias2);
//       System.out.println(r.getRendimiento()+"% de eficacia");
       //LernMatrix
       lm.aprendizaje(entrenamiento);
       ArrayList<PatronBinario> datos = new ArrayList<>();
       
       datos.add(new PatronBinario(new int[]{1,0,1,0,1},new int[]{1,0,0},new int[]{0,0,0}));
       datos.add(new PatronBinario(new int[]{1,1,0,0,1},new int[]{0,1,0},new int[]{0,0,0}));
       datos.add(new PatronBinario(new int[]{1,0,1,1,0},new int[]{0,0,1},new int[]{0,0,0}));
       
       
       lm.recuperacion(datos);
      
    }
    
}
