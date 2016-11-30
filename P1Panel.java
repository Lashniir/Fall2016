/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lashniir
 */
public class P1Panel extends JPanel{   
    
        public P1Panel(String str1){
    
            JLabel label = new JLabel(str1);
            this.add(label);
        }
    
}