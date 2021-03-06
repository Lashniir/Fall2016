import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class P8Frame extends JFrame {

    private static JButton prevBT = new JButton("<--");
    private static JButton nextBT = new JButton("-->");
    private JButton exitBT = new JButton("Exit");
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Database");
    private JMenuItem openMI = new JMenuItem("Open");
    private JMenuItem closMI = new JMenuItem("Close");
    private String[] record = new String[8];
    
    private JButton updaBT = new JButton("Update");
    private JButton cancBT = new JButton("Cancel");
    private JButton deleBT = new JButton("Delete");
    private JButton newBT = new JButton("New");

    public P8Frame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        P8Panel cPanel = new P8Panel();
        setLayout(new BorderLayout());
        add(cPanel, BorderLayout.CENTER);

        JPanel bPanel = new JPanel();
        bPanel.add(prevBT);
        prevBT.setEnabled(false);
        bPanel.add(nextBT);
        nextBT.setEnabled(false);
        bPanel.add(exitBT);
        bPanel.add(updaBT);
        bPanel.add(cancBT);
        bPanel.add(deleBT);
        deleBT.setEnabled(false);
        bPanel.add(newBT);
        newBT.setEnabled(false);
        add(bPanel, BorderLayout.SOUTH);

        menuBar.add(menu);
        menu.add(openMI);
        menu.add(closMI);
        closMI.setEnabled(false);
        menu.setMnemonic(KeyEvent.VK_D);
        openMI.setMnemonic(KeyEvent.VK_O);
        closMI.setMnemonic(KeyEvent.VK_C);

        add(menuBar, BorderLayout.NORTH);

        exitBT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        openMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBDialog dbDial = new DBDialog(P8Frame.this);
                dbDial.setVisible(true);
                if (dbDial.getOK() == true) {
                    try {
                        Class.forName("org.gjt.mm.mysql.Driver");
                        String dbconn = "jdbc:mysql://" + dbDial.getHostName()
                                + ":3300/" + dbDial.getDBName();
                        Connection conn
                                = DriverManager.getConnection(dbconn, 
                                        dbDial.getUsername(),
                                        dbDial.getPassword());
                        Statement stmt = conn.createStatement();
                        String query1 = "select * from "+dbDial.getTableName();
                        ResultSet rset = stmt.executeQuery(query1);
                        openMI.setEnabled(false);
                        closMI.setEnabled(true);
                        nextBT.setEnabled(true);
                        rset.next();
                        record[0] = rset.getString(3);
                        record[1] = rset.getString(2);
                        record[2] = rset.getString(4);
                        record[3] = rset.getString(5);
                        record[4] = rset.getString(6);
                        record[5] = rset.getString(7);
                        record[6] = rset.getString(8);
                        record[7] = rset.getString(9);
                        cPanel.setUIData(record);
                        prevBT.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    if (rset.isFirst()) {
                                        prevBT.setEnabled(false);
                                    } else {
                                        prevBT.setEnabled(true);
                                        nextBT.setEnabled(true);
                                        rset.previous();
                                        record[0] = rset.getString(3);
                                        record[1] = rset.getString(2);
                                        record[2] = rset.getString(4);
                                        record[3] = rset.getString(5);
                                        record[4] = rset.getString(6);
                                        record[5] = rset.getString(7);
                                        record[6] = rset.getString(8);
                                        record[7] = rset.getString(9);
                                        cPanel.aidCheck.setSelected(false);
                                        cPanel.fullTCheck.setSelected(false);
                                        cPanel.OOSCheck.setSelected(false);
                                        cPanel.setUIData(record);
                                        if (rset.isFirst()) {
                                            prevBT.setEnabled(false);
                                        }
                                    }
                                } catch (SQLException sqle) {
                                    System.out.println(sqle);
                                }
                            }
                        });
                        nextBT.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    if (rset.isLast()) {
                                        nextBT.setEnabled(false);
                                    } else {
                                        nextBT.setEnabled(true);
                                        prevBT.setEnabled(true);
                                        rset.next();
                                        record[0] = rset.getString(3);
                                        record[1] = rset.getString(2);
                                        record[2] = rset.getString(4);
                                        record[3] = rset.getString(5);
                                        record[4] = rset.getString(6);
                                        record[5] = rset.getString(7);
                                        record[6] = rset.getString(8);
                                        record[7] = rset.getString(9);
                                        cPanel.dummyRB.setEnabled(true);
                                        cPanel.aidCheck.setSelected(false);
                                        cPanel.fullTCheck.setSelected(false);
                                        cPanel.OOSCheck.setSelected(false);
                                        cPanel.setUIData(record);
                                        if (rset.isLast()) {
                                            nextBT.setEnabled(false);
                                        }
                                    }
                                } catch (SQLException sqle) {
                                    System.out.println(sqle);
                                }
                            }
                        });
                        closMI.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                P8Panel.p8ClearUI();
                                try {
                                    while (rset.isFirst() != true) {
                                        rset.previous();
                                    }
                                } catch (SQLException sqle) {
                                    System.out.println(sqle);
                                }
                            }
                        });
                    } catch (ClassNotFoundException cnfe) {
                        System.out.println(cnfe);
                    } catch (SQLException sqle) {
                        System.out.println(sqle);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        P8Frame frame = new P8Frame();
        frame.setSize(500, 280);
        frame.setVisible(true);
    }
}
