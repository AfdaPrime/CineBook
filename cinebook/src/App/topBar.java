package App;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class topBar {
    private Group group = new Group();
    private BorderPane anchor = new BorderPane();
    private TextField textField = new TextField();
    private Label text = new Label();
    private contoller contoller = new App.contoller();

    private Button staffButton = new Button("staff");

    public Parent bar(int i, boolean staff) {
        text.setText("GSC");

        ImageView gsc = createImageView(
                "D:\\newCode\\university\\FundamentalOfProgramming\\assigment\\CineBook\\cinebook\\src\\App\\GSC-removebg-preview.png");
        ImageView arrow = createImageView(
                "D:\\newCode\\university\\FundamentalOfProgramming\\assigment\\CineBook\\cinebook\\src\\App\\leftArrow.png");

        anchor.getStyleClass().add("background_topBar");

        if (staff) {

            if (i == 0) {
                anchor.setCenter(gsc);
                anchor.setRight(staffButton);
            } else {
                anchor.setCenter(gsc);
                anchor.setLeft(arrow);
                anchor.setRight(staffButton);
            }

        } else {
            if (i == 0) {
                anchor.setCenter(gsc);
                anchor.setRight(staffButton);
            } else {
                anchor.setCenter(gsc);
                anchor.setLeft(arrow);
                anchor.setRight(staffButton);
            }
        }

        // switch (i) {
        // case 0:
        // anchor.setCenter(gsc);
        // break;
        // default:
        // anchor.setCenter(gsc);
        // anchor.setLeft(arrow);
        // break;

        // }

        arrow.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> misc(e, i));

        anchor.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        group.getChildren().addAll(anchor);
        anchor.setPadding(new Insets(5, 5, 5, 5));
        return anchor;
    }

    private void misc(MouseEvent e, int i) {

        Payment.setType();

        contoller.selectRoot(e, i - 1);
    }

    private ImageView createImageView(String x) {
        InputStream stream;

        ImageView imageView = null;

        try {
            stream = new FileInputStream(x);
            Image image = new Image(stream);
            imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitHeight(50);
            imageView.setPreserveRatio(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return imageView;
    }

}
