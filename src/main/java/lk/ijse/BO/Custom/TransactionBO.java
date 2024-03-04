package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.Dto.BookDTO;
import lk.ijse.Dto.CustomerDTO;
import lk.ijse.Dto.TransactionDTO;

import java.util.List;

public interface TransactionBO extends SuperBO {
    List<TransactionDTO> getAll();
    List<String> getAllBookId();
    List<String> getCustomerId();
    BookDTO getBook(String book);
    CustomerDTO getCustomer(String customer);
    boolean saveTransaction(TransactionDTO transactionDTO);
    boolean updateTransaction(TransactionDTO transactionDTO);
    boolean deleteTransaction(String transactionId);
    String getNextId();
}
