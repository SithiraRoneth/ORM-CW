/* Created By Sithira Roneth
 * Date :3/3/24
 * Time :23:14
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

public class DashBordController {

    @FXML
    private AnchorPane root;

    @FXML
    void BookPage(MouseEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/View/book.fxml"));
        Scene scene = new Scene(rootNode);
        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Book");
    }

    @FXML
    void CustomerPage(MouseEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/View/customer.fxml"));
        Scene scene = new Scene(rootNode);
        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Customer");
    }

    @FXML
    void TransactionPage(MouseEvent mouseEvent) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/View/transaction.fxml"));
        Scene scene = new Scene(rootNode);
        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Transaction");
    }
    @FXML
    void SettingPage(MouseEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/View/setting.fxml"));
        Scene scene = new Scene(rootNode);
        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Setting");
    }
}
