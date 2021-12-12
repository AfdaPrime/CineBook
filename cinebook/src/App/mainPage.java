package App;

import java.lang.ModuleLayer.Controller;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainPage {

    static VBox root = new VBox();
    static Scene scene = new Scene(root);
    static VBox box = new VBox();
    static ScrollPane sPane = new ScrollPane();
    // static Node x = contoller.changeRoot();

    public static Scene getScene() throws Exception {
        root.getChildren().addAll(topBar.bar(), sPane);
        box.getChildren().add(contoller.root);

        sPane.setContent(box);
        sPane.setFitToWidth(true);
        sPane.setFitToHeight(true);

        return scene;
    }

}