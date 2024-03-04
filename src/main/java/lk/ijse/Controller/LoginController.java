/* Created By Sithira Roneth
 * Date :3/3/24
 * Time :22:02
 * Project Name :ORM
 * */
package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.UserBO;
import lk.ijse.Dto.UserDTO;

import java.io.IOException;

public class LoginController {
    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtPw;
    @FXML
    private JFXTextField txtMail;
    UserBO userBO = (UserBO) BOFactory.getFactory().getBO(BOFactory.BOTypes.USER);

    @FXML
     void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        String mail = txtMail.getText();
        String pw = txtPw.getText();

        var dto = new UserDTO(mail,pw);
       // UserDTO isCheck = userBO.getUser(dto);

        Parent rootNode = FXMLLoader.load(getClass().getResource("/View/dash-board.fxml"));
        Scene scene = new Scene(rootNode);
        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Dashboard");

    }

    @FXML
     void hyperSignup(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/View/signup.fxml")));
    }
}
