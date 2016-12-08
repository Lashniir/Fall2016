import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class P6Frame extends JFrame {
    
    private BlinkingLabel label1 = new BlinkingLabel("Black and blue, 200 delay",200,Color.blue);
    private BlinkingLabel label2 = new BlinkingLabel("Black and yellow, 300 delay",300,Color.yellow);
    private BlinkingLabel label3 = new BlinkingLabel("Black and orange, 600 delay",600,Color.orange);
    
    public P6Frame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        label1.setOpaque(true);
        label2.setOpaque(true);
        label3.setOpaque(true);
        
        panel.add(Box.createRigidArea(new Dimension(100,100)));
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        
        this.add(panel, BorderLayout.WEST);
    }
    
    public static void main(String[] args){
        P6Frame frame = new P6Frame();
        frame.setSize(300, 250);
        frame.setVisible(true);
    }
}
