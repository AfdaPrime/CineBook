package App;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    static VBox root = new VBox();
    static Scene scene = new Scene(root, Color.BLACK);
    static VBox box = new VBox();
    static ScrollPane sPane = new ScrollPane();

    topBar topBar = new App.topBar();

    picker picker = new App.picker();

    static boolean staff = true;

    @Override
    public void start(Stage stage) throws Exception {

        stage.setMaximized(true);
        box.getChildren().add(picker.placeHolder());

        sPane.setContent(box);

        sPane.setFitToWidth(true);
        sPane.setFitToHeight(true);

        box.getStyleClass().add("bg-3");
        root.getChildren().addAll(topBar.bar(0, staff), sPane);

        scene.getStylesheets().add(getClass().getResource("mainStyle.css").toExternalForm());
        root.prefWidthProperty().bind(stage.widthProperty());

        stage.setScene(scene);
        stage.show();

    }
}
