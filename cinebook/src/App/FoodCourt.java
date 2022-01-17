package App;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javafx.geometry.Insets;
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

    private contoller contoller = new App.contoller();

    public Parent placeHolder() {

        FlowPane flow = new FlowPane();

        for (int i = 0; i < 5; i++) {

            try {
                InputStream stream = new FileInputStream(
                        "D:\\newCode\\university\\FundamentalOfProgramming\\assigment\\CineBook\\cinebook\\src\\Image\\Spider-Man_No_Way_Home_poster.jpg");
                Image image = new Image(stream);
                ImageView imageView = new ImageView();
                imageView.setImage(image);

                VBox anchor = new VBox();

                // anchor.setStyle("-fx-border-width: 50px");
                // anchor.setStyle("-fx-border-color: rgb(201, 172, 9)");

                anchor.getChildren().addAll(imageView, createPricePlaceholder(i), createPlaceholder(i));
                // flow.setPadding(new Insets(10));

                flow.getChildren().add(anchor);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        // flow.setStyle(" -fx-background-color: #fdcf00;");

        flow.setAlignment(Pos.CENTER);

        flow.setHgap(50);

        Button b = new Button("Next");

        pane.setAlignment(Pos.CENTER);
        b.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> check(e, flow));

        pane.setSpacing(20);
        pane.getChildren().addAll(flow, b);
        pane.prefHeightProperty().bind(Main.scene.heightProperty());

        return pane;

    }

    private Node createPricePlaceholder(int i) {

        HBox priceBox = new HBox();
        Label label = new Label();

        String price = "";

        switch (i) {
            case 0:
                price += "Regular Combo :\n 1X Caramel Popcorn Regular, 1X Soft Drink Regular\nRM 14.00";
                break;
            case 1:
                price += "Large Combo :\n 1X Caramel Popcorn Large, 1X  Soft Drink Large      \nRM 18.00";
                break;
            case 2:
                price += "Chicken Hotdog Combo :\n 1X Chicken Hotdog, 1X Soft Drink           \nRM 13.00";
                break;
            case 3:
                price += "Beef Hotdog Combo :\n 1X Beef Hotdog, 1X Soft Drink                 \nRM 13.00";
                break;
            case 4:
                price += "Nugget Combo :\n 1X Nugget Large, 1X Soft Drink                     \nRM 16.50";
                break;
            default:
                break;
        }

        label.setText(price);
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-font-size: 18px");
        label.setPrefWidth(250);
        label.setWrapText(true);
        
        priceBox.setStyle("-fx-background-color: red");
        priceBox.getChildren().add(label);
        priceBox.setAlignment(Pos.CENTER);

        return priceBox;

    }

    private Node createPlaceholder(Integer i) {
        HBox placeholder = new HBox();

        Button plus = new Button("+");
        Button minus = new Button("-");
        Label label = new Label("0");

        // label.setId(i.toString());

        placeholder.setPadding(new Insets(5));
        placeholder.setStyle(" -fx-background-color: red");
        placeholder.getChildren().addAll(plus, minus, label);

        placeholder.setSpacing(10);

        placeholder.setId(i.toString());

        placeholder.setAlignment(Pos.CENTER);

        plus.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> placeholder.getChildren().set(2, changeLabel(e, placeholder.getChildren().get(2))));

        minus.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> placeholder.getChildren().set(2, changeLabel(e, placeholder.getChildren().get(2))));
        return placeholder;

    }

    private Node changeLabel(MouseEvent e, Node total) {

        // System.out.println(total);

        int begin = total.toString().indexOf("'");
        int end = total.toString().lastIndexOf("'");

        String labelTotal = total.toString().substring(begin + 1, end);

        Integer x = Integer.parseInt(labelTotal);

        Label label = new Label();

        if ((e.getSource().toString()).contains("+")) {

            x += 1;
            label.setText(x.toString());
            label.setId(total.getId());
            return label;
        } else if ((e.getSource().toString()).contains("-") && x == 0) {
            return new Label("0");
        } else if ((e.getSource().toString()).contains("-")) {
            x -= 1;
            label.setText(x.toString());
            label.setId(total.getId());
            return label;
        } else
            return new Label("0");
    }

    private void check(MouseEvent e, FlowPane flow) {

        for (int i = 0; i < flow.getChildren().size(); i++) {

            VBox tmp = (VBox) flow.getChildren().get(i);

            HBox temphbox = (HBox) tmp.getChildren().get(2);

            String total = temphbox.getChildren().get(2).toString();

            int begin = total.toString().indexOf("'");
            int end = total.toString().lastIndexOf("'");

            String labelTotal = total.toString().substring(begin + 1, end);

            Integer x = Integer.parseInt(labelTotal);

            Payment.setType(Integer.parseInt(temphbox.getId()), x);
        }

        contoller.selectRoot(e, 5);
    }

}
