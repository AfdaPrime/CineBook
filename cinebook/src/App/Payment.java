/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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

/**
 *
 * @author iwana
 */
public class Payment {

    public Parent placeHolder() {
        return new Label("Payment");
    }

    public double ticketPrice;
    public double fnbPrice;
    public double sum;
    public int ticketNumber;
    public int fnbNumber;

    public double Payment(double ticketPrice, double fnbPrice, int ticketNumber, int fnbNumber) {

        this.ticketPrice = ticketPrice;
        this.fnbPrice = fnbPrice;
        this.ticketNumber = ticketNumber;
        this.fnbNumber = fnbNumber;

        this.sum = (this.ticketPrice * this.ticketNumber) + (this.fnbPrice * this.fnbNumber);

        return this.sum;

    }

}
