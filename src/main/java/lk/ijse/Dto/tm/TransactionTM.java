package lk.ijse.Dto.tm;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TransactionTM {
    private String transId;
    private String bookId;
    private String cusId;
    private String cusName;
    private String startDate;
    private String endDate;
    private String status;

    public TransactionTM(String id,String bookId,String cusId,String startDate,String endDate){
        this.transId = id;
        this.bookId = bookId;
        this.cusId = cusId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public TransactionTM(String bookId,String startDate,String endDate){
        this.bookId = bookId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
