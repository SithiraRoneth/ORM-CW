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
import javafx.scene.layout.AnchorPane;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.UserBO;
import lk.ijse.Dto.UserDTO;

import java.awt.*;
import java.io.IOException;

public class User_signup_Controller {

    @FXML
    private AnchorPane root;
    @FXML
    private Label lblID;
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

        var dto = new UserDTO(id,name,nic,email,pw);
        boolean isReg = userBO.saveUser(dto);
        if (isReg){
            new Alert(Alert.AlertType.CONFIRMATION,"User registered").show();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

    @FXML
    void hyperLogin(ActionEvent event) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/View/login.fxml")));
    }
}