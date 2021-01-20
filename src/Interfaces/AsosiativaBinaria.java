/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import data.PatronBinario;
import java.util.ArrayList;

/**
 *
 * @author jesua
 */
public interface AsosiativaBinaria {
    public abstract void aprendizaje(ArrayList<PatronBinario> instancias);
    public abstract void clasificacion(ArrayList<PatronBinario> instancias);
}
