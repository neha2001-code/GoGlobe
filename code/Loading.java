package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    
    Thread t;
    JLabel loading,lblusername;
    JProgressBar bar;
    String username;
    
    @Override
     public void run(){
        try{
           for(int i=1;i<=101;i++){
               int max = bar.getMaximum();
               int value = bar.getValue();
               
               if(value<max){
                   bar.setValue(bar.getValue()+1);
               }
               else{
                   setVisible(false);
                   new Dashboard(username);
               }
               Thread.sleep(50);
           } 
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    Loading(String userName){
        username = userName;
        t = new Thread(this);
        setBounds(600,200,700,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setForeground(new Color(123, 33, 173));
        text.setFont(new Font("ALGERIAN",Font.BOLD,32));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);
        
        loading = new JLabel("Loading, please wait...");
        loading.setBounds(200,150,300,30);
        loading.setForeground(new Color(180, 4, 164));
        loading.setFont(new Font("Dancing Script",Font.PLAIN,20));
        add(loading);
        
        lblusername = new JLabel("Welcome "+username);
        lblusername.setBounds(20,310,400,40);
        lblusername.setForeground(Color.RED);
        lblusername.setFont(new Font("Roboto Slab",Font.BOLD,20));
        add(lblusername);
        
        t.start();
        
        setVisible(true);
    }
    
    public static void main(String args[]){
       new Loading(""); 
    }
}
