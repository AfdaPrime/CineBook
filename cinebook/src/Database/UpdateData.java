package Database;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateData {

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
            String SQL = "SELECT * FROM TESTING_NOW";
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
                        
                        String username_data = rs.getString("Username");
                        String pwd = rs.getString("Password");
                        
                        //Both info is equals to the input
                        if(username.equals(username_data) && password.equals(pwd)) 
                        {
                            status = 1;
                            break finding;
                        }
                        //Either one of the info is equals to the input
                        else if((!username.equals(username_data) && password.equals(pwd)) || (username.equals(username_data) && !password.equals(pwd)))
                        {
                            System.out.println("\n--------------------------------------------------------------------------");
                            System.out.println("The Username or Password you entered does not match!!!\n");
                            break;
                        }
                        //Both of the info is not equals
                        else if((!username.equals(username_data) && !password.equals(pwd)) && rs.next() == false) 
                        {
                            System.out.println("\n--------------------------------------------------------------------------");
                            System.out.println("The Username and Password you entered does not exist!!!\n");
                            break;
                        }
                        //The statement below needed because everytime it passes 2nd if else, it skipped one line because of rs.next()
                        rs.previous();
                        
                    }
                    
                    System.out.println("Please re-enter your Username and Password : ");
                    System.out.print("Username : ");
                    username = input.nextLine();
                    System.out.print("Password : ");
                    password = input.nextLine();
                    
                    status_data = false;
                    rs.first();
                }
            }
            
            //Updating data in database (Change username or password)
            String newUname, newUpass;
            System.out.println("\n---------------------------------------------------------------------");
            System.out.println("Please enter the following information for you to update your data : ");
            System.out.println("---------------------------------------------------------------------");
            System.out.print("New Username : ");
            newUname = input.nextLine();
            System.out.print("New Password : ");
            newUpass = input.nextLine();
            
            System.out.println("\nYour username has been updated to " + newUname + ".");
            System.out.println("Your password has been updated to " + newUpass + ".\n");
            
            rs.updateString("Username", newUname);
            rs.updateString("Password", newUpass);
            //To commit the changes to the database, you issue an updateRow() command
            rs.updateRow();
            
        } 
        catch (SQLException err) {
            
            System.out.println(err.getMessage());
            
        }
        
    }
    
}