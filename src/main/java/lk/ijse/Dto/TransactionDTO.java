package lk.ijse.Dto;

import lk.ijse.Entity.Book;
import lk.ijse.Entity.User;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class TransactionDTO {
    private String transId;
    private Date startDate;
    private Date endDate;
    private String userId;
    private String bookId;
    private String status;
    private String userName;
    private String bookName;

    public TransactionDTO(String id, Date startDate, Date endDate,User user,Book book){
        this.transId = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userId = String.valueOf(user);
        this.bookId = String.valueOf(book);
    }
}
