package App;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = mainPage.getScene();
        scene.getStylesheets().add(getClass().getResource("mainStyle.css").toExternalForm());

        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

    }
}
