/* Created By Sithira Roneth
 * Date :3/5/24
 * Time :11:55
 * Project Name :ORM
 * */
package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import lk.ijse.BO.Custom.TransactionBO;
import lk.ijse.Dto.BookDTO;
import lk.ijse.Dto.TransactionDTO;
import lk.ijse.Dto.UserDTO;
import lk.ijse.Dto.tm.TransactionTM;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TransactionController {
    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXComboBox<String> cmbBookId;

    @FXML
    private JFXComboBox<String> cmbUserID;

    @FXML
    private TableColumn<?, ?> colBook;

    @FXML
    private TableColumn<?, ?> colReturn;

    @FXML
    private TableColumn<?, ?> colStart;

    @FXML
    private TableColumn<?, ?> colTran;

    @FXML
    private TableColumn<?, ?> colUser;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblid;

    @FXML
    private DatePicker returnDate;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField search;

    @FXML
    private TableView<TransactionTM> tbl;

    @FXML
    private TextField txtbookName;

    @FXML
    private TextField txtusername;
    TransactionBO transactionBO = (TransactionBO) BOFactory.getFactory().getBO(BOFactory.BOTypes.TRANSACTION);

    @FXML
    public void initialize(){
        lblDate.setText(String.valueOf(LocalDate.now()));
        lblid.setText(transactionBO.getNextId());
        setCellValueFactory();
        fillTable();
        setUserId();
        setBookId();

    }

    private void fillTable() {
        ObservableList<TransactionTM>transactionTMS = FXCollections.observableArrayList();
        for (TransactionDTO transactionDTO:transactionBO.getAllTransaction()) {
            transactionTMS.add(new TransactionTM(
                    transactionDTO.getTransId(),
                    transactionDTO.getBookId(),
                    transactionDTO.getUserId(),
                    transactionDTO.getStartDate(),
                    transactionDTO.getEndDate()
            ));
        }
        tbl.setItems(transactionTMS);
    }

    private void setCellValueFactory() {
        colTran.setCellValueFactory(new PropertyValueFactory<>("transId"));
        colBook.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colUser.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        colStart.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        colReturn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
    }

    private void setBookId() {
        ObservableList<String> bookIdList = FXCollections.observableArrayList();
        bookIdList.addAll(transactionBO.getAllBookId());
        cmbBookId.setItems(bookIdList);
    }

    private void setUserId() {
        ObservableList<String> userIdList = FXCollections.observableArrayList();
        userIdList.addAll(transactionBO.getUserId());
        cmbUserID.setItems(userIdList);
    }
    @FXML
    void cmbBookIdOnAction(ActionEvent actionEvent) {
        BookDTO bookDTO = transactionBO.getBook(cmbBookId.getValue());
        txtbookName.setText(bookDTO.getTitle());
    }

    @FXML
    void cmbUserIdOnAction(ActionEvent actionEvent) {
        UserDTO userDTO = transactionBO.getUser(cmbUserID.getValue());
        txtusername.setText(userDTO.getName());
    }


    @FXML
    void HomePage(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/dash-board.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    @FXML
    void saveOnAction(ActionEvent event) {
       /* UserDTO userDTO = null;
        BookDTO bookDTO = null;

        String id = lblid.getText();
        String startDate = String.valueOf(lblDate.getText());
        String end = returnDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        for(UserDTO users : transactionBO.getALlUser()){
            userDTO = new UserDTO(users.getE_mail(),users.getName(),users.getPw());
        }

        for (BookDTO books : transactionBO.getALlBook()){
            bookDTO = new BookDTO(books.getId(),books.getTitle(),books.getGenre(),books.getAuthor());
        }

        var transactionDTO = new TransactionDTO(id,startDate,end);
        boolean isSaved = transactionBO.saveTransaction(transactionDTO, userDTO, bookDTO);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"Transaction Saved").show();
            //fillTable();
        }else {
            new Alert(Alert.AlertType.ERROR,"Transaction unsuccessful").show();
        }*/
        UserDTO userDTO = null;
        BookDTO bookDTO = null;

        String id = lblid.getText();
        String startDate = String.valueOf(lblDate.getText());
        String end = String.valueOf(returnDate.getValue());

        for(UserDTO users : transactionBO.getALlUser()){
            userDTO = new UserDTO(users.getE_mail(),users.getName(),users.getPw());
        }

        for (BookDTO books : transactionBO.getALlBook()){
            bookDTO = new BookDTO(books.getId(),books.getTitle(),books.getAuthor(),books.getGenre());
        }

        var transactionDTO = new TransactionDTO(id,startDate,end);
        boolean isSaved = transactionBO.saveTransaction(transactionDTO, userDTO,bookDTO);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"Transaction Successfully").show();
        }else {
           new Alert(Alert.AlertType.ERROR,"unsuccessfully").show();
        }
    }
    @FXML
    void deleteOnAction(ActionEvent event) {
        if (transactionBO.deleteTransaction(lblid.getText())) {
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted Successful!!").show();
            fillTable();
        } else {
            new Alert(Alert.AlertType.ERROR,"Delete Unsuccessful!!").show();
        }
    }
    @FXML
    void updateOnAction(ActionEvent event) {
        UserDTO userDTO = null;
        BookDTO bookDTO = null;

        String id = lblid.getText();
        String startDate = String.valueOf(lblDate.getText());
        String endDate = String.valueOf(returnDate.getValue());
        String user = cmbUserID.getValue();
        String book = cmbBookId.getValue();

        for(UserDTO users : transactionBO.getALlUser()){
            userDTO = new UserDTO(users.getE_mail(),users.getName(),users.getPw());
        }

        for (BookDTO books : transactionBO.getALlBook()){
            bookDTO = new BookDTO(books.getId(),books.getTitle(),books.getAuthor(),books.getGenre());
        }

        var transactionDTO = new TransactionDTO(id,startDate,endDate,user,book);
        boolean isUpdate = transactionBO.updateTransaction(transactionDTO, userDTO, bookDTO);
        if (isUpdate){
            new  Alert(Alert.AlertType.INFORMATION,"Transaction Update Success!!").show();
            fillTable();
        }else {
            new Alert(Alert.AlertType.ERROR,"Transaction Update Unsuccessful!!").show();
        }
    }

    public void searchOnAction(ActionEvent actionEvent) {
        String transId = search.getText();
        TransactionDTO transactionDTO = transactionBO.getTransaction(transId);
        if (transactionDTO !=null) {
            btnUpdate.setDisable(false);
            btnDelete.setDisable(false);
            txtbookName.setDisable(false);
            txtusername.setDisable(false);
            cmbUserID.setDisable(false);
            cmbBookId.setDisable(false);
            lblid.setDisable(false);
            lblDate.setDisable(false);
            returnDate.setDisable(false);

            lblid.setText(transactionDTO.getTransId());
            cmbBookId.getSelectionModel().select(getCmbIndex(cmbBookId,transactionDTO.getBookId()));
            cmbUserID.getSelectionModel().select(getCmbIndex(cmbUserID,transactionDTO.getUserId()));
            lblDate.setText(transactionDTO.getStartDate());
            returnDate.setValue(LocalDate.parse(transactionDTO.getEndDate()));
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
