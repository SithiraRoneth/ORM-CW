package lk.ijse.Dto;

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
    private String cusId;
    private String bookId;
    private String status;
    private String cusName;
    private String bookName;
}
