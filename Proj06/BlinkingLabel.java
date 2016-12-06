package javaapplication8;

import java.awt.Color;
import javax.swing.JLabel;

public class BlinkingLabel extends JLabel{
    private Color bg;
    private Color fg;
    private int delay = 300;
    
    public BlinkingLabel(String str, int delay){
        super(str);
        this.delay=delay;
        bg = getBackground();
        fg = getForeground();
        new Timer().start();
    }
    
    public void setForeground(Color c){
        fg=c;
        super.setForeground(c);
    }
    
    public class Timer extends Thread{
        public void run(){
            try{
                while(true){
                    BlinkingLabel.super.setForeground(fg);
                    sleep(delay);
                    BlinkingLabel.super.setBackground(fg);
                    sleep(delay);
                    System.out.println("while loop");
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
}
