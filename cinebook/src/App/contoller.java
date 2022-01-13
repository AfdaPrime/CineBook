package App;

import javafx.css.Styleable;
import javafx.scene.control.ScrollPane;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class contoller {

    // static Node x = picker.placeHolder();

    // root = new VBox();
    VBox box = new VBox();
    ScrollPane sPane = new ScrollPane();
    App.topBar topBar = null;

    public void selectRoot(MouseEvent e, int i) {

        try {

            // root.getChildren().clear();

            switch (i) {
                case 0:
                    Main.root.getChildren().set(0, new topBar().bar(i));
                    box.getChildren().add(new picker().placeHolder());
                    break;
                case 1:
                    if (e.getSource().toString().contains("VBox")) {

                        Main.root.getChildren().set(0, new topBar().bar(i));
                        VBox source = (VBox) e.getSource();

                        System.out.println((source.getId()));
                        box.getChildren().add(new dateSelector().placeHolder());
                        break;
                    } else {
                        Main.root.getChildren().set(0, new topBar().bar(i));
                        box.getChildren().add(new dateSelector().placeHolder());
                        break;
                    }

                case 2:
                    Main.root.getChildren().set(0, new topBar().bar(i));
                    box.getChildren().add(new describtion().placeHolder());
                    break;
                case 3:
                    Main.root.getChildren().set(0, new topBar().bar(i));
                    box.getChildren().add(new seat().placeHolder());
                    break;
                case 4:
                    Main.root.getChildren().set(0, new topBar().bar(i));
                    box.getChildren().add(new FoodCourt().placeHolder());
                    break;
                case 5:
                    Main.root.getChildren().set(0, new topBar().bar(i));
                    box.getChildren().add(new payment().placeHolder());
                    break;
                default:
                    break;
            }

            box.getStyleClass().add("bg-3");

            sPane.setContent(box);
            sPane.setFitToWidth(true);
            sPane.setFitToHeight(true);

            // topBar.bar().setId("heelo");

            // root.getChildren().add(topBar.bar());
            // root.getChildren().addAll(topBar.bar(), sPane);
            Main.root.getChildren().set(1, sPane);
            // ((Node) e.getSource()).getScene().setRoot(Main.root);

        } catch (Exception error) {
            error.printStackTrace();
        }

    }

}
