/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package loginandsignup;

import App.Main;
import Database.dataBase;
import SendEmail.SendEmail;

import java.io.IOException;
import static java.lang.Double.NaN;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class StaffSignUpController implements Initializable {

    dataBase db = new dataBase();

    ResultSet staff = db.staff();

    @FXML
    private ImageView image;
    @FXML
    private Label staffSignUpLabel;
    @FXML
    private Label staffIDLabel;
    @FXML
    private Label staffPasswordLabel;
    @FXML
    private TextField staffId;
    @FXML
    private TextField username;
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField phoneNum;
    @FXML
    private PasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void staffIDField(ActionEvent event) {
    }

    @FXML
    private void passwordField(ActionEvent event) {
    }

    @FXML
    private void staffSignUpButton(ActionEvent event) {

        try {

            if (staffId.getText().trim().isEmpty() || username.getText().trim().isEmpty()
                    || name.getText().trim().isEmpty() || email.getText().trim().isEmpty()
                    || phoneNum.getText().trim().isEmpty() || password.getText().trim().isEmpty()) {

                staffId.setText("");
                username.setText("");
                name.setText("");
                email.setText("");
                phoneNum.setText("");
                password.setText("");

                staffId.setStyle("-fx-border-color: red;");
                username.setStyle("-fx-border-color: red;");
                name.setStyle("-fx-border-color: red;");
                email.setStyle("-fx-border-color: red;");
                phoneNum.setStyle("-fx-border-color: red;");
                password.setStyle("-fx-border-color: red;");

                staffId.setPromptText("PLEASE ENTER AGAIN");
                username.setPromptText("PLEASE ENTER AGAIN");
                name.setPromptText("PLEASE ENTER AGAIN");
                email.setPromptText("PLEASE ENTER AGAIN");
                phoneNum.setPromptText("PLEASE ENTER AGAIN");
                password.setPromptText("PLEASE ENTER AGAIN");
            } else {

                if (!staffId.getText().matches("\\d*")) {

                    staffId.setText("");
                    staffId.setStyle("-fx-border-color: red;");
                    staffId.setPromptText("PLEASE ENTER NUMBER");

                } else {

                    staff.moveToInsertRow();
                    staff.updateString("STAFF_ID", staffId.getText());
                    staff.updateString("USERNAME", username.getText());
                    staff.updateString("FULL_NAME", name.getText());
                    staff.updateString("EMAIL", email.getText());
                    staff.updateString("PHONE_NUMBER", phoneNum.getText());
                    staff.updateString("PASSWORD", password.getText());

                    // Inserts a new row
                    staff.insertRow();

                    try {
                        SendEmail.setUser(staff.getString("USERNAME"), staff.getString("EMAIL"),
                                staff.getString("FULL_NAME"));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        App.Main main = new Main();

                        Main.staff = true;

                        stage.close();
                        main.start();
                        db.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(SignUpFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void returnLoginButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StaffLogin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
