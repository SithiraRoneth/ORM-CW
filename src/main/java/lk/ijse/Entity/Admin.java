/* Created By Sithira Roneth
 * Date :2/29/24
 * Time :22:03
 * Project Name :ORM
 * */
package lk.ijse.Entity;

import jakarta.persistence.*;
import lk.ijse.Dto.AdminDTO;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "mail")
    private String mail;
    @Column(name = "pw")
    private String password;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branches;

    public Admin(String mail,String password) {
        this.mail = mail;
        this.password = password;
    }
}
