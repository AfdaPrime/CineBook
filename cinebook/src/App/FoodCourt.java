package App;

import java.sql.ResultSet;
import java.sql.SQLException;

import Database.dataBase;
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
import javafx.scene.layout.VBox;

public class FoodCourt {

    private VBox pane = new VBox();

    private contoller contoller = new App.contoller();

    public Parent placeHolder() {

        dataBase db = new dataBase();

        ResultSet food = db.food();

        FlowPane flow = new FlowPane();
        int i = 0;
        try {
            while (food.next()) {

                try {

                    Image image = new Image(food.getBinaryStream("FOOD_PIC"));
                    ImageView imageView = new ImageView();
                    imageView.setImage(image);

                    imageView.setPreserveRatio(true);
                    imageView.setFitHeight(250);

                    VBox anchor = new VBox();

                    anchor.getChildren().addAll(imageView, createPricePlaceholder(i), createPlaceholder(i));

                    flow.getChildren().add(anchor);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                i++;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        // flow.setStyle(" -fx-background-color: #fdcf00;");

        flow.setAlignment(Pos.CENTER);

        flow.setHgap(50);

        Button b = new Button("Next");

        pane.setAlignment(Pos.CENTER);
        b.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> check(e, flow, db));

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

        priceBox.setStyle("-fx-background-color: #ffd700");
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
        placeholder.setStyle(" -fx-background-color:  #ffd700");
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

    private void check(MouseEvent e, FlowPane flow, dataBase db) {

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
        db.close();
        contoller.selectRoot(e, 5);
    }

}
