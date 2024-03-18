package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.BookBO;
import lk.ijse.DAO.Custom.BookDAO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.Dto.BookDTO;
import lk.ijse.Entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookBOImpl implements BookBO {
    BookDAO bookDAO = (BookDAO) DAOFactory.getFactory().getDAO(DAOFactory.DAOTypes.BOOK);

    @Override
    public List<BookDTO> getAll() {
        List<BookDTO> bookDTOS = new ArrayList<>();
        List<Book> books = bookDAO.getAll();
        if (books != null) {
            for (Book book : books) {
                bookDTOS.add(new BookDTO(
                        book.getId(),
                        book.getTitle(),
                        book.getGenre(),
                        book.getAuthor(),
                        book.getStatus()
                ));
            }
        }
        return bookDTOS;
    }

    @Override
    public boolean saveBook(BookDTO bookDTO) {
        String status = "Available";
        return bookDAO.save(
                new Book(
                        bookDTO.getId(),
                        bookDTO.getTitle(),
                        bookDTO.getGenre(),
                        bookDTO.getAuthor(),
                        status
                )
        );
    }

    @Override
    public boolean updateBook(BookDTO bookDTO) {
        return bookDAO.update(
                new Book(
                        bookDTO.getId(),
                        bookDTO.getTitle(),
                        bookDTO.getGenre(),
                        bookDTO.getAuthor()
                )
        );
    }

    @Override
    public BookDTO getBook(String bookId) {
        Book book = bookDAO.getItem(bookId);
        if (book!=null) {
            return new BookDTO(
                    book.getId(),
                    book.getTitle(),
                    book.getGenre(),
                    book.getAuthor(),
                    book.getStatus()
            );
        }
        return null;
    }

    @Override
    public boolean deleteBook(String bookId) {
        return bookDAO.delete(bookId);
    }

    @Override
    public String getNextId() {
        String id = bookDAO.getNextId();
        Integer newId = Integer.parseInt(id.replace("B","")) + 1;
        return String.format("B%03d",newId);
    }
}
