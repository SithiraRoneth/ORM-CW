/* Created By Sithira Roneth
 * Date :3/13/24
 * Time :10:40
 * Project Name :ORM
 * */
package lk.ijse.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class User_Stock_Controller {
    @FXML
    private ImageView home;

    @FXML
    private AnchorPane rootNode;

    @FXML
    void navigate(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/user-dash.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

}

