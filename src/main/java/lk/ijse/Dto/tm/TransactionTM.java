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
    private Date startDate;
    private Date endDate;
    private String status;
}
