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
    @Column(name = "e-mail")
    private String e_mail;
    @Column(name = "password")
    private String pw;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =  "user")
    private List<Transactions> reservations = new ArrayList<>();

    public User(String id, String name, String nic, String e_mail, String pw){
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.e_mail = e_mail;
        this.pw = pw;
    }

}