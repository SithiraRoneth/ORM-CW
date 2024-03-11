/* Created By Sithira Roneth
 * Date :3/5/24
 * Time :11:53
 * Project Name :ORM
 * */
package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerController {
    @FXML
    private JFXTextField NIc;

    @FXML
    private JFXTextField address;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colNIC;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private JFXTextField contact;

    @FXML
    private JFXTextField cus_id;

    @FXML
    private JFXTextField name;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TableView<?> tblCustomer;


    @FXML
    void HomePage(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/dash-board.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    @FXML
    void deleteOnAction(ActionEvent event) {

    }

    @FXML
    void saveOnAction(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }

}
