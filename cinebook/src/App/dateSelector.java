package App;

import Database.dataBase;
import SendEmail.SendEmail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public Parent placeHolder(int id) {

        try {
            HBox hbox = new HBox();

            dataBase db = new dataBase();

            ResultSet movie = db.movie();

            movie.absolute(id + 1);

            String movieName = movie.getString("MOVIES_NAME");

            System.out.println(movieName);

            db.close();

            dataBase db1 = new dataBase();

            ResultSet date = db1.date(movieName);

//            while (date.next()) {
//
//                if (date.getString("MOVIES_NAME").equals(movieName)) {
//
//                    System.out.println(date.getString("MOVIES_NAME"));
//                    System.out.println(date.getString("BRANCH"));
//                    System.out.println(date.getString("TIME"));
//                }
//            }
            HashSet<String> day = new HashSet<>();
            HashSet<String> branch = new HashSet<>();

            while (date.next()) {

                if (date.getString("MOVIES_NAME").equals(movieName)) {

                    day.add(date.getString("DATE"));
                    branch.add(date.getString("BRANCH"));
                }

            }

            Object[] movieDate = day.toArray();

            //for day
            Integer dateId = 0;
            for (String i : day) {

                System.out.println(i);

                Button button = new Button(i);
                button.setId(dateId.toString());
                button.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> changeLabel(e, date, movieName, movieDate, branch));

                hbox.getChildren().add(button);
                dateId++;
            }

            hbox.setPadding(new Insets(10));

            hbox.setStyle("-fx-spacing:10");

            hbox.setAlignment(Pos.CENTER);

            vPane.getChildren().add(hbox);

            //for location
            for (String b : branch) {

                System.out.println(b);

                TitledPane titlePane = new TitledPane();
                GridPane datePane = createdatePane(date, movieName, movieDate[0], b);
                titlePane.setContent(datePane);
                titlePane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                titlePane.setText(b);

                vPane.getChildren().add(titlePane);

            }

//            for (int i = 0; i < 5; i++) {
//
//                
//
//            }
         
        } catch (SQLException ex) {
            Logger.getLogger(dateSelector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vPane;
    }

    private void changeLabel(MouseEvent e, ResultSet date, String movieName, Object[] movieDate, HashSet<String> branch) {

        Button source = (Button) e.getSource();
        System.out.println(source.getId());

        int place = 1;

        for (String b : branch) {

            System.out.println(b);

            TitledPane titlePane = new TitledPane();
            GridPane datePane = createdatePane(date, movieName, movieDate[Integer.parseInt(source.getId())], b);
            titlePane.setContent(datePane);
            titlePane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            titlePane.setText(b);

            vPane.getChildren().set(place, titlePane);
            place++;

        }

    }

    private GridPane createdatePane(ResultSet date, String movieName, Object day, String branch) {
        GridPane datePane = new GridPane();

        try {

            datePane.setPadding(new Insets(5));
            datePane.setHgap(5);
            datePane.setVgap(5);
            datePane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

            datePane.setAlignment(Pos.CENTER);
            FlowPane flowPane = new FlowPane();

            //for time/hall
            date.first();
            while (date.next()) {

                if (date.getString("MOVIES_NAME").equals(movieName) && date.getString("BRANCH").equals(branch) && date.getString("DATE").equals(day.toString())) {
                    Pane pane = new Pane();
                    String timeText = date.getString("TIME");
                    Label time = new Label(timeText);
                    String hallText = date.getString("MOVIES_HALL");
                    Label hall = new Label("Hall " + hallText);

                    time.getStyleClass().add("dateLabel");
                    time.layoutXProperty().bind(pane.widthProperty().subtract(time.widthProperty()).divide(2));
                    time.layoutYProperty().bind(pane.heightProperty().subtract(time.heightProperty()).divide(2));

                    hall.getStyleClass().add("dateLabel");
                    hall.layoutXProperty().bind(pane.widthProperty().subtract(hall.widthProperty()).divide(2));

                    pane.getChildren().addAll(time, hall);

                    if (hallText.equals("5") || hallText.equals("6") || hallText.equals("7") || hallText.equals("8")) {
                        pane.getStyleClass().add("datePanePremium");
                    } else {
                        pane.getStyleClass().add("datePane");
                    }

                    pane.setPrefWidth(200);
                    pane.setPrefHeight(200);

                    pane.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> misc(e,date,timeText,hallText,movieName,branch,day));

                    flowPane.getChildren().add(pane);
                }

            }

//            FlowPane flowPane = new FlowPane();
//            for (int j = 0; j < 10; j++) {
//                Pane pane = new Pane();
//                Label label = new Label("2/12");
//
//                label.getStyleClass().add("dateLabel");
//                label.layoutXProperty().bind(pane.widthProperty().subtract(label.widthProperty()).divide(2));
//                label.layoutYProperty().bind(pane.heightProperty().subtract(label.heightProperty()).divide(2));
//
//                pane.getChildren().add(label);
//
//                pane.getStyleClass().add("datePane");
//                pane.setPrefWidth(200);
//                pane.setPrefHeight(200);
//
//                pane.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> contoller.selectRoot(e, 3));
//
//                flowPane.getChildren().add(pane);
//            }
            flowPane.getStyleClass().add("bg-1");

            flowPane.prefWidthProperty().bind(datePane.widthProperty());

            datePane.getChildren().add(flowPane);

        } catch (SQLException ex) {
            Logger.getLogger(dateSelector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datePane;
    }
    
    private void misc(MouseEvent e,ResultSet date,String time,String hall,String movieName,String branch,Object day){
        
        try {
            date.close();
            SendEmail email = new SendEmail();
            
            email.setMovie(day.toString(),movieName,time,branch,hall);
            
            contoller.selectRoot(e, 3);
        } catch (SQLException ex) {
            Logger.getLogger(dateSelector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
