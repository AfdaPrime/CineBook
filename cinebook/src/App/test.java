/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package App;

import Database.dataBase;
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
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String SQL = "SELECT * FROM APPLE.MOVIES_LIST";
//        String host = "jdbc:derby://localhost:1527/CinemaBookingDatabase";
//        String uName = "Apple";
//        String uPass = "SiapakahAppleSebenarnya_69";
        try {
//            Connection con = DriverManager.getConnection(host, uName, uPass);
//
//            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//
//            ResultSet rs = stmt.executeQuery(SQL);
//
            dataBase db = new dataBase();
//            rs.abstract(2);
            ResultSet movie = db.movie();

            while (movie.next()) {
//                if (movie.getInt("ID") == 2) {
//                    System.out.println(movie.getString("MOVIES_CAST"));
//                    System.out.println(movie.getString("MOVIES_NAME"));
//                    System.out.println(movie.getString("MOVIES_DESCRIPTION"));
//                }

//movie.
                System.out.println(movie.getInt("ID"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
