/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import Interfaces.ClasificadorSupervisado;
import data.Patron;
import java.util.ArrayList;


/**
 *
 * @author jesua
 */
public class K_NN implements ClasificadorSupervisado{
    private ArrayList<String> clases;
    private ArrayList<Patron> instancias;
    private int k;
    
    public K_NN(int k) {
        this.clases = new ArrayList<>();
        this.k = k;
    }
    @Override
    public void entrenar(ArrayList<Patron> instancias) {
       this.instancias = (ArrayList<Patron>) instancias.clone();
        // generamos un arraylist con las clases que se estan trabajando
        for(Patron p: instancias){
           if(!this.clases.contains(p.getClase())){
                this.clases.add(p.getClase());
           }
       }
    }

    @Override
    public void clasificar(ArrayList<Patron> instancias) {
        int cont =0;
        int eficacia=0;
        for(Patron p: instancias){
           clasificar(p);
       }
        for(int x=0; x<instancias.size();x++){
         System.out.println("Clase "+x+" = "+instancias.get(x).getClase()+" -> Clase Resultante = "+instancias.get(x).getClaseResultante());
         if(instancias.get(x).getClase().equals(instancias.get(x).getClaseResultante())){
             cont++;
         }
     }
     eficacia=(cont*100)/instancias.size();
     System.out.println("Eficacia de un "+eficacia+"%");
    }
    
    public void clasificar(Patron patron) {
        // la funcion sort es un metodo buebuja que ordena elementos
        if(k!=0){
        instancias.sort((a, b) -> new Double(a.calcularDistancia(patron)).compareTo(new Double(b.calcularDistancia(patron))));
        int contador[] = new int[this.clases.size()];
        // clasificar en base al numero de vecinos
        for(Patron aux: this.instancias){
            int i = this.clases.indexOf(aux.getClase());
            contador[i]++;
            if(contador[i]==this.k){
                // clasificar
                patron.setClaseResultante(this.clases.get(i));
                break;
            }
        }
      }   
    }
}
