package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.TransactionBO;
import lk.ijse.DAO.Custom.BookDAO;
import lk.ijse.DAO.Custom.TransactionDAO;
import lk.ijse.DAO.Custom.UserDAO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.Dto.BookDTO;
import lk.ijse.Dto.TransactionDTO;
import lk.ijse.Dto.UserDTO;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.Transactions;
import lk.ijse.Entity.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TransactionBOImpl implements TransactionBO {
    BookDAO bookDAO = (BookDAO) DAOFactory.getFactory().getDAO(DAOFactory.DAOTypes.BOOK);
    UserDAO userDAO = (UserDAO) DAOFactory.getFactory().getDAO(DAOFactory.DAOTypes.USER);
    TransactionDAO transactionDAO = (TransactionDAO) DAOFactory.getFactory().getDAO(DAOFactory.DAOTypes.TRANSACTION);

    @Override
    public List<TransactionDTO> getAll() {
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
            userId.add(user.getId());
        }
        return userId;
    }

    @Override
    public BookDTO getBook(String book) {
        Book books = bookDAO.getItem(book);
        return new BookDTO(
                books.getId(),
                books.getName(),
                books.getType()
        );
    }

    @Override
    public UserDTO getUser(String customer) {
        User user = userDAO.getItem(customer);
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getNic(),
                user.getE_mail(),
                user.getPw()
        );
    }

    @Override
    public boolean saveTransaction(TransactionDTO transactionDTO) {
        User user = userDAO.getItem(transactionDTO.getUserId());
        Book book = bookDAO.getItem(transactionDTO.getBookId());
        book.setStatus("Not Available");

        if (bookDAO.update(book)){
            return transactionDAO.save(new Transactions(
                    transactionDTO.getTransId(),
                    transactionDTO.getStartDate(),
                    transactionDTO.getEndDate(),
                    book,
                    user
            ));
        }
        return false;
    }

    @Override
    public boolean updateTransaction(TransactionDTO transactionDTO) {
        Transactions transaction = transactionDAO.getItem(transactionDTO.getTransId());
        transaction.setStatus(transactionDTO.getStatus());
        transaction.setEndDate((Date) transactionDTO.getEndDate());

        return transactionDAO.update(transaction);
    }

    @Override
    public boolean deleteTransaction(String transactionId) {
        return transactionDAO.delete(transactionId);
    }

    @Override
    public String getNextId() {
        String id = transactionDAO.getNextId();
        Integer newId = Integer.parseInt(id.replace("TRS","")) + 1;
        return String.format("TRS--03d",newId);
    }
}
