package App;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class heroSlide {

    static HBox anchor = new HBox();

    public static Node placeHolder() throws FileNotFoundException {

        for (int i = 0; i < 5; i++) {
            InputStream stream = new FileInputStream(
                    "D:/newCode/university/FundamentalOfProgramming/assigment/CineBook/cinebook/src/Spider-Man_No_Way_Home_poster.jpg");
            Image image = new Image(stream);
            ImageView imageView = new ImageView();
            imageView.setImage(image);

            anchor.getChildren().add(imageView);

        }

        // Button button = new Button("hello");
        // Button button1 = new Button("hello");
        // anchor.setMaxSize(Double.MAX_VALUE, 0);
        anchor.getStyleClass().add("bg");
        // anchor.getChildren().addAll(button, button1);
        // AnchorPane.setTopAnchor(button, (double) 0);
        // AnchorPane.setLeftAnchor(button, (double) 50);
        // AnchorPane.setRightAnchor(button, (double) 0);
        // AnchorPane.setBottomAnchor(button, (double) 0);
        return anchor;
    }

}
