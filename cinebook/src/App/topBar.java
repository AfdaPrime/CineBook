package App;

import Database.dataBase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Stage;
import loginandsignup.Login;

public class topBar {
    private Group group = new Group();
    private BorderPane anchor = new BorderPane();
    private TextField textField = new TextField();
    private Label text = new Label();
    private contoller contoller = new App.contoller();
    private HBox hbox = new HBox();

    private Button logOut = new Button("Log Out");
    private Button staffButton = new Button("Staff");

    public static dataBase db = null;

    public Parent bar(int i, boolean staff) {

        text.setText("GSC");

        ImageView gsc = createImageView(
                "D:\\newCode\\university\\FundamentalOfProgramming\\assigment\\CineBook\\cinebook\\src\\App\\GSC-removebg-preview.png");
        ImageView arrow = createImageView(
                "D:\\newCode\\university\\FundamentalOfProgramming\\assigment\\CineBook\\cinebook\\src\\App\\leftArrow.png");

        anchor.getStyleClass().add("background_topBar");

        hbox.setSpacing(10);

        if (staff) {

            hbox.getChildren().addAll(staffButton, logOut);

            if (i == 0) {
                anchor.setCenter(gsc);
                anchor.setRight(hbox);
            } else {
                anchor.setCenter(gsc);
                anchor.setLeft(arrow);
                anchor.setRight(hbox);
            }

        } else {
            if (i == 0) {
                anchor.setCenter(gsc);
                anchor.setRight(logOut);
            } else {
                anchor.setCenter(gsc);
                anchor.setLeft(arrow);
                anchor.setRight(logOut);
            }
        }

        staffButton.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> staff(e));
        logOut.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> logOut(e));
        arrow.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> misc(e, i));

        anchor.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        group.getChildren().addAll(anchor);
        anchor.setPadding(new Insets(5, 5, 5, 5));
        return anchor;
    }

    private void misc(MouseEvent e, int i) {

        db.close();
        Payment.setType();

        if (i == 6) {

            contoller.selectRoot(e, 0);
        } else {
            contoller.selectRoot(e, i - 1);
        }

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

    private void logOut(MouseEvent event) {

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage stage = new Stage();

        Login login = new Login();

        try {
            currentStage.close();
            login.start(stage);
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    private void staff(MouseEvent event) {

        try {
            Login login = new Login();

            login.getFXMLLoader();
        } catch (IOException ex) {
            Logger.getLogger(topBar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
