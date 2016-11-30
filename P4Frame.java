/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Lashniir
 */
public class P4Frame extends JFrame {
    
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Edit");
    JMenuItem pref = new JMenuItem("Preferences");
    static JPanel board = new JPanel();
    static int redSel = 1;
    static int greenSel = 0;
    static int blueSel = 0;
    
    public P4Frame(){
        this.setLayout(new BorderLayout());
        board.setBackground(Color.RED);
        menu.setMnemonic(KeyEvent.VK_E);
        pref.setMnemonic(KeyEvent.VK_P);
        pref.addActionListener(new PrefHandler());
        menuBar.add(menu);
        menu.add(pref);
        this.add(menuBar, BorderLayout.NORTH);
        this.add(board, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private class PrefHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            P4Dialog p = new P4Dialog(P4Frame.this);}}
    
    public static void main(String[] args){
        P4Frame frame = new P4Frame();
        frame.setSize(500,280);
        frame.setVisible(true);
    }
    
    public static void mySetBGColor(int selColor){
        if(selColor == 0){
            board.setBackground(Color.red);
            redSel = 1;
            greenSel = 0;
            blueSel = 0;
        }
        else if(selColor == 1){
            board.setBackground(Color.green);
            redSel = 0;
            greenSel = 1;
            blueSel = 0;
        }
        else if(selColor ==2){
            board.setBackground(Color.blue);
            redSel = 0;
            greenSel = 0;
            blueSel = 1;
        }
    }
}