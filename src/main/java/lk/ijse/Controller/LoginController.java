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
import lk.ijse.Dto.AdminDTO;

import java.io.IOException;
import java.util.List;

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

    /*@FXML
     void btnLoginOnAction(ActionEvent actionEvent) throws IOException {

        String mail = txtMail.getText();
        String pw = txtPw.getText();

        AdminDTO adminDTO = adminBO.getAdmin(mail);
            if (adminDTO.getMail().equals(mail)) {
                if (adminDTO.getPassword().equals(pw)){
                    Parent rootNode = FXMLLoader.load(getClass().getResource("/View/dash-board.fxml"));
                    Scene scene = new Scene(rootNode);
                    Stage primaryStage = (Stage) root.getScene().getWindow();
                    primaryStage.setScene(scene);
                    primaryStage.centerOnScreen();
                    primaryStage.setTitle("Dashboard");
                }else{
                    lblPw.setText("Invalid Password \uD83D\uDD12");
                }
            }else {
                lblMail.setText("Invalid Mail \uD83D\uDD12");
            }
    }*/
    @FXML
    void btnLoginOnAction(ActionEvent actionEvent) throws IOException {

        String mail = txtMail.getText();
        String pw = txtPw.getText();

        AdminDTO adminDTO = adminBO.getAdmin(mail);

        if (adminDTO != null) { // Check if adminDTO is not null (email exists)
            if (adminDTO.getMail().equals(mail) && adminDTO.getPassword().equals(pw)) {
                // Email and password match
                Parent rootNode = FXMLLoader.load(getClass().getResource("/View/dash-board.fxml"));
                Scene scene = new Scene(rootNode);
                Stage primaryStage = (Stage) root.getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("Dashboard");
            } else {
                // Either email or password is incorrect
                if (!adminDTO.getMail().equals(mail)) {
                    lblMail.setText("Invalid Mail \uD83D\uDD12");
                }
                if (!adminDTO.getPassword().equals(pw)) {
                    lblPw.setText("Invalid Password \uD83D\uDD12");
                }
            }
        } else {
            // Email doesn't exist
            lblMail.setText("Invalid Mail \uD83D\uDD12");
        }
    }

    @FXML
     void hyperSignup(ActionEvent actionEvent) throws IOException {
        /*root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/View/signup.fxml")));*/
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
