/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import Database.dataBase;
import SendEmail.SendEmail;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
    private static String state = new String();

    private static String name = new String();

    private contoller contoller = new App.contoller();

    public static double getSum() {
        return sum;
    }

    public static void setType() {

        fnb = new ArrayList<>();

    }

    public static void setName(String matricCustomer) {

        name = matricCustomer;

    }

    public static void setType(int type, int quantity) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(type);
        list.add(quantity);

        fnb.add(list);

    }

    public static void setTicketNumber(int ticketNumber, String state) {
        Payment.ticketNumber = ticketNumber;
        Payment.state = state;
    }

    private Label movie = new Label();
    private VBox pane = new VBox();
    private VBox placeHolder = new VBox();
    private Button button = new Button("Pay");

    private static String seat;

    public static void setSeat(String seat) {

        Payment.seat = seat;
    }

    private dataBase db = new dataBase();

    public Parent placeHolder() {

        ResultSet movieSet = db.movie();

        System.out.println(name);

        try {
            while (movieSet.next()) {

                if (name != null) {

                    Payment.ticketPrice = 11;

                } else {

                    Payment.ticketPrice = 14;

                }

                if (state.equals("premium")) {
                    Payment.ticketPrice = 100;
                }

            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        String recipt = "";
        String fnbType = "";

        recipt += "Seat     X        " + Payment.ticketNumber + "\t\t\t\t\t" + "RM "
                + (Payment.ticketNumber * Payment.ticketPrice)
                + "\n";

        this.sum += (Payment.ticketNumber * Payment.ticketPrice);

        for (int i = 0; i < fnb.size(); i++) {

            String type = "";
            double price = 0;

            if (fnb.get(i).get(1) != 0) {

                switch (fnb.get(i).get(0)) {
                    case 0:
                        type = "Regular Combo            ";
                        price = 14.0;
                        break;
                    case 1:
                        type = "Large Combo              ";
                        price = 18.00;
                        break;
                    case 2:
                        type = "Chicken Hotdog Combo";
                        price = 13.00;
                        break;
                    case 3:
                        type = "Beef Hotdog Combo        ";
                        price = 13.00;
                        break;
                    case 4:
                        type = "Nugget Combo             ";
                        price = 16.50;
                        break;
                    default:
                        break;
                }

                this.sum += (price * fnb.get(i).get(1));

                fnbType += type + " ";
                recipt += type + "  X" + fnb.get(i).get(1) + "\t\t\t" + "RM "
                        + String.format("%.2f", (price * fnb.get(i).get(1)))
                        + "\n";

            }

        }

        recipt += "----------------------------------------------------\n";
        recipt += "Total:  \t\t\t\t\t             " + "RM " + String.format("%.2f", this.sum);

        SendEmail.setFnbPlace(fnbType);
        movie.setText(recipt);

        placeHolder.getChildren().add(movie);

        movie.setPrefHeight(300);
        movie.setPrefWidth(500);
        movie.getStyleClass().add("payment");

        // placeHolder.setStyle("-fx-background-color: red");
        placeHolder.setAlignment(Pos.CENTER);

        button.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> misc(e));

        pane.setSpacing(10);
        pane.getChildren().addAll(placeHolder, button);
        pane.prefHeightProperty().bind(Main.scene.heightProperty());
        pane.setAlignment(Pos.CENTER);

        return pane;
    }

    private void misc(MouseEvent e) {

        db.close();
        contoller.selectRoot(e, 6);

    }

}
