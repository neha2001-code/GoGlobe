package travel.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
        try{
           Class.forName("com.mysql.cj.jdbc.Driver"); //this forName function takes string as an input , so here we have to write our driver's name
           c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem","root","MCA25neha@");
           s = c.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
