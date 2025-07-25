package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;



public class Login extends JFrame implements ActionListener{
    
    JButton password,signup,login;
    JTextField txtusername,txtpassword;
    
    Login(){
      setLocation(400,400);
      setSize(900,400);
      setLayout(null);
      
      getContentPane().setBackground(Color.WHITE);
      
      JPanel p1 = new JPanel();
      p1.setBackground(new Color(132,49,189));
      p1.setLayout(null);
      p1.setBounds(0,0,400,400);
      add(p1);
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
      Image i2 = i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(0,-5,400, 400);
      p1.add(image);

      
      JPanel p2 = new JPanel();
      p2.setLayout(null);
      p2.setBounds(400, 30, 450, 300);
      add(p2);
      
      JLabel lblusername = new JLabel("Username");
      lblusername.setBounds(60,20,100,25);
      lblusername.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
      p2.add(lblusername);


      txtusername = new JTextField();
      txtusername.setBounds(60, 60, 300, 30);
      txtusername.setBorder(BorderFactory.createEmptyBorder());
      p2.add(txtusername);
      
      JLabel lblpassword = new JLabel("Password");
      lblpassword.setBounds(60,100,100,25);
      lblpassword.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
      p2.add(lblpassword);


      txtpassword = new JTextField();
      txtpassword.setBounds(60, 130, 300,30);
      txtpassword.setBorder(BorderFactory.createEmptyBorder());
      p2.add(txtpassword);
      
      login = new JButton("Login");
      login.setBounds(60,200,100,30);
      login.setBackground(new Color(132,49,189));
      login.setBorder(new LineBorder(new Color(132,49,189)));
      login.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
      login.setForeground(Color.WHITE);
      login.addActionListener(this);
      p2.add(login);
      
      signup = new JButton("SignUp");
      signup.setBounds(230,200,130,30);
      signup.setBackground(new Color(132,49,189));
      signup.setBorder(new LineBorder(new Color(132,49,189)));
      signup.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
      signup.setForeground(Color.WHITE);
      signup.addActionListener(this);
      p2.add(signup);
      
      password = new JButton("Forget Password");
      password.setBounds(130,250,140,30);
      password.setBackground(new Color(132,49,189));
      password.setBorder(new LineBorder(new Color(132,49,189)));
      password.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
      password.setForeground(Color.WHITE);
      password.addActionListener(this);
      p2.add(password);
      
      setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==login){
            try{
                String username = txtusername.getText();
                String pass = txtpassword.getText();
                
                String query = "select * from account where username = '"+username+"' AND password = '"+pass+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next())//returns true or false
                {
                    setVisible(false);                    
                    new Loading(username);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Login Credentials...");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();
        }
        else if(ae.getSource()==password){
             setVisible(false);
            new ForgetPassword();
        }
            
    }
    
    public static void main(String[] args){
        new Login();
    }
}
