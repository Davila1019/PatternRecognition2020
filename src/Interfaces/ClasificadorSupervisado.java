/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import data.Patron;
import java.util.ArrayList;

/**
 *
 * @author working
 */
public interface ClasificadorSupervisado {
    
    public abstract void entrenar(ArrayList<Patron> instancias);
    public abstract void clasificar(ArrayList<Patron> instancias);
    public abstract void clasificar(Patron patron);
    
}