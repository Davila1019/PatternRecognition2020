/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp2021a;

import clasificadores.Bayes;
import clasificadores.K_NN;
import data.LeerDatos;
import data.Patron;
import java.util.ArrayList;
import clasificadores.MinimaDistancia;
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
        //K_NN m = new K_NN(3);
        Bayes m = new Bayes();
        MinimaDistancia n = new MinimaDistancia();
        double[] distancias = new double[instancias.size()];
        
        Patron j = new Patron("","", new double[]{2.4,3.3,5.6,7.8}); // Iris.txt
        //Patron j = new Patron("","", new double[]{13.2,1.78,2.14,11.2,100,2.65,2.76,.26,1.28,4.38,1.05}); //Wine.txt
        //Patron j = new Patron("","", new double[]{0.455,0.365,0.095,0.514,0.2245,0.101,0.15,15}); //abalone.txt
        //Patron j = new Patron("","", new double[]{1.52101,13.64,4.49,1.1,71.78,0.06,8.75,0}); //glass.txt
        //Patron j = new Patron("","", new double[]{0,0,0,0,0,0,1,-1,0,0,-1,-1,0,0,0,0,1,1,-1,-1,0,0,0,0,1,1,1,1,0,0,1,1,0,0}); // inosfere.txt
//        for(int x = 0 ; x<  instancias.size();x++){
//            distancias[x] =    instancias.get(x).calcularDistancia(j);
//           System.out.println(x+"= "+distancias[x]);
//        }
        m.entrenar(instancias);
      
        // TODO: TOKENIZADOR PARA PODER SEPARAR POR COMAS Y GENERAR UN COLECCION DE PATRONES
        
    }
    
}
