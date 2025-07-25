package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    
    Thread thread = new Thread(this);
    
    Splash(){
        //setSize(1920,1080);  //this is hardcoded resolution 
        //setLocation(200,100); // we want to it dynamically expand and take its size, for that we create object of Splash class
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg")); // 
        Image i2 = i1.getImage().getScaledInstance(1920,1080,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        setVisible(true);
        thread.start();//internally it calls the run method
        //run() <- we can write in this way but it will not act as a multithreading
    }
    public void run(){
        try{
            Thread.sleep(7000); //1sec =1000milisecond
            new Login();
            setVisible(false);
        }
        catch(Exception e){
            
        }
    }
    
    public static void main(String[] arsg){
         Splash frame = new Splash();
         int x = 1;
         for(int i=1;i<=500;x+=7,i+=6){
             frame.setLocation(960-x,540-i/2);
             frame.setSize(x+i,i);
             try{
                 Thread.sleep(10);
             }
             catch(Exception e){
                 
             }
         }
    }
    
}
