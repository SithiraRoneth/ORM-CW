/* Created By Sithira Roneth
 * Date :3/4/24
 * Time :12:14
 * Project Name :ORM
 * */
package lk.ijse.Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.BookBO;
import lk.ijse.Dto.BookDTO;

import java.io.IOException;

public class BookController {
    @FXML
    private TextField search;
    @FXML
    private AnchorPane rootNode;
    @FXML
    private JFXTextField B_Name;

    @FXML
    private JFXTextField bookID;

    @FXML
    private JFXComboBox<String> cmbType;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableView<?> tblBook;

    BookBO bookBO = (BookBO) BOFactory.getFactory().getBO(BOFactory.BOTypes.BOOK);

    public void initialize() {
        setType();
    }
    private void setType() {
        cmbType.getItems().setAll("Education","Novel","Love","Series");
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
        String id = bookID.getText();

        boolean isDelete = bookBO.deleteBook(id);
        if (isDelete){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

    @FXML
    void saveOnAction(ActionEvent event) {
        String id = bookID.getText();
        String name = B_Name.getText();
        String type = cmbType.getValue();

        var dto = new BookDTO(id,name,type);
        boolean isSaved = bookBO.saveBook(dto);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"Book Saved").show();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

    @FXML
    void updateOnAction(ActionEvent event) {
        String id = bookID.getText();
        String name = B_Name.getText();
        String type = cmbType.getValue();

        var dto = new BookDTO(id,name,type);
        boolean isUpdate = bookBO.updateBook(dto);
        if (isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
        }else{
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

    @FXML
     void searchOnAction(ActionEvent actionEvent) {
    }
}
