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
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class LoginFXMLController implements Initializable {

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
    }

    @FXML
    private void staffButton(ActionEvent event) throws IOException{
        JOptionPane.showMessageDialog(null, "New form will be opened");
        Parent root = FXMLLoader.load(getClass().getResource("StaffLogin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void gotoSignUp(ActionEvent event) throws IOException{
        JOptionPane.showMessageDialog(null, "New form will be opened");
        Parent root = FXMLLoader.load(getClass().getResource("SignUpFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    
}
