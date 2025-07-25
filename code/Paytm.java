package travel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Paytm extends JFrame implements ActionListener{
    
    JButton back;
    
    Paytm(){
        setBounds(200,200,1500,600);
        
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        
        try{
            pane.setPage("https://paytm.com/rent-payment");
        }
        catch(Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404</html>");
            
        }
        
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);
        
        back = new JButton("Back");
        back.setBounds(900,30,80, 30);
        back.addActionListener(this);
        pane.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Payment();
        
    }
    
    public static void main(String[] args)
    {
        new Paytm();
    }
}
