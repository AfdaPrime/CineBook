package App;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class FoodCourt {

    private VBox pane = new VBox();
    // private Integer x = 0;

    contoller contoller = new App.contoller();

    public Parent placeHolder() {

        FlowPane flow = new FlowPane();

        for (int i = 0; i < 5; i++) {

            try {
                InputStream stream = new FileInputStream(
                        "D:/newCode/university/FundamentalOfProgramming/assigment/CineBook/cinebook/src/App/Spider-Man_No_Way_Home_poster.jpg");
                Image image = new Image(stream);
                ImageView imageView = new ImageView();
                imageView.setImage(image);

                VBox anchor = new VBox();

                anchor.getChildren().addAll(imageView, createPlaceholder());

                flow.getChildren().add(anchor);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        flow.setStyle(" -fx-background-color: #fdcf00;");

        flow.setAlignment(Pos.CENTER);

        flow.setHgap(50);

        Button b = new Button("Next");

        pane.setAlignment(Pos.CENTER);
        b.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> contoller.selectRoot(e, 4));
        pane.getChildren().addAll(flow, b);

        return pane;

    }

    private Node createPlaceholder() {
        HBox placeholder = new HBox();

        Button plus = new Button("+");
        Button minus = new Button("-");
        Label label = new Label("0");

        label.setId("0");

        placeholder.getChildren().addAll(plus, minus, label);

        placeholder.setSpacing(10);

        placeholder.setAlignment(Pos.CENTER);

        plus.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> placeholder.getChildren().set(2, changeLabel(e, placeholder.getChildren().get(2).getId())));

        minus.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> placeholder.getChildren().set(2, changeLabel(e, placeholder.getChildren().get(2).getId())));
        return placeholder;

    }

    private Node changeLabel(MouseEvent e, String id) {

        Integer x = Integer.parseInt(id);

        Label label = new Label();

        if ((e.getSource().toString()).contains("+")) {

            x += 1;
            label.setText(x.toString());
            label.setId(x.toString());
            return label;
        } else if ((e.getSource().toString()).contains("-") && x == 0) {
            return new Label("0");
        } else if ((e.getSource().toString()).contains("-")) {
            x -= 1;
            label.setText(x.toString());
            label.setId(x.toString());
            return label;
        } else
            return new Label("0");
    }

}
