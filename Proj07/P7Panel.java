package javaapplication8;
import java.awt.*;
import javax.swing.*;
/**
 *@author Jess Wilson
 * Project 7 Panel Class
 * 12-6-16
 */
public class P7Panel extends JPanel{
    public static final int UI_VALID = 0;
    public static final int UI_INVALID_NO_FIRST_NAME = 1;
    public static final int UI_INVALID_NO_LAST_NAME = 2;
    public static final int UI_INVALID_NO_MAJOR = 3;
    public static final int UI_INVALID_NO_YEAR = 4;
    public static final int UI_INVALID_NO_DEGREE = 5;
    public static JTextField tfFirstName;
    public static JTextField tfLastName;
    public static JComboBox cbDept;
    public static String[] deptArray = {"Select One", "Art", "Biology",
        "Business","Chemistry","CIS","Economics","History","Kinesiology",
        "Mathematics","Political Science"};
    public static JComboBox cbYear;
    public static String[] yearArray = {"", "1999", "2000", "2001", "2002",
        "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010,",
        "2011", "2012", "2013,", "2014", "2015", "2016", "2017", "2018",
        "2019", "2020", "2021"};
    public static JRadioButton rbAA = new JRadioButton("AA");
    public static JRadioButton rbBA = new JRadioButton("BA");
    public static JRadioButton rbBS = new JRadioButton("BS");
    public static JRadioButton rbDummy = new JRadioButton("");
    public static JCheckBox chAid = new JCheckBox("On Financial Aid");
    public static JCheckBox chFullTime = new JCheckBox("Full-time");
    public static JCheckBox chOutState = new JCheckBox("Out of State");
    JPanel buttonPanel; 
    public P7Panel(){
        Panel border = new Panel();
        border.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel();
        buttonPanel = new JPanel();
        GridLayout grid = new GridLayout(5,1);
        mainPanel.setLayout(grid);
        JPanel hostPanel, dbNamePanel, tablePanel, usernamePanel, passwordPanel;
        hostPanel = new JPanel();
        mainPanel.add(hostPanel);
        dbNamePanel = new JPanel();
        mainPanel.add(dbNamePanel);
        tablePanel = new JPanel();
        mainPanel.add(tablePanel);
        usernamePanel = new JPanel();
        mainPanel.add(usernamePanel);
        passwordPanel = new JPanel();
        mainPanel.add(passwordPanel);
        JLabel r1Label = new JLabel("First Name: ");
        tfFirstName = new JTextField(18);
        hostPanel.add(r1Label);
        hostPanel.add(tfFirstName);
        JLabel r2Label = new JLabel("Last Name: ");
        tfLastName = new JTextField(18);
        dbNamePanel.add(r2Label);
        dbNamePanel.add(tfLastName);        
        JLabel r3Label = new JLabel("Major Dept: ");
        cbDept = new JComboBox();
        cbDept.setLightWeightPopupEnabled(false); 
        cbDept.setSelectedItem("Select One");
        for(int i = 0; i < deptArray.length; i++){
            cbDept.addItem(deptArray[i]);
        }
        tablePanel.add(r3Label);
        tablePanel.add(cbDept);
        JLabel r4Label = new JLabel("Degree: ");
        rbDummy.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(rbAA);
        group.add(rbBA);
        group.add(rbBS);
        group.add(rbDummy);
        JLabel r4Label2 = new JLabel("Year: ");
        cbYear = new JComboBox();
        cbYear.setLightWeightPopupEnabled(false); 
        cbYear.addItem(yearArray);
        for(int i = 0; i < yearArray.length; i++){
            cbYear.addItem(yearArray[i]);
        }
        cbYear.setSelectedItem("");
        usernamePanel.add(r4Label);
        usernamePanel.add(rbAA);
        usernamePanel.add(rbBA);
        usernamePanel.add(rbBS);
        usernamePanel.add(r4Label2);
        usernamePanel.add(cbYear);
        passwordPanel.add(chAid);
        passwordPanel.add(chFullTime);
        passwordPanel.add(chOutState);
        mainPanel.add(hostPanel);
        mainPanel.add(dbNamePanel);
        mainPanel.add(tablePanel);
        mainPanel.add(usernamePanel);
        mainPanel.add(passwordPanel);
        border.add(mainPanel, BorderLayout.CENTER);
        add(border);	
        border.add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
    public static int ValidateUI(){
        if(tfFirstName.getText().equals("")){
            tfFirstName.requestFocus();
            return UI_INVALID_NO_FIRST_NAME;
        }
        else if(tfLastName.getText().equals("")){
            tfLastName.requestFocus();
            return UI_INVALID_NO_LAST_NAME;
        }
        else if(cbDept.getSelectedItem().equals("Select One")){
            cbDept.requestFocus();
            return UI_INVALID_NO_MAJOR;
        }
        else if(cbYear.getSelectedItem().equals("")){
            cbYear.requestFocus();
            return UI_INVALID_NO_YEAR;
        }
        else if(rbDummy.isSelected() == true){
            rbAA.requestFocus();
            return UI_INVALID_NO_DEGREE;
        }
        else{
            return UI_VALID;
        }
    }
    public void setUIData(String[] strArray)
    {
        tfFirstName.setText(strArray[0]);
        tfLastName.setText(strArray[1]);
        for(int i = 0; i < deptArray.length; i++){
            if (deptArray[i].equals(strArray[2]))
                cbDept.setSelectedItem(deptArray[i]);
        }
        if (strArray[3].equals("AA"))
            rbAA.setSelected(true);
        else if (strArray[3].equals("BA"))
            rbBA.setSelected(true);
        else if (strArray[3].equals("BS"))
            rbBS.setSelected(true);
        else
            rbDummy.setSelected(true);
        for(int i = 0; i < yearArray.length; i++){
            if (yearArray[i].equals(strArray[4]))
                cbYear.setSelectedItem(yearArray[i]);
        }
        if (strArray[5].equals("T"))
            chAid.setSelected(true);
        if (strArray[6].equals("T"))
            chFullTime.setSelected(true);
        if (strArray[7].equals("T"))
            chOutState.setSelected(true);
    }
}