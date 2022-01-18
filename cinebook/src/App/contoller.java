package App;

import Database.dataBase;
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

    private static Integer id = 0;

    public void selectRoot(MouseEvent e, int i) {

        try {

            // root.getChildren().clear();
            switch (i) {
                case 0:
                    Main.root.getChildren().set(0, new topBar().bar(i, Main.staff));
                    box.getChildren().add(new picker().placeHolder());
                    break;

                case 1:
                    if (e.getSource().toString().contains("VBox")) {
                        VBox source = (VBox) e.getSource();
                        this.id = Integer.parseInt(source.getId());
                        System.out.println(id);
                    }
                    Main.root.getChildren().set(0, new topBar().bar(i, Main.staff));
                    box.getChildren().add(new describtion().placeHolder(this.id));
                    break;
                case 2:

                    Main.root.getChildren().set(0, new topBar().bar(i, Main.staff));

                    box.getChildren().add(new dateSelector().placeHolder(id));
                    break;

                case 3:
                    Main.root.getChildren().set(0, new topBar().bar(i, Main.staff));
                    box.getChildren().add(new seat().placeHolder());
                    break;
                case 4:
                    Main.root.getChildren().set(0, new topBar().bar(i, Main.staff));
                    box.getChildren().add(new FoodCourt().placeHolder());
                    break;
                case 5:
                    Main.root.getChildren().set(0, new topBar().bar(i, Main.staff));
                    box.getChildren().add(new Payment().placeHolder());
                    break;
                case 6:
                    Main.root.getChildren().set(0, new topBar().bar(i, Main.staff));
                    box.getChildren().add(new JavaFX_QRCodeWriter().placeHolder());
                    break;
                default:
                    break;
            }

            box.getStyleClass().add("bg-3");

            sPane.setContent(box);
            sPane.setFitToWidth(true);
            sPane.setFitToHeight(true);

            Main.root.getChildren().set(1, sPane);

        } catch (Exception error) {
            error.printStackTrace();
        }

    }

}
