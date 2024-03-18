/* Created By Sithira Roneth
 * Date :3/13/24
 * Time :10:35
 * Project Name :ORM
 * */
package lk.ijse.Controller;

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
import lk.ijse.BO.Custom.BookBO;
import lk.ijse.Dto.BookDTO;
import lk.ijse.Dto.tm.BookTM;

import java.io.IOException;

public class User_Book_Controller {
    @FXML
    private TableColumn<?,?> colAuthor;
    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private ImageView home;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TableView<BookTM> tblBook;

    BookBO bookBO = (BookBO) BOFactory.getFactory().getBO(BOFactory.BOTypes.BOOK);

    public void initialize(){
        setCellValueFactory();
        fillTable();

    }
    private void setCellValueFactory(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colType.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void fillTable() {
        ObservableList<BookTM> bookTMS = FXCollections.observableArrayList();
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

    public void navigate(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/user-dash.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }
}
