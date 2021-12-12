import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FlowPane rootPane = new FlowPane();
        Group root1 = new Group();
        Scene scene = new Scene(rootPane);
        Controller controller = new Controller();
        VBox vbox = new VBox(10);
        Parent design = FXMLLoader.load(getClass().getResource("Main.fxml"));

        Label label = new Label("this is VBox example");

        // Text text = new Text();
        // text.setText("This is");

        for (int i = 0; i < 5; i++) {
            rootPane.getChildren().add(new Button("Button " + (int) (i + 1)));
        }
        // add label to vbox
        vbox.getChildren().add(label);
        vbox.setAlignment(Pos.CENTER);

        rootPane.getChildren().addAll(vbox, design, root1);

        scene.getStylesheets().add(getClass().getResource("mainStyle.css").toExternalForm());

        stage.setTitle("test test");

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
