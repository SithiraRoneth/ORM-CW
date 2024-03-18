/* Created By Sithira Roneth
 * Date :3/4/24
 * Time :12:14
 * Project Name :ORM
 * */
package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.BookBO;
import lk.ijse.Dto.BookDTO;
import lk.ijse.Dto.tm.BookTM;

import java.io.IOException;
import java.util.List;

public class BookController {
    @FXML
    private JFXTextField B_Name;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXComboBox<String> cmbType;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField search;

    @FXML
    private TableView<BookTM> tblBook;

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtStatus;
    BookBO bookBO = (BookBO) BOFactory.getFactory().getBO(BOFactory.BOTypes.BOOK);

    public void initialize() {
        setCellValueFactory();
        fillTable();
        setType();
        //txtId.setText(bookBO.getNextId());
        clearFields();
    }

    private void clearFields() {
        txtId.setText("");
        B_Name.setText("");
        cmbType.setValue("");
        txtAuthor.setText("");
        txtStatus.setText("");
    }

    private void fillTable() {
        ObservableList<BookTM>bookTMS = FXCollections.observableArrayList();
        for (BookDTO bookDTO:bookBO.getAll()) {
            bookTMS.add(new BookTM(
                    bookDTO.getId(),
                    bookDTO.getTitle(),
                    bookDTO.getGenre(),
                    bookDTO.getAuthor(),
                    bookDTO.getStatus()
            ));
        }
        tblBook.setItems(bookTMS);
    }
    private void setCellValueFactory(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colType.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }
    private void setType() {
        cmbType.getItems().setAll("Education","Novel","Love","Series","Thriller","History","Fantasy");
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
        String id = txtId.getText();

        boolean isDelete = bookBO.deleteBook(id);
        if (isDelete){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
            fillTable();
            clearFields();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

    @FXML
    void saveOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = B_Name.getText();
        String type = cmbType.getValue();
        String author = txtAuthor.getText();
        String status = txtStatus.getText();

        var dto = new BookDTO(id,name,type,author,status);
        boolean isSaved = bookBO.saveBook(dto);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"Book Saved").show();
            fillTable();
            clearFields();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

    @FXML
    void updateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = B_Name.getText();
        String type = cmbType.getValue();
        String author = txtAuthor.getText();
        String status = txtStatus.getText();

        var dto = new BookDTO(id,name,type,author,status);
        boolean isUpdate = bookBO.updateBook(dto);
        if (isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
            fillTable();
            clearFields();
        }else{
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

    @FXML
     void searchOnAction(ActionEvent actionEvent) {
        String bookId = search.getText();
        BookDTO bookDTO = bookBO.getBook(bookId);
        if (bookDTO!=null) {
            btnSave.setDisable(true);
            btnUpdate.setDisable(false);
            btnDelete.setDisable(false);
            txtId.setDisable(true);
            B_Name.setDisable(false);
            cmbType.setDisable(false);
            txtAuthor.setDisable(false);

            txtId.setText(bookDTO.getId());
            B_Name.setText(bookDTO.getTitle());
            cmbType.getSelectionModel().select(getCmbIndex(cmbType,bookDTO.getGenre()));
            txtAuthor.setText(bookDTO.getAuthor());
        } else {
            new Alert(Alert.AlertType.ERROR,"Invalid Book ID").show();
        }
        search.clear();
    }

    int getCmbIndex(ComboBox<String> cmb,String value) {
        List<String> cmbList = cmb.getItems();
        for (int i=0;i<cmbList.size();i++) {
            if (cmbList.get(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }
}
