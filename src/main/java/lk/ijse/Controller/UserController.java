/* Created By Sithira Roneth
 * Date :3/5/24
 * Time :11:53
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.UserBO;
import lk.ijse.Dto.UserDTO;

import java.io.IOException;

public class UserController {
    @FXML
    private JFXTextField NIc;

    @FXML
    private JFXTextField address;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colNIC;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private JFXTextField contact;

    @FXML
    private JFXTextField cus_id;

    @FXML
    private JFXTextField name;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TableView<?> tblCustomer;

    UserBO userBO = (UserBO) BOFactory.getFactory().getBO(BOFactory.BOTypes.USER);

    private void clearFiled(){
        cus_id.setText("");
        name.setText("");
        address.setText("");
        NIc.setText("");
        contact.setText("");
    }

    @FXML
    void HomePage(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/dash-board.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    @FXML
    void deleteOnAction(ActionEvent event) {
        String id = cus_id.getText();
        boolean isDelete = userBO.deleteUser(id);
        if (isDelete){
            new Alert(Alert.AlertType.CONFIRMATION,"User Deleted").show();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
        clearFiled();
    }

    @FXML
    void saveOnAction(ActionEvent event) {
        String id = cus_id.getText();
        String cus_name = name.getText();
        String nic = NIc.getText();
        String add = address.getText();
        int con = Integer.parseInt(contact.getText());


        var dto = new UserDTO(id,cus_name,nic,add,con);
        boolean isSaved = userBO.saveUser(dto);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"user saved").show();
            clearFiled();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

    @FXML
    void updateOnAction(ActionEvent event) {
        String id = cus_id.getText();
        String cus_name = name.getText();
        String nic = NIc.getText();
        String add = address.getText();
        int con = Integer.parseInt(contact.getText());

        var dto = new UserDTO(id,cus_name,nic,add,con);
        boolean isUpdate = userBO.updateUser(dto);
        if (isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"user updated").show();
            clearFiled();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

}
