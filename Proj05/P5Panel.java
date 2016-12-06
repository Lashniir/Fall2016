import java.awt.GridLayout;
import java.io.PrintWriter;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class P5Panel extends JPanel{
    
    public static final int UI_VALID = 0;
    public static final int UI_INVALID_NO_FIRST_NAME = 1;
    public static final int UI_INVALID_NO_LAST_NAME = 2;
    public static final int UI_INVALID_NO_MAJOR = 3;
    public static final int UI_INVALID_NO_DEGREE = 4;
    public static final int UI_INVALID_NO_YEAR = 5;
    
    private static String[] depts = {"Select One","Art","Biology","Buisness",
                "Chemistry","CIS","Economics","History","HPEES","Mathematics",
                "Political Science","Undecided"};
    private static String[] years = {"Select One","1999","2000","2001","2002",
        "2003", "2004","2005","2006"};
    
    private JLabel firstNameLB = new JLabel("First Name: ");
    private JLabel lastNameLB = new JLabel("Last Name: ");
    private JLabel deptLB = new JLabel("Major Dept: ");
    private static JLabel degreeLB = new JLabel("Degree: ");
    private JLabel yearLB = new JLabel("Year: ");
    private static JTextField firstNameTF = new JTextField();
    private static JTextField lastNameTF = new JTextField();
    private static JComboBox deptCB = new JComboBox(depts);
    private static JComboBox yearCB = new JComboBox(years);
    private static JRadioButton aARB = new JRadioButton("AA");
    private static JRadioButton bARB = new JRadioButton("BA");
    private static JRadioButton bSRB = new JRadioButton("BS");
    private static JRadioButton dummyRB = new JRadioButton();
    private ButtonGroup bg = new ButtonGroup();
    private static JCheckBox aidCheck = new JCheckBox("On Financial Aid");
    private static JCheckBox fullTCheck = new JCheckBox("Full Time");
    private static JCheckBox OOSCheck = new JCheckBox("Out of State");
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JPanel panel5 = new JPanel();
    
    public P5Panel(){
        this.setLayout(new GridLayout(5,1));
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);
        
        bg.add(aARB);
        bg.add(bARB);
        bg.add(bSRB);
        bg.add(dummyRB);
        
        dummyRB.setSelected(true);
        
        deptCB.setSelectedIndex(0);
        yearCB.setSelectedIndex(0);
        
        firstNameTF.setColumns(13);
        lastNameTF.setColumns(13);
        
        panel1.add(firstNameLB);
        panel1.add(firstNameTF);
        panel2.add(lastNameLB);
        panel2.add(lastNameTF);
        panel3.add(deptLB);
        panel3.add(deptCB);
        panel4.add(degreeLB);
        panel4.add(aARB);
        panel4.add(bARB);
        panel4.add(bSRB);
        panel4.add(yearLB);
        panel4.add(yearCB);
        panel5.add(aidCheck);
        panel5.add(fullTCheck);
        panel5.add(OOSCheck);
    }
        
    public static int p5ValidateUI(){
        if(firstNameTF.getText().trim().equals("")){return 1;}
        else if(lastNameTF.getText().trim().equals("")){return 2;}
        else if(deptCB.getSelectedIndex()==0){return 3;}
        else if(dummyRB.isSelected()){return 4;}
        else if(yearCB.getSelectedIndex()==0){return 5;}
        else{return 0;}
    }
    
    public static void p5ClearUI(){
        firstNameTF.setText(null);
        lastNameTF.setText(null);
        deptCB.setSelectedIndex(0);
        yearCB.setSelectedIndex(0);
        dummyRB.setSelected(true);
        aidCheck.setSelected(false);
        fullTCheck.setSelected(false);
        OOSCheck.setSelected(false);
    }
    
    public static void focusFirst(){
        firstNameTF.requestFocus();
    }
    
    public static void focusLast(){
        lastNameTF.requestFocus();
    }
    public static void focusDept(){
	deptCB.requestFocus();
    }
    public static void focusDegree(){
	aARB.requestFocus();
    }
    public static void focusYear(){
	yearCB.requestFocus();
    }
    public static void P5Print(PrintWriter out){
        
        String degree = "";
        String aid = "No Financial Aid";
        String fullT = "Not Full Time";
        String OOS = "In State";
        
        if(aARB.isSelected()){degree = "AA";}
        else if(bARB.isSelected()){degree = "BA";}
        else if(bSRB.isSelected()){degree = "BS";}
        if(aidCheck.isSelected()){aid = "On Financial Aid";}
        if(fullTCheck.isSelected()){fullT = "Full Time";}
        if(OOSCheck.isSelected()){OOS = "Out of State";}
        
        out.println(firstNameTF.getText()+","+
                lastNameTF.getText()+","+
                depts[deptCB.getSelectedIndex()]+","+
                degree+","+
                years[yearCB.getSelectedIndex()]+","+
                aid+","+fullT+","+OOS);
    }
}
