
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener{ 
    JButton back;
    JLabel lblID,lblno,lblsecPack,lbltotPer,lbltotPrice,lblphone;
    String username;
    ViewPackage(String username){
        this.username = username;
        setBounds(450,180,870,800);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         
        JLabel name = new JLabel("Welcome : "+username);
        name.setBounds(300,40,150,70);
        name.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        name.setForeground(Color.BLACK);
        add(name);
        
        JLabel id = new JLabel("ID : ");
        id.setBounds(30,80,150,70);
        id.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        id.setForeground(Color.BLACK);
        add(id);
        
        lblID = new JLabel();
        lblID.setBounds(210,80,150,70);
        lblID.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lblID);
        
        JLabel idno = new JLabel("ID No. : ");
        idno.setBounds(30,120,150,70);
        idno.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        idno.setForeground(Color.BLACK);
        add(idno);
        
        lblno = new JLabel();
        lblno.setBounds(210,120,150,70);
        lblno.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lblno);
        
        JLabel selecPack = new JLabel("Selected Package : ");
        selecPack.setBounds(30,160,170,70);
        selecPack.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        selecPack.setForeground(Color.BLACK);
        add(selecPack);
        
        lblsecPack = new JLabel();
        lblsecPack.setBounds(210,160,150,70);
        lblsecPack.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lblsecPack);
        
        JLabel totPer = new JLabel("Total Person : ");
        totPer.setBounds(500,80,150,70);
        totPer.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        totPer.setForeground(Color.BLACK);
        add(totPer);
        
        lbltotPer = new JLabel();
        lbltotPer.setBounds(700,80,150,70);
        lbltotPer.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lbltotPer);
        
        JLabel totPrice = new JLabel("Total Price : ");
        totPrice.setBounds(500,120,150,70);
        totPrice.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        totPrice.setForeground(Color.BLACK);
        add(totPrice);
        
        lbltotPrice = new JLabel();
        lbltotPrice.setBounds(700,120,250,70);
        lbltotPrice.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lbltotPrice);
        
        JLabel phoneno = new JLabel("Phone No. : ");
        phoneno.setBounds(500,160,100,70);
        phoneno.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        phoneno.setForeground(Color.BLACK);
        add(phoneno);
        
        lblphone = new JLabel();
        lblphone.setBounds(700,160,150,70);
        lblphone.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lblphone);
        
        back = new JButton("Back");
        back.setBounds(300, 250,80, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewPack.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1024,512,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image2 = new JLabel(i3);
        image2.setBounds(0,300,1024,512);
        add(image2);
        
           
        try{
           Conn c = new Conn();
           ResultSet rs=c.s.executeQuery("Select * from bookpackage where username ='"+username+"'");
           while(rs.next()){
               lblID.setText(rs.getString("id"));
               lblno.setText(rs.getString("number"));
               lblsecPack.setText(rs.getString("selectedPackage"));
               lbltotPer.setText(rs.getString("totalPerson"));
               lbltotPrice.setText(rs.getString("totalPrice"));
               lblphone.setText(rs.getString("phone"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    
     @Override
        public void actionPerformed(ActionEvent ae){
                new Dashboard(username);
                setVisible(false);
        }
        public static void main(String args[]){
        new ViewPackage("");
    }
 
}
 