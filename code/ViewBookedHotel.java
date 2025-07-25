
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener{ 
    JButton back;
    JLabel lblID,lblno,lblsecPack,lbltotPer,lblDays,lbltotPrice,lblphone,lblchoice,lblfood;
    String username;
    ViewBookedHotel(String username){
        this.username = username;
        setBounds(450,200,1200,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         
        JLabel name = new JLabel("Welcome : "+username);
        name.setBounds(200,40,200,70);
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
        
        JLabel selecPack = new JLabel("Selected Hotel : ");
        selecPack.setBounds(30,160,170,70);
        selecPack.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        selecPack.setForeground(Color.BLACK);
        add(selecPack);
        
        lblsecPack = new JLabel();
        lblsecPack.setBounds(210,160,150,70);
        lblsecPack.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lblsecPack);
        
        JLabel totPer = new JLabel("Total Person : ");
        totPer.setBounds(30,200,150,70);
        totPer.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        totPer.setForeground(Color.BLACK);
        add(totPer);
        
        lbltotPer = new JLabel();
        lbltotPer.setBounds(210,200,150,70);
        lbltotPer.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lbltotPer);
        
        JLabel noDays = new JLabel("No. of Days : ");
        noDays.setBounds(30,240,150,70);
        noDays.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        noDays.setForeground(Color.BLACK);
        add(noDays);
        
        lblDays = new JLabel();
        lblDays.setBounds(210,240,150,70);
        lblDays.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lblDays);
        
        JLabel totPrice = new JLabel("Total Price : ");
        totPrice.setBounds(30,280,150,70);
        totPrice.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        totPrice.setForeground(Color.BLACK);
        add(totPrice);
        
        lbltotPrice = new JLabel();
        lbltotPrice.setBounds(210,280,250,70);
        lbltotPrice.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lbltotPrice);
        
        JLabel phoneno = new JLabel("Phone No. : ");
        phoneno.setBounds(30,320,100,70);
        phoneno.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        phoneno.setForeground(Color.BLACK);
        add(phoneno);
        
        lblphone = new JLabel();
        lblphone.setBounds(210,320,150,70);
        lblphone.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lblphone);
        
        JLabel choice = new JLabel("AC / Non-AC : ");
        choice.setBounds(30,360,150,70);
        choice.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        choice.setForeground(Color.BLACK);
        add(choice);
        
        lblchoice = new JLabel();
        lblchoice.setBounds(210,360,150,70);
        lblchoice.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lblchoice);
        
        JLabel food = new JLabel("Food Included : ");
        food.setBounds(30,400,150,70);
        food.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        food.setForeground(Color.BLACK);
        add(food);
        
        lblfood = new JLabel();
        lblfood.setBounds(210,400,150,70);
        lblfood.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lblfood);
        
        back = new JButton("Back");
        back.setBounds(300, 500,80, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel8.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image2 = new JLabel(i3);
        image2.setBounds(650,0,600,650);
        add(image2);
        
           
        try{
           Conn c = new Conn();
           ResultSet rs=c.s.executeQuery("Select * from bookhotel where username ='"+username+"'");
           while(rs.next()){
               lblID.setText(rs.getString("id"));
               lblno.setText(rs.getString("number"));
               lblsecPack.setText(rs.getString("selectedHotel"));
               lbltotPer.setText(rs.getString("totalPerson"));
               lbltotPrice.setText(rs.getString("totalPrice"));
               lblphone.setText(rs.getString("phone"));
               lblDays.setText(rs.getString("daysNo"));
               lblchoice.setText(rs.getString("acORnonAC"));
               lblfood.setText(rs.getString("food"));
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
        new ViewBookedHotel("");
    }
 
}
 