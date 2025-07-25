package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
    
    JButton addPersonalDetails,updatePersonalDetails,viewDetails,deletePersonalDetails,checkPackage,bookPackage,viewPackage,viewHotels,bookHotel,viewBookedHotel,destinations,payment,about;
    
    String username;
    Dashboard(String username){
        this.username =username;
        setBounds(0,0,1980,1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(2, 32, 159));
        p1.setBounds(0,0,1980,65);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/travel_logo.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,70,70);
        p1.add(image);
        
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,0,200,65);
        heading.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,25));
        heading.setForeground(Color.white);
        p1.add(heading);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(2, 32, 159));
        p2.setBounds(0,65,300,1080);
        add(p2);
        
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBackground(new Color(2, 32, 159 ));
        addPersonalDetails.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.setLayout(null);
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBackground(new Color(2, 32, 159 ));
        updatePersonalDetails.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setMargin(new Insets(0,0,0,60));
        updatePersonalDetails.setLayout(null);
        updatePersonalDetails.setBounds(0,50,300,50);
        p2.add(updatePersonalDetails);
        
        viewDetails = new JButton("View Details");
        viewDetails.setBackground(new Color(2, 32, 159 ));
        viewDetails.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        viewDetails.setForeground(Color.white);
        viewDetails.setMargin(new Insets(0,0,0,60));
        viewDetails.setLayout(null);
        viewDetails.setBounds(0,100,300,50);
        viewDetails.addActionListener(this);
        p2.add(viewDetails);
        
        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBackground(new Color(2, 32, 159 ));
        deletePersonalDetails.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        deletePersonalDetails.setForeground(Color.white);
        deletePersonalDetails.setMargin(new Insets(0,0,0,60));
        deletePersonalDetails.setLayout(null);
        deletePersonalDetails.setBounds(0,150,300,50);
        p2.add(deletePersonalDetails);
        
        checkPackage = new JButton("Check Package");
        checkPackage.setBackground(new Color(2, 32, 159 ));
        checkPackage.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        checkPackage.setForeground(Color.white);
        checkPackage.setMargin(new Insets(0,0,0,60));
        checkPackage.setLayout(null);
        checkPackage.setBounds(0,200,300,50);
        checkPackage.addActionListener(this);
        p2.add(checkPackage);
        
        bookPackage = new JButton("Book Package");
        bookPackage.setBackground(new Color(2, 32, 159 ));
        bookPackage.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        bookPackage.setForeground(Color.white);
        bookPackage.setMargin(new Insets(0,0,0,60));
        bookPackage.setLayout(null);
        bookPackage.setBounds(0,250,300,50);
        bookPackage.addActionListener(this);
        p2.add(bookPackage);
        
        viewPackage = new JButton("View Package");
        viewPackage.setBackground(new Color(2, 32, 159 ));
        viewPackage.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        viewPackage.setForeground(Color.white);
        viewPackage.setMargin(new Insets(0,0,0,60));
        viewPackage.setLayout(null);
        viewPackage.setBounds(0,300,300,50);
        viewPackage.addActionListener(this);
        p2.add(viewPackage);
        
        viewHotels = new JButton("View Hotels");
        viewHotels.setBackground(new Color(2, 32, 159 ));
        viewHotels.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        viewHotels.setForeground(Color.white);
        viewHotels.setMargin(new Insets(0,0,0,60));
        viewHotels.setLayout(null);
        viewHotels.setBounds(0,350,300,50);
        viewHotels.addActionListener(this);
        p2.add(viewHotels);
        
        bookHotel = new JButton("Book Hotel");
        bookHotel.setBackground(new Color(2, 32, 159 ));
        bookHotel.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        bookHotel.setForeground(Color.white);
        bookHotel.setMargin(new Insets(0,0,0,60));
        bookHotel.setLayout(null);
        bookHotel.setBounds(0,400,300,50);
        bookHotel.addActionListener(this);
        p2.add(bookHotel);
        
        
        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBackground(new Color(2, 32, 159 ));
        viewBookedHotel.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        viewBookedHotel.setForeground(Color.white);
        viewBookedHotel.setMargin(new Insets(0,0,0,60));
        viewBookedHotel.setLayout(null);
        viewBookedHotel.setBounds(0,450,300,50);
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);
        
        destinations = new JButton("Destinations");
        destinations.setBackground(new Color(2, 32, 159 ));
        destinations.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        destinations.setForeground(Color.white);
        destinations.setMargin(new Insets(0,0,0,60));
        destinations.setLayout(null);
        destinations.setBounds(0,500,300,50);
        destinations.addActionListener(this);
        p2.add(destinations);
        
        payment = new JButton("Payment");
        payment.setBackground(new Color(2, 32, 159 ));
        payment.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        payment.setForeground(Color.white);
        payment.setMargin(new Insets(0,0,0,60));
        payment.setLayout(null);
        payment.setBounds(0,550,300,50);
        payment.addActionListener(this);
        p2.add( payment);
        
        about = new JButton("About");
        about.setBackground(new Color(2, 32, 159 ));
        about.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        about.setForeground(Color.white);
        about.setMargin(new Insets(0,0,0,60));
        about.setLayout(null);
        about.setBounds(0,600,300,50);
        about.addActionListener(this);
        p2.add( about);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/travel.jpg"));
        Image i5 = i4.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(0,650,300,300);
        p2.add(image1);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i8 = i7.getImage().getScaledInstance(1623,1015,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image2 = new JLabel(i9);
        image2.setBounds(0,0,2220,1015);
        add(image2);
        
        JLabel head = new JLabel("Welcome to GoGlobe");
        head.setBounds(400,70,1000,70);
        head.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
        head.setForeground(Color.white);
        image2.add(head);
    
        setVisible(true);  
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addPersonalDetails){
            new AddCustomer(username);
            setVisible(false);
        }
        else if(ae.getSource()==viewDetails){
            new ViewCustomer(username);
            setVisible(false);
        }
        else if(ae.getSource()==updatePersonalDetails){
            new UpdateCustomer(username);
            setVisible(false);
        }
        else if(ae.getSource()==checkPackage){
            new CheckPackage();
        }
        else if(ae.getSource()==bookPackage){
            new BookPackage(username);
            setVisible(false);
        }
        else if(ae.getSource()==viewPackage){
            new ViewPackage(username);

        }
        else if(ae.getSource()==viewHotels){
            new CheckHotels();
          
        }
         else if(ae.getSource()==destinations){
            new Destinations();
            setVisible(false);
         }
         else if(ae.getSource()==bookHotel){
             new BookHotel(username);
             setVisible(false);
         }
         else if(ae.getSource()==viewBookedHotel){
             new ViewBookedHotel(username);
            
         }
         else if(ae.getSource()==payment){
             new Payment();
             setVisible(false);
         }
         else if(ae.getSource()==about){
             new About(username);
             
            
         }  
    }
    
    public static void main(String args[]){
        new Dashboard("");
    }
}
