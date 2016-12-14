
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NP7Panel extends JPanel {

    public static final int UI_VALID = 0;
    public static final int UI_INVALID_NO_FIRST_NAME = 1;
    public static final int UI_INVALID_NO_LAST_NAME = 2;
    public static final int UI_INVALID_NO_MAJOR = 3;
    public static final int UI_INVALID_NO_DEGREE = 4;
    public static final int UI_INVALID_NO_YEAR = 5;
    public static final int UI_VALID_BUT_NEEDS_HELP = 6;

    private static String[] depts = {"Select One", "Art", "Biology", "Buisness",
        "Chemistry", "CIS", "Economics", "History", "Kinesiology",
        "Mathematics", "Political Science"};
    private static String[] years = {"Select One", "1999", "2000", "2001", "2002",
        "2003", "2004", "2005", "2006,2007", "2008", "2009", "2010", "2011", "2012",
        "2013", "2014", "2015", "2016", "2017"};
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
    private JRadioButton bARB = new JRadioButton("BA");
    private JRadioButton bSRB = new JRadioButton("BS");
    static JRadioButton dummyRB = new JRadioButton();
    private ButtonGroup bg = new ButtonGroup();
    static JCheckBox aidCheck = new JCheckBox("On Financial Aid");
    static JCheckBox fullTCheck = new JCheckBox("Full Time");
    static JCheckBox OOSCheck = new JCheckBox("Out of State");
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JPanel panel5 = new JPanel();

    public NP7Panel() {
        this.setLayout(new GridLayout(5, 1));
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

    public static int np7ValidateUI() {
        if (firstNameTF.getText().trim().equals("")) {
            return 1;
        } else if (lastNameTF.getText().trim().equals("")) {
            return 2;
        } else if (deptCB.getSelectedIndex() == 0) {
            return 3;
        } else if (dummyRB.isSelected()) {
            return 4;
        } else if (yearCB.getSelectedIndex() == 0) {
            return 5;
        } else if (deptCB.getSelectedIndex() == 12) {
            return 6;
        } else {
            return 0;
        }
    }

    public static void np7ClearUI() {
        firstNameTF.setText(null);
        lastNameTF.setText(null);
        deptCB.setSelectedIndex(0);
        yearCB.setSelectedIndex(0);
        dummyRB.setSelected(true);
        aidCheck.setSelected(false);
        fullTCheck.setSelected(false);
        OOSCheck.setSelected(false);
    }

    public static void focusFirst() {
        firstNameTF.requestFocus();
    }

    public static void focusLast() {
        lastNameTF.requestFocus();
    }

    public static void focusDept() {
        deptCB.requestFocus();
    }

    public static void focusDegree() {
        aARB.requestFocus();
    }

    public static void focusYear() {
        yearCB.requestFocus();
    }

    public void setUIData(String[] strArray) {
        firstNameTF.setText(strArray[0]);
        lastNameTF.setText(strArray[1]);
        for (int i = 0; i < depts.length; i++) {
            if (depts[i].equals(strArray[2])) {
                deptCB.setSelectedItem(depts[i]);
            }
        }
        if (strArray[3].equals("AA")) {
            aARB.setSelected(true);
        } else if (strArray[3].equals("BA")) {
            bARB.setSelected(true);
        } else if (strArray[3].equals("BS")) {
            bSRB.setSelected(true);
        } else {
            dummyRB.setSelected(true);
        }
        for (int i = 0; i < years.length; i++) {
            if (years[i].equals(strArray[4])) {
                yearCB.setSelectedItem(years[i]);
            }
        }
        if (strArray[5].equals("T")) {
            aidCheck.setSelected(true);
        }
        if (strArray[6].equals("T")) {
            fullTCheck.setSelected(true);
        }
        if (strArray[7].equals("T")) {
            OOSCheck.setSelected(true);
        }
    }
}
