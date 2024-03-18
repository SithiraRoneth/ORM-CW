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
    private String startDate;
    private String endDate;
    private String userId;
    private String bookId;
    private String status;

    public TransactionDTO(String id, String startDate, String endDate){
        this.transId = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public TransactionDTO(String id, String startDate, String endDate,String userId,String bookId){
        this.transId = id;
        this.startDate = startDate;
        this.endDate = endDate;;
        this.userId = userId;
        this.bookId = bookId;
    }
}
