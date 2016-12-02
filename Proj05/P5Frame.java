//package javaapplication8;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class P5Frame extends JFrame {

    PrintWriter out;
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("File");
    JMenuItem mOpen = new JMenuItem("Open");
    JMenuItem mClose = new JMenuItem("Close");
    JMenuItem mExit = new JMenuItem("Exit");
    JButton submitBT = new JButton("Submit");
    JButton clearBT = new JButton("Clear");
    JPanel buttonP = new JPanel();
    JFileChooser chooser = new JFileChooser();

    public P5Frame() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        menu.setMnemonic(KeyEvent.VK_F);
        mOpen.setMnemonic(KeyEvent.VK_O);
        mClose.setMnemonic(KeyEvent.VK_C);
        mExit.setMnemonic(KeyEvent.VK_E);
        chooser.setCurrentDirectory(new File("."));

        submitBT.addActionListener(new SubmitHandler());
        clearBT.addActionListener(new ClearHandler());
        mOpen.addActionListener(new OpenHandler());
        mClose.addActionListener(new CloseHandler());
        mExit.addActionListener(new ExitHandler());

        buttonP.add(submitBT);
        buttonP.add(clearBT);
        menuBar.add(menu);
        menu.add(mOpen);
        menu.add(mClose);
        menu.add(mExit);

        add(new P5Panel(), BorderLayout.CENTER);
        add(menuBar, BorderLayout.NORTH);
        add(buttonP, BorderLayout.SOUTH);

        mClose.setEnabled(false);
        submitBT.setEnabled(false);
        clearBT.setEnabled(false);
    }

    public static void main(String[] args) {
        P5Frame frame = new P5Frame();
        frame.setSize(500, 280);
        frame.setVisible(true);
    }

    private class SubmitHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int result = P5Panel.p5ValidateUI();
            if (result == P3Panel.UI_VALID) {
                P5Panel.P5Print(out);
            } else if (result == P5Panel.UI_INVALID_NO_FIRST_NAME) {
                JOptionPane.showMessageDialog(null,
                        "You did not give me your first name. Please try again.");
                P5Panel.focusFirst();
            } else if (result == P5Panel.UI_INVALID_NO_LAST_NAME) {
                JOptionPane.showMessageDialog(null,
                        "You did not give me your last name. Please try again");
                P5Panel.focusLast();
            } else if (result == P5Panel.UI_INVALID_NO_MAJOR) {
                JOptionPane.showMessageDialog(null,
                        "You did not select a major. I know it can be hard, but please try again.");
                P5Panel.focusDept();
            } else if (result == P5Panel.UI_INVALID_NO_DEGREE) {
                JOptionPane.showMessageDialog(null,
                        "You did not select a degree. Please choose from one of the options.");
                P5Panel.focusDegree();
            } else if (result == P5Panel.UI_INVALID_NO_YEAR) {
                JOptionPane.showMessageDialog(null,
                        "You did not selec a year. Please choose one from the options.");
                P5Panel.focusYear();
            }
        }
    }

    private class ClearHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            P5Panel.p5ClearUI();
        }
    }

    private class OpenHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            chooser.showOpenDialog(P5Frame.this);
            File file = chooser.getSelectedFile();
            try {
                if (file.exists()) {
                    int n = JOptionPane.showConfirmDialog(P5Frame.this, "File already exists.\n"
                            + "Would you like to continue?", "File Already Exists",
                            JOptionPane.YES_NO_OPTION);
                    if (n == 1) {
                        return;
                    } else if (n == 0) {
                        out = new PrintWriter(file);
                        submitBT.setEnabled(true);
                        clearBT.setEnabled(true);
                        mClose.setEnabled(true);
                        mOpen.setEnabled(false);
                        P5Frame.this.setVisible(true);
                    }
                } else {
                    out = new PrintWriter(file + ".txt");
                    submitBT.setEnabled(true);
                    clearBT.setEnabled(true);
                    mClose.setEnabled(true);
                    mOpen.setEnabled(false);
                    P5Frame.this.setVisible(true);
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(P5Frame.this,
                        "File Not Found.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class CloseHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            out.close();
            P5Panel.p5ClearUI();
            submitBT.setEnabled(false);
            clearBT.setEnabled(false);
            mClose.setEnabled(false);
            mOpen.setEnabled(true);
            P5Frame.this.setVisible(true);
        }
    }

    private class ExitHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (out == null) {
                System.exit(0);
            }
            out.close();
            System.exit(0);
        }
    }
}
