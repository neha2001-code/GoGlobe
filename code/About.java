package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    JButton back;
    String username;
    About(String username){
        this.username = username;
        setBounds(600,200,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(200,10,100,40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);
        
        String s = "This system is designed to streamline travel bookings, allowing users to explore and book tour packages, view hotel details, and securely make payments.\n" +
"\n" +
"This application is ideal for users who want to:\n" +
"\n" +
"Explore destinations and hotel packages\n" +
"\n" +
"Register and log in with credentials\n" +
"\n" +
"View personalized travel information\n" +
"\n" +
"Book hotels and packages\n" +
"\n" +
"Complete payment securely\n";
        
        TextArea area = new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);
        
        back = new JButton("Back");
        back.setBounds(150,450,150,30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
                new Dashboard(username);
                setVisible(false);
        }
    
    public static void main(String[] args){
        new About("");
    }
}
