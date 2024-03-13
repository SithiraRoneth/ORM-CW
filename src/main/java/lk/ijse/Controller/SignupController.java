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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.AdminBO;
import lk.ijse.Dto.AdminDTO;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class SignupController {
    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtMail;

    @FXML
    private JFXTextField txtPw;
    AdminBO adminBO = (AdminBO) BOFactory.getFactory().getBO(BOFactory.BOTypes.ADMIN);

    @FXML
    void btnSignupOnAction(ActionEvent event) {
        String mail = txtMail.getText();
        String pw = txtPw.getText();

        /*var dto = new AdminDTO(mail,pw);
        boolean isSaved = adminBO.saveUser(dto);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"User Saved").show();
        } else {
          new Alert(Alert.AlertType.ERROR,"Something Wrong").show();
        }*/
        try {
            if (!validateUsername()){
                return;
            }
            var dto = new AdminDTO(mail,pw);
            boolean isReg = adminBO.saveUser(dto);
            if (isReg){
                new Alert(Alert.AlertType.CONFIRMATION,"Registered Successfully").show();
                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/login.fxml"));
                Stage stage = (Stage) root.getScene().getWindow();

                stage.setScene(new Scene(anchorPane));
                stage.centerOnScreen();
            }
        } catch (IOException e) {
           new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
    private boolean validateUsername() {
        boolean isValidate = true;
        boolean email = Pattern.matches("^(.+)@(.+)$",txtMail.getText());
        if (!email){
            showErrorNotification("Invalid email","The email you entered is invalid");
            isValidate = false;
        }
        boolean password = Pattern.matches("[0-9]{5,}", txtPw.getText());
        if (!password){
            showErrorNotification("Invalid password", "The password you entered is invalid");
            isValidate = false;
        }

        return isValidate;
    }
    private void showErrorNotification(String title, String text) {
        Notifications.create()
                .title(title)
                .text(text)
                .showError();
    }


    @FXML
    void hyperLogin(ActionEvent event) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/View/login.fxml")));
    }

}
