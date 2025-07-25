package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {
    
    JTextField totalPerson;
    JComboBox comboid;
    JLabel lbluser,selectPack,totPer,id,number,phone,totPrice,totalPrice,lblusername,idno,num,phoneNumber;
    JButton checkPrice,bookPackage,back;
    String username;
    
    BookPackage(String username){
        this.username = username;
        setBounds(450,200,1100,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel bp = new JLabel("BOOK PACKAGE  ");
        bp.setBounds(30,10,200,30);
        bp.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        bp.setForeground(Color.BLACK);
        add(bp);
        
        lbluser = new JLabel("Username : ");
        lbluser.setBounds(30,70,150,20);
        lbluser.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        lbluser.setForeground(Color.BLACK);
        add(lbluser);
        
        lblusername = new JLabel();
        lblusername.setBounds(250,70,200,25);
        lblusername.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        lblusername.setForeground(Color.BLACK);
        add(lblusername);
        
        selectPack = new JLabel("Select Package : ");
        selectPack.setBounds(30,110,150,20);
        selectPack.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        selectPack.setForeground(Color.BLACK);
        add(selectPack);
        
        comboid  = new JComboBox(new String[]{"Gold","Silver","Bronze"});
        comboid.setBounds(200,110,200,20);
        comboid.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        comboid.setForeground(Color.BLACK);
        add(comboid);
        
        totPer = new JLabel("Total Person : ");
        totPer.setBounds(30,150,150,20);
        totPer.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        totPer.setForeground(Color.BLACK);
        add(totPer);
        
        totalPerson = new JTextField();
        totalPerson.setBounds(200,150,200,25);
        totalPerson.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        totalPerson.setForeground(Color.BLACK);
        add(totalPerson);
        
        id = new JLabel(" ID : ");
        id.setBounds(30,190,150,20);
        id.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        id.setForeground(Color.BLACK);
        add(id);
        
        idno = new JLabel();
        idno.setBounds(200,190,200,25);
        idno.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        idno.setForeground(Color.BLACK);
        add(idno);
        
        number = new JLabel("Number : ");
        number.setBounds(30,230,150,20);
        number.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        number.setForeground(Color.BLACK);
        add(number);
        
        num = new JLabel();
        num.setBounds(200,230,200,25);
        num.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        num.setForeground(Color.BLACK);
        add(num);
        
        phone = new JLabel("Phone No. : ");
        phone.setBounds(30,270,150,20);
        phone.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        phone.setForeground(Color.BLACK);
        add(phone);
        
        phoneNumber = new JLabel();
        phoneNumber.setBounds(200,270,200,25);
        phoneNumber.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        phoneNumber.setForeground(Color.BLACK);
        add(phoneNumber);
        
        totPrice = new JLabel("Total Price: ");
        totPrice.setBounds(30,310,150,20);
        totPrice.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        totPrice.setForeground(Color.BLACK);
        add(totPrice);
        
        totalPrice = new JLabel();
        totalPrice.setBounds(200,310,200,25);
        totalPrice.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        totalPrice.setForeground(Color.BLACK);
        add(totalPrice);
        
        checkPrice = new JButton(" Check Price  ");
        checkPrice.setBounds(30,400,140,30);
        checkPrice.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        checkPrice.setForeground(Color.BLACK);
        checkPrice.addActionListener(this);
        add(checkPrice);
        
        bookPackage = new JButton(" Book Package  ");
        bookPackage.setBounds(200,400,160,30);
        bookPackage.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        bookPackage.setForeground(Color.BLACK);
        bookPackage.addActionListener(this);
        add(bookPackage);
        
        back = new JButton("  Back  ");
        back.setBounds(100,450,160,30);
        back.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookPackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 530,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(590,0,500,530);
        add(image);
              
        try{
           Conn c = new Conn();
           ResultSet rs=c.s.executeQuery("Select * from customer where username ='"+username+"'");
           while(rs.next()){
               idno.setText(rs.getString("id"));
               num.setText(rs.getString("number"));
               lblusername.setText(rs.getString("username"));
               phoneNumber.setText(rs.getString("phone"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);  
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkPrice){
            String pack = (String)comboid.getSelectedItem();
            int cost = 0;
            if(pack=="Gold"){
                cost+=32000;
            }
            else if(pack=="Silver"){
                cost+=24000;
            }
            else if(pack=="Bronze"){
                cost+=12000;
            }
            
            int person = Integer.parseInt(totalPerson.getText());
            cost = person*cost;
            totalPrice.setText(("Rs "+cost));
          }
        else if(ae.getSource()==bookPackage){
           
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+lblusername.getText()+"', '"+(String)comboid.getSelectedItem()+"','"+totalPerson.getText()+"','"+idno.getText()+"','"+num.getText()+"','"+phoneNumber.getText()+"','"+totalPrice.getText().replaceAll("[^0-9]", "")+"')");
                JOptionPane.showMessageDialog(null,"Booking is Done !!! See you soon");
                setVisible(true);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==back){
            new Dashboard(username);
            setVisible(false);
        }
        
        
    }
    
    public static void main(String[] args){
        new BookPackage("");
    }
}
