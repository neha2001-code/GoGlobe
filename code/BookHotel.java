package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {
    
    JTextField totalPerson, totalDays;
    JComboBox comboid, comboFood, comboChoice;
    JLabel lbluser,selectPack,totPer,id,number,phone,totPrice,totalPrice,lblusername,idno,num,phoneNumber,totDay,lblAC,lblFood;
    JButton checkPrice,bookPackage,back;
    String username;
    
    BookHotel(String username){
        this.username = username;
        setBounds(450,200,1200,650);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel bp = new JLabel("BOOK HOTEL ");
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
        lblusername.setBounds(200,70,200,25);
        lblusername.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        lblusername.setForeground(Color.BLACK);
        add(lblusername);
        
        selectPack = new JLabel("Select Hotel: ");
        selectPack.setBounds(30,110,150,20);
        selectPack.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        selectPack.setForeground(Color.BLACK);
        add(selectPack);
        
        comboid  = new JComboBox(new String[]{"JW Marriott Hotel","Madarian Oriental Hotel","The Taj Hotel","Four Season Hotel","Raddisson Blue Hotel","Classio Hotel","Breeze Blow Hotel","River View Hotel","Diamond Plaza Hotel","The Sparkle Hotel"});
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
        
        
        totDay = new JLabel("No. of Days : ");
        totDay.setBounds(30,190,150,20);
        totDay.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        totDay.setForeground(Color.BLACK);
        add(totDay);
        
        totalDays = new JTextField();
        totalDays.setBounds(200,190,200,25);
        totalDays.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        totalDays.setForeground(Color.BLACK);
        add(totalDays);
        
        id = new JLabel(" ID : ");
        id.setBounds(30,230,150,20);
        id.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        id.setForeground(Color.BLACK);
        add(id);
        
        idno = new JLabel();
        idno.setBounds(200,230,200,25);
        idno.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        idno.setForeground(Color.BLACK);
        add(idno);
        
        number = new JLabel("Number : ");
        number.setBounds(30,270,150,20);
        number.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        number.setForeground(Color.BLACK);
        add(number);
        
        num = new JLabel();
        num.setBounds(200,270,200,25);
        num.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        num.setForeground(Color.BLACK);
        add(num);
        
        phone = new JLabel("Phone No. : ");
        phone.setBounds(30,310,150,20);
        phone.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        phone.setForeground(Color.BLACK);
        add(phone);
        
        phoneNumber = new JLabel();
        phoneNumber.setBounds(200,310,200,25);
        phoneNumber.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        phoneNumber.setForeground(Color.BLACK);
        add(phoneNumber);
        
        lblAC = new JLabel("AC / Non-AC : ");
        lblAC.setBounds(30,350,150,20);
        lblAC.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        lblAC.setForeground(Color.BLACK);
        add(lblAC);
        
        comboChoice  = new JComboBox(new String[]{"AC", "Non-AC"});
        comboChoice.setBounds(200,350,200,20);
        comboChoice.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        comboChoice.setForeground(Color.BLACK);
        add(comboChoice);
        
        lblFood = new JLabel("Food Included : ");
        lblFood.setBounds(30,390,150,20);
        lblFood.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        lblFood.setForeground(Color.BLACK);
        add(lblFood);
        
        comboFood  = new JComboBox(new String[]{"Yes", "No"});
        comboFood.setBounds(200,390,200,20);
        comboFood.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        comboFood.setForeground(Color.BLACK);
        add(comboFood);
        
        totPrice = new JLabel("Total Price: ");
        totPrice.setBounds(30,430,150,20);
        totPrice.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        totPrice.setForeground(Color.BLACK);
        add(totPrice);
        
        totalPrice = new JLabel();
        totalPrice.setBounds(200,430,200,25);
        totalPrice.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        totalPrice.setForeground(Color.BLACK);
        add(totalPrice);
        
        checkPrice = new JButton(" Check Price  ");
        checkPrice.setBounds(30,500,140,30);
        checkPrice.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        checkPrice.setForeground(Color.BLACK);
        checkPrice.addActionListener(this);
        add(checkPrice);
        
        bookPackage = new JButton(" Book Package  ");
        bookPackage.setBounds(200,500,160,30);
        bookPackage.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        bookPackage.setForeground(Color.BLACK);
        bookPackage.addActionListener(this);
        add(bookPackage);
        
        back = new JButton("  Back  ");
        back.setBounds(390,500,160,30);
        back.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,18));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel4.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(650,0,600,650);
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
            String ac = (String)comboChoice.getSelectedItem();
            String food = (String)comboFood.getSelectedItem();

            int cost = 0;
            
            String[] hotel = {"JW Marriott Hotel","Madarian Oriental Hotel","The Taj Hotel","Four Season Hotel","Raddisson Blue Hotel","Classio Hotel","Breeze Blow Hotel","River View Hotel","Diamond Plaza Hotel","The Sparkle Hotel"};
            int[] price = {1200,
            1300,
            1400,
            1500,
            1600,
            1700,
            1800,
            1900,
            2000,
            2100
            };
            /*if(pack=="Gold"){
                cost+=32000;
            }
            else if(pack=="Silver"){
                cost+=24000;
            }
            else if(pack=="Bronze"){
                cost+=12000;
            }*/
            for(int i =0;i<=9;i++){
                if(pack == hotel[i])
                    cost = price[i];
            }
            int person = Integer.parseInt(totalPerson.getText());
            int days = Integer.parseInt(totalDays.getText());
            cost = person*cost*days;
            if(ac=="AC"){
                cost = cost+1000;
            }
            if(food=="Yes"){
                cost = cost +1200;
            }
            totalPrice.setText(("Rs "+cost));
          }
        else if(ae.getSource()==bookPackage){
           
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+lblusername.getText()+"', '"+(String)comboid.getSelectedItem()+"','"+totalPerson.getText()+"','"+totalDays.getText()+"','"+idno.getText()+"','"+num.getText()+"','"+phoneNumber.getText()+"','"+(String)comboChoice.getSelectedItem()+"','"+(String)comboFood.getSelectedItem()+"','"+totalPrice.getText().replaceAll("[^0-9]", "")+"')");
                JOptionPane.showMessageDialog(null,"Booking is Done !!! See you soon");
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==back){
            new Dashboard("");
            setVisible(false);
        }
         
        
    }
    
    public static void main(String[] args){
        new BookHotel("");
    }
}
