/* Created By Sithira Roneth
 * Date :3/5/24
 * Time :11:53
 * Project Name :ORM
 * */
package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.UserBO;
import lk.ijse.Dto.BookDTO;
import lk.ijse.Dto.UserDTO;
import lk.ijse.Dto.tm.UserTM;

import java.io.IOException;

public class UserController {
    @FXML
    private JFXButton btnSearch;
    @FXML
    private TextField search;
    @FXML
    private JFXTextField txtPw;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;
    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private JFXTextField name;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TableView<UserTM> tblCustomer;

    UserBO userBO = (UserBO) BOFactory.getFactory().getBO(BOFactory.BOTypes.USER);

    @FXML
    void initialize() {
        setCellValueFactory();
        fillTable();
    }
    private void setCellValueFactory() {
        colAddress.setCellValueFactory(new PropertyValueFactory<>("email"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("pw"));
    }
    private void fillTable() {
        ObservableList<UserTM> userTMS = FXCollections.observableArrayList();
        for (UserDTO userDTO : userBO.getAllUsers()) {
            userTMS.add(new UserTM(
                    userDTO.getE_mail(),
                    userDTO.getName(),
                    userDTO.getPw()
            ));
        }
        tblCustomer.setItems(userTMS);
    }
    private void clearFiled(){
        name.setText("");
        txtEmail.setText("");
        txtPw.setText("");
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
        String email = txtEmail.getText();
        boolean isDelete = userBO.deleteUser(email);
        if (isDelete){
            new Alert(Alert.AlertType.CONFIRMATION,"User Deleted").show();
            fillTable();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
        clearFiled();
    }

    @FXML
    void saveOnAction(ActionEvent event) {
        String email = txtEmail.getText();
        String cus_name = name.getText();
        String pw = txtPw.getText();


        var dto = new UserDTO(email,cus_name,pw);
        boolean isSaved = userBO.saveUser(dto);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"user saved").show();
            fillTable();
            clearFiled();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

    @FXML
    void updateOnAction(ActionEvent event) {
        String email = txtEmail.getText();
        String cus_name = name.getText();
        String pw = txtPw.getText();

        var dto = new UserDTO(email,cus_name,pw);
        boolean isUpdate = userBO.updateUser(dto);
        if (isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"user updated").show();
            fillTable();
            clearFiled();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

    @FXML
    private void searchOnAction(ActionEvent actionEvent) {
        String userId = search.getText();
        UserDTO userDTO = userBO.getUser(userId);
        if (userDTO!=null) {
            txtEmail.setDisable(true);
            txtPw.setDisable(false);
            name.setDisable(false);

            txtEmail.setText(userDTO.getE_mail());
            txtPw.setText(userDTO.getPw());
            name.setText(userDTO.getName());
        } else {
            new Alert(Alert.AlertType.ERROR,"Invalid Book ID").show();
        }
        search.clear();
    }
}
