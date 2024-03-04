/* Created By Sithira Roneth
 * Date :3/3/24
 * Time :21:57
 * Project Name :ORM
 * */
package lk.ijse.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "cus_id",length = 50)
    private String id;
    @Column(name = "cus_name")
    private String name;
    @Column(name = "NIC")
    private String nic;
    @Column(name = "address")
    private String address;
    @Column(name = "contact")
    private int contact;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =  "student")
    private List<Transaction> reservations = new ArrayList<>();
}