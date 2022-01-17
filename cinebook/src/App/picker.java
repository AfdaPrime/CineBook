package App;

import Database.dataBase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class picker {

    public Parent placeHolder() {
        FlowPane flow = new FlowPane();

        contoller contoller = new App.contoller();

        try {

            dataBase db = new dataBase();

            ResultSet movie = db.movie();
            // flow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            flow.getStyleClass().add("bg-1");
            // for (Integer i = 0; i < 3; i++) {
            //
            // InputStream stream;
            //
            // try {
            // stream = new FileInputStream(
            // "D:\\newCode\\university\\FundamentalOfProgramming\\assigment\\CineBook\\cinebook\\src\\Image\\Spider-Man_No_Way_Home_poster.jpg");
            // Image image = new Image(stream);
            // ImageView imageView = new ImageView();
            // imageView.setImage(image);
            //
            // VBox anchor = new VBox();
            // Label label = new Label();
            //
            // anchor.getStyleClass().add("background_selector");
            // // anchor.setBorder(Border);
            // label.setText("SpiderMan: No way home Season 2
            // hdsuendosnsifdrndsofaoisekfnseiofsenkfhse9fjlkxcp-");
            // label.getStyleClass().add("label");
            // label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            //
            // label.setPadding(new Insets(5));
            //
            // anchor.getChildren().addAll(imageView, label);
            // anchor.setPrefWidth(200);
            // anchor.setId(i.toString());
            // flow.getChildren().add(anchor);
            //
            // anchor.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> contoller.selectRoot(e,
            // 1));
            //
            // } catch (FileNotFoundException e1) {
            // // TODO Auto-generated catch block
            // e1.printStackTrace();
            // }
            // }
            Integer i = 0;
            while (movie.next()) {

                try {
                    InputStream stream = new FileInputStream(
                            "D:\\newCode\\university\\FundamentalOfProgramming\\assigment\\CineBook\\cinebook\\src\\Image\\Spider-Man_No_Way_Home_poster.jpg");
                    Image image = new Image(stream);
                    ImageView imageView = new ImageView();
                    imageView.setImage(image);

                    VBox anchor = new VBox();
                    Label label = new Label();

                    anchor.getStyleClass().add("background_selector");
                    // anchor.setBorder(Border);
                    label.setText(movie.getString("MOVIES_NAME"));
                    label.getStyleClass().add("label");
                    label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

                    label.setPadding(new Insets(5));

                    anchor.getChildren().addAll(imageView, label);
                    anchor.setPrefWidth(200);
                    anchor.setId(i.toString());
                    flow.getChildren().add(anchor);

                    anchor.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> contoller.selectRoot(e, 1));

                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                i++;
            }

            movie.close();

        } catch (SQLException ex) {
            Logger.getLogger(picker.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        return flow;
    }

}
