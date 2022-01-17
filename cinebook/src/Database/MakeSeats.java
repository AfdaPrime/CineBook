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
            
            int i, j, hall = 5;
            String seat = "";
            char index=65;
            
            String SQL = "SELECT * FROM APPLE.HALL_SEAT_STATUS";
            String host = "jdbc:derby://localhost:1527/CinemaBookingDatabase";
            String uName = "Apple";
            String uPass = "SiapakahAppleSebenarnya_69";
            
            //Set up a connection to the database
            Connection con = DriverManager.getConnection(host, uName, uPass);
            
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(hall <= 8)
            {
                while (index>64 && index<70)
                {
                    // Move the cursor to the new row
                    rs.moveToInsertRow();
                    for(i=1; i<=8; i++)
                    {
                        seat = seat + index + i;
                        
                        rs.updateString("Branch", "Petaling Jaya - 1 Utama");
                        rs.updateInt("Hall_Number", hall);
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
