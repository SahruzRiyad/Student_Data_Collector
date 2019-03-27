import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.beans.EventHandler;

public class StudentData extends JFrame {
    JTextField name = new JTextField();
    JTextField id = new JTextField();
    JButton submit,cancel;
    JLabel lbl_name = new JLabel("Student Name");
    JLabel lbl_father = new JLabel("Father's Name");
    JLabel lbl_mother = new JLabel("Mother's Name");
    JLabel lbl_gender = new JLabel("Gender");
    JLabel lbl_nation = new JLabel("Nationality");
    JLabel lbl_email = new JLabel("Email");
    JLabel lbl_phone = new JLabel("Phone");
    JLabel lbl_address = new JLabel("Address");
    JTextField father = new JTextField();
    JTextField mother = new JTextField();
    JTextField email = new JTextField();
    JTextField phone = new JTextField();
    JTextArea address = new JTextArea();
    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    JRadioButton others = new JRadioButton("Others");
    JLabel lbl_bd = new JLabel("Date of Birth");
    JTextField bd = new JTextField("DD/MM/YY");
    JTextField nation = new JTextField();

    ButtonGroup grp = new ButtonGroup();
    Container cnt = new Container();
    Font fnt = new Font("Arial",Font.PLAIN,20);
    Font fnt1 = new Font("Arial",Font.BOLD,18);
    StudentData(){
        cnt = this.getContentPane();
        make_frame();
        add_button();
        set_component();
        set_phone();
        set_action();

    }
    void make_frame(){
       // int frameWidth = 1100,frameHeight = 800;
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(true);
        this.setTitle("STUDENT INFORMATION");
        this.setBounds(210,10,1100,800);
        cnt.setBackground(Color.BLACK);
        name.setFont(fnt1);mother.setFont(fnt1);father.setFont(fnt1);
        email.setFont(fnt1);phone.setFont(fnt1);address.setFont(fnt1);

    }
    void set_component(){
        lbl_name.setBounds(50,10,150,100);
        lbl_father.setBounds(50,70,150,100);
        lbl_mother.setBounds(50,130,150,100);
        lbl_bd.setBounds(50,250,150,100);
        lbl_gender.setBounds(50,190,150,100);
        lbl_nation.setBounds(50,310,150,100);
        lbl_email.setBounds(50,370,150,100);
        lbl_phone.setBounds(50,430,150,100);
        lbl_address.setBounds(50,490,150,100);
        male.setBounds(200,220,100,30);
        female.setBounds(320,220,100,30);
        others.setBounds(440,220,100,30);
        male.setFont(fnt1);female.setFont(fnt1);others.setFont(fnt1);
        grp.add(male);grp.add(female);grp.add(others);
        name.setBounds(200,40,500,40);
        father.setBounds(200,100,500,40);
        mother.setBounds(200,160,500,40);
        bd.setBounds(200,280,500,40);
        nation.setBounds(200,340,500,40);
        email.setBounds(200,400,500,40);
        phone.setBounds(200,460,500,40);
        address.setBounds(200,520,500,100);
        bd.setFont(fnt1);
        bd.addFocusListener(new FocusListener() {
            @Override public void focusLost(final FocusEvent pE) {}
            @Override public void focusGained(final FocusEvent pE) {
                bd.setText("");

            }
        });
        lbl_name.setFont(fnt);lbl_father.setFont(fnt);lbl_mother.setFont(fnt);lbl_gender.setFont(fnt);nation.setFont(fnt1);
        lbl_bd.setFont(fnt);lbl_nation.setFont(fnt);lbl_email.setFont(fnt);lbl_phone.setFont(fnt);lbl_address.setFont(fnt);
        lbl_mother.setForeground(Color.white);lbl_father.setForeground(Color.white);lbl_name.setForeground(Color.white);
        lbl_bd.setForeground(Color.white);lbl_nation.setForeground(Color.white);lbl_email.setForeground(Color.white);
        lbl_gender.setForeground(Color.white);lbl_phone.setForeground(Color.white);lbl_address.setForeground(Color.white);
        cnt.add(lbl_name);cnt.add(name);cnt.add(lbl_father);cnt.add(father);cnt.add(bd);cnt.add(nation);cnt.add(email);
        cnt.add(phone);cnt.add(address);
        cnt.add(lbl_mother);cnt.add(mother);cnt.add(lbl_gender);cnt.add(male);cnt.add(lbl_bd);cnt.add(lbl_nation);
        cnt.add(female);cnt.add(others);cnt.add(lbl_email);cnt.add(lbl_phone);cnt.add(lbl_address);


    }
    void set_phone(){
        phone.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
               if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    Toolkit tk = Toolkit.getDefaultToolkit();
                    tk.beep();
                    e.consume();
                }
            }
        });
    }
    void add_button(){
        submit = new JButton("Submit");
        cancel = new JButton("Cancel");
        submit.setBounds(300,650,150,40);
        cancel.setBounds(500,650,150,40);
        submit.setFont(fnt1);cancel.setFont(fnt1);
        cnt.add(submit);cnt.add(cancel);
    }
    void set_action(){
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.getText().equals("") ||father.getText().equals("") ||mother.getText().equals("") ||nation.getText().equals("") ||address.getText().equals("") ||
                        email.getText().equals("") ||phone.getText().equals("") ||bd.getText().equals("") || !(male.isSelected() || female.isSelected() ||
                        others.isSelected()) ){
                    JOptionPane.showMessageDialog(null,"Please Fill The Blank Field");
                }
                else{
                    String s ;
                        if(male.isSelected()){
                            s = "male";
                        }
                        else{
                            s = "female";
                        }
                        try {
                            File file = new File("D:\\JavaProgramming\\Java Lab Work\\Student_Information.txt");
                            FileWriter fw = new FileWriter(file);
                            fw.write("Name: ");fw.append(name.getText());fw.write(System.getProperty("line.separator"));
                            fw.write("Father's Name: ");fw.append(father.getText());fw.write(System.getProperty("line.separator"));
                            fw.write("Mother's Name: ");fw.append(mother.getText());fw.write(System.getProperty("line.separator"));
                            fw.write("Gender: ");fw.append(s);fw.write(System.getProperty("line.separator"));
                            fw.write("Date of Birth: ");fw.append(bd.getText());fw.write(System.getProperty("line.separator"));
                            fw.write("Email: ");fw.append(email.getText());fw.write(System.getProperty("line.separator"));
                            fw.write("Phone: ");fw.append(phone.getText());fw.write(System.getProperty("line.separator"));
                            fw.write("Address: ");fw.append(address.getText());fw.write(System.getProperty("line.separator"));

                            fw.close();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Exception :" + ex);
                        }
                        JOptionPane.showMessageDialog(null,"Successfully Submitted","Accept",JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {

        StudentData std = new StudentData();
    }
}
