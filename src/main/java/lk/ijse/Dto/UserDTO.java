package lk.ijse.Dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
public class UserDTO {
    private String id;
    private String name;
    private String nic;
    private String e_mail;
    private String pw;
}
