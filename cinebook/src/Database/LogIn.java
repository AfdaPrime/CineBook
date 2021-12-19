package Database;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.Scanner;

public class LogIn {

    //In This Database, there are 4 example users : 
    //Username 1 : Muhammad  |  Password 1 : muhammad01
    //Username 2 : Idzhans   |  Password 2 : idzhans01
    //Username 3 : Khairi    |  Password 3 : khairi01
    //Username 4 : Afda      |  Password 4 : afda02
    public static void main(String[] args) {
        
        try {
            int count = 0, status = 0;
            boolean status_data = true;
            String username, password;
            String SQL = "SELECT * FROM CUSTOMER";
            String host = "jdbc:derby://localhost:1527/CinemaBooking_Database";
            String uName = "WIX1002_OCC5_02";
            String uPass = "siapaapplesebenarnya";
            Scanner input = new Scanner(System.in);
            
            //Set up a connection to the database
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(SQL);
            
            //Prompting user to login
            System.out.println("\n---------------------------------------------------------------");
            System.out.println("Welcome to GSC Cinema!!! Please enter the following to log in :");
            System.out.println("---------------------------------------------------------------");
            System.out.print("Username : ");
            username = input.nextLine();
            System.out.print("Password : ");
            password = input.nextLine();
            
            //Find if the username is in the database or not
            finding : {
                
                while(status != 1) 
                {
                    while( rs.next() ) 
                    {
                        if(status_data == false) {
                            rs.first();
                            status_data = true;
                        }
                        
                        String username_data = rs.getString("Username_Customer");
                        String pwd = rs.getString("Password_Customer");
                    
                        if(username.equals(username_data) && password.equals(pwd)) 
                        {
                            status = 1;
                            break finding;
                        }
                    }
                    
                    status_data = false;
                    System.out.println("\n------------------------------------------------------");
                    System.out.println("The username or password you entered does not exist!!!\n");
                    System.out.println("Please re-enter your Username and Password : ");
                    System.out.print("Username : ");
                    username = input.nextLine();
                    System.out.print("Password : ");
                    password = input.nextLine();
                    rs.first();
                }
            }
            
            
            if(status == 1) {
                
                System.out.println("");
                System.out.println("--------------------------------------");
                System.out.println("WELCOME TO GSC BOOKING APPLICATION !!!");
                System.out.println("--------------------------------------");
                
            }
            
        } 
        catch (SQLException err) {
            
            System.out.println(err.getMessage());
            
        }
    }
    
}







