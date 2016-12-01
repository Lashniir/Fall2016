package javaapplication8;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JRadioButton;

public class P4Dialog extends JDialog {

    private JRadioButton redRB = new JRadioButton("Red");
    private JRadioButton greenRB = new JRadioButton("Green");
    private JRadioButton blueRB = new JRadioButton("Blue");
    private JButton okBT = new JButton("Ok");
    private JButton cancelBT = new JButton("Cancel");
    private ButtonGroup bg = new ButtonGroup();
    
    public P4Dialog(final P4Frame parent) {
        super(parent, true);
        if (P4Frame.redSel == 1) {
            redRB.setSelected(true);
        } else if (P4Frame.greenSel == 1) {
            greenRB.setSelected(true);
        } else if (P4Frame.blueSel == 1) {
            blueRB.setSelected(true);
        }
        this.setSize(225, 115);
        this.setLayout(new FlowLayout());
        bg.add(redRB);
        bg.add(greenRB);
        bg.add(blueRB);
        add(redRB);
        add(greenRB);
        add(blueRB);
        add(okBT);
        add(cancelBT);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        okBT.addActionListener(new OKHandler());
        cancelBT.addActionListener(new CancelHandler());
        setVisible(true);
    }

    private class OKHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (redRB.isSelected()) {
                setVisible(false);
                P4Frame.mySetBGColor(0);
            } else if (greenRB.isSelected()) {
                setVisible(false);
                P4Frame.mySetBGColor(1);
            } else if (blueRB.isSelected()) {
                setVisible(false);
                P4Frame.mySetBGColor(2);
            }
        }
    }
    
    private class CancelHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("cancel clicked");
            setVisible(false);
        }
    }
}
