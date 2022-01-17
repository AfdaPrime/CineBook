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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class SignUpFXMLController implements Initializable {

    dataBase db = new dataBase();

    ResultSet customer = db.customer();

    @FXML
    private Label registration;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private ImageView cinemaPicture;
    @FXML
    private Label emailLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField namelField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField matrixNumberField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private CheckBox studentCheckbox;
    @FXML
    private Line line;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        matrixNumberField.setDisable(true);
    }

    @FXML
    private void checkButton(ActionEvent event) {

        matrixNumberField.setDisable(!matrixNumberField.isDisable());

    }

    @FXML
    private void signInButton(ActionEvent event) {
                       
        try {

            if (usernameField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty() || namelField.getText().trim().isEmpty() || phoneField.getText().trim().isEmpty()) {

                usernameField.setText("");
                passwordField.setText("");
                namelField.setText("");
                phoneField.setText("");
                emailField.setText("");

                usernameField.setStyle("-fx-border-color: red;");
                passwordField.setStyle("-fx-border-color: red;");
                namelField.setStyle("-fx-border-color: red;");
                phoneField.setStyle("-fx-border-color: red;");
                emailField.setStyle("-fx-border-color: red;");

                usernameField.setPromptText("PLEASE ENTER AGAIN");
                passwordField.setPromptText("PLEASE ENTER AGAIN");
                namelField.setPromptText("PLEASE ENTER AGAIN");
                phoneField.setPromptText("PLEASE ENTER AGAIN");
                emailField.setPromptText("PLEASE ENTER AGAIN");
            } else {
                
               
                   customer.moveToInsertRow();
                
                customer.updateString("USERNAME", usernameField.getText());
                customer.updateString("PASSWORD", passwordField.getText());
                customer.updateString("FULL_NAME", namelField.getText());
                customer.updateString("PHONE_NUMBER", phoneField.getText());
                customer.updateString("EMAIL", emailField.getText());
                
                 if (matrixNumberField.isDisable()) {

                customer.updateString("MATRIC_NUMBER", null);

            } else {
                if (matrixNumberField.getText().trim().isEmpty()) {
                     matrixNumberField.setText("");
                    matrixNumberField.setStyle("-fx-border-color: red;");
                    matrixNumberField.setPromptText("PLEASE ENTER AGAIN");
                }else{
                    customer.updateString("MATRIC_NUMBER", matrixNumberField.getText());
                   
                }
            }

                 
            //Inserts a new row
            customer.insertRow();
            
            
             try {
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        App.Main main = new Main();
                        
                        Main.staff = false;
                        
                        stage.close();
                        main.start();
                        db.close();
                  
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                
            }

           

            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(SignUpFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void signInPasswordInput(ActionEvent event) {
    }

    @FXML
    private void signInUsernameInput(ActionEvent event) {
    }

    @FXML
    private void returnLoginButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
