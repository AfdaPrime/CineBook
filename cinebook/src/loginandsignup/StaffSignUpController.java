/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package loginandsignup;

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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class StaffSignUpController implements Initializable {

    @FXML
    private ImageView image;
    @FXML
    private Label staffSignUpLabel;
    @FXML
    private Label staffIDLabel;
    @FXML
    private Label staffPasswordLabel;

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
    }

    @FXML
    private void returnLoginButton(ActionEvent event) throws IOException{
        JOptionPane.showMessageDialog(null, "New form will be opened");
        Parent root = FXMLLoader.load(getClass().getResource("StaffLogin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
