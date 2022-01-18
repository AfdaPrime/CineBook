package loginandsignup;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Database.dataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SetPaymentController implements Initializable {

    dataBase db = new dataBase();

    ResultSet movie = db.movie();

    @FXML
    private TextField classic;
    @FXML
    private TextField student;
    @FXML
    private TextField premium;
    @FXML
    private Label labelChange;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }

    @FXML
    private void returnButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StaffEditor.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void changeButton(ActionEvent event) {

        try {
            while (movie.next()) {

                movie.updateString("PRICE_CLASSIC", classic.getText());
                movie.updateString("PRICE_STUDENT", student.getText());
                movie.updateString("PRICE_PREMIUM", premium.getText());
                movie.updateRow();

                labelChange.setText("Prices have been updated");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
