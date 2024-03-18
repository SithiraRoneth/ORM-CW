/* Created By Sithira Roneth
 * Date :3/5/24
 * Time :11:50
 * Project Name :ORM
 * */
package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.UserBO;

import java.io.IOException;

public class SettingController {
    @FXML
    private AnchorPane rootNode;

    @FXML
    private JFXTextField txtNew;

    @FXML
    private JFXTextField txtPw;

    @FXML
    private JFXTextField txtRe;

    UserBO userBO = (UserBO) BOFactory.getFactory().getBO(BOFactory.BOTypes.USER);

    @FXML
    void saveOnAction(ActionEvent event) {
        if (txtPw.equals(txtPw)) {
            if (txtNew.getText().equals(txtRe.getText())) {
               new Alert(Alert.AlertType.CONFIRMATION,"Password change successfully").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Credential not match").show();
            }
        }
   }

    @FXML
    void HomePage(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/dash-board.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }
}
