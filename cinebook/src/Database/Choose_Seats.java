package Database;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Choose_Seats {

    // Blank Seat     : 'O'
    // Occupied Seat  : '/'
    // Forbidden Seat : 'X'
    public static void main(String[] args) {
        
        try{
            
            int i, seatNumber, status = 1, count = 0;
            char index, seatIndex;
            boolean dataStatus = false;
            String seatStatus, seatData, seatChoosen = "";
            String[] userChoosen = new String[10000];
            Scanner input = new Scanner(System.in);
            
            //Initialize the database information
            String SQL = "SELECT * FROM HALL_SEATS";
            String host = "jdbc:derby://localhost:1527/CinemaBooking_Database";
            String uName = "WIX1002_OCC5_02";
            String uPass = "siapaapplesebenarnya";
        
            //Set up a connection to the database
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(SQL);
            
            //Printing the template of the Hall
            System.out.println("");
            System.out.println("  |-----------------------------------------------------------------|");
            System.out.println("  |                             SCREEN                              |");
            System.out.println("  |-----------------------------------------------------------------|");
            System.out.println("  | 01 02 03 04      05 06 07 08 09 10 11 12 13 14      15 16 17 18 |");
            System.out.println("  |-----------------------------------------------------------------|");
            for(index=65; index<77; index++)
            {
                System.out.printf("%c | ", index);
                for(i=1; i<=18; i++)
                {
                    //Get the cursor to the next line of row
                    rs.next();
                    seatStatus = rs.getString("Seat_Status");
                    
                    System.out.printf("%2s ", seatStatus);
                    if(i==4 || i==14)
                        System.out.print("     ");
                }
                System.out.println("|");
            }
            //Indicator for the user to know what does the symbols means for the seats
            System.out.println("\nLegend : ");
            System.out.println("--------------------");
            System.out.println(" Available Seat : O ");
            System.out.println(" Booked Seat    : / ");
            System.out.println(" Blocked Seat   : X ");
            System.out.println("--------------------\n");
            
            //Make the cursor go to the first row
            rs.first();
            i=0;
            
            do
            {
                //Prompting user to enter the number of seats he want to book seat row and seat number
                System.out.println("Please choose your seat");
                System.out.print("Rows (A, B, etc.)     : ");
                seatIndex = input.next().charAt(0);
                System.out.print("Columns (1, 14, etc.) : ");
                seatNumber = input.nextInt();
                
                //Incase if the user entered the seats row and column more or less than it should
                while(seatIndex<65 || seatIndex>76 || seatNumber<1 || seatNumber>18)
                {
                    System.out.println("WARNING : The row or column of the seat you choosen is out of limit!!!");
                    System.out.println("Please choose your seat");
                    System.out.print("Rows (A, B, etc.)     : ");
                    seatIndex = input.next().charAt(0);
                    System.out.print("Columns (1, 14, etc.) : ");
                    seatNumber = input.nextInt();
                }
                
                //Turn the information gathered into a string
                seatChoosen = seatChoosen + seatIndex + seatNumber;
                System.out.println(seatChoosen);
                userChoosen[i] = seatChoosen;
                System.out.println(userChoosen[i]);
                i++;
                count++;
                
                //Checking if the seat is available or not 
                while(rs.next())
                {
                    //Just to make sure the cursor is truely at the first row
                    if(dataStatus == false){
                        rs.first();
                        dataStatus = true;
                    }
                    
                    //Collect Data Info from the database
                    seatData = rs.getString("Seat_Number");
                    seatStatus = rs.getString("Seat_Status");
                    
                    if(seatChoosen.equals(seatData))
                    {
                        if(seatStatus.equals("O"))
                        {
                            rs.updateString("Seat_Status", "/");
                            rs.updateRow();
                            
                            System.out.print("Enter any number to continue or zero (0) to finish booking seat : ");
                            status = input.nextInt();
                            
                            break;
                        }
                        else if(seatStatus.equals("/"))
                        {
                            System.out.println("Sorry. But the seat you entered was occupied. Please enter another seat.");
                            break;
                        }
                        else if(seatStatus.equals("X"))
                        {
                            System.out.println("Sorry. But the seat you entered was blocked for social distancing purpose. Please enter another seat.");
                            break;
                        }
                    }
                }
                dataStatus = false;
                seatChoosen = "";
                rs.first();
            }
            while(status != 0);
            
            System.out.println("\nYour seats has been booked. The seat you choosen : ");
            for(i=0; i<count; i++)
            {
                System.out.print(userChoosen[i] + " ");
            }
            System.out.print("\n\n");
            
        }catch(SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
    }
    
}
