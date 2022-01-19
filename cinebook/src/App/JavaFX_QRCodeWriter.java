/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import SendEmail.SendEmail;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFX_QRCodeWriter {

    private VBox pane = new VBox();
    private Button button = new Button();
    private Label label = new Label("Scan Qr With Your E-Wallet");
    private Label second = new Label("Please Wait...  30 seconds");

    private contoller contoller = new App.contoller();

    public Parent placeHolder() {

        double price = Payment.getSum();

        // qr generator
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = String.format("Transaction Successful! RM%.2f Has been deducted from your E-wallet", price);
        int width = 300;
        int height = 300;
        String fileType = "png";

        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();

            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }

            System.out.println("Success...");

        } catch (WriterException ex) {
            Logger.getLogger(JavaFX_QRCodeWriter.class.getName()).log(Level.SEVERE, null, ex);
        }

        // qr imageview
        ImageView qrView = new ImageView();
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));

        label.setStyle("-fx-font-size: 36;-fx-text-fill: white");
        second.setStyle("-fx-font-size: 24;-fx-text-fill: white");

        buttonTimer(button, second);
        button.setText("Proceed");
        button.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> buttonTask(e));

        pane.getChildren().addAll(label, qrView, second, button);
        pane.prefHeightProperty().bind(Main.scene.heightProperty());
        pane.setAlignment(Pos.CENTER);

        pane.setSpacing(50);

        return pane;

    }

    private Integer count = 0;

    private void buttonTask(MouseEvent e) {

        SendEmail sendEmail = new SendEmail();

        Button b = new Button();

        b.setText("Sending Email...");
        pane.getChildren().set(3, b);
        count = 5;
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {

            count--;

            if (count <= 0) {

                sendEmail.sendEmail();

                contoller.selectRoot(e, 0);

                return;
            }
        }));
        timeline.setCycleCount(5);
        timeline.play();

    }

    private void buttonTimer(Button b, Label sec) {

        b.setDisable(true);
        count = 30;
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {

            count--;

            sec.setText("Please Wait...  " + count.toString() + " seconds");
            if (count <= 0) {

                sec.setText("Please click button below and check your email.");
                b.setDisable(false);

                return;
            }
        }));
        timeline.setCycleCount(30);
        timeline.play();
    }

}
