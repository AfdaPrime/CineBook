/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import SendEmail.SendEmail;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author iwana
 */
public class Payment {

    private static double ticketPrice = 20;
    private static double fnbPrice = 0;
    private static ArrayList<ArrayList<Integer>> fnb = new ArrayList<>();
    private static double sum = 0;
    private static int ticketNumber = 0;

    private contoller contoller = new App.contoller();

    public static double getSum() {
        return sum;
    }

    public static void setType() {

        fnb = new ArrayList<>();

    }

    public static void setType(int type, int quantity) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(type);
        list.add(quantity);

        fnb.add(list);

    }

    public static void setTicketNumber(int ticketNumber) {
        Payment.ticketNumber = ticketNumber;
    }

    private Label movie = new Label();
    private VBox pane = new VBox();
    private VBox placeHolder = new VBox();
    private Button button = new Button("Pay");

    public Parent placeHolder() {

        String recipt = "";
        String fnbType = "";

        recipt += "Seat     X" + Payment.ticketNumber + "\t\t" + "RM " + (Payment.ticketNumber * Payment.ticketPrice)
                + "\n";

        this.sum += (Payment.ticketNumber * Payment.ticketPrice);

        for (int i = 0; i < fnb.size(); i++) {

            String type = "";
            double price = 0;

            if (fnb.get(i).get(1) != 0) {

                switch (fnb.get(i).get(0)) {
                    case 0:
                        type = "Combo A";
                        price = 50;
                        break;
                    case 1:
                        type = "Combo B";
                        price = 30.1;
                        break;
                    case 2:
                        type = "Popcorn";
                        price = 30.1;
                        break;
                    case 3:
                        type = "Nuget  ";
                        price = 3.01;
                        break;
                    case 4:
                        type = "Carrot ";
                        price = 0.01;
                        break;
                    default:
                        break;
                }

                this.sum += (price * fnb.get(i).get(1));

                fnbType += type + " ";
                recipt += type + "  X" + fnb.get(i).get(1) + "\t\t" + "RM "
                        + String.format("%.2f", (price * fnb.get(i).get(1)))
                        + "\n";

            }

        }

        recipt += "---------------------------------\n";
        recipt += "Total:  \t\t\t" + "RM " + String.format("%.2f", this.sum);

        SendEmail.setFnbPlace(fnbType);
        movie.setText(recipt);

        placeHolder.getChildren().add(movie);

        movie.setPrefHeight(300);
        movie.setPrefWidth(500);
        movie.getStyleClass().add("payment");

        // placeHolder.setStyle("-fx-background-color: red");
        placeHolder.setAlignment(Pos.CENTER);

        button.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> contoller.selectRoot(e, 6));

        pane.setSpacing(10);
        pane.getChildren().addAll(placeHolder, button);
        pane.prefHeightProperty().bind(Main.scene.heightProperty());
        pane.setAlignment(Pos.CENTER);

        return pane;
    }

}
