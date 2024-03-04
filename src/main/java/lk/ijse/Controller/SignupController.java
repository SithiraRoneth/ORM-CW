/* Created By Sithira Roneth
 * Date :3/3/24
 * Time :23:27
 * Project Name :ORM
 * */
package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.UserBO;
import lk.ijse.Dto.UserDTO;

import java.io.IOException;

public class SignupController {
    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtMail;

    @FXML
    private JFXTextField txtPw;
    UserBO userBO = (UserBO) BOFactory.getFactory().getBO(BOFactory.BOTypes.USER);

    @FXML
    void btnSignupOnAction(ActionEvent event) {
        String mail = txtMail.getText();
        String pw = txtPw.getText();

        var dto = new UserDTO(mail,pw);
        boolean isSaved = userBO.saveUser(dto);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"User Saved").show();
        } else {
          new Alert(Alert.AlertType.ERROR,"Something Wrong").show();
        }
    }

    @FXML
    void hyperLogin(ActionEvent event) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/View/login.fxml")));
    }

}