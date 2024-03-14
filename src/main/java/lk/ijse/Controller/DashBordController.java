/* Created By Sithira Roneth
 * Date :3/3/24
 * Time :23:14
 * Project Name :ORM
 * */
package lk.ijse.Controller;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;

public class DashBordController {
    @FXML
    private Label lbldesc;
    @FXML
    private Label lblmenu;
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView setting;
    @FXML
    private ImageView transaction;
    @FXML
    private ImageView user;
    @FXML
    private ImageView book;


    @FXML
    void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            switch (icon.getId()) {
                case "user":
                    lblmenu.setText("Manage Users");
                    lbldesc.setText("Click to add, edit, delete, search or view Users");
                    break;
                case "book":
                    lblmenu.setText("Manage  Books");
                    lbldesc.setText("Click to add, edit, delete, search or view Books");
                    break;
                case "transaction":
                    lblmenu.setText("Transaction");
                    lbldesc.setText("Click here if you want to Transaction");
                    break;
                case "setting":
                    lblmenu.setText("Setting");
                    lbldesc.setText("Click if you want to change password");
                    break;
            }

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    @FXML
    void playMouseExitAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            lblmenu.setText("Welcome");
            lbldesc.setText("Please select one of above main operations to proceed");
        }
    }
    @FXML
    void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "user":
                    root = FXMLLoader.load(this.getClass().getResource("/View/user.fxml"));
                    break;
                case "book":
                    root = FXMLLoader.load(this.getClass().getResource("/View/book.fxml"));
                    break;
                case "transaction":
                    root = FXMLLoader.load(this.getClass().getResource("/View/transaction.fxml"));
                    break;
                case "setting":
                    root = FXMLLoader.load(this.getClass().getResource("/View/setting.fxml"));
                    break;
            }

            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }


}
