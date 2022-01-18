/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package loginandsignup;

import App.Main;
import Database.dataBase;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class StaffLoginController implements Initializable {

    dataBase db = new dataBase();

    ResultSet staff = db.staff();

    @FXML
    private Label staffTItle;
    @FXML
    private Label staffIDLabel;
    @FXML
    private Label staffpasswordLabel;
    @FXML
    private Label newStaffLabel;
    @FXML
    private TextField staffUsernameTextfeild;
    @FXML
    private TextField staffIDField;
    @FXML
    private PasswordField staffpasswordFIeld;
    @FXML
    private Line line;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void staffLoginButton(ActionEvent event) {

        try {

            String username = this.staffUsernameTextfeild.getText();
            String staffId = this.staffIDField.getText();
            String password = this.staffpasswordFIeld.getText();

            staff.previous();

            while (staff.next()) {

                if (staff.getString("USERNAME").equals(username) && staff.getString("PASSWORD").equals(password)
                        && staff.getString("STAFF_ID").equals(staffId)) {

                    try {
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        App.Main main = new Main();

                        Main.staff = true;

                        db.close();
                        stage.close();
                        main.start();
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {

                    staffUsernameTextfeild.setText("");
                    staffIDField.setText("");
                    staffpasswordFIeld.setText("");

                    staffUsernameTextfeild.setStyle("-fx-border-color: red;");
                    staffIDField.setStyle("-fx-border-color: red;");
                    staffpasswordFIeld.setStyle("-fx-border-color: red;");

                    staffUsernameTextfeild.setPromptText("PLEASE ENTER AGAIN");
                    staffIDField.setPromptText("PLEASE ENTER AGAIN");
                    staffpasswordFIeld.setPromptText("PLEASE ENTER AGAIN");

                    break;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void staffGoSignUpButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StaffSignUp.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void staffreturnLoginButton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
