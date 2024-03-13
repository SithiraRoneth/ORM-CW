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
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class User_signup_Controller {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtMail;

    @FXML
    private JFXTextField txtPw;

    @FXML
    void btnSignupOnAction(ActionEvent event) {

    }

    @FXML
    void hyperLogin(ActionEvent event) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/View/login.fxml")));
    }
}