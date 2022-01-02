package Database;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

// This programme only used to make seats data in the database and nothing else
// Well it's quite tiring if u wanted to write one by one the seats name and all that stuff right? HAHAHAHAHAA
public class MakeSeats {

    // Blank Seat     : 'O'
    // Occupied Seat  : '/'
    // Forbidden Seat : 'X' 
    // There will be 18 seats per row
    // And there will be 12 seats per column
    // There will be only 2 halls
    public static void main(String[] args) {
        
        try {
            
            int i, j, hall = 1;
            String seat = "";
            char index=65;
        
            String SQL = "SELECT * FROM HALL_SEATS";
            String host = "jdbc:derby://localhost:1527/CinemaBooking_Database";
            String uName = "WIX1002_OCC5_02";
            String uPass = "siapaapplesebenarnya";
        
            //Set up a connection to the database
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(hall <= 2)
            {
                while (index>64 && index<77)
                {
                    // Move the cursor to the new row
                    rs.moveToInsertRow();
                    for(i=1; i<=18; i++)
                    {
                        seat = seat + index + i;
                        
                        rs.updateInt("Hall", hall);
                        rs.updateString("Seat_Number", seat);
                        rs.updateString("Seat_Status", "O");
                        
                        rs.insertRow();
                        rs.moveToInsertRow();
                        seat = "";
                    }
                    // Update String called seat
                    seat  = "";
                    index++;
                }
                // Update the index
                index = 65;
                hall++;
            }
            stmt.close();
            rs.close();
            
            
        }catch(SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
        
    }
    
}
