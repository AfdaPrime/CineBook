/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package loginandsignup;

import Database.dataBase;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import App.Main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class LoginFXMLController implements Initializable {

    dataBase db = new dataBase();

    ResultSet customer = db.customer();

    @FXML
    private ImageView cinemaPicture;
    @FXML
    private Label username;
    @FXML
    private Label password;
    @FXML
    private Label cinemaName;
    @FXML
    private Label registerpopup;
    @FXML
    private Line line;
    @FXML
    private TextField usernameFeild;
    @FXML
    private PasswordField passwordFeild;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loginUsernameInput(ActionEvent event) {
    }

    @FXML
    private void loginPasswordInput(ActionEvent event) {
    }

    @FXML
    private void loginButton(ActionEvent event) {

        try {

            String username = this.usernameFeild.getText();
            String password = this.passwordFeild.getText();

            customer.previous();
            
            while (customer.next()) {

                if (customer.getString("USERNAME").equals(username) && customer.getString("PASSWORD").equals(password)) {

                    try {
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        App.Main main = new Main();
                        
                        Main.staff = false;
                        
                        stage.close();
                        main.start();
                        db.close();
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {

                    usernameFeild.setText("");
                    passwordFeild.setText("");

                    usernameFeild.setStyle("-fx-border-color: red;");
                    passwordFeild.setStyle("-fx-border-color: red;");

                    usernameFeild.setPromptText("PLEASE ENTER AGAIN");
                    passwordFeild.setPromptText("PLEASE ENTER AGAIN");

                }

            }
            

        } catch (SQLException ex) {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void staffButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StaffLogin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void gotoSignUp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignUpFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
