package lk.ijse.Dto.tm;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserTM {
    private String email;
    private String name;
    private String pw;
}
