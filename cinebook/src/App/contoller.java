package App;

import javafx.scene.control.ScrollPane;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.VBox;

public class contoller {

    // static Node x = picker.placeHolder();

    // root = new VBox();
    VBox box = new VBox();
    ScrollPane sPane = new ScrollPane();
    // App.topBar topBar = new topBar();

    // dateSelector dateSelector = new App.dateSelector();

    public void selectRoot(MouseEvent e) {

        try {

            // System.out.println(e);
            // root.getChildren().clear();
            box.getChildren().add(dateSelector.placeHolder());

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
