/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package loginandsignup;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Database.dataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class StaffMovieController implements Initializable {

    dataBase db = new dataBase();

    ResultSet dateDb = db.date();

    @FXML
    private ImageView image;
    @FXML
    private Label movieTitle;
    @FXML
    private Label movielabel;
    @FXML
    private Label showtimelabel;
    @FXML
    private TextField movie;
    @FXML
    private TextField showtime;
    @FXML
    private TextField hall;
    @FXML
    private TextField date;
    @FXML
    private TextField branch;
    @FXML
    private TextField day;
    @FXML
    private Label statusLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void removeButton(ActionEvent event) {

        try {
            while (dateDb.next()) {

                String movie_data = dateDb.getString("MOVIES_NAME");
                String showtime_data = dateDb.getString("TIME");
                String hall_data = dateDb.getString("HALL");
                String date_data = dateDb.getString("DATE");
                String branch_data = dateDb.getString("BRANCH");
                String day_data = dateDb.getString("DAY");

                if (movie.getText().equals(movie_data) && showtime.getText().equals(showtime_data)
                        && hall.getText().equals(hall_data) && date.getText().equals(date_data)
                        && branch.getText().equals(branch_data) && day.getText().equals(day_data)) {
                    break;
                }
            }

            dateDb.deleteRow();
            db.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @FXML
    private void addButton(ActionEvent event) {

        try {

            if (movie.getText().trim().isEmpty() || showtime.getText().trim().isEmpty()
                    || hall.getText().trim().isEmpty() || date.getText().trim().isEmpty()
                    || branch.getText().trim().isEmpty() || day.getText().trim().isEmpty()) {

                movie.setText("");
                showtime.setText("");
                hall.setText("");
                date.setText("");
                branch.setText("");
                day.setText("");

                movie.setStyle("-fx-border-color: red;");
                showtime.setStyle("-fx-border-color: red;");
                hall.setStyle("-fx-border-color: red;");
                date.setStyle("-fx-border-color: red;");
                branch.setStyle("-fx-border-color: red;");
                day.setStyle("-fx-border-color: red;");

                movie.setPromptText("PLEASE ENTER AGAIN");
                showtime.setPromptText("PLEASE ENTER AGAIN");
                hall.setPromptText("PLEASE ENTER AGAIN");
                date.setPromptText("PLEASE ENTER AGAIN");
                branch.setPromptText("PLEASE ENTER AGAIN");
                day.setPromptText("PLEASE ENTER AGAIN");
            } else {

                dateDb.moveToInsertRow();

                dateDb.updateString("MOVIES_NAME", movie.getText());
                dateDb.updateString("TIME", showtime.getText());
                dateDb.updateString("MOVIES_HALL", hall.getText());
                dateDb.updateString("DATE", date.getText());
                dateDb.updateString("BRANCH", branch.getText());
                dateDb.updateString("DAY", day.getText());

                // Inserts a new row
                dateDb.insertRow();

                movie.setText("");
                showtime.setText("");
                hall.setText("");
                date.setText("");
                branch.setText("");
                day.setText("");

                statusLabel.setText("Movie have sucessfull added");

            }

            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(SignUpFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void returnButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StaffEditor.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) ((event.getSource()))).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
