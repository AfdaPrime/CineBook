package loginandsignup;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        Scene scene = new Scene(root);
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
