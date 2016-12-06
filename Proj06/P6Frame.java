/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class P6Frame extends JFrame {
    
    public P6Frame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        panel.add(Box.createRigidArea(new Dimension(100,100)));
        panel.add(new BlinkingLabel("Label 1",150));
        panel.add(new BlinkingLabel("Label 2",300));
        panel.add(new BlinkingLabel("Label 3",600));
        
        this.add(panel, BorderLayout.WEST);
    }
    
    public static void main(String[] args){
        P6Frame frame = new P6Frame();
        frame.setSize(100, 100);
        frame.setVisible(true);
    }
}
