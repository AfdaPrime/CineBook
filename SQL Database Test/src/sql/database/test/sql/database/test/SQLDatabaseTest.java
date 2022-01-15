package sql.database.test;

import java.util.Scanner;
import java.sql.*;
import java.sql.SQLException;

/**
 *
 * @author Idzhans Khairi
 */
public class SQLDatabaseTest {

    // Username : Idz2001 | Password : Hans2001
    // Username : Afda2002 | Password : Apple2002
    public static void main(String[] args) {

        try {

            String username, password;
            Scanner input = new Scanner(System.in);

            String SQL = "SELECT * FROM testdatabase.student";
            String host = "jdbc:mysql://localhost:3306/testDatabase";
            String uName = "root";
            String uPass = "SiapakahAppleSebenarnya_69";

            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println("\n");
            }

        } catch (SQLException e) {

        }

    }

}
