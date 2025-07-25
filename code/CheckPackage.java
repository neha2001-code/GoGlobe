package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame{
    
    CheckPackage(){
        setBounds(450,200,900,600);
        
        String[] package1 = {"GOLD PACKAGE", "6 Days and 7 Nights", "Airpot Assistance", "Half Day City Tour", "Daily Buffet","Soft Drinks Free", "Full Day 3 Island Cruise", "English Speaking Guide", "Book Package","SUMMER SPECIAL","Rs 32000/-","package1.jpg"};
        String[] package2 = {"SILVER PACKAGE", "5 Days and 6 Nights", "Toll Free and Entrance Free Ticket", "Meet and Greet at Airport", "Welcome drinks on Arrival", "Night Safari", "Cruise with Dinner", "Late Night Party","Book Now","WINTER SPECIAL","Rs 24000/-","package2.jpg"};
        String[] package3 = {"BRONZE PACKAGE", "4 Days and 5 Nights", "Return Airfare","Free Clubbing, Horse Riding & other Games","Free water park", "Soft drinks free", "Daily Buffet","BBQ Dinner","Book Now","MONSOON SPECIAL","Rs 12000/-","package3.jpeg"};

        JTabbedPane tab = new JTabbedPane();
        
        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1",null,p1);
        
        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2",null,p2);
        
        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3",null,p3);
        
        add(tab);
        setVisible(true);
    }
    
    public JPanel createPackage(String[] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(50,20,300,30);
        l1.setForeground(Color.YELLOW);
        l1.setFont(new Font("ALGERIAN",Font.BOLD,30));
        p1.add(l1);
        
        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(50,70,300,30);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Copperplate Gothic Light",Font.BOLD,25));
        p1.add(l2);
        
        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(50,120,300,30);
        l3.setForeground(Color.BLUE);
        l3.setFont(new Font("Copperplate Gothic Light",Font.BOLD,25));
        p1.add(l3);
        
        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(50,170,300,30);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("Copperplate Gothic Light",Font.BOLD,25));
        p1.add(l4);
        
        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(50,220,300,30);
        l5.setForeground(Color.BLUE);
        l5.setFont(new Font("Copperplate Gothic Light",Font.BOLD,25));
        p1.add(l5);
        
        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(50,270,300,30);
        l6.setForeground(Color.RED);
        l6.setFont(new Font("Copperplate Gothic Light",Font.BOLD,25));
        p1.add(l6);
        
        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(50,320,300,30);
        l7.setForeground(Color.BLUE);
        l7.setFont(new Font("Copperplate Gothic Light",Font.BOLD,25));
        p1.add(l7);
        
        JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(50,370,300,30);
        l8.setForeground(Color.RED);
        l8.setFont(new Font("Copperplate Gothic Light",Font.BOLD,25));
        p1.add(l8);
        
        JLabel l9 = new JLabel(pack[8]);
        l9.setBounds(50,420,300,30);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Copperplate Gothic Light",Font.BOLD,25));
        p1.add(l9);
        
        JLabel l10 = new JLabel(pack[9]);
        l10.setBounds(50,470,300,30);
        l10.setForeground(Color.PINK);
        l10.setFont(new Font("Copperplate Gothic Light",Font.BOLD,25));
        p1.add(l10);
        
        JLabel l11 = new JLabel(pack[10]);
        l11.setBounds(500,470,300,30);
        l11.setForeground(Color.cyan);
        l11.setFont(new Font("Copperplate Gothic Light",Font.BOLD,25));
        p1.add(l11);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[11]));
        Image i2 = i1.getImage().getScaledInstance(500, 450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,0,500, 450);
        p1.add(image);
        
        return p1;
        
    }
 
    public static void main(String args[]){
        new CheckPackage();
    }
}
