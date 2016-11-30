package javaapplication8;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class P2Frame extends JFrame{
        private static JLabel firstNameLB = new JLabel("First Name:  ");
        private static JLabel lastNameLB = new JLabel("Last Name:  ");
        private static JLabel classLB = new JLabel("Class:            ");
        private static JTextField firstNameTF = new JTextField();
        private static JTextField lastNameTF = new JTextField();
        private static JTextField classTF = new JTextField();
        private static JButton showHideBT = new JButton("Show");
        private static JButton updateBT = new JButton("Update");
        private static JButton exitBT = new JButton("Exit");
        private static TextWindow textWindow = new TextWindow();
 
    public P2Frame(String str){

        firstNameTF.setPreferredSize(new Dimension(100, 20));
        firstNameTF.setMaximumSize(new Dimension(100, 20));
        lastNameTF.setPreferredSize(new Dimension(100, 20));
        lastNameTF.setMaximumSize(new Dimension(100, 20));
        classTF.setPreferredSize(new Dimension(100, 20));
        classTF.setMaximumSize(new Dimension(100, 20));
        
        exitBT.addActionListener(new ExitHandler());
        updateBT.addActionListener(new UpdateHandler());
        showHideBT.addActionListener(new SHHandler());
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        JPanel panel2 = new JPanel();
        
        
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        panel3.add(Box.createRigidArea(new Dimension(10,10)));
        panel.add(firstNameLB);
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        panel3.add(firstNameTF);
        panel3.add(Box.createRigidArea(new Dimension(10,10)));
        panel.add(lastNameLB);
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        panel3.add(lastNameTF);
        panel3.add(Box.createRigidArea(new Dimension(10,10)));
        panel.add(classLB);
        panel3.add(classTF);
        
        this.add(panel, BorderLayout.WEST);
        this.add(panel3, BorderLayout.EAST);
        
        panel2.add(showHideBT);
        panel2.add(updateBT);
        panel2.add(exitBT);
        
        this.add(panel2, BorderLayout.SOUTH);
        
    }
    private static class SHHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(showHideBT.getText().equals("Show")){
                textWindow.setVisible(true);
                showHideBT.setText("Hide");
                TextWindow.setJTA(firstNameTF.getText(),lastNameTF.getText(),classTF.getText());
                
            }
            else if(showHideBT.getText().equals("Hide")){
                textWindow.setVisible(false);
                showHideBT.setText("Show");
            }
        }
    }
    private static class UpdateHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            TextWindow.setJTA(firstNameTF.getText(),lastNameTF.getText(),classTF.getText());
        }
    }
    private static class ExitHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
    public static void setSHB(){
        showHideBT.setText("Show");
    }
    public static void main(String[] args){
        P2Frame frame1 = new P2Frame("Frame 1");
        frame1.setSize(225,175);
        frame1.setResizable(false);
        frame1.setVisible(true);
    }
}
