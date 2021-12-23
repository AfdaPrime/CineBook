package Database;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;

public class DeleteData {

    //In This Database, there are 4 example users : 
    //Username 1 : Muhammad  |  Password 1 : muhammad01
    //Username 2 : Idzhans   |  Password 2 : idzhans01
    //Username 3 : Khairi    |  Password 3 : khairi01
    //Username 4 : Afda      |  Password 4 : afda02
    //Username 5 : Afiq      |  Password 5 : afiq02 (newly entered. delete later)
    public static void main(String[] args) {
        
        try {
            
            String username, password;
            Scanner input = new Scanner(System.in);
            
            String SQL = "SELECT * FROM TESTING_NOW";
            String host = "jdbc:derby://localhost:1527/CinemaBooking_Database";
            String uName = "WIX1002_OCC5_02";
            String uPass = "siapaapplesebenarnya";
            
            //Set up a connection to the database
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(SQL);
            
            //Prompt user to login
            System.out.println("\n---------------------------------------------------------------------------------");
            System.out.println("WELCOME TO GSC!!! PLEASE ENTER THE FOLLOWING TO LOG IN AND DELETING YOUR ACCOUNT:");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.print("Username : ");
            username = input.nextLine();
            System.out.print("Password : ");
            password = input.nextLine();
            
            while( rs.next() ) {
                
                String username_data = rs.getString("Username");
                String password_data = rs.getString("Password");
                
                if(username.equals(username_data) && password.equals(password_data)) {
                    break;
                }
            }
            
            System.out.print("\nPress enter to delete your account...  ");
            input.nextLine();
            
            //Use deleteRow() to delete a row
            rs.deleteRow();
            //Close the Statement object and the ResultSet objects
            stmt.close();
            rs.close();
            
            System.out.println("\nYour account has been deleted...\n");
            
        }
        catch(SQLException err) {
            
            System.out.println(err.getMessage());
            
        }
        
        
        
        
    }
    
}
