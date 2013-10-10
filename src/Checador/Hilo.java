/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Checador;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Carmelita
 */
public class Hilo extends Thread {
    public JLabel lbl;
    
    public Hilo(JLabel lbl){
        this.lbl = lbl;
    }
    
    public void run(){
        while(true){
            Date hoy;
            hoy = new Date();
            SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
            lbl.setText(s.format(hoy));
            try{
                sleep(1000);
            }catch(Exception e){
                
            }
        }
    }
}
