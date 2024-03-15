/* Created By Sithira Roneth
 * Date :3/3/24
 * Time :22:00
 * Project Name :ORM
 * */
package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/View/dash-board.fxml")));
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
