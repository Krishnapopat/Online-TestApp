import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class login extends Frame implements ActionListener
{
    JLabel l1 = new JLabel("Institute Of Technology Nirma University");
    JButton b1 = new JButton("Student Login");
    JButton b2 = new JButton("Exit");

    public login()
    {
        setLayout(null);
        setSize(600,350);
        setVisible(true);
        setLocation(250,100);
        l1.setBounds(140,40,450,50);
        Font myFont = new Font("Serif",Font.BOLD,20);
        l1.setFont(myFont);
        b1.setBounds(220,140,150,30);
        b2.setBounds(220,200,150,30);
        add(l1);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b2)
        {
            System.exit(0);
        }
        if(e.getSource()==b1) {
            new login3().setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String args[])
    {
        login l2 =new login();
    }
}
class login3 extends Frame implements ActionListener {
    JLabel l1 = new JLabel("Student Login");
    JLabel l2 = new JLabel("Email ID");
    TextField t1 = new TextField();
    JLabel l3 = new JLabel("Password");
    TextField t2 = new TextField();
    JButton b1 = new JButton("Login");
    JButton b2 = new JButton("Exit");
    Label l4 = new Label("Invalid E-mail Address or Password !!!");
    Label l5 = new Label("The above fields should not be Empty !!!");
    public login3()
    {
        setLayout(null);
        setSize(600,350);
        setVisible(true);
        setLocation(250,100);
        l1.setBounds(200,40,450,50);
        Font myFont = new Font("Serif",Font.BOLD,25);
        l1.setFont(myFont);
        l2.setBounds(100, 100, 180, 50);
        t1.setBounds(300, 100, 180, 30);
        l3.setBounds(100,160, 180, 50);
        t2.setBounds(300, 160, 180,  30);
        b1.setBounds(120,220,100,30);
        b2.setBounds(320,220,100,30);
        l4.setBounds(50,260,200,50);
        l5.setBounds(50,260,200,50);
        add(l1);
        add(l2);
        add(t1);
        add(l3);
        add(t2);
        t2.setEchoChar('*');
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s1=t1.getText();
        String s2=t2.getText();
        if(e.getSource()==b2)
        {
            System.exit(0);
        }
        if(e.getSource()==b1)
        {
            if(s1.equals("21BCE228") && s2.equals("2004"))
            {
                new OnlineTest("OOPs Innovative Assignment ").setVisible(true);
                remove(l4);
                setVisible(false);
            }
            if(s1.equals("") || s2.equals(""))
            {
                add(l5);
            }
            if(!(s1.equals("21BCE228")) && !(s2.equals("2004")))
            {
                add(l4);
                l4.setVisible(true);
            }
        }
    }
    public static void main(String args[])
    {
        login3 l2 =new login3();
    }
}

class OnlineTest extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton btnNext, btnBookmark;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    // create jFrame with radioButton and JButton
    OnlineTest(String s) {
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        btnNext = new JButton("Next");
        btnBookmark = new JButton("Bookmark");
        btnNext.addActionListener(this);
        btnBookmark.addActionListener(this);
        add(btnNext);
        add(btnBookmark);
        set();
        label.setBounds(30, 40, 450, 20);
        //radioButton[0].setBounds(50, 80, 200, 20);
        radioButton[0].setBounds(50, 80, 450, 20);
        radioButton[1].setBounds(50, 110, 450, 20);
        radioButton[2].setBounds(50, 140, 450, 20);
        radioButton[3].setBounds(50, 170, 500, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnBookmark.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    // handle all actions based on event
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            //if (check())
            count += check();
            current++;
            set();
//            if (current == 0) {
//                btnNext.setText("Start Test");
//                btnBookmark.setText("Result");
//            }
            if (current == 10) {
                btnNext.setEnabled(false);
                btnBookmark.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
//            if (current == 0) {
//                btnNext.setText("Start Test");
//                btnBookmark.setText("Result");
//            }
            if (current == 10)
                btnBookmark.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                //if (check())
                count += check();
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            //if (check())
            count += check();
            current++;
            JOptionPane.showMessageDialog(this, "Total Marks Are = " + count);
            System.exit(0);
        }
    }

    // SET Questions with options
    void set() {
        radioButton[4].setSelected(true);

        if (current == 0) {
            label.setText("Que1:  What is true about a break?");
            radioButton[0].setText("Break stops the execution of entire program");
            radioButton[1].setText("Break halts the execution of the loop for certain time frame");
            radioButton[2].setText("Break halts the execution and forces the control out of the loop");
            radioButton[3].setText("Break forces the control out of the loop and starts the execution of next iteration");
        }
        if (current == 1) {
            label.setText("Que2:  Which feature of java 7 allows to not explicitly close IO resource?");
            radioButton[0].setText("try catch finally");
            radioButton[1].setText("IOException");
            radioButton[2].setText("AutoCloseable");
            radioButton[3].setText("Streams");
        }
        if (current == 2) {
            label.setText("Que3: SessionFactory is a thread-safe object.");
            radioButton[0].setText("true");
            radioButton[1].setText("false");
            radioButton[2].setText("don't know");
            radioButton[3].setText("false");
        }
        if (current == 3) {
            label.setText("Que4: Which is the new method introduced in java 8 to iterate over a collection?");
            radioButton[0].setText("for (String i : StringList)");
            radioButton[1].setText("foreach (String i : StringList)");
            radioButton[2].setText("StringList.forEach()");
            radioButton[3].setText("List.for()");
        }
        if (current == 4) {
            label.setText("Que5:  What is the substitute of Rhino javascript engine in Java 8?");
            radioButton[0].setText(" Nashorn");
            radioButton[1].setText("V8");
            radioButton[2].setText("Inscript");
            radioButton[3].setText("Narcissus");
        }
        if (current == 5) {
            label.setText("Que6: How to read entire file in one line using java 8?");
            radioButton[0].setText("Files.readAllLines()");
            radioButton[1].setText("Files.read()");
            radioButton[2].setText("Files.readFile()");
            radioButton[3].setText("Files.lines()");
        }
        if (current == 6) {
            label.setText("Que7:  Which feature of java 7 allows to not explicitly close IO resource?");
            radioButton[0].setText("try catch finally");
            radioButton[1].setText("IOException");
            radioButton[2].setText("AutoCloseable");
            radioButton[3].setText("Streams");
        }
        if (current == 7) {
            label.setText("Que8:  Which of the following is not a core interface of Hibernate?");
            radioButton[0].setText("Configuration");
            radioButton[1].setText("Criteria");
            radioButton[2].setText("SessionManagement");
            radioButton[3].setText("Session");
        }
        if (current == 8) {
            label.setText("Que9: SessionFactory is a thread-safe object.");
            radioButton[0].setText("true");
            radioButton[1].setText("false");
            radioButton[2].setText("don't know");
            radioButton[3].setText("false");
        }
        if (current == 9) {
            label.setText("Que10: Which of the following is not a state of object in Hibernate?");
            radioButton[0].setText("Attached()");
            radioButton[1].setText("Detached()");
            radioButton[2].setText("Persistent()");
            radioButton[3].setText("Transient()");
        }
        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            radioButton[j].setBounds(50, 80 + i, 200, 20);
    }

    // declare right answers.
    int check() {
        if (current == 0)
            return (radioButton[2].isSelected()?4:radioButton[0].isSelected()?-1:radioButton[1].isSelected()?-1:radioButton[3].isSelected()?-1:0);
        if (current == 1)
            return (radioButton[1].isSelected()?4:radioButton[0].isSelected()?-1:radioButton[2].isSelected()?-1:radioButton[3].isSelected()?-1:0);
        if (current == 2)
            return (radioButton[0].isSelected()?4:radioButton[2].isSelected()?-1:radioButton[1].isSelected()?-1:radioButton[3].isSelected()?-1:0);
        if (current == 3)
            return (radioButton[2].isSelected()?4:radioButton[0].isSelected()?-1:radioButton[1].isSelected()?-1:radioButton[3].isSelected()?-1:0);
        if (current == 4)
            return (radioButton[0].isSelected()?4:radioButton[2].isSelected()?-1:radioButton[1].isSelected()?-1:radioButton[3].isSelected()?-1:0);
        if (current == 5)
            return (radioButton[0].isSelected()?4:radioButton[2].isSelected()?-1:radioButton[1].isSelected()?-1:radioButton[3].isSelected()?-1:0);
        if (current == 6)
            return (radioButton[1].isSelected()?4:radioButton[0].isSelected()?-1:radioButton[2].isSelected()?-1:radioButton[3].isSelected()?-1:0);
        if (current == 7)
            return (radioButton[2].isSelected()?4:radioButton[0].isSelected()?-1:radioButton[1].isSelected()?-1:radioButton[3].isSelected()?-1:0);
        if (current == 8)
            return (radioButton[0].isSelected()?4:radioButton[2].isSelected()?-1:radioButton[1].isSelected()?-1:radioButton[3].isSelected()?-1:0);
        if (current == 9)
            return (radioButton[0].isSelected()?4:radioButton[2].isSelected()?-1:radioButton[1].isSelected()?-1:radioButton[3].isSelected()?-1:0);
        return 0;
    }

    public static void main(String s[]) {
        new OnlineTest("Online Test App");
    }

}