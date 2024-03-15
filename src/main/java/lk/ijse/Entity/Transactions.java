/* Created By Sithira Roneth
 * Date :3/3/24
 * Time :21:57
 * Project Name :ORM
 * */
package lk.ijse.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "transaction")
public class Transactions {
    @Id
    @Column(name = "trans_id",length = 50)
    private String id;
    @Column(name = "start_date",columnDefinition = "date")
    private Date startDate;
    @Column(name = "end_date",columnDefinition = "date")
    private Date endDate;
    @Column(name = "res_status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "user_type_id",
            referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id",
            referencedColumnName = "book_id")
    private Book book;

    public Transactions(String transId, java.util.Date startDate, java.util.Date endDate, Book book, User user) {
       this.id = transId;
       this.startDate = (Date) startDate;
       this.endDate = (Date) endDate;
       this.user = user;
       this.book = book;
    }
}