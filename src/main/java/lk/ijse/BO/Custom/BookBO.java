package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.Dto.BookDTO;

import java.util.List;

public interface BookBO extends SuperBO {
    List<BookDTO> getAll();
    boolean saveBook(BookDTO bookDTO);
    boolean updateBook(BookDTO bookDTO);
    BookDTO getBook(String bookId);
    boolean deleteBook(String bookId);
    String getNextId();
}
