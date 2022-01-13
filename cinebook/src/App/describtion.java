package App;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class describtion {

    private GridPane pane = new GridPane();

    private Label title = new Label();
    private Label describtion = new Label();
    private Button button = new Button();

    public Node placeHolder() {

        title.setText("Placeholder");

        title.setStyle("-fx-font-size: 40");
        // pane.setStyle("-fx-alignment: center-left ");
        pane.prefHeightProperty().bind(Main.scene.heightProperty());

        describtion.setText(
                "Quis duis minim duis veniam ea ex commodo nisi voluptate ad. Lorem sint sint magna Lorem ea est occaecat duis aute nostrud pariatur reprehenderit. Eu cupidatat occaecat velit excepteur aliquip irure in labore pariatur nisi voluptate. Fugiat non deserunt adipisicing id labore deserunt ipsum irure enim esse ex magna. Tempor cupidatat et ea officia non irure minim veniam Lorem Lorem magna nostrud. Non duis culpa et amet incididunt ipsum ipsum consectetur. Est consequat amet ex cillum aliquip ea Lorem.");

        pane.add(title, 0, 0);
        pane.add(describtion, 0, 2);

        return pane;

    }

}
