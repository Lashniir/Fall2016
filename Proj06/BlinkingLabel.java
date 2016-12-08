import java.awt.Color;
import javax.swing.JLabel;

public class BlinkingLabel extends JLabel{
    private Color bg;
    private Color fg;
    private int delay = 300;
    
    public BlinkingLabel(String str, int delay, Color c){
        super(str);
        this.delay=delay;
        bg = c;
        fg = this.getForeground();
        new Timer().start();
    }
    
    public void setForeground(Color c){
        //fg=c;
        super.setForeground(c);
    }
    
    public class Timer extends Thread{
        @Override
        public void run(){
            try{
                while(true){
                    BlinkingLabel.super.setForeground(fg);//fg
                    sleep(delay);
                    BlinkingLabel.super.setForeground(bg);//bg
                    sleep(delay);
                    //System.out.println("while loop");
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
}
