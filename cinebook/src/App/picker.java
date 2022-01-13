package App;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class picker {

    FlowPane flow = new FlowPane();

    contoller contoller = new App.contoller();

    public Node placeHolder() {
        try {
            // flow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            flow.getStyleClass().add("bg-1");
            for (Integer i = 0; i < 3; i++) {
                InputStream stream = new FileInputStream(
                        "D:/newCode/university/FundamentalOfProgramming/assigment/CineBook/cinebook/src/App/Spider-Man_No_Way_Home_poster.jpg");
                Image image = new Image(stream);
                ImageView imageView = new ImageView();
                imageView.setImage(image);

                VBox anchor = new VBox();
                Label label = new Label();

                anchor.getStyleClass().add("background_selector");
                // anchor.setBorder(Border);
                label.setText("SpiderMan: No way home Season 2 hdsuendosnsifdrndsofaoisekfnseiofsenkfhse9fjlkxcp-");
                label.getStyleClass().add("label");
                label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

                label.setPadding(new Insets(5));

                anchor.getChildren().addAll(imageView, label);
                anchor.setPrefWidth(200);
                anchor.setId(i.toString());
                flow.getChildren().add(anchor);

                anchor.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> contoller.selectRoot(e, 1));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        return flow;
    }

}
