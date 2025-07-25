package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener{
    
    JButton pay,back;
    
    Payment(){
        setBounds(500,200,860,478);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.png"));
        Image i2 = i1.getImage().getScaledInstance(860, 478, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,860,478);
        add(image);
        
        back = new JButton(" Back ");
        back.setBounds(100,30,150,30);
        back.setForeground(Color.BLUE);
        back.addActionListener(this);
        image.add(back);
        
        pay = new JButton(" Pay ");
        pay.setBounds(600,30,150,30);
        pay.setForeground(Color.BLUE);
        pay.addActionListener(this);
        image.add(pay);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==pay){
            new Paytm();
            setVisible(false);
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Payment();
    }
}
