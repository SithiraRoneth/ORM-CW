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
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id",length = 50)
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "NIC")
    private String nic;
    @Column(name = "address")
    private String address;
    @Column(name = "contact")
    private int contact;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =  "user")
    private List<Transaction> reservations = new ArrayList<>();

    public User(String id, String name, String nic, String address, int contact){
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.contact = contact;
    }

}