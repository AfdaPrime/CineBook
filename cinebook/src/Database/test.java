package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {

        String jdbcURL = "jdbc:derby://localhost:1527/CinemaBooking_Database";

        try {
            Connection conn = DriverManager.getConnection(jdbcURL);
            System.out.println("Connected");
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
