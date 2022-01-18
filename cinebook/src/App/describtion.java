package App;

import Database.dataBase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.ModuleLayer.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class describtion {

    private HBox pane = new HBox();

    private VBox vbox = new VBox();

    private Label title = new Label();
    private Label describtion = new Label();
    private Label cast = new Label();
    private Button button = new Button("Book Now");

    // public Node placeHolder() {
    //
    // contoller contoller = new App.contoller();
    //
    // try {
    // InputStream stream = new FileInputStream(
    // "D:/newCode/university/FundamentalOfProgramming/assigment/CineBook/cinebook/src/App/Spider-Man_No_Way_Home_poster.jpg");
    // Image image = new Image(stream);
    // ImageView imageView = new ImageView();
    // imageView.setImage(image);
    //
    // imageView.setPreserveRatio(true);
    // imageView.setFitHeight(500);
    //
    // title.setText("Spodemun no way home");
    //
    // describtion.setText(
    // "Esse veniam velit deserunt laboris. Minim nulla ipsum qui voluptate quis
    // anim excepteur elit irure. Cupidatat dolore nostrud incididunt incididunt
    // incididunt exercitation. Magna exercitation laborum amet cillum est
    // tempor.Qui nostrud culpa eu pariatur et do veniam. Aliquip eu est id nostrud
    // et reprehenderit ad. Ea reprehenderit esse non culpa et pariatur qui. Nulla
    // sunt voluptate Lorem veniam anim. Ut proident dolor aliquip consequat Lorem
    // officia id aliqua quis Lorem. Sit reprehenderit nulla Lorem est dolor cillum
    // do. Velit cillum nisi duis exercitation reprehenderit sit aliqua duis
    // cupidatat culpa ut.");
    //
    // // describtion.setMaxSize(500, 150);
    //
    // vbox.getChildren().addAll(title, describtion, button);
    //
    // title.setStyle("-fx-font-size: 64");
    // describtion.setStyle("-fx-font-size: 18");
    //
    // // describtion.setPrefHeight(500);
    // describtion.setPrefWidth(1000);
    // describtion.setWrapText(true);
    //
    // vbox.setSpacing(50);
    //
    // button.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> contoller.selectRoot(e,
    // 3));
    //
    // title.setPadding(new Insets(100, 100, 0, 0));
    // describtion.setPadding(new Insets(10, 100, 0, 0));
    //
    // // vbox.setAlignment(Pos.CENTER);
    //
    // pane.setAlignment(Pos.CENTER);
    //
    // vbox.prefHeightProperty().bind(Main.scene.heightProperty());
    // // pane.prefWidthProperty().bind(Main.scene.widthProperty());
    //
    // pane.getChildren().addAll(vbox, imageView);
    // } catch (FileNotFoundException e) {
    // e.printStackTrace();
    // }
    //
    // return pane;
    //
    // }
    public Node placeHolder(int id) {

        dataBase db = new dataBase();

        topBar.db = db;

        try (ResultSet movie = db.movie()) {

            System.out.println(movie.absolute(id + 1));
            contoller contoller = new App.contoller();

            Image image = new Image(movie.getBinaryStream("MOVIES_PIC"));
            ImageView imageView = new ImageView();
            imageView.setImage(image);

            imageView.setPreserveRatio(true);
            imageView.setFitHeight(500);

            title.setText(movie.getString("MOVIES_NAME"));

            describtion.setText(movie.getString("MOVIES_DESCRIPTION"));

            cast.setText(movie.getString("MOVIES_CAST"));

            vbox.getChildren().addAll(title, describtion, cast, button);

            title.setStyle("-fx-font-size: 64;-fx-text-fill: white");
            describtion.setStyle("-fx-font-size: 18;-fx-text-fill: white");
            cast.setStyle("-fx-text-fill: white");

            // describtion.setPrefHeight(500);
            describtion.setPrefWidth(1000);
            describtion.setWrapText(true);

            vbox.setSpacing(50);

            button.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> contoller.selectRoot(e, 2));

            title.setPadding(new Insets(100, 100, 0, 0));
            describtion.setPadding(new Insets(10, 100, 0, 0));

            // vbox.setAlignment(Pos.CENTER);
            pane.setAlignment(Pos.CENTER);

            vbox.prefHeightProperty().bind(Main.scene.heightProperty());
            // pane.prefWidthProperty().bind(Main.scene.widthProperty());

            pane.getChildren().addAll(vbox, imageView);

        } catch (SQLException ex) {
            Logger.getLogger(describtion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pane;
    }

}
