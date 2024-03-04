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
public class Transaction {
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
    @JoinColumn(name = "customer_type_id",
            referencedColumnName = "cus_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "book_id",
            referencedColumnName = "book_id")
    private Book book;
}