package Database;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;

public class Signin {

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
            
            System.out.println("Please enter the following to sign in : ");
            System.out.print("Username : ");
            username = input.nextLine();
            System.out.print("Password : ");
            password = input.nextLine();
            
            rs.moveToInsertRow();
            
            rs.updateString("Username", username);
            rs.updateString("Password", password);
            //Inserts a new row
            rs.insertRow();
            //to commit any changes to the database what we'll do is to close our Statement object and our ResultSet object
            stmt.close();
            rs.close();
            
            System.out.println("\nYou have signed in to GSC! Welcome!!!\n");
            
            
        }
        catch(SQLException err) {
            
            System.out.println(err.getMessage());
            
        }
        
    }
    
}
