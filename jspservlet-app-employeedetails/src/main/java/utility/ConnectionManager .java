package utility;

import java.sql.*;


public class ConnectionManager {
    public static Connection con;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","examly");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}



