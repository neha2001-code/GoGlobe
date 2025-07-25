package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener{
    
    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField  tfnumber,tfcountry,tfaddress,tfemail,tfphoneno,tfgen;
    JRadioButton rmale,rfemale;
    JButton update, back;
    String username;
     
    UpdateCustomer(String username){
        this.username = username;
        setBounds(450,200,900,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel txt = new JLabel("UPDATE CUSTOMER DETAILS");
        txt.setBounds(80, 0, 300, 25);
        txt.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(txt);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updatecustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(440,445,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(460,40,440,445);
        add(image);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        lblusername.setForeground(Color.BLACK);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220 ,90,150,25);
        add(labelusername);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
        comboid = new JComboBox(new String[] {"Passport","Pan Card","Voter ID","Aadhaar Card","Driving Licence"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220, 135, 150,25);
        add(tfnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(220 ,170,150,25);
        add(labelname);
        
        JLabel lblgender= new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 210, 70, 25);
        rmale.setBackground(Color.white);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210, 70, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
        tfgen = new JTextField();
        tfgen.setBounds(400 ,210,50,25);
        add(tfgen);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        JLabel country = new JLabel("Country");
        country.setBounds(30,250,150,25);
        add(country);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(220 ,250,150,25);
        add(tfcountry);
        
        JLabel address = new JLabel("Address");
        address.setBounds(30,290,150,35);
        add(address);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220 ,290,250,35);
        add(tfaddress);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30,330,150,25);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220 ,330,150,25);
        add(tfemail);
        
        JLabel lblphoneno = new JLabel("Phone No. ");
        lblphoneno.setBounds(30,370,150,25);
        add(lblphoneno);
        
        tfphoneno = new JTextField();
        tfphoneno.setBounds(220 ,370,150,25);
        add(tfphoneno);
        
        update = new JButton("Update");
        update.setBounds(220,420,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(350,420,100,30);
        back.addActionListener(this);
        add(back);
        
          try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username ='"+username+"'");
            while(rs.next()){
                //JOptionPane.showMessageDialog(null,rs.getString("username"));

                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                //(String)comboid.getSelectedItem(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgen.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfemail.setText(rs.getString("email"));
                tfphoneno.setText(rs.getString("phone"));
                
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);   
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            // 0
            String username = labelusername.getText();
            String id = (String)comboid.getSelectedItem(); 
            String number = tfnumber.getText();
            //String name = labelname.getText();
            String gender = null;
            if(rmale.isSelected()){
                gender = "Male";
            }
            else{
                gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphoneno.getText();
            String email = tfemail.getText();
            
            try{
                Conn c = new Conn();
                String query = "update customer set id = '"+id+"',number ='"+number+"',gender = '"+gender+"',country='"+country+"',address = '"+address+"',email = '"+email+"',phone='"+phone+"'";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully!!!");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Dashboard("");
        }
    }
    
    public static void main(String[] args){
        new UpdateCustomer("");
    }
}
