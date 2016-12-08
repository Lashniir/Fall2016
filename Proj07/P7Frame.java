package javaapplication8;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
/**
 *@author Jess Wilson
 * Project 7 Frame Class - Main
 * 12-6-16
 */
public class P7Frame extends JFrame{
    private static P7Panel dataPanel = new P7Panel();
    private static JButton previous = new JButton("<-");
    private static JButton next = new JButton("->");
    private JButton exit = new JButton("Exit");
    private JMenu databaseJM;
    private static JMenuItem open;
    private static JMenuItem close;
    private DBDialog dbDialog;
    private String[] record = new String[8];
    
    public P7Frame(String title){
        add(dataPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        previous.setEnabled(false);
        next.setEnabled(false);
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        buttonPanel.add(previous);
        buttonPanel.add(next);
        buttonPanel.add(exit);
        add(buttonPanel, BorderLayout.SOUTH);
        JMenuBar jmb = new JMenuBar();
        databaseJM = new JMenu("Database");
        databaseJM.setMnemonic('D');
        databaseJM.getPopupMenu().setLightWeightPopupEnabled(false); 
        open = new JMenuItem("Open");
        close = new JMenuItem("Close");
        close.setEnabled(false);
        open.setMnemonic('O');
        open.setAccelerator
        (KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_MASK));
        dbDialog = new DBDialog(this);
        open.addActionListener(new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent e){
        dbDialog.setVisible(true);
        if (dbDialog.getOK() == true){
            try{
                Class.forName("org.gjt.mm.mysql.Driver");
                String dbconn="jdbc:mysql://"+dbDialog.getHostName()+":3306/"
                    +dbDialog.getDBName();
                Connection conn =
                DriverManager.getConnection(dbconn,dbDialog.getUsername(),
                        dbDialog.getPassword());
                Statement stmt = conn.createStatement();
                String query1 = "select * from " + dbDialog.getTableName();
                ResultSet rset = stmt.executeQuery(query1);
                open.setEnabled(false);
                close.setEnabled(true);
                //previous.setEnabled(true);
                next.setEnabled(true);   
                rset.next();
                record[0] = rset.getString(3);
                record[1] = rset.getString(2);
                record[2] = rset.getString(4);
                record[3] = rset.getString(5);
                record[4] = rset.getString(6);
                record[5] = rset.getString(7);
                record[6] = rset.getString(8);
                record[7] = rset.getString(9);
                dataPanel.setUIData(record);
                previous.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    try{
                        if (rset.isFirst()){
                            previous.setEnabled(false);
                        }
                        else{
                            previous.setEnabled(true);
                            next.setEnabled(true);
                            rset.previous();
                            for(int i = 0; i < record.length; i++){
                                
                            }
                            record[0] = rset.getString(3);
                            record[1] = rset.getString(2);
                            record[2] = rset.getString(4);
                            record[3] = rset.getString(5);
                            record[4] = rset.getString(6);
                            record[5] = rset.getString(7);
                            record[6] = rset.getString(8);
                            record[7] = rset.getString(9);
                            dataPanel.chAid.setSelected(false);
                            dataPanel.chFullTime.setSelected(false);
                            dataPanel.chOutState.setSelected(false);
                            dataPanel.setUIData(record);
                            if (rset.isFirst()){
                            previous.setEnabled(false);
                            }
                        }
                    }
                    catch(SQLException sqle){
                        System.out.println(sqle);
                    }
                }
                });
                next.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    try{
                        if (rset.isLast()){
                            next.setEnabled(false);
                        }
                        else{
                            next.setEnabled(true);
                            previous.setEnabled(true);
                            rset.next();
                            record[0] = rset.getString(3);
                            record[1] = rset.getString(2);
                            record[2] = rset.getString(4);
                            record[3] = rset.getString(5);
                            record[4] = rset.getString(6);
                            record[5] = rset.getString(7);
                            record[6] = rset.getString(8);
                            record[7] = rset.getString(9);
                            dataPanel.rbDummy.setEnabled(true);
                            dataPanel.chAid.setSelected(false);
                            dataPanel.chFullTime.setSelected(false);
                            dataPanel.chOutState.setSelected(false);
                            dataPanel.setUIData(record);
                            if (rset.isLast()){
                            next.setEnabled(false);
                            }
                        }
                    }
                    catch(SQLException sqle){
                        System.out.println(sqle);
                    }
                }
                });
                /*rset.close();
                stmt.close();
                conn.close();*/
                close.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    ClearUI();
                    try{
                    while (rset.isFirst() != true){
                        rset.previous();
                        }
                    }
                    catch(SQLException sqle){
                        System.out.println(sqle);
                    }
                }
            });
            }
            catch(ClassNotFoundException cnfe){
                System.out.println(cnfe);
            }
            catch(SQLException sqle){
                System.out.println(sqle);
            }
        }
        }
        });
        close.setMnemonic('C');
        close.setAccelerator
        (KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_MASK));
        /*close.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ClearUI();
            }
        });*/
        jmb.add(databaseJM);
        databaseJM.add(open);
        databaseJM.add(close);
        setJMenuBar(jmb);
        setSize(500,400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);   
    }
    public static void ClearUI(){
        dataPanel.tfFirstName.setText("");
        dataPanel.tfLastName.setText("");
        dataPanel.cbDept.setSelectedItem("Select One");
        dataPanel.cbYear.setSelectedItem("");
        dataPanel.rbDummy.setSelected(true);
        dataPanel.chAid.setSelected(false);
        dataPanel.chFullTime.setSelected(false);
        dataPanel.chOutState.setSelected(false);
        previous.setEnabled(false);
        next.setEnabled(false);
        open.setEnabled(true);
        close.setEnabled(false);
    }
    public static void main(String[] args){
        P7Frame main = new P7Frame("Project 7");
        main.setVisible(true);
    }
}