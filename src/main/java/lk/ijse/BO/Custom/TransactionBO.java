package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.Dto.BookDTO;
import lk.ijse.Dto.UserDTO;
import lk.ijse.Dto.TransactionDTO;

import java.util.List;

public interface TransactionBO extends SuperBO {
    List<TransactionDTO> getAll();
    List<TransactionDTO>getAllStock();
    List<String> getAllBookId();
    List<String> getUserId();
    BookDTO getBook(String book);
    UserDTO getUser(String user);
    boolean saveTransaction(TransactionDTO transactionDTO,UserDTO userDTO,BookDTO bookDTO);
    boolean updateTransaction(TransactionDTO transactionDTO,UserDTO userDTO,BookDTO bookDTO);
    boolean deleteTransaction(String transactionId);

    String getNextId();

    List<UserDTO> getALlUser();
    List<BookDTO> getALlBook();

    TransactionDTO getTransaction(String id);

    List<TransactionDTO> getAllTransaction();

    boolean updateTransaction(TransactionDTO transactionDTO, BookDTO bookDTO, UserDTO userDTO);
}
