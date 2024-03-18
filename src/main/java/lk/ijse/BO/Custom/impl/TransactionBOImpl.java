package lk.ijse.BO.Custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.BO.Custom.TransactionBO;
import lk.ijse.DAO.Custom.BookDAO;
import lk.ijse.DAO.Custom.QueryDAO;
import lk.ijse.DAO.Custom.TransactionDAO;
import lk.ijse.DAO.Custom.UserDAO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.Dto.BookDTO;
import lk.ijse.Dto.TransactionDTO;
import lk.ijse.Dto.UserDTO;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.Transactions;
import lk.ijse.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class TransactionBOImpl implements TransactionBO {
    BookDAO bookDAO = (BookDAO) DAOFactory.getFactory().getDAO(DAOFactory.DAOTypes.BOOK);
    UserDAO userDAO = (UserDAO) DAOFactory.getFactory().getDAO(DAOFactory.DAOTypes.USER);
    TransactionDAO transactionDAO = (TransactionDAO) DAOFactory.getFactory().getDAO(DAOFactory.DAOTypes.TRANSACTION);
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getFactory().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public List<TransactionDTO> getAll() {
        List<TransactionDTO>transactionDTOS = queryDAO.getAllTransaction();
        return transactionDTOS;
    }

    @Override
    public List<TransactionDTO> getAllStock() {
        return null;
    }

    @Override
    public List<String> getAllBookId() {
        List<String>bookIds = new ArrayList<>();
        for (Book book:bookDAO.getAll()) {
            bookIds.add(book.getId());
        }
        return bookIds;
    }

    @Override
    public List<String> getUserId() {

        List<String>userId = new ArrayList<>();
        for (User user:userDAO.getAll()) {
            userId.add(user.getE_mail());
        }
        return userId;
    }

    @Override
    public BookDTO getBook(String book) {
        Book books = bookDAO.getItem(book);
        return new BookDTO(
                books.getId(),
                books.getTitle(),
                books.getGenre(),
                books.getAuthor()
        );
    }

    @Override
    public UserDTO getUser(String customer) {
        User user = userDAO.getItem(customer);
        return new UserDTO(
                user.getE_mail(),
                user.getName(),
                user.getPw()
        );
    }

    @Override
    public boolean saveTransaction(TransactionDTO transactionDTO,UserDTO userDTO,BookDTO bookDTO) {
        return transactionDAO.saveTransaction(
                new Transactions(transactionDTO.getTransId(),transactionDTO.getStartDate(),transactionDTO.getEndDate()),
                new User(userDTO.getE_mail(),userDTO.getName(),userDTO.getPw()),
                new Book(bookDTO.getId(),bookDTO.getTitle(),bookDTO.getGenre(),bookDTO.getAuthor()));
    }

    @Override
    public boolean updateTransaction(TransactionDTO transactionDTO, UserDTO userDTO, BookDTO bookDTO) {
        return transactionDAO.saveTransaction(
                new Transactions(transactionDTO.getTransId(),transactionDTO.getStartDate(),transactionDTO.getEndDate()),
                new User(userDTO.getE_mail(),userDTO.getName(),userDTO.getPw()),
                new Book(bookDTO.getId(),bookDTO.getTitle(),bookDTO.getGenre(),bookDTO.getAuthor()));
    }

    @Override
    public boolean deleteTransaction(String transactionId) {
        return transactionDAO.delete(transactionId);
    }

    @Override
    public String getNextId() {
        String id = transactionDAO.getNextId();
        Integer newId = Integer.parseInt(id.replace("TRS","")) + 1;
        return String.format("TRS%03d",newId);
    }

    @Override
    public List<UserDTO> getALlUser() {
        List<User> userList = userDAO.getAll();
        List<UserDTO> userDTOS = new ArrayList<>();

        for (User user : userList){
            userDTOS.add(new UserDTO(user.getE_mail(),user.getName(),user.getPw()));
        }
        return userDTOS;
    }

    @Override
    public List<BookDTO> getALlBook() {
        List<Book> booksList = bookDAO.getAll();
        List<BookDTO> bookDTOS = new ArrayList<>();

        for (Book book : booksList){
            bookDTOS.add(new BookDTO(book.getId(),book.getTitle(),book.getGenre(),book.getAuthor()));
        }
        return bookDTOS;
    }
    @Override
    public TransactionDTO getTransaction(String id) {
        Transactions transactions = transactionDAO.getItem(id);
        if (transactions!=null) {
            return new TransactionDTO(transactions.getId(), transactions.getStartDate(),transactions.getEndDate(), transactions.getUserList().getE_mail(), transactions.getBookList().getId(), transactions.getStatus());
        } else {
            new Alert(Alert.AlertType.ERROR).show();
        }
        return null;
    }

    @Override
    public List<TransactionDTO> getAllTransaction() {
        List<TransactionDTO> transactionDTOS = new ArrayList<>();
        List<Transactions> transactionsList = transactionDAO.getAll();

        if (transactionDTOS!=null) {
            for (Transactions transactions : transactionsList) {
                transactionDTOS.add(new TransactionDTO(
                        transactions.getId(),
                        transactions.getStartDate(),
                        transactions.getEndDate(),
                        transactions.getUser(),
                        transactions.getBook(),
                        transactions.getStatus()
                ));
            }
        }
        return transactionDTOS;
    }
    @Override
    public boolean updateTransaction(TransactionDTO transactionDTO,BookDTO bookDTO,UserDTO userDTO) {
        String status = "Complete";
        return transactionDAO.updateTransaction(
                new Transactions(transactionDTO.getTransId(),transactionDTO.getStartDate(),transactionDTO.getEndDate(),transactionDTO.getUserId(),transactionDTO.getBookId(),status),
                new Book(bookDTO.getId(),bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getGenre()),
                new User(userDTO.getE_mail(),userDTO.getName(),userDTO.getPw()));
    }
}
