package App;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    static VBox root = new VBox();
    static Scene scene = new Scene(root);
    static VBox box = new VBox();
    static ScrollPane sPane = new ScrollPane();

    topBar topBar = new App.topBar();

    picker picker = new App.picker();

    @Override
    public void start(Stage stage) throws Exception {

        box.getChildren().add(picker.placeHolder());

        sPane.setContent(box);
        sPane.setFitToWidth(true);
        sPane.setFitToHeight(true);

        root.getChildren().addAll(topBar.bar(), sPane);

        scene.getStylesheets().add(getClass().getResource("mainStyle.css").toExternalForm());

        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

    }
}
