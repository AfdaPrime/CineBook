package App;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class dateSelector {

    private static FlowPane flow = new FlowPane();

    contoller contoller = new App.contoller();

    public static Parent placeHolder() {

        try {
            flow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            flow.getStyleClass().add("bg-1");

            for (Integer i = 0; i < 20; i++) {
                InputStream stream = new FileInputStream(
                        "D:/newCode/university/FundamentalOfProgramming/assigment/CineBook/cinebook/src/App/Spider-Man_No_Way_Home_poster.jpg");
                Image image = new Image(stream);
                ImageView imageView = new ImageView();
                imageView.setImage(image);

                VBox anchor = new VBox();
                Label label = new Label();

                flow.getChildren().add(anchor);
                anchor.getStyleClass().add("bg-2");
                label.setText("Hello world!");
                label.getStyleClass().add("bg-2");
                label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

                anchor.getChildren().addAll(imageView, label);
                anchor.setPrefSize(200, 200);
                anchor.setId(i.toString());

                // anchor.addEventFilter(MouseEvent.MOUSE_PRESSED, new
                // EventHandler<MouseEvent>() {
                // @Override
                // public void handle(MouseEvent mouseEvent) {
                // contoller.selectRoot(mouseEvent);
                // }
                // });
                anchor.setOnMouseClicked((e) -> contoller().selectRoot(e));
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return flow;

    }

    private static App.contoller contoller() {
        return null;
    }
}