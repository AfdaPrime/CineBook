package App;

import java.beans.EventHandler;
import java.util.EventObject;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class contoller {

    // static Node x = picker.placeHolder();

    static Node root = picker.placeHolder();
    static Scene scene;
    static Stage stage;

    public static void selectRoot(Event event) {

        try {

            System.out.println(((Node) event.getSource()).getScene());

            root = dateSelector.placeHolder();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene((Parent) root);

            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
