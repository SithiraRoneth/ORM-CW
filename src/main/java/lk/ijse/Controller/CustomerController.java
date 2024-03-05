/* Created By Sithira Roneth
 * Date :3/5/24
 * Time :11:53
 * Project Name :ORM
 * */
package lk.ijse.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerController {
    @FXML
    private AnchorPane rootNode;

    @FXML
    void HomePage(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/dash-board.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }
}
