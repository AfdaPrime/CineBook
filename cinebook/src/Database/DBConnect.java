package Database;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBConnect {

    public static void main(String[] args) {
        
        try {
            String host = "jdbc:derby://localhost:1527/Employees";
            String uName = "IdzhansKhairi";
            String uPass = "employeestest";
            
            
            // Set up a connection to a database
            Connection con = DriverManager.getConnection(host, uName, uPass);
            
            
            //TYPE_FORWARD_ONLY       : To move forward through the records, from beginning to end
            //TYPE_SCROLL_SENSITIVE   : To move forward AND backward through the records, and detecting any changes made to the records.
            //TYPE_SCROLL_INSENSITIVE : To move forward AND backward through the records, but are not bothered about any changes made to the records.
            //CONCUR_READ_ONLY        : ResultSet is Read Only
            //CONCUR_UPDATABLE        : ResultSet is Updateable
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM Workers";
            
            //Hold all the records from the database table
            //A way to store and manipulate the records returned from a SQL query
            ResultSet rs = stmt.executeQuery( SQL );
            
            //rs.next()    : Moves the Cursor to the next row in your table. If there are no more rows in the table, a value of False will be retuned.
            //rs.previous() : Moves the Cursor back one row in your table. If no more rows in the table, a value of False will be retuned.
            //rs.first() : Moves the Cursor to the first row in your Table.
            //rs.last() : Moves the Cursor to the last row in your Table.
            //rs.absolute : Moves the Cursor to a particular row in the table. So absolute(5) will move the Cursor to row number 5 in a Table.
            System.out.println("");
            while( rs.next() ) {  
                
                int id_col = rs.getInt("ID"); //Can use index number instead : int id_col = rs.getInt(1);
                String first_name = rs.getString("First_Name");
                String last_name = rs.getString("Last_Name");
                String job = rs.getString("Job_Title");
            
                //Printing all information from the table in the database
                
                System.out.println(id_col + " " + first_name + " " + last_name + " " + job);
                
            }
            System.out.println("");
            
            
        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        
        
        
    }
    
}
