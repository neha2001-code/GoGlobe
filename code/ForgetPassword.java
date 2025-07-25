 package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 
public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField txtusername,txtname,txtquestion,txtanswer,txtpassword;
    JButton search,retrieve,back;
    
    ForgetPassword(){
        setBounds(350,200,1000,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgetpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(540,30,500,300);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 600, 300);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,40,100,25);
        lblusername.setFont(new Font("Robot Slab",Font.BOLD,14));
        p1.add(lblusername);
        
        txtusername = new JTextField();
        txtusername.setBounds(250,40,150,25);
        p1.add(txtusername);
        
        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.white);
        search.setBounds(450,40,80,25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel name = new JLabel("Name");
        name.setBounds(30,80,100,25);
        name.setFont(new Font("Robot Slab",Font.BOLD,14));
        p1.add(name);
        
        txtname = new JTextField();
        txtname.setBounds(250,80,150,25);
        p1.add(txtname);
        
        
        JLabel secQues = new JLabel("Security Question");
        secQues.setBounds(30,120,150,25);
        secQues.setFont(new Font("Robot Slab",Font.BOLD,14));
        p1.add(secQues);
        
        txtquestion = new JTextField();
        txtquestion.setBounds(250,120,150,25);
        p1.add(txtquestion);
       
        
        JLabel ans = new JLabel("Answer");
        ans.setBounds(30,160,100,25);
        ans.setFont(new Font("Robot Slab",Font.BOLD,14));
        p1.add(ans);
        
        txtanswer = new JTextField();
        txtanswer.setBounds(250,160,150,25);
        p1.add(txtanswer);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.white);
        retrieve.setBounds(450,160,90,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel lblPassword = new JLabel(" Password");
        lblPassword.setBounds(30,200,100,25);
        lblPassword.setFont(new Font("Robot Slab",Font.BOLD,14));
        p1.add(lblPassword);
        
        txtpassword = new JTextField();
        txtpassword.setBounds(250,200,150,25);
        p1.add(txtpassword);
        
        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.white);
        back.setBounds(200,240,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){            
            //DML COmmand            
            try{
                String query = "select * from account where username = '"+txtusername.getText()+"' ";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                JOptionPane.showMessageDialog(null, "Account Found");
                while(rs.next())
                {
                   txtname.setText(rs.getString("name"));
                   txtquestion.setText(rs.getString("security"));

                }   
            }
            catch(Exception e){
               e.printStackTrace();
            }
        }
        else if(ae.getSource() == retrieve){
             try{
                String query = "select * from account where answer = '"+txtanswer.getText()+"' AND username = '"+txtusername.getText()+"' ";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
               
                while(rs.next())
                {
                   txtpassword.setText(rs.getString("password"));
                }   
            }
            catch(Exception e){
               e.printStackTrace();
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
        
    }

    public static void main(String[] args){
        new ForgetPassword();
    }
}

