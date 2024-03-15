/* Created By Sithira Roneth
 * Date :3/13/24
 * Time :22:20
 * Project Name :ORM
 * */
package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.UserBO;
import lk.ijse.Dto.UserDTO;
import org.controlsfx.control.Notifications;

import java.awt.*;
import java.io.IOException;
import java.util.regex.Pattern;

public class User_signup_Controller {
    @FXML
    private Label lblID;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtNIC;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtPW;

    UserBO userBO = (UserBO) BOFactory.getFactory().getBO(BOFactory.BOTypes.USER);

    public void initialize(){
        generateNextID();
    }

    private void generateNextID() {
        try {
            String userId = userBO.getNextId();
            lblID.setText(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnSignupOnAction(ActionEvent event) {
        String id = lblID.getText();
        String name = txtName.getText();
        String nic = txtNIC.getText();
        String email = txtEmail.getText();
        String pw = txtPW.getText();

        try {
            if (!validateUsername()) {
                return;
            }
            var dto = new UserDTO(id, name, nic, email, pw);
            boolean isReg = userBO.saveUser(dto);
            if (isReg) {
                new Alert(Alert.AlertType.CONFIRMATION, "User registered").show();
            } else {
                new Alert(Alert.AlertType.ERROR).show();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    private boolean validateUsername() {
        boolean isValidate = true;
        boolean email = Pattern.matches("^(.+)@(.+)$",txtEmail.getText());
        if (!email){
            showErrorNotification("Invalid email","The email you entered is invalid");
            isValidate = false;
        }
        boolean password = Pattern.matches("[0-9]{5,}", txtPW.getText());
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