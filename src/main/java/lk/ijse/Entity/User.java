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
    @Column(name = "e-mail")
    private String e_mail;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String pw;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =  "userList")
    private List<Transactions> transactions = new ArrayList<>();

   public User(String email,String name,String pw){
       this.e_mail = email;
       this.name = name;
       this.pw = pw;
   }

}