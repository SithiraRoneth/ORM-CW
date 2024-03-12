package lk.ijse.Dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
public class UserDTO {
    private String cusId;
    private String name;
    private String nic;
    private String address;
    private int contact;
}
