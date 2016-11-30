/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import javax.swing.JFrame;

/**
 *
 * @author Lashniir
 */
public class P1Frame extends JFrame{
    
    public P1Frame(String str1){
        P1Panel panel = new P1Panel(str1);
        this.setTitle(str1);
        this.setSize(200,100);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
