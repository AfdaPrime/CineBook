package App;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import SendEmail.SendEmail;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class seat {

    private contoller contoller = new App.contoller();

    private VBox pane = new VBox();
    private Label seat = new Label(" ");
    private Label price = new Label("RM 0");

    private Button screen = new Button("Screen");

    public Node placeHolder() {
        GridPane grid = new GridPane();
        Button confirm = new Button("Confirm");

        confirm.setDisable(true);

        for (int i = 0; i < 18; i++) {
            if (i == 2 || i == 3 || i == 14 || i == 15) {
                continue;
            }
            for (int j = 0; j < 8; j++) {

                Button b = new Button(j + "|" + i);

                b.getStyleClass().add("buttonSeat-x");
                b.setPrefWidth(50);
                grid.add(b, i, j, 2, 1);
                b.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> collectLabel(e, confirm));
            }
        }

        confirm.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> contoller.selectRoot(e, 4));
        // label.setStyle("-fx-background-color: #fdcf00;");

        seat.setPrefHeight(40);

        price.setStyle("-fx-font-size: 24px");

        screen.setPrefHeight(40);
        screen.setPrefWidth(500);

        // pane.getChildren().add(screen);
        pane.getChildren().add(grid);
        pane.getChildren().add(seat);
        pane.getChildren().add(price);
        pane.getChildren().add(confirm);

        grid.setHgap(60);
        grid.setVgap(10);

        grid.setStyle("-fx-background-color: red");
        pane.setStyle("-fx-alignment: center");

        pane.setSpacing(10);

        pane.prefHeightProperty().bind(Main.scene.heightProperty());

        grid.setPadding(new Insets(10));

        grid.setAlignment(Pos.CENTER);

        return pane;
    }

    private String updateText = "";
    private Integer priceTotal = 0;
    private int totalSeat = 0;

    private void collectLabel(MouseEvent e, Button confirm) {

        Label seat = new Label();
        Label price = new Label();
        Button b = (Button) e.getSource();
        Button source = (Button) e.getSource();

        String newCode = new String();

        seat.setStyle("-fx-font-size: 18px");
        seat.setPrefHeight(40);

        price.setStyle("-fx-font-size: 24px");

        // change button colour when press
        if (b.getStyleClass().toString().equals("button buttonSeat-x")) {
            b.getStyleClass().set(1, "buttonSeat-v");

            totalSeat += 1;
            priceTotal += 20;
            price.setText("Rm " + priceTotal.toString());

            confirm.setDisable(false);

            updateText += source.getText() + "   ";

        } else {
            b.getStyleClass().set(1, "buttonSeat-x");

            totalSeat -= 1;
            priceTotal -= 20;
            price.setText("Rm " + priceTotal.toString());

            String[] msg = updateText.split(" ");

            for (String words : msg) {

                // If desired word is found
                if (!words.equals(source.getText())) {

                    // Concat the word not equal to the given
                    // word
                    newCode += words + " ";
                }
            }

            updateText = newCode;

        }

        if (totalSeat == 0) {
            confirm.setDisable(true);
        }

        Payment.setTicketNumber(totalSeat);
        seat.setText(updateText);
        SendEmail.setSeat(updateText);
        pane.getChildren().set(1, seat);
        pane.getChildren().set(2, price);
    }

}
