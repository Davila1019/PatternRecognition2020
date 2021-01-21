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
 * @author jesua
 */
public interface Asociativa {
    public abstract void aprendizaje(ArrayList<Patron> instancias);
    public abstract void recuperacion(ArrayList<Patron> instancias);
}
