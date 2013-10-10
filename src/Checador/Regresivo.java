/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Checador;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carmelita
 */
public class Regresivo extends Thread{
    
    private Component componente;
    
    
    public Regresivo(Component comp){
        this.componente = comp;
    }
    
    public void run(){
        try {
            sleep(3000);
            componente.setVisible(false);
            System.out.println("Registro Completado");
        } catch (InterruptedException ex) {
            Logger.getLogger(Regresivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
