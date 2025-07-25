package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteDetails extends JFrame implements ActionListener{
    JButton back;
    JLabel lbluserName,lblID,lblno,lblname,lblgender,lblcountry,lbladd,lblmail,lblphone;
    String username;
    DeleteDetails(String username){
        this.username = username;
        setBounds(450,180,870,700);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel note = new JLabel("*NOTE : Once your click on delete button your all record will be deleted.");
        note.setBounds(30,10,650,70);
        note.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        note.setForeground(Color.RED);
        add(note);
         
        JLabel name = new JLabel("Welcome : ");
        name.setBounds(300,40,150,70);
        name.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        name.setForeground(Color.BLACK);
        add(name);
        
        lblname = new JLabel();
        lblname.setBounds(400,40,150,70);
        lblname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        add(lblname);
        
        JLabel userName = new JLabel("Username : ");
        userName.setBounds(30,80,150,70);
        userName.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        userName.setForeground(Color.BLACK);
        add(userName);
        
        lbluserName = new JLabel();
        lbluserName.setBounds(210,80,150,70);
        lbluserName.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lbluserName);
        
        JLabel id = new JLabel("ID : ");
        id.setBounds(30,120,150,70);
        id.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        id.setForeground(Color.BLACK);
        add(id);
        
        lblID = new JLabel();
        lblID.setBounds(210,120,150,70);
        lblID.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lblID);
        
        JLabel idno = new JLabel("ID No. : ");
        idno.setBounds(30,160,150,70);
        idno.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        idno.setForeground(Color.BLACK);
        add(idno);
        
        lblno = new JLabel();
        lblno.setBounds(210,160,150,70);
        lblno.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lblno);
        
        JLabel gender = new JLabel("Gender : ");
        gender.setBounds(30,200,150,70);
        gender.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        gender.setForeground(Color.BLACK);
        add(gender);
        
        lblgender = new JLabel();
        lblgender.setBounds(210,200,150,70);
        lblgender.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lblgender);
        
        JLabel country = new JLabel("Country : ");
        country.setBounds(400,80,100,70);
        country.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        country.setForeground(Color.BLACK);
        add(country);
        
        lblcountry = new JLabel();
        lblcountry.setBounds(550,80,150,70);
        lblcountry.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lblcountry);
        
        JLabel adress = new JLabel("Address : ");
        adress.setBounds(400,120,100,70);
        adress.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        adress.setForeground(Color.BLACK);
        add(adress);
        
        lbladd = new JLabel();
        lbladd.setBounds(550,120,250,70);
        lbladd.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lbladd);
        
        JLabel email = new JLabel("Email : ");
        email.setBounds(400,160,100,70);
        email.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        email.setForeground(Color.BLACK);
        add(email);
        
        lblmail = new JLabel();
        lblmail.setBounds(550,160,250,70);
        lblmail.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lblmail);
        
        JLabel phoneno = new JLabel("Phone No. : ");
        phoneno.setBounds(400,200,100,70);
        phoneno.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        phoneno.setForeground(Color.BLACK);
        add(phoneno);
        
        lblphone = new JLabel();
        lblphone.setBounds(550,200,150,70);
        lblphone.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        add(lblphone);
        
        back = new JButton("Delete");
        back.setBounds(300, 250,80, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewCust.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1024,512,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image2 = new JLabel(i3);
        image2.setBounds(0,300,1024,512);
        add(image2);
        
           
        try{
           Conn c = new Conn();
           ResultSet rs=c.s.executeQuery("Select * from customer where username ='"+username+"'");
           while(rs.next()){
               lblname.setText(rs.getString("name"));
               lblID.setText(rs.getString("id"));
               lblno.setText(rs.getString("number"));
               lbluserName.setText(rs.getString("username"));
               lblgender.setText(rs.getString("gender"));
               lblcountry.setText(rs.getString("country"));
               lbladd.setText(rs.getString("address"));
               lblmail.setText(rs.getString("email"));
               lblphone.setText(rs.getString("phone"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    
     @Override
        public void actionPerformed(ActionEvent ae){
                try{
                    Conn c = new Conn();
                    c.s.executeUpdate("Delete from account where username ='"+username+"'");                    
                    c.s.executeUpdate("Delete from bookhotel where username ='"+username+"'");
                    c.s.executeUpdate("Delete from bookpackage where username ='"+username+"'");
                    c.s.executeUpdate("Delete from customer where username ='"+username+"'");                    

                    JOptionPane.showMessageDialog(null,"Record deleted!");
                    setVisible(false);
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
        }
    public static void main(String args[]){
        new DeleteDetails("nehap");
    }
}
