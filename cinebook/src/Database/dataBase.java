/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class dataBase {

    private String SQL = "SELECT * FROM APPLE";
    private String host = "jdbc:derby://localhost:1527/CinemaBookingDatabase";
    private String uName = "Apple";
    private String uPass = "SiapakahAppleSebenarnya_69";
    private Statement stmt = null;
    private ResultSet rs = null;

    private ResultSet connection(String SQL) {
        try {

            // Set up a connection to the database
            Connection con = DriverManager.getConnection(host, uName, uPass);

            this.stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            this.rs = stmt.executeQuery(SQL);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(dataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet movie() {
        this.SQL += ".MOVIES_LIST";

        ResultSet rs = connection(SQL);

        return rs;
    }

    public ResultSet date() {

        this.SQL += ".MOVIES_BRANCH_AND_TIME ";

        this.rs = connection(SQL);

        return rs;
    }

    public ResultSet customer() {

        this.SQL += ".CUSTOMER_INFO";

        this.rs = connection(SQL);

        return rs;

    }

    public ResultSet staff() {

        this.SQL += ".STAFF_INFO";

        this.rs = connection(SQL);

        return rs;

    }

    public ResultSet seat() {

        this.SQL += ".HALL_SEAT_STATUS";

        this.rs = connection(SQL);

        return rs;

    }

    public ResultSet food() {

        this.SQL += ".FOOD_LIST";

        this.rs = connection(SQL);

        return rs;

    }

    public ResultSet booking() {

        this.SQL += ".BOOKING_INFO";

        this.rs = connection(SQL);

        return rs;
    }

    public void close() {
        try {
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(dataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
