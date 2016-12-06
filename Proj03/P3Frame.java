import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class P3Frame extends JFrame {
    
    static JButton submitBT = new JButton("Submit");
    JButton clearBT = new JButton("Clear");
    JButton exitBT = new JButton("Exit");
    JPanel buttonP = new JPanel();
    
    public P3Frame(){
        P3Panel inputPanel = new P3Panel();
        this.setLayout(new BorderLayout());
        this.add(inputPanel,BorderLayout.CENTER);
        buttonP.add(submitBT);
        buttonP.add(clearBT);
        buttonP.add(exitBT);
        this.add(buttonP, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        submitBT.addActionListener(new SubmitHandler());
        clearBT.addActionListener(new ClearHandler());
        exitBT.addActionListener(new ExitHandler());
        this.getRootPane().setDefaultButton(P3Frame.submitBT);
    }

    private class ExitHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    private class ClearHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e){
            P3Panel.p3ClearUI();
        }
    }
    private class SubmitHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e){
            int result = P3Panel.p3ValidateUI();
            if(result==P3Panel.UI_VALID){JOptionPane.showMessageDialog(null,
                    "All Clear Sir, No Problems Detected");}
            else if(result==P3Panel.UI_INVALID_NO_FIRST_NAME){
                JOptionPane.showMessageDialog(null,
                    "You did not give me your first name. Please try again.");
                P3Panel.focusFirst();
            }
            else if(result==P3Panel.UI_INVALID_NO_LAST_NAME){
                JOptionPane.showMessageDialog(null,
                    "You did not give me your last name. Please try again");
                P3Panel.focusLast();
            }
            else if(result==P3Panel.UI_INVALID_NO_MAJOR){
                JOptionPane.showMessageDialog(null,
                    "You did not select a major. I know it can be hard, but please try again.");
		P3Panel.focusDept();
            }
            else if(result==P3Panel.UI_INVALID_NO_DEGREE){
                JOptionPane.showMessageDialog(null,
                    "You did not select a degree. Please choose from one of the options.");
		P3Panel.focusDegree();
            }
            else if(result==P3Panel.UI_INVALID_NO_YEAR){
                JOptionPane.showMessageDialog(null,
                    "You did not selec a year. Please choose one from the options.");
		P3Panel.focusYear();
            }
	    else if(result==P3Panel.UI_VALID_BUT_NEEDS_HELP){
		JOptionPane.showMessageDialog(null,
		    "You have filled out the form correctly,\r\nbut have selected that you need help.\r\nPlease contact an adult for help.");
	    }
        }
    }
    
    public static void main(String[] args){
        P3Frame frame = new P3Frame();
        frame.setSize(500,280);
        frame.setVisible(true);
    }
}
