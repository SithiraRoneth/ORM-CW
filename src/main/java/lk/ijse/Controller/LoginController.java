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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.AdminBO;
import lk.ijse.BO.Custom.UserBO;
import lk.ijse.Dto.AdminDTO;
import lk.ijse.Dto.UserDTO;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label lblPw;
    @FXML
    private Label lblMail;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtPw;
    @FXML
    private JFXTextField txtMail;
    AdminBO adminBO = (AdminBO) BOFactory.getFactory().getBO(BOFactory.BOTypes.ADMIN);
    UserBO userBO = (UserBO) BOFactory.getFactory().getBO(BOFactory.BOTypes.USER);

    @FXML
    void btnLoginOnAction(ActionEvent actionEvent) throws IOException {

        String mail = txtMail.getText();
        String pw = txtPw.getText();

        AdminDTO adminDTO = adminBO.getAdmin(mail);
        UserDTO userDTO = userBO.getUser(mail);

        if (adminDTO != null && adminDTO.getMail().equals(mail) && adminDTO.getPassword().equals(pw)) {
            // Admin login successful
            Parent rootNode = FXMLLoader.load(getClass().getResource("/View/dash-board.fxml"));
            Scene scene = new Scene(rootNode);
            Stage primaryStage = (Stage) root.getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.setTitle("Admin Dashboard");
        } else if (userDTO != null && userDTO.getE_mail().equals(mail)&& userDTO.getPw().equals(pw)) {
            // User login successful
            Parent rootNode = FXMLLoader.load(getClass().getResource("/View/user-dash.fxml"));
            Scene scene = new Scene(rootNode);
            Stage primaryStage = (Stage) root.getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.setTitle("User Dashboard");
        } else {
            // Invalid credentials for both admin and user
            lblMail.setText("Invalid Email \uD83D\uDD12");
            lblPw.setText("Invalid Password \uD83D\uDD12");
        }
    }

    @FXML
     void hyperSignup(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Choose one");
        alert.setContentText("Choose an option:");

        ButtonType buttonTypeOne = new ButtonType("Admin");
        ButtonType buttonTypeTwo = new ButtonType("User");

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

        alert.showAndWait().ifPresent(response -> {
            if (response == buttonTypeOne) {
                root.getChildren().clear();
                try {
                    root.getChildren().add(FXMLLoader.load(getClass().getResource("/View/signup.fxml")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (response == buttonTypeTwo) {
                root.getChildren().clear();
                try {
                    root.getChildren().add(FXMLLoader.load(getClass().getResource("/View/user_signup.fxml")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
