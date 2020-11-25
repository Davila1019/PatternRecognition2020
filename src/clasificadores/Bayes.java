/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import Interfaces.ClasificadorSupervisado;
import data.MatrizConfusion;
import data.Patron;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jesua
 */
public class Bayes implements ClasificadorSupervisado {

   
    ArrayList<Patron> promedio,varianza,desviacion;
    ArrayList<String> aux;
    Patron promedios, varianzas, desviaciones;
    double[] auxiliar,var, des;
    public Bayes() {
        this.promedio = new ArrayList<>();
        this.varianza = new ArrayList<>();
        this.desviacion = new ArrayList<>();
    }
    @Override
      public void entrenar(ArrayList<Patron> instancias) {
       aux = new ArrayList();
       
        for(int x=0; x<instancias.size(); x++){
                aux.add(instancias.get(x).getClase());
        }
        
       Set<String> hs = new HashSet<String>(aux);
       aux.clear();
       aux.addAll(hs);
     //Calculamos el promedio o media
     calcularPromedio(aux,instancias);
     //Calculamos la varianza
     calcularVarianza(aux,instancias);
     //Calculamos la desviación estandar
     calcularDesviacion(aux,instancias);
    }

    @Override
    public void clasificar(ArrayList<Patron> instancias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void calcularVarianza(ArrayList<String> aux,ArrayList<Patron> instancias){
        int contInsClas;
        for(int w=0; w<this.promedio.size();w++){
         this.var = new double[instancias.get(0).getVectorC().length];
         contInsClas=0;
        for(int x=0; x<instancias.size();x++){
          if(aux.get(w).equals(instancias.get(x).getClase())){
              contInsClas+=1;
            for(int y=0; y<instancias.get(x).getVectorC().length;y++){
                  this.var[y]= this.var[y]+Math.pow(instancias.get(x).getVectorC()[y]-this.promedio.get(w).getVectorC()[y], 2);
                 }
             }
         }
        for(int x=0; x<this.var.length; x++){
          this.var[x]=this.var[x]/contInsClas;
        }
        this.varianzas = new Patron(aux.get(w),"",this.var);
        this.varianza.add(this.varianzas);
     }
         for(int x=0; x<varianza.size(); x++){
            for(int y=0; y<varianza.get(x).getVectorC().length; y++){
                System.out.println(varianza.get(x).getVectorC()[y]+"-> clase -> "+varianza.get(x).getClase());
            } 
        }
    }
    public void calcularPromedio(ArrayList<String> aux,ArrayList<Patron> instancias){
        int contInsClas;
     for(int w=0; w<aux.size();w++){
         this.auxiliar = new double[instancias.get(0).getVectorC().length];
         contInsClas=0;
        for(int x=0; x<instancias.size();x++){
          if(aux.get(w).equals(instancias.get(x).getClase())){
              contInsClas+=1;
            for(int y=0; y<instancias.get(x).getVectorC().length;y++){
                  this.auxiliar[y]=this.auxiliar[y]+instancias.get(x).getVectorC()[y];
                  
                 }
             }
         }
        for(int x=0; x<this.auxiliar.length; x++){
           this.auxiliar[x]=this.auxiliar[x]/contInsClas;
        }
        this.promedios = new Patron(aux.get(w),"",this.auxiliar);
        this.promedio.add(this.promedios);
     }
    }
    public void calcularDesviacion(ArrayList<String> aux,ArrayList<Patron> instancias){
        for(int w=0; w<aux.size();w++){
        this.des = new double[instancias.get(0).getVectorC().length];
        for(int x=0; x<varianza.size();x++){
          if(aux.get(w).equals(varianza.get(x).getClase())){
            for(int y=0; y<instancias.get(x).getVectorC().length;y++){
                  this.des[y]= Math.sqrt(this.varianza.get(x).getVectorC()[y]);
                 }
             }
         }
        
        this.desviaciones = new Patron(aux.get(w),"",this.des);
        this.desviacion.add(this.desviaciones);
     }
        for(int x=0; x<desviacion.size(); x++){
            for(int y=0; y<desviacion.get(x).getVectorC().length; y++){
                System.out.println(desviacion.get(x).getVectorC()[y]+"-> clase -> "+desviacion.get(x).getClase());
            } 
        }
    }        
}
    
    

