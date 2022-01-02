package App;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class topBar {

    private static HBox anchor = new HBox();
    private static TextField textField = new TextField();
    private static Label text = new Label();

    public Parent bar() {

        text.setText("GSC");

        anchor.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        anchor.getStyleClass().add("bg");
        anchor.getChildren().addAll(text, new Button("hello"), textField);
        // anchor.addEventFilter(MouseEvent.MOUSE_PRESSED, new
        // EventHandler<MouseEvent>() {
        // @Override
        // public void handle(MouseEvent mouseEvent) {
        // System.out.println(mouseEvent);
        // }
        // });
        return anchor;
    }

}
