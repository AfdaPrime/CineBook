package App;

import Database.dataBase;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main {
    // public static void main(String[] args) {
    // launch(args);
    // }

    static VBox root = new VBox();
    static Scene scene = new Scene(root, Color.BLACK);
    static VBox box = new VBox();
    static ScrollPane sPane = new ScrollPane();

    topBar topBar = new App.topBar();

    public static boolean staff = false;

    public void start() {

        Stage stage = new Stage();

        stage.setMaximized(true);

        if (box.getChildren().isEmpty()) {

            box.getChildren().add(new picker().placeHolder());
        } else {
            box.getChildren().set(0, new picker().placeHolder());
        }

        sPane.setContent(box);

        sPane.setFitToWidth(true);
        sPane.setFitToHeight(true);

        box.getStyleClass().add("bg-3");

        if (root.getChildren().isEmpty()) {

            root.getChildren().addAll(topBar.bar(0, staff), sPane);
            System.out.println(root.getChildren().size());
        } else {

            root.getChildren().set(0, topBar.bar(0, staff));
            root.getChildren().set(1, sPane);

        }

        scene.getStylesheets().add(getClass().getResource("mainStyle.css").toExternalForm());
        root.prefWidthProperty().bind(stage.widthProperty());

        stage.setScene(scene);
        stage.show();

    }
}
