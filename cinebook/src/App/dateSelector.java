package App;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class dateSelector {

    private VBox vPane = new VBox();

    contoller contoller = new App.contoller();

    public Parent placeHolder() {

        HBox hbox = new HBox();

        for (Integer i = 0; i < 7; i++) {

            Button button = new Button(i.toString());

            hbox.getChildren().add(button);
        }

        hbox.setPadding(new Insets(10));

        hbox.setStyle("-fx-spacing:10");

        hbox.setAlignment(Pos.CENTER);

        vPane.getChildren().add(hbox);

        for (int i = 0; i < 5; i++) {

            TitledPane titlePane = new TitledPane();
            GridPane datePane = createdatePane();
            titlePane.setContent(datePane);
            titlePane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            titlePane.setText("ZOUK");

            vPane.getChildren().add(titlePane);

        }
        return vPane;

    }

    private GridPane createdatePane() {

        GridPane datePane = new GridPane();

        datePane.setPadding(new Insets(5));
        datePane.setHgap(5);
        datePane.setVgap(5);
        datePane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        datePane.setAlignment(Pos.CENTER);

        for (int i = 0; i < 1; i++) {

            FlowPane flowPane = new FlowPane();
            for (int j = 0; j < 10; j++) {
                Pane pane = new Pane();
                Label label = new Label("2/12");

                label.getStyleClass().add("dateLabel");
                label.layoutXProperty().bind(pane.widthProperty().subtract(label.widthProperty()).divide(2));
                label.layoutYProperty().bind(pane.heightProperty().subtract(label.heightProperty()).divide(2));

                pane.getChildren().add(label);

                pane.getStyleClass().add("datePane");
                pane.setPrefWidth(200);
                pane.setPrefHeight(200);

                pane.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> contoller.selectRoot(e, 2));

                flowPane.getChildren().add(pane);
            }
            flowPane.getStyleClass().add("bg-1");

            flowPane.prefWidthProperty().bind(datePane.widthProperty());

            datePane.getChildren().add(flowPane);

        }

        return datePane;

    }

}