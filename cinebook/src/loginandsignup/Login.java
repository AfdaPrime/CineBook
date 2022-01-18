package loginandsignup;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image(
                "file:D:/newCode/university/FundamentalOfProgramming/assigment/CineBook/cinebook/src/loginandsignup/gsc_logo-3.jpg"));
        stage.setTitle("GSC Movie");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void getFXMLLoader() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("StaffMovie.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Add Movie Time");
        stage.setScene(scene);
        stage.show();

    }

}
