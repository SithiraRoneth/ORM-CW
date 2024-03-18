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
    private String startDate;
    @Column(name = "end_date",columnDefinition = "date")
    private String endDate;
    @Column(name = "user")
    private String user;
    @Column(name = "book")
    private String book;
    @Column(name = "res_status")
    private String status;
    @ManyToOne
    @JoinColumn
    private User userList;
    @ManyToOne
    @JoinColumn
    private Book bookList;

    public Transactions(String id,String startDate,String endDate) {
       this.id = id;
       this.startDate = startDate;
       this.endDate = endDate;

    }
}