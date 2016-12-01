import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TextWindow extends JFrame{
    
    private static JTextArea jTA;
    public TextWindow(){
        setSize(225,100);
        setLayout(new FlowLayout());
        jTA = new JTextArea(3,18);
        setJTA("","","");
        add(jTA);
        jTA.setEditable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.addWindowListener( new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent we) {
                        P2Frame.setSHB();
                    }
                } );
    }
    
    public static void setJTA(String s1, String s2, String s3){
        jTA.setText("First Name: "+s1+"\nLast Name: "+s2+"\nClass: "+s3);
    }
}
