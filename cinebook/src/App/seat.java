package App;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.dataBase;
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
    private Label seatLabel = new Label(" ");
    private Label price = new Label("RM 0");

    private static String movie = new String();
    private static String hall = new String();
    private static String branch = new String();

    private static String name = new String();
    private Button screen = new Button("Screen");

    public static void setSeatSelection(String movie, String hall, String branch) {

        seat.movie = movie;
        seat.hall = hall;
        seat.branch = branch;
    }

    public static void setName(String matricCustomer) {

        name = matricCustomer;

    }

    public Node placeHolder() {
        GridPane grid = new GridPane();
        Button confirm = new Button("Confirm");

        confirm.setDisable(true);

        dataBase db = new dataBase();

        ResultSet seatSet = db.seat();

        // seat
        try {

            while (seatSet.next()) {

                if (seatSet.getString("BRANCH").equals(branch) && seatSet.getString("HALL_NUMBER").equals(hall)) {

                    break;

                }

            }

            if (Integer.parseInt(hall) == 5 || Integer.parseInt(hall) == 6 || Integer.parseInt(hall) == 7
                    || Integer.parseInt(hall) == 8) {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 12; j++) {
                        if (j == 2 || j == 3 || j == 8 || j == 9) {
                            continue;
                        }

                        Button b = new Button(seatSet.getString("SEAT_NUMBER"));

                        if (seatSet.getString("SEAT_STATUS").equals("X")) {

                            b.setText("X");

                            b.setDisable(true);
                        } else if (seatSet.getString("SEAT_STATUS").equals("/")) {

                            b.setText("/");

                            b.setDisable(true);
                        }
                        b.getStyleClass().add("buttonSeat-x");

                        seatSet.next();

                        b.setPrefWidth(50);
                        grid.add(b, j, i, 2, 1);

                        // System.out.println(grid.);
                        b.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> collectLabel(e, confirm, "premium"));

                    }

                }
                // System.out.println(grid.getChildren().);
            } else {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 18; j++) {
                        if (j == 2 || j == 3 || j == 14 || j == 15) {
                            continue;
                        }

                        Button b = new Button(seatSet.getString("SEAT_NUMBER"));

                        if (seatSet.getString("SEAT_STATUS").equals("X")) {

                            b.setStyle("-fx-background-color: #fdcf00");

                            b.setText("X");

                            b.setDisable(true);
                        } else if (seatSet.getString("SEAT_STATUS").equals("/")) {
                            b.setStyle("-fx-background-color: #fdcf00");
                            b.setText("/");

                            b.setDisable(true);
                        }

                        seatSet.next();
                        b.getStyleClass().add("buttonSeat-x");
                        b.setPrefWidth(50);
                        grid.add(b, j, i, 2, 1);
                        b.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> collectLabel(e, confirm, "classic"));

                    }
                }
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        confirm.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> misc(e, db));
        // label.setStyle("-fx-background-color: #fdcf00;");

        seatLabel.setPrefHeight(40);

        price.setStyle("-fx-font-size: 24px");

        screen.setPrefHeight(40);
        screen.setPrefWidth(500);

        // pane.getChildren().add(screen);
        pane.getChildren().add(grid);
        pane.getChildren().add(seatLabel);
        pane.getChildren().add(price);
        pane.getChildren().add(confirm);

        grid.setHgap(60);
        grid.setVgap(10);

        // grid.setStyle("-fx-background-color: red");
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

    private void collectLabel(MouseEvent e, Button confirm, String state) {

        int priceInfo = 0;

        Label seat = new Label();
        Label price = new Label();
        Button b = (Button) e.getSource();
        Button source = (Button) e.getSource();

        String newCode = new String();

        seat.setStyle("-fx-font-size: 18px;-fx-text-fill: white");
        seat.setPrefHeight(40);

        price.setStyle("-fx-font-size: 24px;-fx-text-fill: white");

        if (state.equals("premium")) {

            priceInfo = 100;

        } else {

            if (name != null) {
                priceInfo = 11;
            } else {
                priceInfo = 14;
            }

        }

        // change button colour when press
        if (b.getStyleClass().toString().equals("button buttonSeat-x")) {
            b.getStyleClass().set(1, "buttonSeat-v");

            totalSeat += 1;
            priceTotal += priceInfo;
            price.setText("Rm " + priceTotal.toString());

            confirm.setDisable(false);

            updateText += source.getText() + "   ";

        } else {
            b.getStyleClass().set(1, "buttonSeat-x");

            totalSeat -= 1;
            priceTotal -= priceInfo;
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
        if (Integer.parseInt(hall) == 5 || Integer.parseInt(hall) == 6 || Integer.parseInt(hall) == 7
                || Integer.parseInt(hall) == 8) {

            Payment.setTicketNumber(totalSeat, "premium");
        } else {

            Payment.setTicketNumber(totalSeat, "classic");
        }
        seat.setText(updateText);
        Payment.setSeat(updateText);
        SendEmail.setSeat(updateText);
        pane.getChildren().set(1, seat);
        pane.getChildren().set(2, price);
    }

    private void misc(MouseEvent e, dataBase db) {

        db.close();
        contoller.selectRoot(e, 4);
    }

}
