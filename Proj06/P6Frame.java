package javaapplication8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class P6Frame extends JFrame {
    
    private BlinkingLabel label1 = new BlinkingLabel("Label 1",100);
    private BlinkingLabel label2 = new BlinkingLabel("Label 2",300);
    private BlinkingLabel label3 = new BlinkingLabel("Label 3",600);
    
    public P6Frame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        label1.setBackground(Color.red);
        label1.setForeground(Color.blue);
        label1.setOpaque(true);
        label2.setBackground(Color.red);
        label2.setForeground(Color.blue);
        label2.setOpaque(true);
        label3.setBackground(Color.red);
        label3.setForeground(Color.blue);
        label3.setOpaque(true);
        
        panel.add(Box.createRigidArea(new Dimension(100,100)));
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        
        this.add(panel, BorderLayout.WEST);
    }
    
    public static void main(String[] args){
        P6Frame frame = new P6Frame();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
