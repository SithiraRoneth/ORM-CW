/* Created By Sithira Roneth
 * Date :3/13/24
 * Time :10:40
 * Project Name :ORM
 * */
package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.TransactionBO;
import lk.ijse.Dto.TransactionDTO;
import lk.ijse.Dto.tm.TransactionTM;

import java.io.IOException;

public class User_Stock_Controller {
    @FXML
    private TableColumn<?, ?> colEnd;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colStart;

    @FXML
    private ImageView home;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TableView<TransactionTM> tblBook;

    @FXML
    private JFXTextField txtBookId;

    @FXML
    private JFXTextField txtEndDate;

    @FXML
    private JFXTextField txtName;

    TransactionBO transactionBO = (TransactionBO) BOFactory.getFactory().getBO(BOFactory.BOTypes.TRANSACTION);

    @FXML
    public void initialize(){
        setCellFactory();
        fillTable();
    }

    private void fillTable() {
        ObservableList<TransactionTM> transactionTMS = FXCollections.observableArrayList();
        for (TransactionDTO transactionDTO:transactionBO.getAllStock()) {
            transactionTMS.add(new TransactionTM(
                    transactionDTO.getBookId(),
                    transactionDTO.getStartDate(),
                    transactionDTO.getEndDate()
            ));
        }
        tblBook.setItems(transactionTMS);
    }

    private void setCellFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colStart.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        colEnd.setCellValueFactory(new PropertyValueFactory<>("endDate"));
    }

    @FXML
    void navigate(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/user-dash.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

}

