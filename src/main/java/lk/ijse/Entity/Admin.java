/* Created By Sithira Roneth
 * Date :2/29/24
 * Time :22:03
 * Project Name :ORM
 * */
package lk.ijse.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
}
