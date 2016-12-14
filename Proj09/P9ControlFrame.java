import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class P9ControlFrame extends JFrame{
    
    private JSlider wSlide = new JSlider();
    private JSlider hSlide = new JSlider();
    private JSlider rSlide = new JSlider();
    private JSlider gSlide = new JSlider();
    private JSlider bSlide = new JSlider();
    private JLabel wLB = new JLabel("Width");
    private JLabel hLB = new JLabel("Height");
    private JLabel rLB = new JLabel("Red");
    private JLabel gLB = new JLabel("Green");
    private JLabel bLB = new JLabel("Blue");
    
    public P9ControlFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel sPanel = new JPanel();
        JPanel lPanel = new JPanel();
        
        lPanel.setLayout(new BoxLayout(lPanel, BoxLayout.PAGE_AXIS));
        
        sPanel.add(wSlide);
        sPanel.add(hSlide);
        sPanel.add(rSlide);
        sPanel.add(gSlide);
        sPanel.add(bSlide);
        
        lPanel.add(wLB);
        lPanel.add(Box.createRigidArea(new Dimension(0,6)));
        lPanel.add(hLB);
        lPanel.add(Box.createRigidArea(new Dimension(0,6)));
        lPanel.add(rLB);
        lPanel.add(Box.createRigidArea(new Dimension(0,6)));
        lPanel.add(gLB);
        lPanel.add(Box.createRigidArea(new Dimension(0,6)));
        lPanel.add(bLB);
        
        add(sPanel, BorderLayout.CENTER);
        add(lPanel, BorderLayout.EAST);
        
        setVisible(true);
        
        try{ServerSocket sock = new ServerSocket(5000);}
        catch(IOException ioe){System.out.println(ioe);}
    }
    
    public static void main(String[] args){
        P9ControlFrame frame = new P9ControlFrame();
        frame.setSize(300,200);
    }
}
