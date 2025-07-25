package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame  implements ActionListener{
    
    JButton create,back;
    JTextField txtusername,txtname,txtpass,secAns  ;
    Choice security;
    
    Signup(){
        setBounds(500,200,950,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(148, 119, 232) );
        p1.setBounds(10,10,500,300);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Robot Slab",Font.BOLD,16));
        lblusername.setBounds(50,20,300,25);
        p1.add(lblusername);
        
        txtusername = new JTextField();
        txtusername.setBounds(190, 20,250, 25);
        txtusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtusername);
        
        
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Robot Slab",Font.BOLD,16));
        name.setBounds(50,60,125,25);
        p1.add(name);
        
        txtname = new JTextField();
        txtname.setBounds(190,60,250,25);
        txtname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtname);
        
        JLabel password = new JLabel("Password");
        password.setFont(new Font("Robot Slab",Font.BOLD,16));
        password.setBounds(50,100,125,25);
        p1.add(password);
        
        txtpass = new JTextField();
        txtpass.setBounds(190,100,250,25);
        txtpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtpass);
        
        
        JLabel lblsec = new JLabel("Security Question");
        lblsec.setFont(new Font("Robot Slab",Font.BOLD,16));
        lblsec.setBounds(50,140,125,25);
        p1.add(lblsec);
        
        security = new Choice();
        security.add("Nick Name");
        security.add("Favourite Food");
        security.add("Pet Name");
        security.add("Nursury School Name");
        security.setBounds(190,140,250,28);
        //security.setBorder(BorderFactory.createEmptyBorder());
        p1.add(security);
        
        JLabel answer = new JLabel("Answer");
        answer.setFont(new Font("Robot Slab",Font.BOLD,16));
        answer.setBounds(50,180,125,25);
        p1.add(answer);
        
        secAns = new JTextField();
        secAns.setBounds(190,180,250,25);
        secAns.setBorder(BorderFactory.createEmptyBorder());
        p1.add(secAns);
        
        create = new JButton("Create");
        create.setBackground(Color.white);
        create.setFont(new Font("Robot Slab",Font.BOLD,16));
        create.setForeground(new Color(148, 119, 232));
        create.setBounds(50,240,100,35);
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setFont(new Font("Robot Slab",Font.BOLD,16));
        back.setForeground(new Color(142, 86, 194 ));
        back.setBounds(300,240,100,35);
        back.addActionListener(this);
        p1.add(back);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(530,10,400,300);
        add(image);
        
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == create){
            
            String username = txtusername.getText();
            String name = txtname.getText();
            String password = txtpass.getText();
            String question = security.getSelectedItem();
            String secuAns = secAns.getText();
            
            //DML COmmand
            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+secuAns+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Account Created Successfully!");
                setVisible(false);
                new Login();
                
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
        new Signup();
    }
}
